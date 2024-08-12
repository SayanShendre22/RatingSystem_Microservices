package com.lcwd.rating.Rating.Service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.Rating.Service.entity.Rating;
import com.lcwd.rating.Rating.Service.exceptions.ResourseNotFoundException;
import com.lcwd.rating.Rating.Service.repo.RatingRepo;

@Service
public class RatingServiceImp implements RatingService {
	
	@Autowired
	RatingRepo rr;

	@Override
	public Rating createRating(Rating r) {
		return rr.save(r);
	}

	@Override
	public List<Rating> getAll() {
		return rr.findAll();
	}

	@Override
	public List<Rating> findByUserID(String id) {
		return rr.findByUserID(id);
	}

	@Override
	public List<Rating> findByHotelID(String id) {
		return rr.findByHotelID(id);
	}

//	@Override
//	public Rating get(String id) {
//		return rr.findById(id).orElseThrow( ()-> new ResourseNotFoundException("Rating with id : "+id+ " not founded!!") );
//	}

}
