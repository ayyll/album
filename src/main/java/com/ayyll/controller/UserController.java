package com.ayyll.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ayyll.entity.User;
import com.ayyll.service.PhotoService;
import com.ayyll.service.UserService;
import com.ayyll.service.impl.PhotoServiceImpl;
import com.ayyll.service.impl.UserServiceImpl;

@Controller
public class UserController {
	
	@RequestMapping(value = "/login ", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> login(HttpServletRequest request) throws IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//System.out.println(username + "," + password);
		User user = new User(username,password);
		UserService us = new UserServiceImpl();
		
		//查询账号密码是否匹配,存在返回用户id,不存在返回-1
		int id = us.login(user);
		//System.out.println(id);
		Map<String, Object> map = new HashMap<String, Object>();
		if(id != -1) {
			map.put("msg", "ok");
			map.put("user_id", id);
			//把用户名保存在session
			request.getSession().setAttribute("user_id", id);
			request.getSession().setAttribute("username", username);
		} else {
			map.put("msg", "no");
		}
		return map;		
	}
	
	@RequestMapping(value = "/user/{id} ", method = RequestMethod.GET)
	public ModelAndView testREST(@PathVariable Long id,HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value = "/toIndex", method = RequestMethod.GET)
	public ModelAndView toIndex(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView register(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		return mv;
	}
	
	@RequestMapping(value = "/register.do ", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> doRegister(HttpServletRequest request) throws IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username, password);
		//System.out.println(username  + " " + password);
		UserService us = new UserServiceImpl();
		Map<String,Object> map = new HashMap<String, Object>();
		if(us.register(user)) map.put("msg", "ok");
		else map.put("msg", "no");
		return map;
	}
}
