package com.esd.docsched.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.esd.docsched.pojo.Appointment;
import com.esd.docsched.pojo.Doctor;
import com.esd.docsched.pojo.Patient;
import com.esd.docsched.utils.Role;

@Repository
public class AdminDao {
	
	public List<Appointment> getAllAppointments() throws HibernateException {
		Session session = DAO.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query q = session.createQuery("FROM Appointment", Appointment.class);
		List<Appointment> list = q.list();
		
		session.close();
		
		return list;
	}
	
	public List<Patient> getPatientList() throws HibernateException {
		Session session = DAO.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query q = session.createQuery("From Patient", Patient.class);
		
		return q.list();
	}
	
	public void deleteDoctor(Long id) {
		Session session = DAO.getSessionFactory().openSession();
    	session.beginTransaction();
    	
    	Doctor doctor = session.get(Doctor.class, id);
        if (doctor != null) {
            session.remove(doctor);
            session.getTransaction().commit();
        } else {
            System.out.println("Doctor not found");
        }
        
        session.close();
	}
	
	public void deletePatient(Long id) {
		Session session = DAO.getSessionFactory().openSession();
    	session.beginTransaction();
    	
    	Patient patient = session.get(Patient.class, id);
        if (patient != null) {
            session.remove(patient);
            session.getTransaction().commit();
        } else {
            System.out.println("Doctor not found");
        }
        
        session.close();
	}
}
