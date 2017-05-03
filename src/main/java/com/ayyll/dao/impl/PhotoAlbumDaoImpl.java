package com.ayyll.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ayyll.dao.PhotoAlbumDao;
import com.ayyll.entity.PhotoAlbum;
import com.ayyll.utils.MyBatisUtil;

public class PhotoAlbumDaoImpl implements PhotoAlbumDao {

	public static final String NAMESPACE = "com.ayyll.mapper.PhotoAlbumMapper";
	@Override
	public boolean add(PhotoAlbum photoAlbum) {
		
		SqlSession session = MyBatisUtil.getSession();
		try {
			session.insert(NAMESPACE + ".addPhotoAlbum", photoAlbum);
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
	public boolean delete(PhotoAlbum photoAlbum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PhotoAlbum> queryByUserId(int user_id) {
		
		SqlSession session = MyBatisUtil.getSession();
		return session.selectList(NAMESPACE + ".queryByUserId", user_id);
		 
	}

}
