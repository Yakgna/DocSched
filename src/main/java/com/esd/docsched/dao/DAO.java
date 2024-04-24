package com.esd.docsched.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.esd.docsched.pojo.Appointment;
import com.esd.docsched.pojo.Doctor;
import com.esd.docsched.pojo.Patient;
import com.esd.docsched.pojo.User;

public class DAO {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySetting(Environment.JAKARTA_JDBC_DRIVER, "com.mysql.cj.jdbc.Driver")
                        .applySetting(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://localhost:3306/docscheddb")
                        .applySetting(Environment.JAKARTA_JDBC_USER, "root")
                        .applySetting(Environment.JAKARTA_JDBC_PASSWORD, "Root@2023")
                        .applySetting(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect")
                        .applySetting(Environment.SHOW_SQL, "true")
                        .applySetting(Environment.HBM2DDL_AUTO, "update")
                        .build();

                MetadataSources metadataSources = new MetadataSources(serviceRegistry);
                metadataSources.addAnnotatedClass(Patient.class);
                metadataSources.addAnnotatedClass(Doctor.class);
                metadataSources.addAnnotatedClass(Appointment.class);
                

                Metadata metadata = metadataSources.getMetadataBuilder().build();

                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sessionFactory;
    }

}
