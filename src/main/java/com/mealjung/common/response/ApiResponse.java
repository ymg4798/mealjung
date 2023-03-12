package com.mealjung.common.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ApiResponse<T> {
    private CommonData common;
    private T data;

    public ApiResponse(CommonData common, T data) {
        this.common = common;
        this.data = data;
    }

    public static<T> ApiResponse<T> response(CommonData common) {
        return new ApiResponse<>(common, null);
    }

    public static<T> ApiResponse<T> response(CommonData common, T data) {
        return new ApiResponse<>(common, data);
    }

}
