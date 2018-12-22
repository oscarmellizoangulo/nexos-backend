package com.nexos.backend.api.vo;

import java.io.Serializable;


public class AddressVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idAddress;

	private String address;

	private String description;

	public AddressVO() {
	}

	public int getIdAddress() {
		return this.idAddress;
	}

	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}