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
 * The persistent class for the contact_type database table.
 * 
 */
@Entity
@Table(name="contact_type")
@NamedQuery(name="ContactType.findAll", query="SELECT c FROM ContactType c")
public class ContactType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_contact_type")
	private int idContactType;

	@Column(name="contact_type")
	private String contactType;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="contactType")
	private List<Contact> contacts;

	public ContactType() {
	}

	public int getIdContactType() {
		return this.idContactType;
	}

	public void setIdContactType(int idContactType) {
		this.idContactType = idContactType;
	}

	public String getContactType() {
		return this.contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact addContact(Contact contact) {
		getContacts().add(contact);
		contact.setContactType(this);

		return contact;
	}

	public Contact removeContact(Contact contact) {
		getContacts().remove(contact);
		contact.setContactType(null);

		return contact;
	}

}