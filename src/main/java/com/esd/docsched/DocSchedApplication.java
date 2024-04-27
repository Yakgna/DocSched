package com.esd.docsched;

import org.hibernate.HibernateException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.esd.docsched.dao.UserDao;
import com.esd.docsched.pojo.Doctor;
import com.esd.docsched.pojo.Patient;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SpringBootApplication(scanBasePackages = {"com.esd.docsched.controller", "com.esd.docsched.dao", "com.esd.docsched.config", "com.esd.docsched.validator", "com.esd.docsched.authFilter"})
@Controller
public class DocSchedApplication {
	
	@GetMapping("/")
	public String homePage(@ModelAttribute("patient") Patient patient , HttpServletRequest request) {
		String viewName = "error";
		HttpSession session = request.getSession(false);
		if (session == null) {
			viewName = "home-page";
		} else {
			String action = request.getParameter("action");
			
			if (action == null) {
				viewName = "redirect:dashboard";
			} else if (action.equals("logout")) {
				viewName = "home-page";
				session.invalidate();
			}
		}
        return "home-page";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DocSchedApplication.class, args);
	}

}
