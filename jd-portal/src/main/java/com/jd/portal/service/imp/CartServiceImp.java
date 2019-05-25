package com.jd.portal.service.imp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jd.pojo.JDResult;
import com.jd.pojo.User;
import com.jd.portal.service.CartService;
import com.jd.portal.service.UserService;
import com.jd.util.CookieUtils;
import com.jd.util.HttpClientUtil;
import com.jd.util.JsonUtils;

/*
 * 购物车，取出tmp_user_key和token,然后只需调用服务层即可处理
 */
@Service
public class CartServiceImp implements CartService {

	//cart
	@Value("${CART_BASE_URL}")
	private String CART_BASE_URL;
	@Value("${ADD_CART}")
	private String ADD_CART;
	@Value("${CART_LIST}")
	private String CART_LIST;
	@Value("${CART_DELETE}")
	private String CART_DELETE;
	@Value("${CART_CLEAR}")
	private String CART_CLEAR;
	
	
	// cookie
	@Value("${TMP_USER_KEY}")
	private String TMP_USER_KEY;
	@Value("${TOKEN}")
	private String TOKEN;

	@Autowired
	private UserService userService;

	@Override
	public JDResult addCartItem(long itemId, int num, HttpServletRequest request) {
		String tmp_user_key = CookieUtils.getCookieValue(request, TMP_USER_KEY);
		String token = CookieUtils.getCookieValue(request, TOKEN);
		User user = userService.getUserByToken(token);
		String userId = "";
		if (user != null) {
			userId = user.getId() + "";
		}
		String json = "";
		String url = CART_BASE_URL + ADD_CART + itemId + "?userId=" + userId + "&tmp_user_key=" + tmp_user_key
				+ "&num=" + num;
		try {
			json = HttpClientUtil.doGet(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDResult jdResult = JsonUtils.jsonToPojo(json, JDResult.class);
		return jdResult;
	}

	@Override
	public JDResult getCartItemList(HttpServletRequest request) {
		String tmp_user_key = CookieUtils.getCookieValue(request, TMP_USER_KEY);
		String token = CookieUtils.getCookieValue(request, TOKEN);
		User user = userService.getUserByToken(token);
		String userId = "";
		if (user != null) {
			userId = user.getId() + "";
		}
		String json = "";
		try {
			String url = CART_BASE_URL + CART_LIST + "?userId=" + userId + "&tmp_user_key=" + tmp_user_key;
			json = HttpClientUtil.doGet(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDResult jdResult = JsonUtils.jsonToPojo(json, JDResult.class);
		return jdResult;
	}

	@Override
	public JDResult deleteCartItem(long itemId, HttpServletRequest request) {
		String tmp_user_key = CookieUtils.getCookieValue(request, TMP_USER_KEY);
		String token = CookieUtils.getCookieValue(request, TOKEN);
		User user = userService.getUserByToken(token);
		String userId = "";
		if (user != null) {
			userId = user.getId() + "";
		}
		String json = "";
		try {
			String url = CART_BASE_URL + CART_DELETE + itemId + "?userId=" + userId + "&tmp_user_key="
					+ tmp_user_key;
			json = HttpClientUtil.doGet(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDResult jdResult = JsonUtils.jsonToPojo(json, JDResult.class);
		return jdResult;
	}

	@Override
	public JDResult clearCart(HttpServletRequest request) {
		String tmp_user_key = CookieUtils.getCookieValue(request, TMP_USER_KEY);
		String token = CookieUtils.getCookieValue(request, TOKEN);
		User user = userService.getUserByToken(token);
		String userId = "";
		if (user != null) {
			userId = user.getId() + "";
		}
		String json = "";
		try {
			String url = CART_BASE_URL + CART_CLEAR + "?userId=" + userId + "&tmp_user_key=" + tmp_user_key;
			json = HttpClientUtil.doGet(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDResult jdResult = JsonUtils.jsonToPojo(json, JDResult.class);
		return jdResult;
	}

}
