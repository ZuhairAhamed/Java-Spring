package com.luv2code.springdemo.mvc;

public class Student {
	
	private String firstName;
	
	private String lastName;
	
	private String country;
	
	private String programmingLanguage;
	
	private String os[];
	

	public Student() {
		// TODO Auto-generated constructor stub
	}

	
	public String[] getOs() {
		return os;
	}


	public void setOs(String[] os) {
		this.os = os;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getProgrammingLanguage() {
		return programmingLanguage;
	}

	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
