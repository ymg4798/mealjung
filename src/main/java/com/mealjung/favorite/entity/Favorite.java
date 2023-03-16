package com.mealjung.favorite.entity;

import com.mealjung.common.utils.enums.FavoriteType;
import com.mealjung.common.utils.enums.converter.FavoriteTypeConverter;
import com.mealjung.common.utils.enums.converter.statics.EnumConverterUtils;
import com.mealjung.favorite.controller.dto.FavoriteUpdateRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 *  open 공개 비공개 여부
 *  향후 좋아요 리스트에서 해당 게시물로 이동방식.. 해당 타입 url/id 로 조회 ..
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = FavoriteTypeConverter.class)
    private FavoriteType type;

    private Long typeId;

    private String title;

    private boolean open; // 공개 비공개 여부

    private boolean delete; // 삭제여부 체크

    @Builder
    public Favorite(FavoriteType type, Long typeId, String title, boolean open) {
        this.type = type;
        this.typeId = typeId;
        this.title = title;
        this.open = open;
        this.delete = false;
    }

    public static Favorite create(String type, Long typeId, String title, boolean open) {
        return Favorite.builder()
                .type(EnumConverterUtils.ofEnum(FavoriteType.class, type))
                .typeId(typeId)
                .title(title)
                .open(open)
                .build();
    }

    public void update(FavoriteUpdateRequest request) {
        this.type = EnumConverterUtils.ofEnum(FavoriteType.class, request.getType());
        this.typeId = request.getTypeId();
        this.title = request.getTitle();
        this.open = request.getOpen();
    }

    public void delete() {
        this.delete = true;
    }
}


