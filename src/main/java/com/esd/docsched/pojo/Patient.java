package com.esd.docsched.pojo;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name =  "patient")
public class Patient extends User {
	private String dob;
	private String sex;
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Appointment> appointment;
	
	public Patient() {
	}
	
	

	public Patient(String first_name, String last_name, String email_address, String password, String dob, String sex) {
		super(first_name, last_name, password, email_address);
		this.dob = dob;
		this.sex = sex;
		
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
