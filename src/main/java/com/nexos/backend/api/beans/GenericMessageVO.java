package com.nexos.backend.api.beans;

public class GenericMessageVO {
	private String message;

	public GenericMessageVO(String message) {
		super();
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	} 
}
