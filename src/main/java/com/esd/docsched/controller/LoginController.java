package com.esd.docsched.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.esd.docsched.dao.UserDao;
import com.esd.docsched.pojo.Doctor;
import com.esd.docsched.pojo.User;

@Controller
public class LoginController {

    @PostMapping("/login.htm")
    public ModelAndView authLogin() {
        return new ModelAndView("loginpage");
    }
}
