package com.user.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.entity.user;

public interface UserRepo extends JpaRepository<user, String> {

}
