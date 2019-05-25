package com.jd.portal.springconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.jd.portal.intercept.CartInterceptor;
import com.jd.portal.intercept.LoginInterceptor;

@SuppressWarnings("deprecation")
@Configuration
public class SpringMVCConfig extends WebMvcConfigurerAdapter {
    
    @Autowired
    private LoginInterceptor loginIterceptor;
    @Autowired
    private CartInterceptor cartInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 判断用户是否登录的拦截器
        registry.addInterceptor(loginIterceptor).addPathPatterns("/page/order/**");
        
        //添加临时购物车key
        registry.addInterceptor(cartInterceptor).addPathPatterns("/page/item");
    }

}
