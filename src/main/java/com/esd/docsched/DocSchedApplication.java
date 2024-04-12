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

@SpringBootApplication(scanBasePackages = {"com.esd.docsched.controller"})
@Controller
@RequestMapping("/docsched")
public class DocSchedApplication {
	
	@GetMapping("")
	public String homePage(@ModelAttribute("patient") Patient patient , HttpServletRequest request) {
        return "home-page";
	}
	
	@PostMapping("/signup")
	public String patientSignUp(@ModelAttribute("patient") Patient patient, UserDao userDao) {
		try {
    		userDao.save(patient);
    	} catch (HibernateException e) {
    		return "error";
    	}
    	return "sign-up";
	}
	
	@GetMapping("/doctor")
	public String doctorPage(@ModelAttribute("doctor") Doctor doctor) {
        return "home-page-doc";
    }
	
	@PostMapping("/doctor/signup")
	public String doctorSignUp(@ModelAttribute("doctor") Doctor doctor, UserDao userDao) {
		try {
    		userDao.save(doctor);
    	} catch (HibernateException e) {
    		return "error";
    	}
    	return "sign-up";
    } 
	
	public static void main(String[] args) {
		SpringApplication.run(DocSchedApplication.class, args);
	}

}
