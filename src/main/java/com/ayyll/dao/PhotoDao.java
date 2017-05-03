package com.ayyll.dao;

import java.util.List;

import com.ayyll.entity.Photo;

public interface PhotoDao {

	boolean add(Photo photo);
	boolean delete(Photo photo);
	boolean update(Photo photo);	
	List<Photo> query(int user_id);
	List<Photo> queryAll();
}
