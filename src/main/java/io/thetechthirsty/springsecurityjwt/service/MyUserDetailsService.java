package io.thetechthirsty.springsecurityjwt.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username.equals("foo")) {
			return new User("foo", "$2a$10$PqbwFOkdK.X1gZ3dxmcgwuh8w7jeC.3uhBMkADNEYuf4avBVN57B2", new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("User name not found");
		}
		
	}

}
