package com.example.hhruscanner.kafka;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@Service
public class KafkaMessageProducer {
    @Value("${topic.newVacancies}")
    private String NEW_VACANCIES_TOPIC;
    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    public KafkaMessageProducer(KafkaTemplate<String, KafkaMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendNewVacancyMessage(VacancyMessage message) {
        kafkaTemplate.send(NEW_VACANCIES_TOPIC, message);
    }
}

