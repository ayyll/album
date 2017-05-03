package com.ayyll.service.impl;

import com.ayyll.dao.UserDao;
import com.ayyll.dao.impl.UserDaoImpl;
import com.ayyll.entity.User;
import com.ayyll.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao udao;
	public UserServiceImpl() {
		
		udao = new UserDaoImpl();
	}
	@Override
	
	public int login(User user) {
		
		User ans = udao.query(user);
		return ans != null ? ans.getId() : -1;
		
	}
	@Override
	public boolean register(User user) {
		//如果用户名已存在,返回false
		if(udao.query(user.getUsername()) != null) return false;
		return udao.add(user);
		 
	}

}
