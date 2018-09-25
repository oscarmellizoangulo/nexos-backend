package com.nexos.backend.api.beans;

public class UserVO {
	private String userName;
	private String email;
	private String fullName;
	private String rol;
	public UserVO() {
		
	}
	public UserVO(String userName, String email, String fullName, String rol) {
		super();
		this.userName = userName;
		this.email = email;
		this.fullName = fullName;
		this.rol = rol;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}
	
	
}
