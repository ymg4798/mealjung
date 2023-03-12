package com.mealjung.common.response.aspect;

import com.mealjung.common.response.ApiResponse;
import com.mealjung.common.response.CommonData;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ApiResponseAspect {

    @Around("@within(com.mealjung.common.response.annotation.ApiResponseAnnotation)")
    public ApiResponse<Object> doResponse(ProceedingJoinPoint joinPoint) {

        log.info("[ApiResponse] {}", joinPoint.getSignature());

        ApiResponse<?> result = null;
        String message = "";
        String success = "N";

        try {
            Object proceedResult = joinPoint.proceed();
            if (proceedResult instanceof ApiResponse) {
                result = (ApiResponse<?>) proceedResult;
                success = "Y";
            } else {
                throw new IllegalStateException("반환 값이 올바르지 않습니다.");
            }
        } catch (RuntimeException e) {
            message = e.getMessage();
        }  catch (Throwable e) {
            log.error("Error occurred while processing request: {}", e.getMessage());
        }

        if (result == null) {
            result = new ApiResponse<>();
            success = "N";
        }

        CommonData common = CommonData.create(message, success, success.equals("N") ? "Y" : "N");

        return ApiResponse.response(common, result.getData());
    }
}
