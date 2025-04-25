package com.example.hhruscanner.client;

import com.example.hhruscanner.domain.Vacancy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "hhru", url = "${api.hhru}" + "vacancies")
public interface HhRuClient {
    @GetMapping("{vacancy_id}")
    Vacancy getVacancy(@PathVariable String vacancy_id);

    @GetMapping
    VacancyResponse getVacancies(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam("per_page") int perPage,
            @RequestParam("text") String text,
            @RequestParam("date_from") String date,
            @RequestParam("professional_role") int id,
            @RequestParam("schedule") String schedule);
}

