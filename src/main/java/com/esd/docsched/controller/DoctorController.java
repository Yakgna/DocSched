package com.esd.docsched.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.esd.docsched.dao.AppointmentDao;
import com.esd.docsched.pojo.Appointment;
import com.esd.docsched.pojo.User;
import com.esd.docsched.utils.AppointmentStatus;
import com.esd.docsched.utils.Role;
import com.esd.docsched.utils.SessionUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class DoctorController {
	
	@Autowired
	AppointmentDao appointmentDao;
	
	@GetMapping("/doctor/dashboard")
	public ModelAndView doctorDashboard(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if (SessionUtil.checkSessionActive(Role.DOCTOR, request)) {
			mv.setViewName("error");
			return mv;
		}
		
		User user = (User) SessionUtil.getSession(request).getAttribute("user");
		List<Appointment> appointments = appointmentDao.getAppointments(user.getId(), "doctor");
		mv.addObject("appointments", appointments);
		mv.setViewName("dashboard-doc");
        return mv;
	}
	
	@PostMapping("/doctor/dashboard")
	public ModelAndView updateAppointment(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		if (SessionUtil.checkSessionActive(Role.PATIENT, request)) {
			mv.addObject("errortype", "forbidden");
			mv.setViewName("error");
			return mv;
		}
		
		if (request.getParameter("changestatus") != null && request.getParameter("changestatus").equals("cancelled")) {
			appointmentDao.update(AppointmentStatus.CANCELLED.getLabel(), Long.parseLong(request.getParameter("appointmentid")));
		}
		
		mv.setViewName("redirect:dashboard");
		return mv;
	}
	
}
