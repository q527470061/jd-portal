package com.jd.portal.service;

import javax.servlet.http.HttpServletRequest;

import com.jd.pojo.JDResult;
import com.jd.portal.pojo.OrderCustom;

public interface OrderService {

	JDResult createOrder(OrderCustom orderCustom ,HttpServletRequest request);
	
	JDResult getOrderList(Integer page,Integer rows,HttpServletRequest request);
}
