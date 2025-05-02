package com.example.hhruscanner.kafka;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class VacancyMessage extends KafkaMessage {
    private String company;
    private String name;
    private String url;

    public VacancyMessage(String company, String name, String url) {
        this.company = company;
        this.name = name;
        this.url = url;
    }
}
