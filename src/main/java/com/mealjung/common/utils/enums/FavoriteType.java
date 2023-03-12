package com.mealjung.common.utils.enums;

import lombok.Getter;

@Getter

public enum FavoriteType implements EnumType {
    REVIEW("REVIEW", "리뷰"),
    RESTAURANT("RESTAURANT", "식당"),
    MENU("MENU", "메뉴");

    private String code;
    private String value;

    FavoriteType(String code, String value) {
        this.code = code;
        this.value = value;
    }
}


