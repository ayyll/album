package com.ayyll.dao;

import java.util.List;

import com.ayyll.entity.PhotoAlbum;

public interface PhotoAlbumDao {
	//新建相册
	boolean add(PhotoAlbum photoAlbum);
	//删除相册
	boolean delete(PhotoAlbum photoAlbum);
	//根据用户id查询相册
	List<PhotoAlbum> queryByUserId(int user_id);
	
}
