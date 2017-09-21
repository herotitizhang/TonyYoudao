package com.tony.creation.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // note: has to be @RestController. doesn't work if it's only @Controller
@RequestMapping("/tests") 
public class TestController {

	@RequestMapping("/home") 
	public String home() {
		return "home";
	}
		
	@RequestMapping("/hey") 
	public String hey() {
		return "hey";
	}
	
}