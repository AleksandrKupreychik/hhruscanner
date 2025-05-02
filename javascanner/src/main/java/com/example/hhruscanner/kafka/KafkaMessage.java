package com.example.hhruscanner.kafka;


import java.util.UUID;
public class KafkaMessage {
    private final UUID id;
    public KafkaMessage() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}
