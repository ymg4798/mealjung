package com.mealjung.favorite.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FavoriteApiCommonResponse {
    private String message;
    private String success;
    private String errorYn;

    @Builder
    public FavoriteApiCommonResponse(String message, String success, String errorYn) {
        this.message = message;
        this.success = success;
        this.errorYn = errorYn;
    }

    public static FavoriteApiCommonResponse create(String message, String success, String errorYn) {
        return FavoriteApiCommonResponse.builder()
                .message(message)
                .success(success)
                .errorYn(errorYn)
                .build();
    }
}
