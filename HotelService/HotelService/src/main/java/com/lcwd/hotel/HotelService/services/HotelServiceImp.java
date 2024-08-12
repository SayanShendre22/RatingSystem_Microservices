package com.lcwd.hotel.HotelService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.HotelService.entity.Hotel;
import com.lcwd.hotel.HotelService.repo.HotelRepo;
import com.lcwd.hotel.HotelService.exceptions.ResourceNotFoundException;

@Service
public class HotelServiceImp implements HotelService {

	@Autowired
	HotelRepo hr;
	
	@Override
	public Hotel create(Hotel h) {
		h.setId(UUID.randomUUID().toString());
		return hr.save(h);
	}

	@Override
	public List<Hotel> getAll() {
		return hr.findAll();
	}

	@Override
	public Hotel get(String id) {
		return hr.findById(id).orElseThrow( ()-> new ResourceNotFoundException("hotel with given id not found !!") );
	}

}
