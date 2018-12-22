package com.nexos.backend.api.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class DiscountVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idDiscount;

	private String discount;

	private BigDecimal percentage;

	public DiscountVO() {
	}

	public int getIdDiscount() {
		return this.idDiscount;
	}

	public void setIdDiscount(int idDiscount) {
		this.idDiscount = idDiscount;
	}

	public String getDiscount() {
		return this.discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public BigDecimal getPercentage() {
		return this.percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}
}