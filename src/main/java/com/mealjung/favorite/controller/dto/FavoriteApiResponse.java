package com.mealjung.favorite.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FavoriteApiResponse<T> {
    private FavoriteApiCommonResponse common;
    private T data;

    public FavoriteApiResponse(FavoriteApiCommonResponse common, T data) {
        this.common = common;
        this.data = data;
    }

    public static<T> FavoriteApiResponse<T> response(FavoriteApiCommonResponse common) {
        return new FavoriteApiResponse<>(common, null);
    }

    public static<T> FavoriteApiResponse<T> response(FavoriteApiCommonResponse common, T data) {
        return new FavoriteApiResponse<>(common, data);
    }

}
