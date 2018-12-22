package com.nexos.backend.api.vo;

import com.nexos.backend.api.exception.MessageCode;

public class GenericMessageVO {
	private MessageCode messageCode;

	public GenericMessageVO(MessageCode messageCode) {
		super();
		this.messageCode = messageCode;
	}

	public MessageCode getMessageCode() {
		return messageCode;
	}	 
}
