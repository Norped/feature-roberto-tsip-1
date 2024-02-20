package com.urlnavigator.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urlnavigator.api.entity.UrlEntity;
import com.urlnavigator.api.service.UrlServiceImpl;

@RestController
@RequestMapping("/api")
public class UrlNavigatorController {

	
	  private final UrlServiceImpl urlServiceImpl;

	  @Autowired
	  public UrlNavigatorController(UrlServiceImpl urlServiceImpl) {
	      this.urlServiceImpl = urlServiceImpl;
	  }
	
	@GetMapping(value = "/test")
	private String test(){
		return "Norped, Testing is done successfully!";
	}
	
	@GetMapping(value = "/findUrl/{urlName}")
    private ResponseEntity<Object> findUrl(@PathVariable String urlName) {
        UrlEntity url = urlServiceImpl.findByUrl(urlName);
        return new ResponseEntity<>((Object) url, HttpStatus.OK);
    }
	
	@GetMapping(value = "/list")
	private ResponseEntity<Object> findAll(){
		Iterable<UrlEntity> urls = this.urlServiceImpl.findAll();
		return new ResponseEntity<>((Object) urls, HttpStatus.OK);
	}
	

}