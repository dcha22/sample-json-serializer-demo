package com.sample.jsonserializer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="USA") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@GetMapping("/greeting2") 
	public String greeting2(
			@RequestParam(name="name", required=false, defaultValue = "INDIA")  
			String name, Model model) {
		model.addAttribute("name", name);
		return "dch/greeting2"; // this should map to an html page; 'dch' is subfolder under templates/
	}
}
