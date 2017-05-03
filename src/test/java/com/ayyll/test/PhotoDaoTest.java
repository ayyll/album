package com.ayyll.test;

import org.junit.Before;
import org.junit.Test;

import com.ayyll.dao.PhotoAlbumDao;
import com.ayyll.dao.PhotoDao;
import com.ayyll.dao.impl.PhotoAlbumDaoImpl;
import com.ayyll.dao.impl.PhotoDaoImpl;
import com.ayyll.entity.Photo;

public class PhotoDaoTest {
	private PhotoDao pdao;
	private PhotoAlbumDao padao;
	@Before
	public void before() {
		pdao = new PhotoDaoImpl();
		padao = new PhotoAlbumDaoImpl();
	}
	@Test
	public void testAdd() {
		
		System.out.println(padao.queryByUserId(1));
	}
}
