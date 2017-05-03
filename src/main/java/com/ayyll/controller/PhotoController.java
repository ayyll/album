package com.ayyll.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.ayyll.dao.PhotoDao;
import com.ayyll.dao.impl.PhotoDaoImpl;
import com.ayyll.entity.Photo;
import com.ayyll.service.PhotoService;
import com.ayyll.service.impl.PhotoServiceImpl;

@Controller
public class PhotoController {

	/**
	 * @param file
	 * 图片上传
	 */
	@RequestMapping(value = "/photo", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> solve(@RequestParam(value = "imgfile", required = false) MultipartFile file,HttpServletRequest request) throws IOException {

		String path = request.getSession().getServletContext()
				.getRealPath("images");
		String fileName = file.getOriginalFilename();
		//System.out.println(path);
		String username = (String)request.getSession().getAttribute("username");
		String type = request.getParameter("type");
		path += "/" + username + "/" + type;
		//System.out.println(path);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		String url = "images/" + username + "/" + type + "/" + fileName;
		PhotoDao pdao = new PhotoDaoImpl();
		Photo photo = new Photo((Integer)request.getSession().getAttribute("user_id"), type, url, new Timestamp(new Date().getTime()));
		// 保存
		try {
			file.transferTo(targetFile);//图片存储在服务器
			pdao.add(photo);//图片信息以及url存储在数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "ok");
		return map;
		
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public ModelAndView upload(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("upload");
		return mv;
	}
	
	@RequestMapping(value = "/plist", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> getPlist(HttpServletRequest request) throws IOException {
		
		PhotoService ps = new PhotoServiceImpl();
		//System.out.println(request.getSession().getAttribute("user_id"));
		List<Photo> ans = ps.queryPhotoList((Integer)request.getSession().getAttribute("user_id"));
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("photo", ans);
		return map;
	}
}
