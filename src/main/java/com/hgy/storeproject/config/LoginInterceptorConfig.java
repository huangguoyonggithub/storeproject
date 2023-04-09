package com.hgy.storeproject.config;

import com.hgy.storeproject.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/** 处理拦截器的注册（过滤器）*/
@Configuration //加载当前的拦截器并进行注册(自动加载)
public class LoginInterceptorConfig implements WebMvcConfigurer {
    /**配置拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 创建拦截器对象
        HandlerInterceptor interceptor = new LoginInterceptor();

        // 白名单
        List<String> patterns = new ArrayList<String>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/font/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/picture/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/web/all-product.html");
        patterns.add("/web/sidebar.html");
        patterns.add("/web/product-single.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");
        patterns.add("/goods/**");

        // 通过注册工具添加拦截器
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(patterns);
    }
}
