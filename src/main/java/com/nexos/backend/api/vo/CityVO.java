package com.nexos.backend.api.vo;

import java.io.Serializable;

public class CityVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idCity;

	private String city;
	
	private DepartmentVO departmentVO;
	
	public CityVO() {
	}

	public int getIdCity() {
		return this.idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}

	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}
}