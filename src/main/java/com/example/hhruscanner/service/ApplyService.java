package com.example.hhruscanner.service;

import com.example.hhruscanner.domain.Vacancy;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
@NoArgsConstructor
public class ApplyService {
    private final int DELAY_FOR_SPAM_FILTER = 1000;
    private final AtomicInteger COUNTER_APPLY = new AtomicInteger(0);

    @Async
    public void applyVacancies(List<Vacancy> items) {
        for (Vacancy vac : items) {
            try {
                Thread.sleep(DELAY_FOR_SPAM_FILTER);
                log.info("\u001B[32m" + "vacancy: {} published:{} created:{} " + "\u001B[0m",
                        vac.getAlternateUrl(), vac.getCreatedAt(), vac.getInitialCreatedAt());
                Runtime.getRuntime().exec("open " + vac.getAlternateUrl());// TODO:для откликов поменяй url
                COUNTER_APPLY.getAndIncrement();
                log.info("\u001B[32m" + COUNTER_APPLY.get() + "\u001B[0m");
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}