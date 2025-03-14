package org.example.pkdkdonghieube.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Áp dụng cho tất cả API
                        .allowedOrigins("http://localhost:5173") // Cho phép React truy cập
                        .allowedOrigins("https://pkdakhoadonghieu.netlify.app")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Cho phép các phương thức HTTP
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}

