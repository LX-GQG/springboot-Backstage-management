package com.example.demo.config;

import com.example.demo.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: 顾倾歌
 * @Date: 2021/7/16
 * @Description: web配置
 **/

public class DemoWebConfig implements WebMvcConfigurer {

    @Value("${cbs.imagesPath}")
    private String UPLOAD_FOLDER;

    /**
     * 拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //添加拦截器
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api/**")
                //放行路径，可以添加多个
                .excludePathPatterns("/api/login")
                .excludePathPatterns("/api/cust/login")
                .addPathPatterns("/**")
                .excludePathPatterns("/upload/**");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + UPLOAD_FOLDER);
    }
}
