package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Author: 顾倾歌
 * @Date: 2021/7/16
 * @Description: 跨域配置
 **/

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //允许源，这里允许所有源访问，实际应用会加以限制
        corsConfiguration.addAllowedOrigin("*");
        //允许所有请求头
        corsConfiguration.addAllowedHeader("*");
        //允许所有方法
        corsConfiguration.addAllowedMethod("*");
        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(source);
    }

}
