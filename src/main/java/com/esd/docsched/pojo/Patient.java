package com.esd.docsched.pojo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name =  "patient", uniqueConstraints = @UniqueConstraint(columnNames = "email_address"))
public class Patient extends User {
	private String email_address;
	private String dob;
	private String sex;
	
	public Patient() {
	}
	
	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
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
