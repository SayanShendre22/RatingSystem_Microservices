package com.user.service.external.hotelservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.entity.Hotel;

@FeignClient(name = "HOTELSERVICE")
public interface HotelService {
	
	@GetMapping("/hotels/{id}")
	Hotel getHotel(@PathVariable String id);

}
