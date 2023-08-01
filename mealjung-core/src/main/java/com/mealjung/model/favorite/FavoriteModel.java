package com.mealjung.model.favorite;

import com.mealjung.common.enums.FavoriteType;
import com.mealjung.entity.favorite.Favorite;
import com.querydsl.core.annotations.QueryProjection;

public class FavoriteModel {

    private final Long userId;

    private final FavoriteType type;

    private final Long typeId;

    private final boolean open;

    @QueryProjection
    public FavoriteModel(Long userId, FavoriteType type, Long typeId, boolean open) {
        this.userId = userId;
        this.type = type;
        this.typeId = typeId;
        this.open = open;
    }

    public static Favorite create(Long userId, FavoriteType type, Long typeId, boolean open) {
        return Favorite.builder()
                .userId(userId)
                .type(type)
                .typeId(typeId)
                .open(open)
                .build();
    }

    public Long getUserId() {
        return userId;
    }

    public FavoriteType getType() {
        return type;
    }

    public Long getTypeId() {
        return typeId;
    }

    public boolean isOpen() {
        return open;
    }
}
