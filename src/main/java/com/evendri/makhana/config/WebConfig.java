package com.evendri.makhana.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // This configuration tells Spring Boot to serve requests for /uploads/**
        // from the local 'uploads' folder in the project directory.
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:uploads/");
    }
}