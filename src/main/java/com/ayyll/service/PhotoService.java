package com.ayyll.service;

import java.util.List;

import com.ayyll.entity.Photo;
import com.ayyll.entity.PhotoAlbum;

public interface PhotoService {
	
	//创建相册
	boolean createPhotoAlbum(PhotoAlbum photoAlbum);
	//删除相册
	boolean deletePhotoAlbum(PhotoAlbum photoAlbum);
	//查询用户的相册列表
	List<String> queryPhotoAlbumList(int user_id);
	//查询用户的图片列表
	List<Photo> queryPhotoList(int user_id);
}
