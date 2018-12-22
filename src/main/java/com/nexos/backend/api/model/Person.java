package com.nexos.backend.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_person")
	private int idPerson;

	@Column(name="document_number")
	private String documentNumber;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="razon_social")
	private String razonSocial;

	@Column(name="second_last_name")
	private String secondLastName;

	@Column(name="second_name")
	private String secondName;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="person")
	private List<Client> clients1;

	//bi-directional many-to-many association to AddressVO
	@ManyToMany
	@JoinTable(
		name="person_address"
		, joinColumns={
			@JoinColumn(name="id_person")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_address")
			}
		)
	private List<Address> addresses;

	//bi-directional many-to-many association to Client
	@ManyToMany
	@JoinTable(
		name="attendant"
		, joinColumns={
			@JoinColumn(name="id_person")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_client")
			}
		)
	private List<Client> clients2;

	//bi-directional many-to-many association to Contact
	@ManyToMany
	@JoinTable(
		name="person_contact"
		, joinColumns={
			@JoinColumn(name="id_person")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_contact")
			}
		)
	private List<Contact> contacts;

	//bi-directional many-to-one association to DocumentType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_document_type")
	private DocumentType documentType;

	//bi-directional many-to-one association to PersonType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_type_person")
	private PersonType personType;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="person")
	private List<User> users;

	public Person() {
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

	public List<Client> getClients1() {
		return this.clients1;
	}

	public void setClients1(List<Client> clients1) {
		this.clients1 = clients1;
	}

	public Client addClients1(Client clients1) {
		getClients1().add(clients1);
		clients1.setPerson(this);

		return clients1;
	}

	public Client removeClients1(Client clients1) {
		getClients1().remove(clients1);
		clients1.setPerson(null);

		return clients1;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Client> getClients2() {
		return this.clients2;
	}

	public void setClients2(List<Client> clients2) {
		this.clients2 = clients2;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public DocumentType getDocumentType() {
		return this.documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public PersonType getPersonType() {
		return this.personType;
	}

	public void setPersonType(PersonType personType) {
		this.personType = personType;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setPerson(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setPerson(null);

		return user;
	}

}