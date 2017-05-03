package com.ayyll.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserInterceptor extends HandlerInterceptorAdapter{
	 
	/**  
     * 在业务处理器处理请求之前被调用  
     * 如果返回false  
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链 
     * 如果返回true  
     *    执行下一个拦截器,直到所有的拦截器都执行完毕  
     *    再执行被拦截的Controller  
     *    然后进入拦截器链,  
     *    从最后一个拦截器往回执行所有的postHandle()  
     *    接着再从最后一个拦截器往回执行所有的afterCompletion()  
     */ 
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String requestUri = request.getRequestURI();
		//注册登陆界面不拦截
		if(requestUri.equals("/album/register") || requestUri.endsWith("/album/login")|| requestUri.equals("/album/register.do"))return true;
		//如果未登陆,返回到登陆页面
		if(request.getSession().getAttribute("username") == null) {
			response.sendRedirect("/album");
			return false;
		}
		return true;
	}
	
}
