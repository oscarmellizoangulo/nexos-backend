package com.nexos.backend.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the reference database table.
 * 
 */
@Entity
@NamedQuery(name="Reference.findAll", query="SELECT r FROM Reference r")
public class Reference implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_reference")
	private int idReference;

	private String reference;

	//bi-directional many-to-one association to Quotation
	@OneToMany(mappedBy="reference")
	private List<Quotation> quotations;

	public Reference() {
	}

	public int getIdReference() {
		return this.idReference;
	}

	public void setIdReference(int idReference) {
		this.idReference = idReference;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public List<Quotation> getQuotations() {
		return this.quotations;
	}

	public void setQuotations(List<Quotation> quotations) {
		this.quotations = quotations;
	}

	public Quotation addQuotation(Quotation quotation) {
		getQuotations().add(quotation);
		quotation.setReference(this);

		return quotation;
	}

	public Quotation removeQuotation(Quotation quotation) {
		getQuotations().remove(quotation);
		quotation.setReference(null);

		return quotation;
	}

}