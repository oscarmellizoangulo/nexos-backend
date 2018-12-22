package com.nexos.backend.api.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the user_rol database table.
 * 
 */
@Entity
@Table(name="user_rol")
@NamedQuery(name="UserRol.findAll", query="SELECT u FROM UserRol u")
public class UserRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserRolPK id;

	//bi-directional many-to-one association to Rol
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rol")
	private Rol rol;

	public UserRol() {
	}

	public UserRolPK getId() {
		return this.id;
	}

	public void setId(UserRolPK id) {
		this.id = id;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}