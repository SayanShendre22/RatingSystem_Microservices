package com.user.service.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entity.user;
import com.user.service.services.UserServices;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("users")
public class MyController {
	
	@Autowired
	private UserServices us;

	@RequestMapping("/hello")
	public String hello() {
		return "Hello sayan";
	}
	
	
	 private static final Logger logger = LoggerFactory.getLogger(MyController.class);
	
	
	// create
	@PostMapping
	public ResponseEntity<user> createUser(@RequestBody  user u)
	{
		user u1 = us.saveUser(u);
		return ResponseEntity.status(HttpStatus.CREATED).body(u1);  // way 1
	}
	
	// get single users
	@GetMapping("/{id}")
//	@CircuitBreaker(name = "RatingHotelBraker",fallbackMethod = "RatingHotelFallback")
//	@Retry(name = "RatingHotelRetry",fallbackMethod = "RatingHotelFallback")
	@RateLimiter(name = "RatingHotelRateLimiter",fallbackMethod = "RatingHotelFallback")
	public ResponseEntity<user> getUserById(@PathVariable String id){
		user u1 = us.getUserById(id);
		return new ResponseEntity<>(u1,HttpStatus.OK);  		   // way 2
	}
	
	int retryCount =1;
	
	//fallback fun for getUserById API
	public ResponseEntity<user> RatingHotelFallback(String id, Exception ex){
		logger.info("getUserById API fails "+ex.getMessage());
		user u =new user("00","DEMO", "DEMO@123", "it is an demo user, because service fail to serve you");
		logger.info("retry count : "+retryCount);
		retryCount++;
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	
	// get all users
	@GetMapping
	public ResponseEntity<List<user>> getAllUsers(){
		List<user> u = us.getAllUsers();
		return ResponseEntity.ok(u);                               // way 3
	}
	
	
}
