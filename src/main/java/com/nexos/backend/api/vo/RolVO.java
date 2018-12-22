package com.nexos.backend.api.vo;

public class RolVO {
	private Integer idRol;
	private String rol;
	/**
	 * @param idRol
	 * @param rol
	 */
	public RolVO(Integer idRol, String rol) {
		super();
		this.idRol = idRol;
		this.rol = rol;
	}
	/**
	 * @return the idRol
	 */
	public Integer getIdRol() {
		return idRol;
	}
	/**
	 * @param idRol the idRol to set
	 */
	public void setIdRol(Integer idRol) {
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
