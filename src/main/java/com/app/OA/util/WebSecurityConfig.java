package com.app.OA.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebSecurityConfig implements WebMvcConfigurer{
	
    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
//        // 排除配置
        addInterceptor.excludePathPatterns("/account/login**");
        addInterceptor.excludePathPatterns("/static/**");      
        // 拦截配置
        addInterceptor.addPathPatterns("/account/**");
        addInterceptor.addPathPatterns("/photo/**");
        addInterceptor.addPathPatterns("/power/**");
        addInterceptor.addPathPatterns("/role/**");
    }
    
       

}
