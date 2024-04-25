package com.esd.docsched.pojo;

import java.util.Date;
import java.util.List;

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
	@OneToMany(mappedBy = "patient")
	private List<Appointment> appointment;
	
	public Patient() {
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
