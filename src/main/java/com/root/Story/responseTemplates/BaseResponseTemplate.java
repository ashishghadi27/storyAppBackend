package com.root.Story.responseTemplates;

import org.springframework.http.HttpStatus;

public class BaseResponseTemplate {

	private HttpStatus status;
	private String message;
	private Object response;
	
	public BaseResponseTemplate(HttpStatus status, String message, Object response) {
		super();
		this.status = status;
		this.message = message;
		this.response = response;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "BaseResponseTemplate [status=" + status + ", message=" + message + ", response=" + response + "]";
	}
	
}
