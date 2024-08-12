package com.lcwd.hotel.HotelService.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.hotel.HotelService.entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String> {

}
