package com.nexos.backend.api.beans;

public class User {
	private Integer idUser;
	private Integer idPerson;
	private String userName;
	private String password;
	private String email;
	public User() {
		
	}
	public User(Integer idUser, Integer idPerson, String userName, String password, String email) {
		super();
		this.idUser = idUser;
		this.idPerson = idPerson;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	
	public Integer getIdUser() {
		return idUser;
	}
	public Integer getIdPerson() {
		return idPerson;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	
}
