package com.nexos.backend.api.beans;

public class RolVO {
	private Long idRol;
	private String rol;
	/**
	 * @param idRol
	 * @param rol
	 */
	public RolVO(Long idRol, String rol) {
		super();
		this.idRol = idRol;
		this.rol = rol;
	}
	/**
	 * @return the idRol
	 */
	public Long getIdRol() {
		return idRol;
	}
	/**
	 * @param idRol the idRol to set
	 */
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}
	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}
}
