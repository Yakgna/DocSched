package com.esd.docsched.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;

import com.esd.docsched.pojo.User;

@Repository
public class UserDao {
	
	public void save(User user) throws HibernateException{
        Session session = DAO.getSessionFactory().openSession();
    	session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
    }
}
