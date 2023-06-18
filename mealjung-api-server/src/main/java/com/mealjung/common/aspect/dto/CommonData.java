package com.mealjung.common.aspect.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CommonData {
    private String message;
    private String success;
    private String errorYn;

    @Builder
    public CommonData(String message, String success, String errorYn) {
        this.message = message;
        this.success = success;
        this.errorYn = errorYn;
    }
}
