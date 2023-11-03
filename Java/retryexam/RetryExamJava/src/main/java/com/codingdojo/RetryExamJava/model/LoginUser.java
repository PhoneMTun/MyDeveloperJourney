package com.codingdojo.RetryExamJava.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginUser {
	@NotEmpty(message="Email is required!")
	@Email(message="Please enter a valid email!")
	private String emailString;
	
	@NotEmpty(message="Password us required!")
	@Size(min=8, max=128, message="Password must be between 8 and 128 characters")
	private String passwordString;
	
	public LoginUser() {}

	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}

	public String getPasswordString() {
		return passwordString;
	}

	public void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}
	
	
}

