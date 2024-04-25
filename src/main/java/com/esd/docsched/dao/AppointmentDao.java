package com.esd.docsched.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.esd.docsched.pojo.Appointment;
import com.esd.docsched.pojo.User;
import com.esd.docsched.utils.Role;

@Repository
public class AppointmentDao {
	
	public void save(Appointment appointment) throws HibernateException{
        Session session = DAO.getSessionFactory().openSession();
    	session.beginTransaction();
        session.persist(appointment);
        session.getTransaction().commit();
    }
	

	public List<Appointment> getAppointments(Long id, String role) throws HibernateException {
		Session session = DAO.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query q = session.createQuery("FROM Appointment WHERE " + role + ".id=" + id, Appointment.class);
		List<Appointment> list = q.list();
		
		return list;
	}
}
