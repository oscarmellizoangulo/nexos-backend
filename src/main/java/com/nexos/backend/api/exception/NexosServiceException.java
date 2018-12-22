package com.nexos.backend.api.exception;

public class NexosServiceException extends Exception{
private static final long serialVersionUID = 7718828512143293558L;
	
	private final MessageCode code;

	public NexosServiceException(MessageCode code) {
		super();
		this.code = code;
	}

	public NexosServiceException(String message, Throwable cause, MessageCode code) {
		super(message, cause);
		this.code = code;
	}

	public NexosServiceException(String message, MessageCode code) {
		super(message);
		this.code = code;
	}

	public NexosServiceException(MessageCode code, Throwable cause) {
		super(cause);
		this.code = code;
	}
	
	public MessageCode getCode() {
		return this.code;
	}
}
