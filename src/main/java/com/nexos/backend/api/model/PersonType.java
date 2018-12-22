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
 * The persistent class for the person_type database table.
 * 
 */
@Entity
@Table(name="person_type")
@NamedQuery(name="PersonType.findAll", query="SELECT p FROM PersonType p")
public class PersonType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_person_type")
	private int idPersonType;

	@Column(name="person_type")
	private String personType;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="personType")
	private List<Person> persons;

	public PersonType() {
	}

	public int getIdPersonType() {
		return this.idPersonType;
	}

	public void setIdPersonType(int idPersonType) {
		this.idPersonType = idPersonType;
	}

	public String getPersonType() {
		return this.personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setPersonType(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setPersonType(null);

		return person;
	}

}