package com.esd.docsched.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.persister.collection.mutation.RowMutationOperations.Restrictions;
import org.springframework.stereotype.Repository;

import com.esd.docsched.pojo.Doctor;
import com.esd.docsched.pojo.Patient;
import com.esd.docsched.pojo.User;
import com.esd.docsched.utils.Role;
import org.hibernate.query.Query;

@Repository
public class UserDao {
	
	public void save(User user) throws HibernateException{
        Session session = DAO.getSessionFactory().openSession();
    	session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
    }
	
	public Doctor getDoctor(String username) throws HibernateException {
		Session session = DAO.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query q = session.createQuery("From Doctor where email_address='" + username + "'", Doctor.class);
		
		return (Doctor)q.uniqueResult();
	}
	
	public Patient getPatient(String username) throws HibernateException {
		Session session = DAO.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query q = session.createQuery("From Patient where email_address='" + username + "'", Patient.class);
		
		return (Patient)q.uniqueResult();
	}
	
	public List<Doctor> getDoctorList() throws HibernateException {
		Session session = DAO.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query q = session.createQuery("From Doctor", Patient.class);
		
		return q.list();
	}
}
