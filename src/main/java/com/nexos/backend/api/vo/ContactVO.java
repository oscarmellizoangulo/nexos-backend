package com.nexos.backend.api.vo;

import java.io.Serializable;

public class ContactVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idContact;

	private String contact;

	private String description;

	private ContactTypeVO contactTypeVO;

	public ContactVO() {
	}

	public int getIdContact() {
		return this.idContact;
	}

	public void setIdContact(int idContact) {
		this.idContact = idContact;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ContactTypeVO getContactTypeVO() {
		return contactTypeVO;
	}

	public void setContactTypeVO(ContactTypeVO contactTypeVO) {
		this.contactTypeVO = contactTypeVO;
	}
}