package com.esd.docsched.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.esd.docsched.dao.UserDao;
import com.esd.docsched.pojo.Doctor;
import com.esd.docsched.pojo.Patient;
import com.esd.docsched.pojo.User;
import com.esd.docsched.utils.Role;

@Controller
public class LoginController {
	
	private BCryptPasswordEncoder passwordEncoder;
	
    @PostMapping("/login")
    public ModelAndView authLogin(HttpServletRequest request, UserDao userDao) {
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	passwordEncoder = new BCryptPasswordEncoder();
    	String role = "patient";
    	String viewName = "";
    	
    	User user;
    	if (request.getParameter("doctor") == null) {
    		user = userDao.getPatient(username);
    		viewName = "dashboard";
    	} else {
    		role = "doctor";
    		user = userDao.getDoctor(username);
    		viewName = "doctor/dashboard";
    	}
    	
    	if (user == null) {
    		return new ModelAndView("username-not-found");
    	} else {
    		String pass = user.getPassword();
    		System.out.println(pass);
    		if (passwordEncoder.matches(password, pass)) {
    			HttpSession session = request.getSession();
    			session.setAttribute("user", user);
    			session.setAttribute("role", role);
    			return new ModelAndView("redirect:"+viewName);
    		}
    	}
        return new ModelAndView("error");
    }
    
    @PostMapping("/signup")
	public String patientSignUp(@ModelAttribute("patient") Patient patient, UserDao userDao) {
		try {
			passwordEncoder = new BCryptPasswordEncoder();
			patient.setPassword(passwordEncoder.encode(patient.getPassword()));
    		userDao.save(patient);
    	} catch (HibernateException e) {
    		System.out.println(e);
    		return "error";
    	}
    	return "sign-up";
	}
	
	@GetMapping("/doctor")
	public String doctorPage(@ModelAttribute("doctor") Doctor doctor, HttpServletRequest request) {
        return "home-page-doc";
    }
	
	@PostMapping("/doctor/signup")
	public String doctorSignUp(@ModelAttribute("doctor") Doctor doctor, UserDao userDao) {
		try {
			passwordEncoder = new BCryptPasswordEncoder();
			doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
    		userDao.save(doctor);
    	} catch (HibernateException e) {
    		return "error";
    	}
    	return "sign-up";
    } 
}
