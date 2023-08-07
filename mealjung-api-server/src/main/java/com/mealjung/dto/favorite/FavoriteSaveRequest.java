package com.mealjung.dto.favorite;

import com.mealjung.common.converter.utils.EnumConverterUtils;
import com.mealjung.common.enums.FavoriteType;
import com.mealjung.entity.favorite.Favorite;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class FavoriteSaveRequest {
    private Long userId;// 임시 필드
    @NotBlank(message = "type 값이 비어있습니다.")
    private String type;
    @NotBlank(message = "Id 값이 비어있습니다.")
    private Long typeId;
    @NotNull(message = "공개 비공개 여부를 선택해주세요.")
    private Boolean open;

    public Favorite toEntity() {
        return Favorite.builder()
                .userId(userId)
                .type(EnumConverterUtils.ofEnum(FavoriteType.class, type))
                .typeId(typeId)
                .open(open)
                .build();
    }
}


