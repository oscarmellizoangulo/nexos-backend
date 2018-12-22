package com.nexos.backend.api.vo;

import java.io.Serializable;

public class CountryVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idCountry;

	private String country;

	public CountryVO() {
	}

	public int getIdCountry() {
		return this.idCountry;
	}

	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}