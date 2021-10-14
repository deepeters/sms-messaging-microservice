package org.dennispeters.java.smsmessenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class Message {
	
	private long id;
	private String message;
	private Date created;
	private String phoneNumber;
	
	//Constructors
	public Message() {
		
	}
	
	public Message(long id, String message, String phoneNumber) {
		this.id = id;
		this.message = message;
		this.phoneNumber = phoneNumber;
		this.created = new Date();
	}
	
	//Getters and Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	

}
