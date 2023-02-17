package com.sample.jsonserializer.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.jsonserializer.model.Person;

@RestController
@RequestMapping("/demo2")
public class PersonController {
	
	@GetMapping("/person") 
	public ResponseEntity<com.sample.jsonserializer.model.Person> getPerson(
			@RequestParam (required = false) String firstName, 
			@RequestParam (required = false) String lastName,
			@RequestParam (required = false) int age) {
		
		Person _person = new com.sample.jsonserializer.model.Person();
		
		_person.setFirstName(firstName);
		_person.setLastName(lastName);
		_person.setAge(age);
		_person.setLocalDateTime(LocalDateTime.ofInstant(new Date().toInstant(),ZoneId.systemDefault()));
		_person.setBirthDate(1373473547000L); //hard coded the epoch for 
		return new ResponseEntity<>(_person, HttpStatus.OK);
	}
	
	@RequestMapping("/person")
	public ResponseEntity<Person> savePerson (@RequestBody Person person) {
		return new ResponseEntity<>(person, HttpStatus.OK);
	}
}
