package com.spring.mvc;

public class LoginBean {
	//declare properties
	private String username;
	private String password;
	
	//setter and getter methods
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//check method to validate the user credentials
	public boolean checkCredentials(String username, String password)
	{
		boolean status =false;
		if("john".equals(username) && "doe123".equals(password))
		{
			status =true;
		}
		return status;
	}
	
}
