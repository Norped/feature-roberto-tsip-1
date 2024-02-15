package com.urlnavigator.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UrlNavigatorController {
	
	@GetMapping(value = "/test")
	private String test(){
		return "Norped, Testing is done successfully!";
	}

}
