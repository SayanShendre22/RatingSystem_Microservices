package com.lcwd.rating.Rating.Service.exceptions;

public class ResourseNotFoundException extends RuntimeException {

	public ResourseNotFoundException() {
		super("Rating not founded for the given id!!");
	}

	public ResourseNotFoundException(String message) {
		super(message);
	}

	
	
}
