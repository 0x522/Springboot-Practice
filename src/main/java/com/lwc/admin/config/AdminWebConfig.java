package com.lwc.admin.config;

import com.lwc.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")     //选择添加路径哪些被拦截
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/aaa/**","/anno","/ico/**")
        .excludePathPatterns("/LoginController");   //去除要拦截的路径
    }
}
