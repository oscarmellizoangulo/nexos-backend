package com.nexos.backend.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_rol")
	private int idRol;

	private String rol;

	//bi-directional many-to-many association to Menu
	@ManyToMany(mappedBy="rols")
	private List<Menu> menus;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="rols")
	private List<User> users;

	//bi-directional many-to-one association to UserRol
	@OneToMany(mappedBy="rol")
	private List<UserRol> userRols;

	public Rol() {
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<UserRol> getUserRols() {
		return this.userRols;
	}

	public void setUserRols(List<UserRol> userRols) {
		this.userRols = userRols;
	}
}