package com.usco.project.message.response;

public class ResponseMessage {
	private String message;
	
	private Boolean isOk;
 
	public ResponseMessage(String message, Boolean isOk) {
		this.message = message;
		this.isOk = isOk;
	}
 
	public String getMessage() {
		return message;
	}
 
	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getIsOk() {
		return isOk;
	}

	public void setIsOk(Boolean isOk) {
		this.isOk = isOk;
	}
	
	
}
