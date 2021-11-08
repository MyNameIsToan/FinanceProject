package com.runningmicroservice.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.runningmicroservice.authservice.entities.UserEntities;

public interface UserRepository extends JpaRepository<UserEntities, Long>{
	UserEntities findByUsername(String username);
}
