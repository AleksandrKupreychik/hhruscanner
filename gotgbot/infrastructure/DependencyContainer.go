package infrastructure

import (
	"gotgbot/kafkaconsumer"
	"gotgbot/tg"
	"log"
)

type DependencyContainer struct {
	kafkaConsumer  *kafkaconsumer.VacancyConsumer
	telegramSender *tg.TelegramSender
}

func NewApplication() *DependencyContainer {
	cfg := Load()
	telegramSender := tg.NewTelegramSender(cfg.TelegramToken, cfg.ChatId)
	kafkaConsumer := kafkaconsumer.NewVacancyConsumer(cfg.KafkaBroker, cfg.KafkaTopic, cfg.GroupId)
	return &DependencyContainer{
		kafkaConsumer:  kafkaConsumer,
		telegramSender: telegramSender,
	}
}

func (a *DependencyContainer) Start() {
	log.Print("app started")
	messages := a.kafkaConsumer.Consume()
	for msg := range messages {
		if err := a.telegramSender.SendVacancy(msg); err != nil {
			log.Println("error send to tg:", err)
		}
	}
}
