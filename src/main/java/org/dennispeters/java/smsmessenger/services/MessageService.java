package org.dennispeters.java.smsmessenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dennispeters.java.smsmessenger.database.DatabaseClass;
import org.dennispeters.java.smsmessenger.model.Message;


public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1, "Harry Potter was a good film series", "+254700000000"));
		messages.put(2L, new Message(2, "Fantastic Beast has dragons and that way better", "+254711111111"));
		messages.put(3L, new Message(3, "Neither can match up to Lord of the Rings", "+254722222222"));
	}
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message> (messages.values());
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(),  message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	

}