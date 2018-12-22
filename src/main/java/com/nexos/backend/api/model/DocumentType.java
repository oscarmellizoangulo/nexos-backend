package com.nexos.backend.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the document_type database table.
 * 
 */
@Entity
@Table(name="document_type")
@NamedQuery(name="DocumentType.findAll", query="SELECT d FROM DocumentType d")
public class DocumentType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_document_type")
	private int idDocumentType;

	@Column(name="document_type")
	private String documentType;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="documentType")
	private List<Person> persons;

	public DocumentType() {
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

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setDocumentType(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setDocumentType(null);

		return person;
	}

}