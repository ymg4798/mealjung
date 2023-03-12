package com.mealjung.favorite.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class FavoriteSaveRequest {
    @NotBlank(message = "type 값이 비어있습니다.")
    private String type;
    @NotBlank(message = "Id 값이 비어있습니다.")
    private Long typeId;
    @NotBlank(message = "제목이 비어있습니다.")
    private String title;
}
