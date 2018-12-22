package com.nexos.backend.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the quotation_combo database table.
 * 
 */
@Embeddable
public class QuotationComboPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_quotation", insertable=false, updatable=false)
	private int idQuotation;

	@Column(name="id_combo", insertable=false, updatable=false)
	private int idCombo;

	public QuotationComboPK() {
	}
	public int getIdQuotation() {
		return this.idQuotation;
	}
	public void setIdQuotation(int idQuotation) {
		this.idQuotation = idQuotation;
	}
	public int getIdCombo() {
		return this.idCombo;
	}
	public void setIdCombo(int idCombo) {
		this.idCombo = idCombo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof QuotationComboPK)) {
			return false;
		}
		QuotationComboPK castOther = (QuotationComboPK)other;
		return 
			(this.idQuotation == castOther.idQuotation)
			&& (this.idCombo == castOther.idCombo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idQuotation;
		hash = hash * prime + this.idCombo;
		
		return hash;
	}
}