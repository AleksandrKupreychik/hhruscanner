package tg

import (
	"fmt"
	"gotgbot/model"
	"log"
	"time"

	"gopkg.in/telebot.v3"
)

type TelegramSender struct {
	bot    *telebot.Bot
	chatId int64
}

func NewTelegramSender(token string, chatId int64) *TelegramSender {
	p := telebot.Settings{
		Token:  token,
		Poller: &telebot.LongPoller{Timeout: 10 * time.Second},
	}

	bot, err := telebot.NewBot(p)
	if err != nil {
		log.Fatal("start bot error:", err)
	}

	return &TelegramSender{
		chatId: chatId,
		bot:    bot,
	}
}

func (s *TelegramSender) SendVacancy(v model.VacancyMessage) error {
	message := fmt.Sprintf("*%s*\n\n%s\n\n[Открыть вакансию](%s)", v.Company, v.Title, v.URL)
	chatID := s.chatId
	log.Println("send to : ", chatID)
	_, err := s.bot.Send(
		&telebot.Chat{ID: chatID},
		message,
		telebot.ModeMarkdown,
	)
	return err
}
