package com.nexos.backend.api.vo;

import java.io.Serializable;

public class ServiceTypeVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idServiceType;

	private String serviceType;

	public ServiceTypeVO() {
	}

	public int getIdServiceType() {
		return this.idServiceType;
	}

	public void setIdServiceType(int idServiceType) {
		this.idServiceType = idServiceType;
	}

	public String getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
}