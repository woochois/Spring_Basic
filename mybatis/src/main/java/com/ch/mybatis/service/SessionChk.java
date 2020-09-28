package com.ch.mybatis.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
public class SessionChk extends HandlerInterceptorAdapter{
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		// System.out.println("session="+session);
		if (session.getAttribute("id") == null || 
				session.getAttribute("id").equals("")) {
			response.sendRedirect("loginForm.html");
			// 원래하려는 작업을 취소
			return false;
		}			
		return true;
	}
}