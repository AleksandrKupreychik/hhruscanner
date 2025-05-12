package main

import (
	"gotgbot/infrastructure"
)

func main() {
	application := infrastructure.NewApplication()
	application.Start()
}
