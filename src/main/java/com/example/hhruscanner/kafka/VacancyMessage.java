package com.example.hhruscanner.kafka;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class VacancyMessage extends KafkaMessage {
    private String company;
    private String name;
    private String url;

}
