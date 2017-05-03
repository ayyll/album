package com.ayyll.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ayyll.entity.PhotoAlbum;
import com.ayyll.service.PhotoService;
import com.ayyll.service.impl.PhotoServiceImpl;


@Controller
public class PhotoAlbumController {
	
	/**
	 * @param request
	 * @return
	 * 创建相册
	 */
	@RequestMapping(value = "/user/photo_album", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createAlbum(HttpServletRequest request) {
		
		int user_id = (Integer)request.getSession().getAttribute("user_id");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		Timestamp ts = new Timestamp(new Date().getTime());
		PhotoAlbum photoAlbum = new PhotoAlbum(user_id, name, description, ts);
		//System.out.println("name = " + name + "desc =" + description);
		
		Map<String, Object> map = new HashMap<String, Object>();
		PhotoService ps = new PhotoServiceImpl();
		if(ps.createPhotoAlbum(photoAlbum)) {
			map.put("msg", "ok");
		} else {
			map.put("msg", "no");
		}
		return map;
	}
	
	/**
	 * @param request
	 * @return
	 * 请求相册列表,即查询用户的相册目录
	 */
	@RequestMapping(value = "/photoAlbumList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getPhotoAlbumList(HttpServletRequest request) {
		
		int user_id = (Integer)request.getSession().getAttribute("user_id");
		Map<String,Object> map = new HashMap<String, Object>();
		PhotoService ps = new PhotoServiceImpl();
		List<String> ans =  ps.queryPhotoAlbumList(user_id);
		//System.out.println(ans);
		map.put("list", ans);
		return map;
	}
}
