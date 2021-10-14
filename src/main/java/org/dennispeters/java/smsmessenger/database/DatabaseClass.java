package org.dennispeters.java.smsmessenger.database;

import java.util.HashMap;
import java.util.Map;

import org.dennispeters.java.smsmessenger.model.Message;


public class DatabaseClass {
	
	public static Map<Long, Message> messages = new HashMap<>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}

}
