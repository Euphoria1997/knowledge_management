//package com.example.knowledge_managing.config;
//
//import com.example.knowledge_managing.interceptor.PathRewriterInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
//
//    @Autowired
//    PathRewriterInterceptor pathRewriterInterceptor;
//
//    @Bean
//    PathRewriterInterceptor getInterceptor(){
//        return new PathRewriterInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(pathRewriterInterceptor).addPathPatterns("/**");
//    }
//
//}
