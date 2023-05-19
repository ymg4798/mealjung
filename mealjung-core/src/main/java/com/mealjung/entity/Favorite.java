package com.mealjung.entity;

import com.mealjung.common.converter.FavoriteTypeConverter;
import com.mealjung.common.converter.utils.EnumConverterUtils;
import com.mealjung.common.enums.FavoriteType;
import com.mealjung.dto.favorite.FavoriteUpdateRequest;
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
public class Favorite extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Convert(converter = FavoriteTypeConverter.class)
    private FavoriteType type;

    private Long typeId;

    private boolean open; // 공개 비공개 여부

    private boolean delete; // 삭제여부 체크

    @Builder
    public Favorite(Long userId, FavoriteType type, Long typeId, boolean open) {
        this.userId = userId;
        this.type = type;
        this.typeId = typeId;
        this.open = open;
        this.delete = false;
    }

    public static Favorite create(Long userId, String type, Long typeId, boolean open) {
        return Favorite.builder()
                .userId(userId)
                .type(EnumConverterUtils.ofEnum(FavoriteType.class, type))
                .typeId(typeId)
                .open(open)
                .build();
    }

    public void update(FavoriteUpdateRequest request) {
        this.type = EnumConverterUtils.ofEnum(FavoriteType.class, request.getType());
        this.typeId = request.getTypeId();
        this.open = request.getOpen();
    }

    public void delete() {
        this.delete = true;
    }
}

