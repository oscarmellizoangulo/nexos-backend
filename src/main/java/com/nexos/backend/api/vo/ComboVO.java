package com.nexos.backend.api.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ComboVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idCombo;

	private String combo;

	private BigDecimal price;

	public ComboVO() {
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

}