package com.jd.portal.service.imp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jd.pojo.JDResult;
import com.jd.pojo.User;
import com.jd.portal.pojo.OrderCustom;
import com.jd.portal.service.CartService;
import com.jd.portal.service.OrderService;
import com.jd.portal.service.UserService;
import com.jd.util.CookieUtils;
import com.jd.util.HttpClientUtil;
import com.jd.util.JsonUtils;

@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	private UserService userService;
	@Value("${TOKEN}")
	private String TOKEN;

	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	@Value("${ORDER_CREATE}")
	private String ORDER_CREATE;
	@Value("${ORDER_LIST}")
	private String ORDER_LIST;

	@Autowired
	private CartService cartService;

	@Override
	public JDResult createOrder(OrderCustom orderCustom, HttpServletRequest request) {
		String token = CookieUtils.getCookieValue(request, TOKEN);
		User user = userService.getUserByToken(token);
		orderCustom.setBuyerNick(user.getUsername());
		orderCustom.setUserId(user.getId());
		String json = "";
		try {
			json = HttpClientUtil.doPostJson(ORDER_BASE_URL + ORDER_CREATE, JsonUtils.objectToJson(orderCustom));
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDResult jdResult = JsonUtils.jsonToPojo(json, JDResult.class);
		// 订单成功，清楚购物车
		if (jdResult.getStatus() == 200) {
			cartService.clearCart(request);
		}
		return jdResult;
	}

	@Override
	public JDResult getOrderList(Integer page, Integer rows, HttpServletRequest request) {
		String token = CookieUtils.getCookieValue(request, TOKEN);
		User user = userService.getUserByToken(token);
		String json = "";
		try {
			json = HttpClientUtil.doGet(ORDER_BASE_URL + ORDER_LIST + user.getId() + "/" + page + "/" + rows);
			JDResult jdResult = JsonUtils.jsonToPojo(json, JDResult.class);
			return jdResult;
		} catch (Exception e) {
			e.printStackTrace();
			return JDResult.build(500, e.getMessage());
		}
	}

}
