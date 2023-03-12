package com.mealjung.common.log.aspect;

import com.mealjung.common.log.LogTrace;
import com.mealjung.common.log.dto.TraceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Aspect
@Component
public class TraceAspect {

    private final LogTrace logTrace;

    @Around("execution(* com.mealjung.*.controller..*(..)) " +
            "|| execution(* com.mealjung.*.service..*(..))" +
            "|| execution(* com.mealjung.*.entity..*(..))")
    public Object doTrace(ProceedingJoinPoint joinPoint) throws  Throwable{
        TraceStatus status = null;
        try {
            status = logTrace.begin(joinPoint.getSignature().toString());
            Object result = joinPoint.proceed();
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
