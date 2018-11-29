package com.nexos.backend.api.beans;

public class DocumentTypeVO {
	private Long idDocumentType;
	private String document;
	/**
	 * @param idDocumentType
	 * @param document
	 */
	public DocumentTypeVO(Long idDocumentType, String document) {
		super();
		this.idDocumentType = idDocumentType;
		this.document = document;
	}
	/**
	 * @return the idDocumentType
	 */
	public Long getIdDocumentType() {
		return idDocumentType;
	}
	/**
	 * @param idDocumentType the idDocumentType to set
	 */
	public void setIdDocumentType(Long idDocumentType) {
		this.idDocumentType = idDocumentType;
	}
	/**
	 * @return the document
	 */
	public String getDocument() {
		return document;
	}
	/**
	 * @param document the document to set
	 */
	public void setDocument(String document) {
		this.document = document;
	}
	
}
