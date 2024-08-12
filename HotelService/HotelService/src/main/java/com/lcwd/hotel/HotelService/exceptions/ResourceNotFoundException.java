package com.lcwd.hotel.HotelService.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super("Resourse not found !!");
		
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}


	
}
