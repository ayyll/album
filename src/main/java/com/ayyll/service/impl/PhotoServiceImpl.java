package com.ayyll.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.ayyll.dao.PhotoAlbumDao;
import com.ayyll.dao.PhotoDao;
import com.ayyll.dao.impl.PhotoAlbumDaoImpl;
import com.ayyll.dao.impl.PhotoDaoImpl;
import com.ayyll.entity.Photo;
import com.ayyll.entity.PhotoAlbum;
import com.ayyll.service.PhotoService;

public class PhotoServiceImpl implements PhotoService {

	private PhotoAlbumDao  paDao;
	private PhotoDao  pdao;
	
	public PhotoServiceImpl() {
		paDao = new PhotoAlbumDaoImpl();
		pdao = new PhotoDaoImpl();
	}
	@Override
	public boolean createPhotoAlbum(PhotoAlbum photoAlbum) {
		
		return paDao.add(photoAlbum);
	}

	@Override
	public boolean deletePhotoAlbum(PhotoAlbum photoAlbum) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<String> queryPhotoAlbumList(int user_id) {
		
		List<String> ans = new ArrayList<String>();
		List<PhotoAlbum> q = paDao.queryByUserId(user_id);
		for (PhotoAlbum photoAlbum : q) {
			ans.add(photoAlbum.getName());
		}
		return ans;
		 
	}
	@Override
	public List<Photo> queryPhotoList(int user_id) {
		
		return pdao.query(user_id);
		
	}

}
