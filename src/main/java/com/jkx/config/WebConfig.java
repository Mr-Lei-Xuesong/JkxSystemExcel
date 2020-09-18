package com.jkx.config;

import com.jkx.config.Interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lx
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //将我们上步定义的实现了HandlerInterceptor接口的拦截器实例authenticationInterceptor
        // 添加InterceptorRegistration中，并设置过滤规则，
        // 所有请求都要经过authenticationInterceptor拦截。
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/**").excludePathPatterns("/login/**");

    }
}
