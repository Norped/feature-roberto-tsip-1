package com.urlnavigator.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urlnavigator.api.common.Constants;
import com.urlnavigator.api.entity.UrlEntity;
import com.urlnavigator.api.service.UrlServiceImpl;

@RestController
@RequestMapping("/api")
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
        UrlEntity url = urlServiceImpl.findByUrl(urlName);
        return new ResponseEntity<>(url, HttpStatus.OK);
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

	@DeleteMapping(value = "/delete/{id}")
	private ResponseEntity<Object> deleteByUrl(@PathVariable String id)	{
		try {
            Integer urlId = Integer.parseInt(id);
            String result = urlServiceImpl.deleteById(urlId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(this.constants.INVALID_ID_FORMAT, HttpStatus.BAD_REQUEST);
        }
	}
}