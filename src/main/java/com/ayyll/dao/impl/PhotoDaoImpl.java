package com.ayyll.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ayyll.dao.PhotoDao;
import com.ayyll.entity.Photo;
import com.ayyll.utils.MyBatisUtil;

public class PhotoDaoImpl implements PhotoDao {
	public static final String NAMESPACE = "com.ayyll.mapper.PhotoMapper";

	@Override
	public boolean add(Photo photo) {

		SqlSession session = MyBatisUtil.getSession();
		try {
			session.insert(NAMESPACE + ".addPhoto", photo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	@Override
	public boolean delete(Photo photo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Photo photo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Photo> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Photo> query(int user_id) {
		
		SqlSession session = MyBatisUtil.getSession();
		return session.selectList(NAMESPACE + ".queryPhotoById", user_id);
	}

}
