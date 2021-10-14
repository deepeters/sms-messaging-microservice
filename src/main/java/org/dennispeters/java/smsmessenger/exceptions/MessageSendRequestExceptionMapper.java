package org.dennispeters.java.smsmessenger.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.dennispeters.java.smsmessenger.model.ErrorMessage;

@Provider
public class MessageSendRequestExceptionMapper implements ExceptionMapper<MessageSendRequestException> {

	@Override
	public Response toResponse(MessageSendRequestException ex) {
		// TODO Auto-generated method stub
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "http://jave.net");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
