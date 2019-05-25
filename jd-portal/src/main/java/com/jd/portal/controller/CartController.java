package com.jd.portal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jd.pojo.JDResult;
import com.jd.portal.service.CartService;

@RequestMapping("/cart")
@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping("/add/{itemId}")
	public JDResult addCartItem(@PathVariable Long itemId, @RequestParam(defaultValue = "1") Integer num,
			HttpServletRequest request) {
		return cartService.addCartItem(itemId, num, request);
	}

	@RequestMapping("/delete/{itemId}")
	public JDResult deleteCartItem(@PathVariable Long itemId, HttpServletRequest request) {		
		return cartService.deleteCartItem(itemId, request);
	}
	
	@RequestMapping("/list")
	public JDResult getCart(HttpServletRequest request) {
		return cartService.getCartItemList(request);
	}
	
	@RequestMapping("/clear")
	public JDResult clearCart(HttpServletRequest request) {
		return cartService.clearCart(request);
	}
}
