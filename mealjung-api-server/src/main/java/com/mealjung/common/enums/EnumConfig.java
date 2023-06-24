package com.mealjung.common.enums;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnumConfig {
    @Bean
    public EnumBean enumBean() {
        EnumBean enumBean = new EnumBean();

        //enumBean.put("Sample", Sample.class);

        return enumBean;
    }
}
