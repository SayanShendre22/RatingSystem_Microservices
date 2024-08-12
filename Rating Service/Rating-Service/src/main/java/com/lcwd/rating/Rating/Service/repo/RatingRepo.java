package com.lcwd.rating.Rating.Service.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lcwd.rating.Rating.Service.entity.Rating;

public interface RatingRepo extends MongoRepository<Rating,String>{

	
	//customMethods
	public List<Rating> findByHotelID(String id);
	public List<Rating> findByUserID(String id);
	
}
