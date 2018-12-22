package com.nexos.backend.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the service database table.
 * 
 */
@Entity
@NamedQuery(name="Service.findAll", query="SELECT s FROM Service s")
public class Service implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_service")
	private int idService;

	@Column(name="additional_hour_price")
	private BigDecimal additionalHourPrice;

	private String detail;

	@Column(name="price_hour")
	private BigDecimal priceHour;

	private String service;

	//bi-directional many-to-one association to ComboService
	@OneToMany(mappedBy="service")
	private List<ComboService> comboServices;

	//bi-directional many-to-many association to Quotation
	@ManyToMany(mappedBy="services")
	private List<Quotation> quotations;

	//bi-directional many-to-many association to ServiceType
	@ManyToMany(mappedBy="services")
	private List<ServiceType> serviceTypes;

	public Service() {
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

	public List<ComboService> getComboServices() {
		return this.comboServices;
	}

	public void setComboServices(List<ComboService> comboServices) {
		this.comboServices = comboServices;
	}

	public ComboService addComboService(ComboService comboService) {
		getComboServices().add(comboService);
		comboService.setService(this);

		return comboService;
	}

	public ComboService removeComboService(ComboService comboService) {
		getComboServices().remove(comboService);
		comboService.setService(null);

		return comboService;
	}

	public List<Quotation> getQuotations() {
		return this.quotations;
	}

	public void setQuotations(List<Quotation> quotations) {
		this.quotations = quotations;
	}

	public List<ServiceType> getServiceTypes() {
		return this.serviceTypes;
	}

	public void setServiceTypes(List<ServiceType> serviceTypes) {
		this.serviceTypes = serviceTypes;
	}

}