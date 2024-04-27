package com.esd.docsched.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.esd.docsched.dao.AdminDao;
import com.esd.docsched.dao.AppointmentDao;
import com.esd.docsched.dao.UserDao;
import com.esd.docsched.pojo.Appointment;
import com.esd.docsched.pojo.Doctor;
import com.esd.docsched.pojo.Patient;
import com.esd.docsched.pojo.User;
import com.esd.docsched.utils.Role;
import com.esd.docsched.utils.SessionUtil;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	UserDao userDao;
	
	@GetMapping("/adminpage")
	public ModelAndView getPatients(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView(); 
//		if (SessionUtil.checkSessionActive(Role.PATIENT, request)) {
//			mv.addObject("errortype", "forbidden");
//			mv.setViewName("error");
//			return mv;
//		}
		
		String tab = request.getParameter("dashboard");
		
		if (tab != null && tab.equals("doctors")) {
			List<Doctor> doctorList = userDao.getDoctorList();
			mv.addObject("doctors", doctorList);
			mv.setViewName("dashboard-admin-doctors");
			return mv;
		} else if (tab != null && tab.equals("appointments")) {
			List<Appointment> appointmentList = adminDao.getAllAppointments();
			mv.addObject("appointments", appointmentList);
			mv.setViewName("dashboard-admin-appointments");
			return mv;
		} else {
			List<Patient> patientList = adminDao.getPatientList();
			mv.addObject("patients", patientList);
			mv.setViewName("dashboard-admin");
			return mv;
		}
	}
	
	@PostMapping("/adminpage")
	public ModelAndView changeTab(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView(); 
//		if (SessionUtil.checkSessionActive(Role.PATIENT, request)) {
//			mv.addObject("errortype", "forbidden");
//			mv.setViewName("error");
//			return mv;
//		}
//		
		String id = request.getParameter("id");
		String deleteUser = request.getParameter("deleteuser");
		
		if (id != null && deleteUser != null) {
			if (deleteUser.equals("doctor")) {
				adminDao.deleteDoctor(Long.parseLong(id));
				mv.setViewName("redirect:adminpage?dashboard=doctors");
				return mv;
			} 
			else if (deleteUser.equals("patient")) {
				adminDao.deletePatient(Long.parseLong(id));
				mv.setViewName("redirect:adminpage?dashboard=users");
				return mv;
			}
		}

		mv.setViewName("redirect:adminpage");
		return mv;
	}
}
