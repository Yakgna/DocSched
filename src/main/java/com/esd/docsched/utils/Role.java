package com.esd.docsched.utils;

public enum Role {
	DOCTOR("Doctor"),
	PATIENT("Patient"),
	ADMIN("Admin");
	
	public String label;
	
	Role(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
