package com.example.hhruscanner.client;

import com.example.hhruscanner.domain.Vacancy;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class VacancyResponse {
    private List<Vacancy> items;
    private int found;
    private int pages;
    private int page;
}
