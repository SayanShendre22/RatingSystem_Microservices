package com.lcwd.rating.Rating.Service.services;

import java.util.List;

import com.lcwd.rating.Rating.Service.entity.Rating;

public interface RatingService {
	
	// create
	public Rating createRating(Rating r);
	
	// get all
	List<Rating> getAll();
	
	// get single rating
	List<Rating> findByUserID(String id);
	List<Rating> findByHotelID(String id);


}
