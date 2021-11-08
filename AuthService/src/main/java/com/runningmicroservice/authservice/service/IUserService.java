package com.runningmicroservice.authservice.service;

import java.util.List;

import com.runningmicroservice.authservice.entities.UserEntities;

public interface IUserService {
	List<UserEntities> findAll();
	UserEntities Register(UserEntities user);
	Boolean Validate(UserEntities user, String Code);
}
