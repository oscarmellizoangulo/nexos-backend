package com.nexos.backend.api.vo;

public class ClientVO {
	private Integer idCliente;
	private String documentNumber;
	private String fullName;
	
	public ClientVO(Integer idCliente, String documentNumber, String fullName) {
		super();
		this.idCliente = idCliente;
		this.documentNumber = documentNumber;
		this.fullName = fullName;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}
