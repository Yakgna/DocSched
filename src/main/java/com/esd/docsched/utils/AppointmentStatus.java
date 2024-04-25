package com.esd.docsched.utils;

public enum AppointmentStatus {
	SCHEDULED("Scheduled"),
	CANCELLED("Cancelled");
	
	public String label;
	
	AppointmentStatus(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
