package com.nexos.backend.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the combo_service database table.
 * 
 */
@Entity
@Table(name="combo_service")
@NamedQuery(name="ComboService.findAll", query="SELECT c FROM ComboService c")
public class ComboService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_combo_service")
	private int idComboService;

	//bi-directional many-to-one association to Combo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_combo")
	private Combo combo;

	//bi-directional many-to-one association to Service
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_service")
	private Service service;

	public ComboService() {
	}

	public int getIdComboService() {
		return this.idComboService;
	}

	public void setIdComboService(int idComboService) {
		this.idComboService = idComboService;
	}

	public Combo getCombo() {
		return this.combo;
	}

	public void setCombo(Combo combo) {
		this.combo = combo;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

}