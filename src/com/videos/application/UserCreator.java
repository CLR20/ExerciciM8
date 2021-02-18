package com.videos.application;

import javax.swing.JOptionPane;

import com.videos.domain.*;

public class UserCreator {
	
	//private static Scanner sc;
	private static String firstName;
	private static String lastName;
	private static String password;
	private static String registered;
	private static Users user;
	
	public UserCreator () {
		
	}
	
	public void createUser () {
		
		// Asking for data until all of it is correct.
		do {
						
			firstName = JOptionPane.showInputDialog("Enter your first name: ");				
			lastName = JOptionPane.showInputDialog("Enter your last name: ");				
			password = JOptionPane.showInputDialog("Enter a password: ");
	
			// Checking the data to ensure there are no null fields.
			try {
				checkData(firstName, lastName, password);
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "ERROR FOUND. You must enter all the requested data."
						+ "\nException type: " + e.getClass().getName());				
			}					
		} while (firstName.length() < 1 || lastName.length() < 1 || password.length() < 1);
		
		// Creating a User with the data.
		user = new Users (firstName, lastName, password);
	}
	
	// Printing the User data.
	public String getUser() {
		return user.toString();
	}
	
	// Method to check if all the fields are entered.
	static void checkData (String firstName, String lastName, String password) throws NullPointerException {
		
		if (firstName.length() < 1 || lastName.length() < 1 || password.length() < 1) {
			throw new NullPointerException ();
		}
	}

}
