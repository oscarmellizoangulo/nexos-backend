package com.nexos.backend.api.vo;

import java.io.Serializable;

public class ContactTypeVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idContactType;

	private String contactType;

	public ContactTypeVO() {
	}

	public int getIdContactType() {
		return this.idContactType;
	}

	public void setIdContactType(int idContactType) {
		this.idContactType = idContactType;
	}

	public String getContactType() {
		return this.contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
}