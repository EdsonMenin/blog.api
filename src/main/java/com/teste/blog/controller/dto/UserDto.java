package com.teste.blog.controller.dto;

public class UserDto {

	public String name;
	public String username;
	public String password;
	
	public UserDto() {	
	}
	
	public UserDto(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
}
