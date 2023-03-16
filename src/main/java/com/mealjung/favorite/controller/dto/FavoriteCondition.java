package com.mealjung.favorite.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FavoriteCondition {
    private String type;
    private String title;

    public FavoriteCondition(String type, String title) {
        this.type = type;
        this.title = title;
    }
}


