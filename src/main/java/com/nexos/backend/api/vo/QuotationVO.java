package com.nexos.backend.api.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class QuotationVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idQuotation;

	private String codeQuotation;

	private Date dateQuotation;

	private Date fechaEvento;

	private int hours;

	private int offerValidity;

	private ClientVO client;

	private List<ComboVO> combosVOs;

	private List<DiscountVO> discountsVOs;

	private ReferenceVO referenceVOs;

	private List<ServiceVO> servicesVOs;

	private UserVO userVO;

	private List<ServiceTypeVO> serviceTypesVOs;

	public QuotationVO() {
	}

	public int getIdQuotation() {
		return this.idQuotation;
	}

	public void setIdQuotation(int idQuotation) {
		this.idQuotation = idQuotation;
	}

	public String getCodeQuotation() {
		return this.codeQuotation;
	}

	public void setCodeQuotation(String codeQuotation) {
		this.codeQuotation = codeQuotation;
	}

	public Date getDateQuotation() {
		return this.dateQuotation;
	}

	public void setDateQuotation(Date dateQuotation) {
		this.dateQuotation = dateQuotation;
	}

	public Date getFechaEvento() {
		return this.fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public int getHours() {
		return this.hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getOfferValidity() {
		return this.offerValidity;
	}

	public void setOfferValidity(int offerValidity) {
		this.offerValidity = offerValidity;
	}

	public ClientVO getClient() {
		return client;
	}

	public void setClient(ClientVO client) {
		this.client = client;
	}

	public List<ComboVO> getCombosVOs() {
		return combosVOs;
	}

	public void setCombosVOs(List<ComboVO> combosVOs) {
		this.combosVOs = combosVOs;
	}

	public List<DiscountVO> getDiscountsVOs() {
		return discountsVOs;
	}

	public void setDiscountsVOs(List<DiscountVO> discountsVOs) {
		this.discountsVOs = discountsVOs;
	}

	public ReferenceVO getReferenceVOs() {
		return referenceVOs;
	}

	public void setReferenceVOs(ReferenceVO referenceVOs) {
		this.referenceVOs = referenceVOs;
	}

	public List<ServiceVO> getServicesVOs() {
		return servicesVOs;
	}

	public void setServicesVOs(List<ServiceVO> servicesVOs) {
		this.servicesVOs = servicesVOs;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public List<ServiceTypeVO> getServiceTypesVOs() {
		return serviceTypesVOs;
	}

	public void setServiceTypesVOs(List<ServiceTypeVO> serviceTypesVOs) {
		this.serviceTypesVOs = serviceTypesVOs;
	}
	
	

}