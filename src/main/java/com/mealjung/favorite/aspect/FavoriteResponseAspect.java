package com.mealjung.favorite.aspect;

import com.mealjung.favorite.controller.dto.FavoriteApiCommonResponse;
import com.mealjung.favorite.controller.dto.FavoriteApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class FavoriteResponseAspect {

    @Around("@annotation(com.mealjung.favorite.annotation.FavoriteResponse)")
    public FavoriteApiResponse<Object> doResponse(ProceedingJoinPoint joinPoint) {

        log.info("[ApiResponse] {}", joinPoint.getSignature());

        FavoriteApiResponse<?> result = null;
        String message = "";
        String success = "N";

        try {
            Object proceedResult = joinPoint.proceed();
            if (proceedResult instanceof FavoriteApiResponse) {
                result = (FavoriteApiResponse<?>) proceedResult;
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
            result = new FavoriteApiResponse<>();
            success = "N";
        }

        FavoriteApiCommonResponse common = FavoriteApiCommonResponse.create(message, success, success.equals("N") ? "Y" : "N");

        return FavoriteApiResponse.response(common, result.getData());
    }
}
