package com.verisk.tutorial.serverless.model;

public class Message {

	public Message() {}
	
	public Message(String message) {
		this.message = message;
	}
	
	private String message;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
