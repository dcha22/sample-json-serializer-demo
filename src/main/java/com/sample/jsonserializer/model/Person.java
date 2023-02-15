package com.sample.jsonserializer.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Person {

	private Long id;
	private String firstName;
	private String lastName;
	private int age;
	private LocalDateTime localDateTime;
}
