package com.ayyll.dao.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.ayyll.dao.UserDao;
import com.ayyll.entity.User;
import com.ayyll.utils.MyBatisUtil;

public class UserDaoImpl implements UserDao {
	
	public static final String NAMESPACE = "com.ayyll.mapper.UserMapper"; 
	@Override
	public boolean add(User user) {
		
		SqlSession session = MyBatisUtil.getSession();
		try {
			session.insert(NAMESPACE + ".addUser" , user);  
	        session.commit();
		} catch(Exception e) {
			
			e.printStackTrace();
			return false;
		} finally {
			
			session.close();
		}
        return true;
	}

	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User query(User user) {
		
		SqlSession session = MyBatisUtil.getSession();
		return session.selectOne(NAMESPACE + ".queryUser" , user);
	}
	
	@Override
	public User query(String username) {
		
		SqlSession session = MyBatisUtil.getSession();
		return session.selectOne(NAMESPACE + ".queryUserIsExit" , username);
	}
	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
