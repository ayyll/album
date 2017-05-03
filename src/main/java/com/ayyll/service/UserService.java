package com.ayyll.service;

import com.ayyll.entity.User;

public interface UserService {
	
	/**
	 * @param user
	 * @return 返回用户的id，不存在返回-1
	 */
	int login(User user);
	
	boolean register(User user);
}
