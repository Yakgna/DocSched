package com.esd.docsched.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.esd.docsched.dao.AppointmentDao;
import com.esd.docsched.dao.UserDao;
import com.esd.docsched.pojo.Appointment;
import com.esd.docsched.pojo.Doctor;
import com.esd.docsched.pojo.Patient;
import com.esd.docsched.pojo.User;
import com.esd.docsched.utils.Role;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {
	
	@Autowired
	AppointmentDao appointmentDao;
	
	@Autowired
	UserDao userDao;
	
	@GetMapping("/dashboard")
    public ModelAndView patientDashboard(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(false); 
		if (session == null) {
			mv.setViewName("error");
			return mv;
		}
		String tab = request.getParameter("dashboard");
		
		if (tab != null && tab.equals("book")) {
			List<Doctor> doctorList = userDao.getDoctorList();
			mv.addObject("doctors", doctorList);
			mv.setViewName("book-appointment");
			return mv;
		}
		
		User user = (User) session.getAttribute("user");
		List<Appointment> appointments = appointmentDao.getAppointments(user.getId(), "patient");
		mv.addObject("appointments", appointments);
        return mv;
    }
	
	@GetMapping("/dashboard/doctor")
	public ModelAndView doctorDashboard(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(false); 
		if (session == null) {
			mv.setViewName("error");
			return mv;
		} else if (!session.getAttribute("role").equals(Role.DOCTOR.getLabel())) {
				mv.setViewName("error");
				return mv;
			}
		
		User user = (User) session.getAttribute("user");
		List<Appointment> appointments = appointmentDao.getAppointments(user.getId(), "doctor");
		mv.addObject("appointments", appointments);
		mv.setViewName("dashboard-doc");
        return mv;
	}
	
	@PostMapping("/dashboard")
	public ModelAndView bookAppointment(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(false);
		if (session == null) {
			mv.setViewName("error");
			return mv;
		}
		
		String docId = request.getParameter("doctor");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime appointmentDate = LocalDateTime.now();
		try {
			appointmentDate = LocalDateTime.parse(request.getParameter("appointmentdate"), formatter);
		} catch (DateTimeParseException e) {
			System.err.println(e);
		}
		String symptoms = request.getParameter("symptoms");
		
		List<Doctor> doctorList = userDao.getDoctorList();
		mv.addObject("doctors", doctorList);
		
		Doctor doctor = userDao.getDoctor(docId);
		Patient patient = (Patient) session.getAttribute("user");
		
		appointmentDao.save(new Appointment(appointmentDate, symptoms, patient, doctor));
		
		mv.setViewName("redirect:dashboard");
		return mv;	
	}
	
}
