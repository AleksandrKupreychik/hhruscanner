package com.example.hhruscanner.service;

import com.example.hhruscanner.client.HhRuClient;
import com.example.hhruscanner.client.VacancyResponse;
import com.example.hhruscanner.controller.SearchResponse;
import com.example.hhruscanner.domain.Vacancy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchService {
    private final int MAX_VACS_PER_PAGE = 100;
    private final HhRuClient hhRuClient;

    public Vacancy getVacancy(String id) {
        return hhRuClient.getVacancy(id);
    }

    public SearchResponse getVacs(Integer page, String text, String dateFrom, int profId, String schedule) {
        VacancyResponse hhruresp;
        SearchResponse response = new SearchResponse();
        do {
            hhruresp = hhRuClient.getVacancies(page, MAX_VACS_PER_PAGE, text, dateFrom, profId, schedule);
            response.getVacancyList().addAll(hhruresp.getItems());
            page = hhruresp.getPage() + 1;
        } while (hhruresp.getPages() != 0 && hhruresp.getPages() - 1 != hhruresp.getPage());
        response.setFound(hhruresp.getFound());
        response.setListSize(response.getVacancyList().size());
        return response;
    }
}




