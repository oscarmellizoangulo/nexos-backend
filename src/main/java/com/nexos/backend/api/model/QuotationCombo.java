package com.nexos.backend.api.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the quotation_combo database table.
 * 
 */
@Entity
@Table(name="quotation_combo")
@NamedQuery(name="QuotationCombo.findAll", query="SELECT q FROM QuotationCombo q")
public class QuotationCombo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private QuotationComboPK id;

	//bi-directional many-to-one association to Combo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="combo")
	private Combo combo;

	public QuotationCombo() {
	}

	public QuotationComboPK getId() {
		return this.id;
	}

	public void setId(QuotationComboPK id) {
		this.id = id;
	}

	public Combo getCombo() {
		return this.combo;
	}

	public void setCombo(Combo combo) {
		this.combo = combo;
	}

}