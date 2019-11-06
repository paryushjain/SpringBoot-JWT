package io.thetechthirsty.springsecurityjwt.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.thetechthirsty.springsecurityjwt.model.AuthenticationRequest;
import io.thetechthirsty.springsecurityjwt.model.AuthenticationResponse;
import io.thetechthirsty.springsecurityjwt.service.MyUserDetailsService;
import io.thetechthirsty.springsecurityjwt.util.JwtUtil;

@RestController
@RequestMapping("/v1/api")
public class HelloResource {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping(value = "/hello")
	public String hello() {
		return "Hello World!";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createToken(@RequestBody AuthenticationRequest authenticateRequest) throws Exception {

		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(),
				authenticateRequest.getPassword()));

		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticateRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
