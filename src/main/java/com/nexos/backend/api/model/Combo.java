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
 * The persistent class for the combo database table.
 * 
 */
@Entity
@NamedQuery(name="Combo.findAll", query="SELECT c FROM Combo c")
public class Combo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_combo")
	private int idCombo;

	private String combo;

	private BigDecimal price;

	//bi-directional many-to-one association to ComboService
	@OneToMany(mappedBy="combo")
	private List<ComboService> comboServices;

	//bi-directional many-to-many association to Quotation
	@ManyToMany(mappedBy="combos")
	private List<Quotation> quotations;

	//bi-directional many-to-one association to QuotationCombo
	@OneToMany(mappedBy="combo")
	private List<QuotationCombo> quotationCombos;

	public Combo() {
	}

	public int getIdCombo() {
		return this.idCombo;
	}

	public void setIdCombo(int idCombo) {
		this.idCombo = idCombo;
	}

	public String getCombo() {
		return this.combo;
	}

	public void setCombo(String combo) {
		this.combo = combo;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<ComboService> getComboServices() {
		return this.comboServices;
	}

	public void setComboServices(List<ComboService> comboServices) {
		this.comboServices = comboServices;
	}

	public ComboService addComboService(ComboService comboService) {
		getComboServices().add(comboService);
		comboService.setCombo(this);

		return comboService;
	}

	public ComboService removeComboService(ComboService comboService) {
		getComboServices().remove(comboService);
		comboService.setCombo(null);

		return comboService;
	}

	public List<Quotation> getQuotations() {
		return this.quotations;
	}

	public void setQuotations(List<Quotation> quotations) {
		this.quotations = quotations;
	}

	public List<QuotationCombo> getQuotationCombos() {
		return this.quotationCombos;
	}

	public void setQuotationCombos(List<QuotationCombo> quotationCombos) {
		this.quotationCombos = quotationCombos;
	}
}