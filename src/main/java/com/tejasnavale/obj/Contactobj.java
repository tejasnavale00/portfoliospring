package com.tejasnavale.obj;

public class Contactobj {
	
	private String name;
	private String email;
	private String subject;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Contactobj [name=" + name + ", email=" + email + ", subject=" + subject + "]";
	}
	
	

}
