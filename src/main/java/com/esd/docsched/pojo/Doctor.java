package com.esd.docsched.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name =  "doctor", uniqueConstraints = @UniqueConstraint(columnNames = "email_address"))
public class Doctor extends User{
	
	private String email_address;	
    private String practice_name;
    private String specialty;
    private String phone_number;
    private String zip_code;

    // Constructors
    public Doctor() {
    }
    
    
	public String getEmail_address() {
		return email_address;
	}
	
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	
	public String getPractice_name() {
		return practice_name;
	}

	public void setPractice_name(String practice_name) {
		this.practice_name = practice_name;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
}