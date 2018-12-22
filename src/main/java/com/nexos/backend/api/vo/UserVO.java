package com.nexos.backend.api.vo;

import java.util.List;

public class UserVO {
	private String userName;
	private String email;
	private String fullName;
	private List<RolVO> roles;
	public UserVO(String userName, String email, String fullName, List<RolVO> roles) {
		super();
		this.userName = userName;
		this.email = email;
		this.fullName = fullName;
		this.roles = roles;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public List<RolVO> getRoles() {
		return roles;
	}
	public void setRoles(List<RolVO> roles) {
		this.roles = roles;
	}
	public UserVO() {
		
	}
	
	
}
