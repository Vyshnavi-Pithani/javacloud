package com.luv2code.springboot.cruddemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.config.JwtUtil;
import com.luv2code.springboot.cruddemo.entity.UsersInfo;
import com.luv2code.springboot.cruddemo.exceptions.UserNotFoundException;
import com.luv2code.springboot.cruddemo.response.TokenResponse;
import com.luv2code.springboot.cruddemo.service.RequestsService;
import com.luv2code.springboot.cruddemo.service.UsersService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class JwtController {

	@Autowired
	private RequestsService requestsService;
	private UsersService usersService;
	@Autowired
	public JwtController(UsersService theUsersService) {
		this.usersService = theUsersService;
	}
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@PostMapping("/login")
	public TokenResponse<UsersInfo> login(@RequestBody UsersInfo register) throws Exception{
	
		UsersInfo customer =usersService.findByemail(register.getEmail());
		if(customer == null) {
			return new TokenResponse<UsersInfo>(true, "Invalid Email",null,null);

		}
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(register.getEmail(),register.getPassword()));
		} catch(DisabledException de) {
//			throw new Exception("User disabled",de);

			throw new UserNotFoundException();
			
		} catch(BadCredentialsException bce) {
			
			return new TokenResponse<UsersInfo>(true, "Invalid Password",null,null);

		}// End of try catch
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(register.getEmail());
	
		final String jwt = jwtUtil.generateToken(userDetails);
		
		return new TokenResponse<UsersInfo>(false, "Login Successful",jwt,customer);
	}// End of login()
}
