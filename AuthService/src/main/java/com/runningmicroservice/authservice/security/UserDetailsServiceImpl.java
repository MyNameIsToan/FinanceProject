package com.runningmicroservice.authservice.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.runningmicroservice.authservice.entities.UserEntities;
import com.runningmicroservice.authservice.service.IUserService;

@Service 
public class UserDetailsServiceImpl implements UserDetailsService  {
	
	@Autowired
	private IUserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<UserEntities> users = userService.findAll();
		for(UserEntities user: users) {
			if(user.getUsername().equals(username)) {
				if(user.isEnabled() == true) {
					List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_" + user.getRole());
					return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
				}
			}
		}
		throw new UsernameNotFoundException("Username: " + username + " not found");
	}
}