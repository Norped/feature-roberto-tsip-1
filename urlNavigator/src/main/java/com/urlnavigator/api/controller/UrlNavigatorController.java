package com.urlnavigator.api.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urlnavigator.api.exception.ApiError;
import com.urlnavigator.api.exception.ApiErrorMessages;

import com.urlnavigator.api.common.Constants;
import com.urlnavigator.api.entity.UrlEntity;
import com.urlnavigator.api.service.UrlServiceImpl;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://192.168.1.34:8080")
public class UrlNavigatorController {

	
	  private final UrlServiceImpl urlServiceImpl;
	  private final Constants constants;

	  @Autowired
	  public UrlNavigatorController(UrlServiceImpl urlServiceImpl, Constants constants) {
	      this.urlServiceImpl = urlServiceImpl;
	      this.constants = constants;
	  }
	
	@GetMapping(value = "/test")
	private String test(){
		return constants.TEST;
	}
	
	@GetMapping(value = "/findUrl/{urlName}")
    private ResponseEntity<Object> findUrl(@PathVariable String urlName) {
		
		switch (urlName.trim()) {
        	case "" -> {
	        				ApiError apiError = new ApiError(ApiErrorMessages.INVALID_PARAMETERS, HttpStatus.BAD_REQUEST,
				            ApiErrorMessages.INVALID_PARAMETERS, ApiErrorMessages.URL_IS_EMPTY, LocalDateTime.now());
	        				return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
        				}
        	case " " -> System.out.println("The string contains a single space.");
        	default -> {
        		UrlEntity url = urlServiceImpl.findByUrl(urlName);
        		if (url == null || url.getUrl().isEmpty()) {
        			
        			ApiError apiError = new ApiError(ApiErrorMessages.INVALID_PARAMETERS, HttpStatus.BAD_REQUEST,
				            ApiErrorMessages.INVALID_PARAMETERS, ApiErrorMessages.URL_IS_NOT_FOUND, LocalDateTime.now());
	        				return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
        			
        		}else {
        			return new ResponseEntity<>(url, HttpStatus.OK);
        		}	
        	}
		}
		return null;
		
    }
	
	@GetMapping(value = "/list")
	private ResponseEntity<Object> findAll(){
		Iterable<UrlEntity> urls = this.urlServiceImpl.findAll();
		return new ResponseEntity<>(urls, HttpStatus.OK);
	}
	
	@PostMapping(value = "/add")
	private ResponseEntity<Object> save(@RequestBody UrlEntity payload)	{
		UrlEntity result = this.urlServiceImpl.save(payload);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PutMapping(value = "/update")
	private ResponseEntity<Object> update(@RequestBody UrlEntity payload)	{
		UrlEntity result = this.urlServiceImpl.update(payload);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<Object> deleteByUrl(@RequestBody Map<String, Integer> requestData) {
	    // Extract the ID from the request data
	    Integer urlId = requestData.get("id");
	    
	    // Check if the ID is provided and valid
	    if (urlId == null) {
	        ApiError apiError = new ApiError(ApiErrorMessages.INVALID_PARAMETERS, HttpStatus.BAD_REQUEST,
	                ApiErrorMessages.INVALID_PARAMETERS, ApiErrorMessages.URL_ID_MUST_NUMERIC, LocalDateTime.now());
	        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	    }
	    
	    try {
	        // Call the service method to delete the record
	        String result = urlServiceImpl.deleteById(urlId);
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    } catch (Exception e) {
	        // Handle any exceptions that occur during deletion
	        ApiError apiError = new ApiError("Error deleting record", HttpStatus.INTERNAL_SERVER_ERROR,
	                "Error deleting record", e.getMessage(), LocalDateTime.now());
	        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


	
	@DeleteMapping(value = "/delete/{id}")
	private ResponseEntity<Object> deleteByUrl(@PathVariable String id)	{
		try {
            Integer urlId = Integer.parseInt(id);
            String result = urlServiceImpl.deleteById(urlId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (NumberFormatException e) {
        	
        	ApiError apiError = new ApiError(ApiErrorMessages.INVALID_PARAMETERS, HttpStatus.BAD_REQUEST,
		            ApiErrorMessages.INVALID_PARAMETERS, ApiErrorMessages.URL_ID_MUST_NUMERIC, LocalDateTime.now());
    				return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
        }
	}
}