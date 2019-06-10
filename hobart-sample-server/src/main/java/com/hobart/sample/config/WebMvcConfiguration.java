package com.hobart.sample.config;

import com.hobart.sample.common.interceptor.RequestLoggingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestLoggingHandler());
    }

    /**
     * 自己定义的拦截器类
     * @return
     */
    @Bean
    RequestLoggingHandler requestLoggingHandler() {
        return new RequestLoggingHandler();
    }
}
