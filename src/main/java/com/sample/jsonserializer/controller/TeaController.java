package com.sample.jsonserializer.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.jsonserializer.model.Tea;

@RestController
@RequestMapping("/demo")
public class TeaController {
	
	@GetMapping("/greeting") 
	public String greeting() {
		return "Hi from my Tea world";
	}
	
	/**
	 * Method Description: 
	 * @param name
	 * @param model
	 * @return
	 */
	@GetMapping("/greeting2") 
	public String greeting2(
			@RequestParam(name="name", required=false, defaultValue = "INDIA")  
			String name, Model model) {
		model.addAttribute("name", name);
		return "greetings..";
	}
	
	@RequestMapping("/tea")
	public ResponseEntity<Tea> getTeaObject(
			@RequestParam (required = false) String name, 
			@RequestParam (required = false) String type
			) {
		Tea _tea = new Tea();
		_tea.setTeaName(name);
		_tea.setTeaType(type);
		_tea.setLocalDateTime(LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));
		_tea.setDate(new Date());
		_tea.setLocalDate(LocalDate.ofInstant(new Date().toInstant(),ZoneId.systemDefault()));
		return new ResponseEntity<>(_tea, HttpStatus.OK);
	}
}
