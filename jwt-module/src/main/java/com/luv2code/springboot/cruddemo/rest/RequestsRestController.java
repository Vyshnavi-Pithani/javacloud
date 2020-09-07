package com.luv2code.springboot.cruddemo.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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

import com.luv2code.springboot.cruddemo.entity.RequestForm;
import com.luv2code.springboot.cruddemo.exceptions.RequestNotFoundException;
import com.luv2code.springboot.cruddemo.response.Response;
import com.luv2code.springboot.cruddemo.service.RequestsService;
import com.luv2code.springboot.cruddemo.service.UsersService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class RequestsRestController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unused")
	@Autowired
	private UsersService usersService;
	
	@SuppressWarnings("unused")
	private RequestsService requestsService;
	@Autowired
	public RequestsRestController(RequestsService theRequestsService) {
		this.requestsService = theRequestsService;
	}
	
	

	@SuppressWarnings("unchecked")
	@GetMapping("/approvedrequests")
	public Response<List<RequestForm>> getAllApproved() throws RequestNotFoundException  {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8082/api/approvedrequests", HttpMethod.GET, entity, Response.class).getBody();
	}
	
	
	//Approvals
	@SuppressWarnings("unchecked")
	@PutMapping("/applicationapprove/{appId}")
	public Response<RequestForm> findAllApproved(@PathVariable Integer appId) {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8082/api/applicationapprove/"+appId, HttpMethod.PUT, entity, Response.class).getBody();
	}
	@SuppressWarnings("unchecked")
	@PutMapping("/applicationreject/{appId}")
	public Response<RequestForm> findAllRejected(@PathVariable Integer appId) {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8082/api/applicationreject/"+appId, HttpMethod.PUT, entity, Response.class).getBody();
	}
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/requests")
	public Response<List<RequestForm>> getAllRejected() throws RequestNotFoundException  {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8082/api/requests", HttpMethod.GET, entity, Response.class).getBody();
	}
	
	// add for POST /Assets
	
	@SuppressWarnings("unchecked")
	@PostMapping("/requests/{id}")
	public Response<RequestForm> addRequestForm(@PathVariable int id,@RequestBody RequestForm theRequestForm) {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<RequestForm> entity = new HttpEntity<RequestForm>(theRequestForm,headers);
	      
	      return restTemplate.exchange("http://localhost:8082/api/requests/"+id, HttpMethod.POST, entity, Response.class).getBody();
	   }
	
	

	// add mapping for PUT /Assets - update
	
	@SuppressWarnings("unchecked")
	@PutMapping("/requests/{id}")
	public Response<RequestForm> updateRequestForm(@PathVariable int id,@RequestBody RequestForm theRequestForm) {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <RequestForm> entity = new HttpEntity<RequestForm>(theRequestForm,headers);
	      
	      return restTemplate.exchange("http://localhost:8082/api/requests/"+id, HttpMethod.GET, entity, Response.class).getBody();
	}
	
	// add mapping for DELETE /Assets/{assetId}
	@SuppressWarnings("unchecked")
	@DeleteMapping("/requests/{requestId}")
	public Response<String> deleteRequestForm(@PathVariable int requestId) {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8082/api/requests/"+requestId, HttpMethod.DELETE, entity, Response.class).getBody();
		
	}
	

	
	
	
}
