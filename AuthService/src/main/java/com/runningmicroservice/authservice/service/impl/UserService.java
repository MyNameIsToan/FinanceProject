package com.runningmicroservice.authservice.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.runningmicroservice.authservice.entities.UserEntities;
import com.runningmicroservice.authservice.repository.UserRepository;
import com.runningmicroservice.authservice.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserEntities> findAll() {
		return userRepository.findAll();
	}

	@Override
	public UserEntities Register(UserEntities user) {
		UserEntities NewUser = new UserEntities();
		NewUser.setUsername(user.getUsername());
		NewUser.setPassword(encoder.encode(user.getPassword()));
		NewUser.setEmail(user.getEmail());
		NewUser.setRole(user.getCode());
		NewUser.setCode(GenerateRandomCode());
		NewUser.setEnabled(false);
		userRepository.save(NewUser);
		return NewUser;
	}
	
	@Override
	public Boolean Validate(UserEntities user, String Code) {
		UserEntities ValidateUser = userRepository.findByUsername(user.getUsername());
		if(ValidateUser != null) {
			if(Code.equals(ValidateUser.getCode())) {
				ValidateUser.setEnabled(true);
				userRepository.save(ValidateUser);
				return true;
			}
		}
		return false;
	}

	public String GenerateRandomCode() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return String.format("%06d", number);
	}
}
