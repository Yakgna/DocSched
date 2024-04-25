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
import com.esd.docsched.utils.AppointmentStatus;
import com.esd.docsched.utils.Role;
import com.esd.docsched.utils.SessionUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class PatientController {
	
	@Autowired
	AppointmentDao appointmentDao;
	
	@Autowired
	UserDao userDao;
	
	@GetMapping("/dashboard")
    public ModelAndView patientDashboard(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView(); 
		if (SessionUtil.checkSessionActive(Role.PATIENT, request)) {
			mv.addObject("errortype", "forbidden");
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
		HttpSession session = SessionUtil.getSession(request);
		User user = (User) session.getAttribute("user");
		List<Appointment> appointments = appointmentDao.getAppointments(user.getId(), "patient");
		mv.addObject("appointments", appointments);
        return mv;
    }
	
	@PostMapping("/dashboard")
	public ModelAndView bookAppointment(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		if (SessionUtil.checkSessionActive(Role.PATIENT, request)) {
			mv.addObject("errortype", "forbidden");
			mv.setViewName("error");
			return mv;
		}
		
		if (request.getParameter("changestatus") != null && request.getParameter("changestatus").equals("cancelled")) {
			appointmentDao.update(AppointmentStatus.CANCELLED.getLabel(), Long.parseLong(request.getParameter("appointmentid")));
		} else {
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
			HttpSession session = SessionUtil.getSession(request);
			Patient patient = (Patient) session.getAttribute("user");
			
			appointmentDao.save(new Appointment(appointmentDate, symptoms, AppointmentStatus.SCHEDULED.getLabel(), patient, doctor));
		}
		
		mv.setViewName("redirect:dashboard");
		return mv;	
	}
	
}
