package com.esd.docsched;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication(scanBasePackages = {"com.esd.docsched.controller"})
@Controller
@RequestMapping("/docsched")
public class DocSchedApplication {
	
	@GetMapping("/")
	public String homePage() {
		return "home-page";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DocSchedApplication.class, args);
	}

}
