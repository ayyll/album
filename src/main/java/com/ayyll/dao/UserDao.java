package com.ayyll.dao;

import java.util.List;

import com.ayyll.entity.User;

public interface UserDao {
	
	boolean add(User user);
	boolean delete(User user);
	boolean update(User user);
	
	User query(User user);
	User query(String username);
	List<User> queryAll();
}
