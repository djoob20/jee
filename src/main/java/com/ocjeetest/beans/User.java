package com.ocjeetest.beans;

public class User {
	
	private String firstname;
	private String lastname;
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) throws BeanException {
		
		if(firstname.length() > 10) {
			throw new BeanException("Le nom est trop grand ! (10 caractères maximum)");
		}else {
			
			this.firstname = firstname;
		}
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	

}
