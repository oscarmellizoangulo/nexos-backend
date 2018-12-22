package com.nexos.backend.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the service_type database table.
 * 
 */
@Entity
@Table(name="service_type")
@NamedQuery(name="ServiceType.findAll", query="SELECT s FROM ServiceType s")
public class ServiceType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_service_type")
	private int idServiceType;

	@Column(name="service_type")
	private String serviceType;

	//bi-directional many-to-many association to Quotation
	@ManyToMany
	@JoinTable(
		name="quotation_type_service"
		, joinColumns={
			@JoinColumn(name="id_type_service")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_quotation")
			}
		)
	private List<Quotation> quotations;

	//bi-directional many-to-many association to Service
	@ManyToMany
	@JoinTable(
		name="service_type_service"
		, joinColumns={
			@JoinColumn(name="id_service_type")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_service")
			}
		)
	private List<Service> services;

	public ServiceType() {
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

	public List<Quotation> getQuotations() {
		return this.quotations;
	}

	public void setQuotations(List<Quotation> quotations) {
		this.quotations = quotations;
	}

	public List<Service> getServices() {
		return this.services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

}