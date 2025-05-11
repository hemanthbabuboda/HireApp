package com.hireapp.Auth.dto;

import java.util.Objects;

public class RegisterRequest {

	private String username;
	private String password;
	private String Role;
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
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public RegisterRequest(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		Role = role;
	}
	public RegisterRequest() {
		super();
	}
	@Override
	public String toString() {
		return "RegisterRequest [username=" + username + ", password=" + password + ", Role=" + Role + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Role, password, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisterRequest other = (RegisterRequest) obj;
		return Objects.equals(Role, other.Role) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	
	
}
