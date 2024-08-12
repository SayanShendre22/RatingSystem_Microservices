package com.user.service.services;

import java.util.List;

import com.user.service.entity.user;

public interface UserServices {

	public user saveUser(user u);
	
	public List<user> getAllUsers();
	
	public user getUserById(String id);
	
}
