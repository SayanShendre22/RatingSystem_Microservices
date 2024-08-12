package com.lcwd.rating.Rating.Service.controllers;

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

import com.lcwd.rating.Rating.Service.entity.Rating;
import com.lcwd.rating.Rating.Service.services.RatingService;
import com.lcwd.rating.Rating.Service.services.RatingServiceImp;

@RestController
@RequestMapping("/ratings")
public class MyController {

	@Autowired
	RatingService rs;

	// create
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating r) {
		return ResponseEntity.status(HttpStatus.CREATED).body(rs.createRating(r));
	}

	// get all
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating() {
		return new ResponseEntity<>(rs.getAll(), HttpStatus.OK);
	}

	// get by user id
	@GetMapping("/user/{id}")
	public ResponseEntity<List<Rating>> getByUserId(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(rs.findByUserID(id));
	}

	// get by hotel id
	@GetMapping("/hotel/{id}")
	public ResponseEntity<List<Rating>> getByHotelId(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(rs.findByHotelID(id));
	}

}
