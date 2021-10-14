package org.dennispeters.java.smsmessenger.exceptions;

public class MessageSendRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8960107400642640783L;
	
	public MessageSendRequestException(String message) {
		super(message);
	}

}
