package infrastructure

import (
	"github.com/joho/godotenv"
	"log"
	"os"
	"strconv"
)

type Configuration struct {
	KafkaBroker   string
	KafkaTopic    string
	TelegramToken string
	GroupId       string
	ChatId        int64
}

func Load() *Configuration {
	err := godotenv.Load(".env")
	if err != nil {
		log.Fatalf("error loading .env file: %s", err)
	}
	return &Configuration{
		KafkaBroker:   getEnv("KAFKA_BROKER", "localhost:9092"),
		KafkaTopic:    getEnv("KAFKA_TOPIC", "newVacancies"),
		TelegramToken: getEnv("TELEGRAM_TOKEN", ""),
		GroupId:       getEnv("GROUP_ID", "gotgbot-consumer"),
		ChatId:        getEnvAsInt64("CHAT_ID", 0),
	}
}

func getEnv(key, defaultValue string) string {
	if value, ok := os.LookupEnv(key); ok {
		return value
	} else {
		log.Printf("environment with key: %v not found using default value: %v", key, defaultValue)
	}
	return defaultValue
}

func getEnvAsInt64(key string, defaultValue int64) int64 {
	valStr := getEnv(key, "")
	if valStr == "" {
		return defaultValue
	}
	val, err := strconv.ParseInt(valStr, 10, 64)
	if err != nil {
		log.Printf("error parsing %s: %v, default value: %d\n", key, err, defaultValue)
		return defaultValue
	}
	return val
}
