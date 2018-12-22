package com.nexos.backend.api.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the user_rol database table.
 * 
 */
@Embeddable
public class UserRolPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_rol", insertable=false, updatable=false)
	private int idRol;

	@Column(name="id_user", insertable=false, updatable=false)
	private int idUser;

	public UserRolPK() {
	}
	public int getIdRol() {
		return this.idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public int getIdUser() {
		return this.idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserRolPK)) {
			return false;
		}
		UserRolPK castOther = (UserRolPK)other;
		return 
			(this.idRol == castOther.idRol)
			&& (this.idUser == castOther.idUser);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRol;
		hash = hash * prime + this.idUser;
		
		return hash;
	}
}