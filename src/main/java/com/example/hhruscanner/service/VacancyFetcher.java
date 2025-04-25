package com.example.hhruscanner.service;

import com.example.hhruscanner.domain.Vacancy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class VacancyFetcher {
    private final String SEARCH_TEXT_JAVA = "java";
    private final int PROF_ID_DEVELOPER = 96;
    private final String REMOTE_SCHEDULE = "remote";
    private final int UPDATE_TIME_MILLS = 600000;

    private final SearchService searchService;
    private final ApplyService applyService;


    @Scheduled(fixedRate = UPDATE_TIME_MILLS)
    public void newVacancySeeker() {
        ZonedDateTime dateTime = Instant.now().minusMillis(UPDATE_TIME_MILLS).atZone(ZoneId.of("Europe/Moscow"));
        String isoDate = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        log.info("\u001B[32m" + "Time: {} " + "\u001B[0m", isoDate);
        List<Vacancy> items = searchService.getVacs(null, SEARCH_TEXT_JAVA, isoDate, PROF_ID_DEVELOPER, REMOTE_SCHEDULE)
                .getVacancyList()
                .stream()
                .map(vac -> searchService.getVacancy(vac.getId()))
                .filter(this::isRealNewVacancy)
                .collect(Collectors.toList());
        log.info("\u001B[32m" + "find vacancies = {}" + "\u001B[0m", items.size());
        applyService.applyVacancies(items);
    }

    private boolean isRealNewVacancy(Vacancy v) {
        LocalDateTime createDate = LocalDateTime.parse(fixTimezoneFormat(v.getInitialCreatedAt()),
                DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        LocalDateTime publishDate = LocalDateTime.parse(fixTimezoneFormat(v.getCreatedAt()),
                DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        return createDate.isEqual(publishDate);
    }

    /**
     * С hhru приходит кривой формат DateTime
     *
     * @param input дата с hhru
     * @return корректная дата типа ISO_OFFSET_DATE_TIME
     */
    private static String fixTimezoneFormat(String input) {
        return input.replaceAll("(\\d{2})(\\d{2})$", "$1:$2");
    }
}
