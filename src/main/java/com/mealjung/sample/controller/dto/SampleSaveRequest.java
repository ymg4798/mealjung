package com.mealjung.sample.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class SampleSaveRequest {

    @NotBlank(message = "값을 입력 해주세요.")
    private String name;

    @NotBlank(message = "값을 입력 해주세요.")
    private String address;

    @Pattern(regexp = "^[YN]$")
    private String openYn;
}


