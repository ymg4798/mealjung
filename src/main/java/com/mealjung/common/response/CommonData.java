package com.mealjung.common.response;

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

    public static CommonData create(String message, String success, String errorYn) {
        return CommonData.builder()
                .message(message)
                .success(success)
                .errorYn(errorYn)
                .build();
    }
}
