package com.mealjung.dto.favorite;

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


