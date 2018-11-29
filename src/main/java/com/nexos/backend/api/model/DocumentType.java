package com.nexos.backend.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_documento")
public class DocumentType {
	@Id
    @GeneratedValue
    @Column(name = "id_tipo_documento", nullable = false)
	private Long idDocumentType;
	@Column(name = "documento", nullable = false)
	private String document;
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
