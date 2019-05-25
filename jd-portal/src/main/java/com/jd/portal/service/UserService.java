package com.jd.portal.service;

import com.jd.pojo.User;

public interface UserService {

	 User getUserByToken(String token);
}
