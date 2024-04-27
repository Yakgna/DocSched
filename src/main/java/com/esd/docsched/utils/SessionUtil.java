package com.esd.docsched.utils;

import com.esd.docsched.pojo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SessionUtil {
	
	public static boolean checkSessionActive(Role role, HttpServletRequest request) {
		return (request.getSession(false) == null) && (request.getParameter("role").equals(role.getLabel()));
	}
	
	public static void createSession(User user, Role role, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		session.setAttribute("role", role.getLabel());
		System.out.println("Session created");
	}
	
	public static HttpSession getSession(HttpServletRequest request) {
		return request.getSession(false);
	}
}
