package com.jd.portal.service.imp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jd.pojo.JDResult;
import com.jd.pojo.User;
import com.jd.portal.service.UserService;
import com.jd.util.HttpClientUtil;

/**
 * 
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Value("${SSO_BASE_URL}")
	public String SSO_BASE_URL;
	@Value("${SSO_USER_TOKEN}")
	private String SSO_USER_TOKEN;
	@Value("${SSO_PAGE_LOGIN}")
	public String SSO_PAGE_LOGIN;
	@Value("${COOKIE_NAME}")
	public String COOKIE_NAME;
	
	
	@Override
	public User getUserByToken(String token) {
		String json =null;
		try {
			//调用sso系统的服务，根据token取用户信息
			try {
				json = HttpClientUtil.doGet(SSO_BASE_URL + SSO_USER_TOKEN + token);
			}catch (Exception e) {
				e.printStackTrace();
			}
			//把json转换成JDREsult
			JDResult result = JDResult.formatToPojo(json, User.class);
			if (result.getStatus() == 200) {
				User user = (User) result.getData();
				return user;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
