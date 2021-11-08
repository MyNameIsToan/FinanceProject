package com.runningmicroservice.authservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.runningmicroservice.authservice.entities.UserEntities;

@RestController
public class AuthController {
	@GetMapping(value="/Hello")
	public String Testing() {
		return "HelloWorld";		
	}
	
	@PutMapping(value="/register")
	public UserEntities Register(@RequestBody UserEntities model) {
		return Register(model);		
	}
	
	@PutMapping(value="/validate/{code}")
	public boolean Validate(@PathVariable("code") String Code, @RequestBody UserEntities model) {
		return true;	
	}
}
