package com.videos.domain;

import java.util.Date;

public class Users {

	String firstName;
	String lastName;
	String password;
	// Automatically creating the registration data
	Date registration;
		
	public Users (String firstName, String lastName, String password) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		registration = new Date();
	}
	
	// Overriding the toString method. Overriding the password with *** in print for security reasons.
	public String toString() {
		return "\nPERSONAL DATA: \n\tName: " + firstName + " " + lastName  
				+ "\n\tPassword: " + password.replaceAll(".", "*") 
				+ "\n\tRegistration: " + registration;
	}
	
}
