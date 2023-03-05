package com.mealjung.sample.controller.dto;

import lombok.Getter;

@Getter
public class SampleSearchCondition {
    private String name;
    private String openYn;
    private Integer page;

    public SampleSearchCondition(String name, String openYn, Integer page) {
        this.name = name;
        this.openYn = openYn;
        this.page = page;
    }
}


