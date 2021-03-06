package com.ketul.demo.module.dto;

public class UserDto {

	private String name;
	
	private String email;

	public UserDto() {
		super();
	}

	public UserDto(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

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

	@Override
	public String toString() {
		return "UserDto [name=" + name + ", email=" + email + "]";
	}
	
	
	
}
