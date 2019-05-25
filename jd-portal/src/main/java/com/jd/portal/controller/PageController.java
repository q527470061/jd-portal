package com.jd.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/page")
@Controller
public class PageController {

	//商品详情页
	@RequestMapping("/item")
	public String getItem() {
		return "item";
	}
	
	@RequestMapping("/cart/success")
	public String showSuccess() {
		return "cart_msg";
	}

	@RequestMapping("/cart/list")
	public String showCart() {
		return "cart";
	}
	
	@RequestMapping("/order/orderInf")
	public String showOrderInf() {
		return "orderInf";
	}
	

}
