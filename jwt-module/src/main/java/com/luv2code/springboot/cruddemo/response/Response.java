package com.luv2code.springboot.cruddemo.response;

import lombok.Data;

@Data
public class Response<T> {

	private boolean error;

	private String message;

	T data;

	public Response() {
	}
	
	public Response(boolean error,String message,T data) {
		this.error = error;
		this.message = message;
		this.data = data;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Response [error=" + error + ", message=" + message + ", data=" + data + "]";
	}
	
	
}
