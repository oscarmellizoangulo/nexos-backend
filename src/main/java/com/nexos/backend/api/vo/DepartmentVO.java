package com.nexos.backend.api.vo;

import java.io.Serializable;

public class DepartmentVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idDepartment;

	private String department;

	private CountryVO countryVO;

	public DepartmentVO() {
	}

	public int getIdDepartment() {
		return this.idDepartment;
	}

	public void setIdDepartment(int idDepartment) {
		this.idDepartment = idDepartment;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public CountryVO getCountryVO() {
		return countryVO;
	}

	public void setCountryVO(CountryVO countryVO) {
		this.countryVO = countryVO;
	}
	
}