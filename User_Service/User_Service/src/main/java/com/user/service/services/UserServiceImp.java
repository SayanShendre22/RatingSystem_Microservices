package com.user.service.services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.entity.Hotel;
import com.user.service.entity.Rating;
import com.user.service.entity.user;
import com.user.service.exception.ResourseNotFoundExcepton;
import com.user.service.external.hotelservice.HotelService;
import com.user.service.repo.UserRepo;

@Service
public class UserServiceImp implements UserServices {
	
	@Autowired
	private UserRepo ur; 
	
	@Autowired
	private RestTemplate RT;
	
	@Autowired
	HotelService HS;

	@Override
	public user saveUser(user u) {
		// generate random user id
	    String userID =	UUID.randomUUID().toString();
	    u.setId(userID);
		return ur.save(u);
	}

	@Override
	public List<user> getAllUsers() {
		return ur.findAll();
	}

	@Override
	public user getUserById(String id) {
		
		user u = ur.findById(id).orElseThrow(()->new ResourseNotFoundExcepton("User with given id not found :"+id));
	
		// call rating service and add rating to user
		// http://localhost:8083/ratings/user/760aee1b-debf-4af3-ab6e-6e77ff9bada7
		
		Rating[] rating= RT.getForObject("http://RATING-SERVICE/ratings/user/"+u.getId(), Rating[].class);
		
		 List<Rating> ratingArrayList = Arrays.stream(rating).toList();
		 
		 List<Rating> ratingList =  ratingArrayList.stream().map( R ->{
			 
//			 ResponseEntity<Hotel> forEntity = RT.getForEntity("http://HOTELSERVICE/hotels/"+R.getHotelID(),Hotel.class); 
//			 Hotel hotel = forEntity.getBody();

			 Hotel hotel = HS.getHotel(R.getHotelID());
			 
			 R.setHotel(hotel);
			 
			 return R;
		 }
		 ).collect(Collectors.toList());
		
		u.setRatings(ratingList);
		return u;
	}

}
