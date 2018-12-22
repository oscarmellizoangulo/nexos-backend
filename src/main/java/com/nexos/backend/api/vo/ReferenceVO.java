package com.nexos.backend.api.vo;

import java.io.Serializable;

public class ReferenceVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idReference;

	private String reference;

	public ReferenceVO() {
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
}