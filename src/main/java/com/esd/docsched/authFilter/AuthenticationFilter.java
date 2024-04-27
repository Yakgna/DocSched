package com.esd.docsched.authFilter;

import java.io.IOException;
import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.esd.docsched.pojo.User;
import com.esd.docsched.utils.Role;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
@Order(1)
public class AuthenticationFilter implements Filter {

	private static List<String> publicURLs = List.of("/", "/doctor", "/signup", "/login", "/forbidden");

	private static List<String> patientURLs = List.of("/dashboard");

	private static List<String> doctorURLs = List.of("/doctor/dashboard");

	private static List<String> adminURLs = List.of("/adminpage");

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String role = (String) session.getAttribute("role");
		String requestURI = request.getRequestURI();

		if (user == null) {
			if (!publicURLs.contains(requestURI)) {
				response.sendRedirect("/forbidden");
				return;
			}
		} else {
			if (role.equals(Role.ADMIN.getLabel())) {
				System.out.println("Filter");
				if (!publicURLs.contains(requestURI) && !adminURLs.contains(requestURI)) {
					response.sendRedirect("/forbidden");
					return;
				}
			} else if (role.equals(Role.DOCTOR.getLabel())) {
				if (!publicURLs.contains(requestURI) && !doctorURLs.contains(requestURI)) {
					response.sendRedirect("/forbidden");
					return;
				}
			} else if (role.equals(Role.PATIENT.getLabel())) {
				if (!publicURLs.contains(requestURI) && !patientURLs.contains(requestURI)) {
					response.sendRedirect("/forbidden");
					return;
				}
			}
		}
		chain.doFilter(request, response);
	}

}
