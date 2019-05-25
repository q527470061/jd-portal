package com.jd.portal.service;

import javax.servlet.http.HttpServletRequest;
import com.jd.pojo.JDResult;


public interface CartService {
	//购物车，取出tmp_user_key和token,然后只需调用服务层即可处理
	
	JDResult addCartItem(long itemId, int num, HttpServletRequest request);
	
	JDResult getCartItemList(HttpServletRequest request);
	
	JDResult deleteCartItem(long itemId, HttpServletRequest request);
	
	JDResult clearCart(HttpServletRequest request);
}
