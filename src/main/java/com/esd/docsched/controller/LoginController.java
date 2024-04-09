package com.esd.docsched.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/docsched")
public class LoginController {

//    @GetMapping("")
//    public String homePage() {
//        return "This-is-Homepage";
//    }

    @GetMapping("/login.htm")
    public String doctorLogin(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("loginpage");
    	String loginUser = request.getParameter("userType");
        mv.addObject("userType", loginUser);
        return "loginpage";
    }

    @PostMapping("/login.htm")
    public ModelAndView authLogin(HttpServletRequest request) {
        return new ModelAndView("home-page");
    }

}
