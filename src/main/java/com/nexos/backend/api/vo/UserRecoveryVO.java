package com.nexos.backend.api.vo;

public class UserRecoveryVO {
	private String userName;

	public UserRecoveryVO(String userName) {
		super();
		this.userName = userName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
}
