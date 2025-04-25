package com.example.hhruscanner.controller;

import com.example.hhruscanner.domain.Vacancy;
import com.example.hhruscanner.service.ApplyService;
import com.example.hhruscanner.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SearchController {
    private final int MAX_APPLY_IN_DAY = 200;
    final SearchService searchService;
    final ApplyService applyService;

    public SearchController(SearchService searchService, ApplyService applyService) {
        this.searchService = searchService;
        this.applyService = applyService;
    }


    @GetMapping("/vacancy")
    public @ResponseBody Vacancy getVacancy(@RequestParam("id") String id) {
        return searchService.getVacancy(id);
    }

    @GetMapping("/vacancies")
    public @ResponseBody SearchResponse getVacs(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam("text") String text,
            @RequestParam("date_from") String dateFrom,
            @RequestParam("professional_role") int id, // 96 программист разработчик
            @RequestParam("schedule") String schedule,
            @RequestParam(value = "apply", required = false) boolean apply) {
        SearchResponse response = searchService.getVacs(page, text, dateFrom, id, schedule);
        if(apply && MAX_APPLY_IN_DAY> response.getListSize()){
            applyService.applyVacancies(response.getVacancyList());
            response.setApplied(true);
        }
        return response;
    }
}
