package com.nexos.backend.api.vo;

public class UserRolVO {
	private int idUser;
	
	private RolVO rolVO;

	public UserRolVO() {
		super();
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public RolVO getRolVO() {
		return rolVO;
	}

	public void setRolVO(RolVO rolVO) {
		this.rolVO = rolVO;
	}
	
	
}
