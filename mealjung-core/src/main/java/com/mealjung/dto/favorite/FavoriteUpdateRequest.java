package com.mealjung.dto.favorite;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class FavoriteUpdateRequest {
    private Long userId;
    @NotBlank(message = "Type 이 비어있습니다.")
    private String type;
    @NotBlank(message = "TypeId가 비어있습니다.")
    private Long typeId;
    @NotNull(message = "공개 비공개 여부를 선택해주세요.")
    private Boolean open;

    @Builder
    public FavoriteUpdateRequest(Long userId, String type, Long typeId, Boolean open) {
        this.userId = userId;
        this.type = type;
        this.typeId = typeId;
        this.open = open;
    }
}


