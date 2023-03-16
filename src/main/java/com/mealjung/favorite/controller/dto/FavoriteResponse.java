package com.mealjung.favorite.controller.dto;

import com.mealjung.favorite.entity.Favorite;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FavoriteResponse {
    private String type;
    private Long typeId;
    private String title;
    private Boolean open;
    private Boolean delete;

    @QueryProjection
    @Builder
    public FavoriteResponse(String type, Long typeId, String title, Boolean open, Boolean delete) {
        this.type = type;
        this.typeId = typeId;
        this.title = title;
        this.open = open;
        this.delete = delete;
    }

    public static FavoriteResponse create(Favorite favorite) {
        return FavoriteResponse.builder()
                .type(favorite.getType().getValue())
                .typeId(favorite.getTypeId())
                .title(favorite.getTitle())
                .open(favorite.isOpen())
                .delete(favorite.isDelete())
                .build();
    }
}
