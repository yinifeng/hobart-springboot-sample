package com.hobart.sample.config;

import com.hobart.sample.common.interceptor.RequestLoggingHandler;
import com.hobart.sample.common.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor());
    }

    /**
     * 自己定义的拦截器类
     * @return
     */
    //@Bean
    RequestLoggingHandler requestLoggingHandler() {
        return new RequestLoggingHandler();
    }

    /**
     * 自己定义的拦截器类
     * @return
     */
    @Bean
    TokenInterceptor tokenInterceptor() {
        return new TokenInterceptor();
    }
}
