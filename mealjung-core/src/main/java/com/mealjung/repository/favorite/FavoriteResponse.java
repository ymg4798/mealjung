package com.mealjung.repository.favorite;

import com.mealjung.common.enums.FavoriteType;
import com.mealjung.entity.favorite.Favorite;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FavoriteResponse {
    private String type;
    private Long typeId;
    private Boolean open;
    private Boolean delete;

    @QueryProjection
    @Builder
    public FavoriteResponse(FavoriteType type, Long typeId, Boolean open, Boolean delete) {
        this.type = type.getValue();
        this.typeId = typeId;
        this.open = open;
        this.delete = delete;
    }

    public static FavoriteResponse create(Favorite favorite) {
        return FavoriteResponse.builder()
                .type(favorite.getType())
                .typeId(favorite.getTypeId())
                .open(favorite.isOpen())
                .delete(favorite.isDelete())
                .build();
    }
}
