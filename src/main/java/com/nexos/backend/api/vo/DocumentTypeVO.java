package com.nexos.backend.api.vo;

import java.io.Serializable;

public class DocumentTypeVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idDocumentType;

	private String documentType;

	public DocumentTypeVO() {
	}

	public DocumentTypeVO(int idDocumentType, String documentType) {
		super();
		this.idDocumentType = idDocumentType;
		this.documentType = documentType;
	}

	public int getIdDocumentType() {
		return this.idDocumentType;
	}

	public void setIdDocumentType(int idDocumentType) {
		this.idDocumentType = idDocumentType;
	}

	public String getDocumentType() {
		return this.documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
}