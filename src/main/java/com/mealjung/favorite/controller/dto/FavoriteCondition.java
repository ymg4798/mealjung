package com.mealjung.favorite.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FavoriteCondition {
    private String type;
    private Integer page;

    public FavoriteCondition(String type, Integer page) {
        this.type = type;
        this.page = page;
    }
}


