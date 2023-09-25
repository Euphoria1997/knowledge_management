package com.example.knowledge_managing.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BaseInterceptor implements WebMvcConfigurer {

    /**
     * 拦截某个请求跳转固定位置
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //super.addViewControllers(registry);
//        registry.addViewController("/IMG").setViewName("success");

        registry.addResourceHandler("/IMG/**").addResourceLocations("file:///C:/img/");
//        registry.addResourceHandler("/IMG/**").addResourceLocations("file:/www/wwwroot/img/");
//        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}