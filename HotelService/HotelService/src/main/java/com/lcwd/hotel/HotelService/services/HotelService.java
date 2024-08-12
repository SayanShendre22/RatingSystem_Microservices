package com.lcwd.hotel.HotelService.services;

import java.util.List;

import com.lcwd.hotel.HotelService.entity.Hotel;

public interface HotelService {

	
	//create
	public Hotel create(Hotel h);
	
	//get all
	List<Hotel> getAll();
	
	//get single
	Hotel get(String id);
	
}
