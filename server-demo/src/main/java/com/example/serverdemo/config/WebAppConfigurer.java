package com.example.serverdemo.config;

import com.example.serverdemo.handlerInterceptor.RestTemplateControllerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个，/**是对所有的请求都做拦截
        registry.addInterceptor(new RestTemplateControllerInterceptor())
                .addPathPatterns("/");
//                .excludePathPatterns("/login", "/register");
    }

}
