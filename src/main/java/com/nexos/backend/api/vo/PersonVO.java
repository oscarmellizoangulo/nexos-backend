package com.nexos.backend.api.vo;

import java.io.Serializable;
import java.util.List;

public class PersonVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idPerson;

	private String documentNumber;

	private String firstName;

	private String lastName;

	private String razonSocial;

	private String secondLastName;

	private String secondName;

	private List<AddressVO> addressesVOs;

	private List<ContactVO> contactsVOs;

	private DocumentTypeVO documentTypeVO;

	private PersonTypeVO personTypeVO;

	public PersonVO() {
	}

	public int getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getDocumentNumber() {
		return this.documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getSecondLastName() {
		return this.secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	public String getSecondName() {
		return this.secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public List<AddressVO> getAddressesVOs() {
		return addressesVOs;
	}

	public void setAddressesVOs(List<AddressVO> addressesVOs) {
		this.addressesVOs = addressesVOs;
	}

	public List<ContactVO> getContactsVOs() {
		return contactsVOs;
	}

	public void setContactsVOs(List<ContactVO> contactsVOs) {
		this.contactsVOs = contactsVOs;
	}

	public DocumentTypeVO getDocumentTypeVO() {
		return documentTypeVO;
	}

	public void setDocumentTypeVO(DocumentTypeVO documentTypeVO) {
		this.documentTypeVO = documentTypeVO;
	}

	public PersonTypeVO getPersonTypeVO() {
		return personTypeVO;
	}

	public void setPersonTypeVO(PersonTypeVO personTypeVO) {
		this.personTypeVO = personTypeVO;
	}
}