package com.mealjung.favorite.controller.dto;

import com.mealjung.favorite.entity.Favorite;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FavoriteSaveResponse {
    private String type;
    private Long typeId;
    private String title;

    @Builder
    public FavoriteSaveResponse(String type, Long typeId, String title) {
        this.type = type;
        this.typeId = typeId;
        this.title = title;
    }

    public static FavoriteSaveResponse create(Favorite entity) {
        return FavoriteSaveResponse.builder()
                .type(entity.getType().getValue())
                .typeId(entity.getTypeId())
                .title(entity.getTitle())
                .build();
    }
}
