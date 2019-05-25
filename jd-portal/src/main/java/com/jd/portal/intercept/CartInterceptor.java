package com.jd.portal.intercept;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jd.util.CookieUtils;

/*
 * 在访问/page/item时添加一个临时购物车tmp_user_key
 */
@Component
public class CartInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 判断用户是否登录
		// 从cookie中取临时购物车的key值
		String tmp_user_key = CookieUtils.getCookieValue(request, "tmp_user_key");
		if (tmp_user_key == null) {
			// 如果不存在，生成一保存在cookie内
			tmp_user_key = UUID.randomUUID() + "";
			//存取3天
			CookieUtils.setCookie(request, response, "tmp_user_key", tmp_user_key, 1*3*24*60*60);
		}
		return true;
	}

}
