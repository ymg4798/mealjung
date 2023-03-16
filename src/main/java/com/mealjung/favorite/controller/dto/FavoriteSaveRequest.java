package com.mealjung.favorite.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class FavoriteSaveRequest {
    @NotBlank(message = "type 값이 비어있습니다.")
    private String type;
    @NotBlank(message = "Id 값이 비어있습니다.")
    private Long typeId;
    @NotBlank(message = "제목이 비어있습니다.")
    private String title;
    @NotNull(message = "공개 비공개 여부를 선택해주세요.")
    private Boolean open;
}
