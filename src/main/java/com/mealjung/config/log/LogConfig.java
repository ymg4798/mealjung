package com.mealjung.config.log;

import com.mealjung.common.log.LogTrace;
import com.mealjung.common.log.LogTraceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfig {

    @Bean
    public LogTrace logTrace() {
        return new LogTraceImpl();
    }
}
