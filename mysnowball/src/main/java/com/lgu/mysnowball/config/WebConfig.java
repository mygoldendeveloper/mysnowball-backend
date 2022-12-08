package com.lgu.mysnowball.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000", "http://localhost:8080", "https://ec2-3-114-67-166.ap-northeast-1.compute.amazonaws.com", "http://3.114.67.166:8080",
                "https://www,mysnowball.me", "https://mysnowball.me")
            .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS", "PATCH")
            .allowedHeaders("Origin", "Content-Type", "Authorization", "Bearer", "refreshToken")
            .allowCredentials(true);
    }
}