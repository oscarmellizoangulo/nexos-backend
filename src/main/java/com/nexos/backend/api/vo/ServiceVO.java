package com.nexos.backend.api.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ServiceVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idService;

	private BigDecimal additionalHourPrice;

	private String detail;

	private BigDecimal priceHour;

	private String service;

	private List<ServiceTypeVO> serviceTypesVos;

	public ServiceVO() {
	}

	public int getIdService() {
		return this.idService;
	}

	public void setIdService(int idService) {
		this.idService = idService;
	}

	public BigDecimal getAdditionalHourPrice() {
		return this.additionalHourPrice;
	}

	public void setAdditionalHourPrice(BigDecimal additionalHourPrice) {
		this.additionalHourPrice = additionalHourPrice;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public BigDecimal getPriceHour() {
		return this.priceHour;
	}

	public void setPriceHour(BigDecimal priceHour) {
		this.priceHour = priceHour;
	}

	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public List<ServiceTypeVO> getServiceTypesVos() {
		return serviceTypesVos;
	}

	public void setServiceTypesVos(List<ServiceTypeVO> serviceTypesVos) {
		this.serviceTypesVos = serviceTypesVos;
	}
	
}