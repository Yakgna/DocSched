package com.esd.docsched.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.esd.docsched.dao.UserDao;
import com.esd.docsched.pojo.Doctor;
import com.esd.docsched.pojo.Patient;
import com.esd.docsched.pojo.User;
import com.esd.docsched.utils.Role;
import com.esd.docsched.utils.SessionUtil;
import com.esd.docsched.validator.UserValidator;

@Controller
public class LoginController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	UserValidator validator;
	
    @PostMapping("/login")
    public ModelAndView authLogin(HttpServletRequest request) {
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	Role role;
    	String viewName = "";
    	
    	User user;
    	if (username.equals("admin")) {
    		role=Role.ADMIN;
    		user = userDao.getPatient(username);
    		viewName = "adminpage";
    	} 
    	else if (request.getParameter("doctor") == null) {
    		role = Role.PATIENT;
    		user = userDao.getPatient(username);
    		viewName = "dashboard";
    	} 
    	else {
    		role = Role.DOCTOR;
    		user = userDao.getDoctor(username);
    		viewName = "doctor/dashboard";
    	}
    	
    	if (user == null) {
    		ModelAndView mv = new ModelAndView("error");
    		mv.addObject("errortype", "invalidlogin");
    		return mv;
    	} else {
    		String pass = user.getPassword();
    		if (passwordEncoder.matches(password, pass)) {
    			SessionUtil.createSession(user, role, request);
    			return new ModelAndView("redirect:"+viewName);
    		}
    	}
        return new ModelAndView("error");
    }
    
    @PostMapping("/signup")
	public String patientSignUp(@ModelAttribute("patient") Patient patient, BindingResult results) {
    	
    	validator.validate(patient, results);
        if (results.hasErrors()) {
            return "home-page";
        }
		try {
			patient.setPassword(passwordEncoder.encode(patient.getPassword()));
    		userDao.save(patient);
    	} catch (HibernateException e) {
    		System.out.println(e);
    		return "error";
    	}
    	return "sign-up";
	}
	
	@GetMapping("/doctor")
	public ModelAndView doctorPage(@ModelAttribute("doctor") Doctor doctor, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("home-page-doc");
        return mv;
    }
	
	@PostMapping("/doctor/signup")
	public String doctorSignUp(@ModelAttribute("doctor") Doctor doctor) {
		try {
			doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
    		userDao.save(doctor);
    	} catch (HibernateException e) {
    		return "error";
    	}
    	return "sign-up";
    } 
	
	@GetMapping("/forbidden") 
	public String forbiddenUrl(){
		return "forbidden";
	}
}
