package com.nexos.backend.api.vo;

import java.io.Serializable;

public class PersonTypeVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idPersonType;

	private String personType;

	public PersonTypeVO() {
	}

	public int getIdPersonType() {
		return this.idPersonType;
	}

	public void setIdPersonType(int idPersonType) {
		this.idPersonType = idPersonType;
	}

	public String getPersonType() {
		return this.personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

}