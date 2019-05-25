package com.jd.portal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jd.pojo.JDResult;
import com.jd.portal.pojo.OrderCustom;
import com.jd.portal.service.OrderService;

@RequestMapping("/order")
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/create")
	public JDResult createOrder(@RequestBody OrderCustom orderCustom, HttpServletRequest request) {

		return orderService.createOrder(orderCustom, request);
	}

	@RequestMapping("/list/{page}/{rows}")
	public JDResult getOrderList(@PathVariable Integer page, @PathVariable Integer rows, HttpServletRequest request) {

		return orderService.getOrderList(page, rows, request);
	}

}
