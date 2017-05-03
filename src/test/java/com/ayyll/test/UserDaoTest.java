package com.ayyll.test;

import org.junit.Before;
import org.junit.Test;

import com.ayyll.dao.UserDao;
import com.ayyll.dao.impl.UserDaoImpl;
import com.ayyll.entity.User;

public class UserDaoTest {
	private UserDao udao;
	@Before
	public void before() {
		udao = new UserDaoImpl();
	}
	@Test
	public void testQuery() {
		User user = new User("yh","123456");
		System.out.println(udao.query(user));
	}
}
