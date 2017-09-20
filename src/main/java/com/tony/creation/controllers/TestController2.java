package com.tony.creation.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@RestController
//public class TestController2 {
//	
//	@RequestMapping("/getTests") 
//	public Map<String, Object> getTests() {
//		Map<String, Object> model = new HashMap<String, Object>();
//		List<String> thresholds = new ArrayList<String>();
//		thresholds.add("  ");
//		model.put("thresholds", thresholds);
//		return model;
//	}
//}

@Controller
public class TestController2 {
	
	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
	    model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
	    return "welcome";
	}
}