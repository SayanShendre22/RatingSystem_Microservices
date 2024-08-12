package com.user.service.exception;

public class ResourseNotFoundExcepton extends RuntimeException {
	
	public ResourseNotFoundExcepton() {
		super("Resourse Not Found on Server!!! ");
	}
	
	public ResourseNotFoundExcepton(String msg) {
		super(msg);
	}

}
