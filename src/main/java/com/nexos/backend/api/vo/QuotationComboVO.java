package com.nexos.backend.api.vo;

import java.io.Serializable;

public class QuotationComboVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idQuotation;

	private ComboVO comboVO;

	public QuotationComboVO() {
	}

	public int getIdQuotation() {
		return idQuotation;
	}

	public void setIdQuotation(int idQuotation) {
		this.idQuotation = idQuotation;
	}

	public ComboVO getComboVO() {
		return comboVO;
	}

	public void setComboVO(ComboVO comboVO) {
		this.comboVO = comboVO;
	}

	
}