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

import com.luv2code.springboot.cruddemo.entity.Assets;

import com.luv2code.springboot.cruddemo.exceptions.AssetNotFoundException;
import com.luv2code.springboot.cruddemo.response.Response;
import com.luv2code.springboot.cruddemo.service.AssetsService;


@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class AssetsRestController {
	
//	@Autowired
//	private RequestsService requestsSevice;
//	
	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unused")
	private AssetsService assetsService;
	@Autowired
	public AssetsRestController(AssetsService theAssetsService) {
		this.assetsService = theAssetsService;
	}
	
	//expose "/Assets" and return the list
	@SuppressWarnings("unchecked")
	@GetMapping("/assets")
	public Response<List<Assets>> findAll() throws AssetNotFoundException {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8081/api/assets", HttpMethod.GET, entity, Response.class).getBody();
	}
	
	// add mapping for GET /Assets/{assetId}
	@SuppressWarnings("unchecked")
	@GetMapping("/assets/{assetId}")
	public Response<Assets> getAsset(@PathVariable int assetId) throws AssetNotFoundException {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8081/api/assets/"+assetId, HttpMethod.GET, entity, Response.class).getBody();
		
		
	}
	
	// add for POST /Assets
	
	@SuppressWarnings("unchecked")
	@PostMapping("/assets")
	public Response<Assets> addAsset(@RequestBody Assets theAsset) {
//		theAsset.setAssetID(0);
//		theAsset.setRequestInfoBeanList();
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Assets> entity = new HttpEntity<Assets>(theAsset,headers);
	      
	      return restTemplate.exchange("http://localhost:8081/api/assets", HttpMethod.POST, entity, Response.class).getBody();
	}
	
	// add mapping for PUT /Assets - update
	
	@SuppressWarnings("unchecked")
	@PutMapping("/assets")
	public Response<Assets> updateAsset(@RequestBody Assets theAsset) {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Assets> entity = new HttpEntity<Assets>(theAsset,headers);
	      
	      return restTemplate.exchange("http://localhost:8081/api/assets", HttpMethod.PUT, entity, Response.class).getBody();
	}
	
	// add mapping for DELETE /Assets/{assetId}
	@SuppressWarnings("unchecked")
	@DeleteMapping("/assets/{assetId}")
	public Response<String> deleteAsset(@PathVariable int assetId) throws AssetNotFoundException {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8081/api/assets/"+assetId, HttpMethod.DELETE, entity, Response.class).getBody();
		
		
	}
	
	@GetMapping("/assets/{pageNumber}/{itemsPerPage}")
	public Object getAssets(@PathVariable int pageNumber,@PathVariable int itemsPerPage){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange("http://localhost:8081/api/assets/" + pageNumber + "/" + itemsPerPage, HttpMethod.GET, entity, Object.class)
				.getBody();
	}
	
	
	@GetMapping("/assets/{pageNumber}/{itemsPerPage}/{fieldName}")
	public Object getSortAssets(@PathVariable int pageNumber,@PathVariable int itemsPerPage,@PathVariable String fieldName){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange("http://localhost:8081/api/assets/" + pageNumber + "/" + itemsPerPage + "/" + fieldName, HttpMethod.GET, entity, Object.class)
				.getBody();	
	}

	@GetMapping("/requests/{pageNumber}/{itemsPerPage}")
	public Object getRequestForm(@PathVariable int pageNumber,@PathVariable int itemsPerPage){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange("http://localhost:8082/api/requests/" + pageNumber + "/" + itemsPerPage, HttpMethod.GET, entity,Object.class)
				.getBody();
	}

	@GetMapping("/requests/{pageNumber}/{itemsPerPage}/{fieldName}")
	public Object getSortRequestForm(@PathVariable int pageNumber,@PathVariable int itemsPerPage,@PathVariable String fieldName){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange("http://localhost:8082/api/requests/" + pageNumber + "/" + itemsPerPage + "/" + fieldName, HttpMethod.GET, entity, Object.class)
				.getBody();
	}
	
	
}
