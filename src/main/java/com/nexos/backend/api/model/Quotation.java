package com.nexos.backend.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the quotation database table.
 * 
 */
@Entity
@NamedQuery(name="Quotation.findAll", query="SELECT q FROM Quotation q")
public class Quotation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_quotation")
	private int idQuotation;

	@Column(name="code_quotation")
	private String codeQuotation;

	@Temporal(TemporalType.DATE)
	@Column(name="date_quotation")
	private Date dateQuotation;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_evento")
	private Date fechaEvento;

	private int hours;

	@Column(name="offer_validity")
	private int offerValidity;

	//bi-directional many-to-one association to Client
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_client")
	private Client client;

	//bi-directional many-to-many association to Combo
	@ManyToMany
	@JoinTable(
		name="quotation_combo"
		, joinColumns={
			@JoinColumn(name="id_quotation")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_combo")
			}
		)
	private List<Combo> combos;

	//bi-directional many-to-many association to Discount
	@ManyToMany
	@JoinTable(
		name="quotation_discount"
		, joinColumns={
			@JoinColumn(name="id_quotation")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_discount")
			}
		)
	private List<Discount> discounts;

	//bi-directional many-to-one association to Reference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_reference")
	private Reference reference;

	//bi-directional many-to-many association to Service
	@ManyToMany
	@JoinTable(
		name="quotation_service"
		, joinColumns={
			@JoinColumn(name="id_quotation")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_service")
			}
		)
	private List<Service> services;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user")
	private User user;

	//bi-directional many-to-many association to ServiceType
	@ManyToMany(mappedBy="quotations")
	private List<ServiceType> serviceTypes;

	public Quotation() {
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

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Combo> getCombos() {
		return this.combos;
	}

	public void setCombos(List<Combo> combos) {
		this.combos = combos;
	}

	public List<Discount> getDiscounts() {
		return this.discounts;
	}

	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}

	public Reference getReference() {
		return this.reference;
	}

	public void setReference(Reference reference) {
		this.reference = reference;
	}

	public List<Service> getServices() {
		return this.services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ServiceType> getServiceTypes() {
		return this.serviceTypes;
	}

	public void setServiceTypes(List<ServiceType> serviceTypes) {
		this.serviceTypes = serviceTypes;
	}

}