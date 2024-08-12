package com.lcwd.hotel.HotelService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.hotel.HotelService.entity.Hotel;
import com.lcwd.hotel.HotelService.services.HotelService;

@RestController
@RequestMapping("hotels")
public class MyControllers {
	
	@Autowired
	private HotelService hs;
	
	// create 
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel h){
		return ResponseEntity.status(HttpStatus.CREATED).body(hs.create(h));
	}
	
	
	// get All 
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel(){
		return ResponseEntity.status(HttpStatus.OK).body(hs.getAll());
	}
	
	
	// get single
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotelByID(@PathVariable String id){
		return new ResponseEntity<>(hs.get(id),HttpStatus.OK);
	}
		

}
