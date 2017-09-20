package com.tony.creation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests") 
public class TestController {

	@RequestMapping("/home") 
	public String home() {
		return "home";
	}
		

}