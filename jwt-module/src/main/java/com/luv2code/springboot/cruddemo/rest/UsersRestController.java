package com.luv2code.springboot.cruddemo.rest;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.luv2code.springboot.cruddemo.config.JwtUtil;
import com.luv2code.springboot.cruddemo.entity.RequestForm;
import com.luv2code.springboot.cruddemo.entity.UsersInfo;
import com.luv2code.springboot.cruddemo.exceptions.UserNotFoundException;
import com.luv2code.springboot.cruddemo.response.Response;
import com.luv2code.springboot.cruddemo.service.RequestsService;
import com.luv2code.springboot.cruddemo.service.UsersService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class UsersRestController {
	
	@Autowired
	private RestTemplate restTemplate;
	
    @SuppressWarnings("unused")
	@Autowired
	private RequestsService requestsService;
	@SuppressWarnings("unused")
	private UsersService usersService;
	@Autowired
	public UsersRestController(UsersService theUsersService) {
		this.usersService = theUsersService;
	}
	@SuppressWarnings("unused")
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@SuppressWarnings("unused")
	@Autowired
	private JwtUtil jwtUtil;
	
	@SuppressWarnings("unused")
	@Autowired
	private UserDetailsService userDetailsService;
	
	//Requests for Managers
	@SuppressWarnings("unchecked")
	@GetMapping("/myrequests/{id}")
	public Response<List<RequestForm>> myRequests(@PathVariable int id) throws UserNotFoundException {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8083/api/myrequests/"+id, HttpMethod.GET, entity, Response.class).getBody();
	   }
	
	
	//Approval for Managers
	@SuppressWarnings("unchecked")
	@GetMapping("/myapprovals/{id}")
	public Response<List<RequestForm>> myApprovals(@PathVariable int id) throws UserNotFoundException {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8083/api/myapprovals/"+id, HttpMethod.GET, entity, Response.class).getBody();
	}
	
	//expose "/Assets" and return the list
	@SuppressWarnings("unchecked")
	@GetMapping("/users")
	public Response<List<UsersInfo>> findAll() throws UserNotFoundException {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8083/api/users", HttpMethod.GET, entity, Response.class).getBody();
	}
	
	// add mapping for GET /Assets/{assetId}
	@SuppressWarnings("unchecked")
	@GetMapping("/users/{id}")
	public Response<UsersInfo> getRequestForm(@PathVariable int id) throws UserNotFoundException {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8083/api/users/"+id, HttpMethod.GET, entity, Response.class).getBody();
	}
	
	// add for POST /Assets
	
	@SuppressWarnings("unchecked")
	@PostMapping("/users")
	public Response<UsersInfo> addRequestForm(@Valid @RequestBody UsersInfo theRequestForm) {
		
//		theRequestForm.setRequestID(0);
		
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<UsersInfo> entity = new HttpEntity<UsersInfo>(theRequestForm,headers);
	      
	      return restTemplate.exchange("http://localhost:8083/api/users", HttpMethod.POST, entity, Response.class).getBody();
	}
	
	// add mapping for PUT /Assets - update
	
//	@SuppressWarnings("unchecked")
//	@PutMapping("/users")
//	public Response<UsersInfo> updateRequestForm(@PathVariable int id,@RequestBody UsersInfo customer) {
//		HttpHeaders headers = new HttpHeaders();
//	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	      HttpEntity<UsersInfo> entity = new HttpEntity<UsersInfo>(customer,headers);
//	      
//	      return restTemplate.exchange("http://localhost:8083/api/users", HttpMethod.PUT, entity, Response.class).getBody();
//	}
	
	@SuppressWarnings("unchecked")
	@PutMapping("/users")
	public Response<UsersInfo> updateRequestForm(@RequestBody UsersInfo id) {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<UsersInfo> entity = new HttpEntity<UsersInfo>(id,headers);	      
	      return restTemplate.exchange("http://localhost:8083/api/users", HttpMethod.PUT, entity, Response.class).getBody();

	}
	
	@SuppressWarnings("unchecked")
	@PutMapping("/forgotpassword/{email}/{password}")
	public Response<UsersInfo> forgotpassword(@PathVariable String email,@PathVariable 	String password,@RequestBody UsersInfo customer){
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<UsersInfo> entity = new HttpEntity<UsersInfo>(customer,headers);
	      
	      return restTemplate.exchange("http://localhost:8083/api/forgotpassword/" + email + "/" + "password", HttpMethod.PUT, entity, Response.class).getBody();
	}
	
	
	@SuppressWarnings("unchecked")
	@PutMapping
	// add mapping for DELETE /Assets/{assetId}
	@DeleteMapping("/users")
	public Response<String> deleteRequestForm(@PathVariable int id) throws UserNotFoundException {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8083/api/users", HttpMethod.DELETE, entity, Response.class).getBody();
	}
	
	
	@GetMapping("/users/{pageNumber}/{itemsPerPage}")
	public Object getRequestForm(@PathVariable int pageNumber,@PathVariable int itemsPerPage){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange("http://localhost:8083/api/users/" + pageNumber + "/" + itemsPerPage, HttpMethod.GET, entity, Object.class)
				.getBody();
	}
	
	@GetMapping("/users/{pageNumber}/{itemsPerPage}/{fieldName}")
	public Object getSortRequestForm(@PathVariable int pageNumber,@PathVariable int itemsPerPage,@PathVariable String fieldName){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange("http://localhost:8083/api/users/" + pageNumber + "/" + itemsPerPage + "/" + fieldName, HttpMethod.GET, entity, Object.class)
				.getBody();	
	}
	

	
	
	
	
}
