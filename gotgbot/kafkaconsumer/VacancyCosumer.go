package kafkaconsumer

import (
	"context"
	"encoding/json"
	"gotgbot/model"
	"log"
	"time"

	"github.com/segmentio/kafka-go"
)

type VacancyConsumer struct {
	reader *kafka.Reader
}

func NewVacancyConsumer(broker, topic, groupId string) *VacancyConsumer {
	r := kafka.NewReader(kafka.ReaderConfig{
		Brokers:     []string{broker},
		Topic:       topic,
		GroupID:     groupId,
		StartOffset: kafka.LastOffset,
	})
	return &VacancyConsumer{reader: r}
}

func (c *VacancyConsumer) Consume() <-chan model.VacancyMessage {
	out := make(chan model.VacancyMessage)
	log.Println("listening")
	go func() {
		defer close(out)
		for {
			m, err := c.reader.ReadMessage(context.Background())
			if err != nil {
				log.Println("kafka error:", err)
				time.Sleep(5 * time.Second)
				continue
			}
			var vacancy model.VacancyMessage
			if err := json.Unmarshal(m.Value, &vacancy); err != nil {
				log.Println("unmarshall error:", err)
				continue
			}
			log.Println("get vacancy: ", vacancy)
			out <- vacancy
		}
	}()
	return out
}
