package com.example.hhruscanner.controller;

import com.example.hhruscanner.domain.Vacancy;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class SearchResponse {
    private Integer found;
    private Integer listSize;
    private boolean applied;
    private List<Vacancy> vacancyList = new ArrayList<>();
}
