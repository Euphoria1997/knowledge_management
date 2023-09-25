package com.example.knowledge_managing.config;

import com.example.knowledge_managing.filter.UrlFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlatformFilterConfig {
    //过滤器
    @Bean("urlFilter")
    public UrlFilter urlFilter() {
        return new UrlFilter();
    }

    //注册过滤器
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterReg = new FilterRegistrationBean();
        filterReg.setFilter(urlFilter());
        filterReg.addUrlPatterns("/*");
        filterReg.setOrder(1);
        return filterReg;
    }
}