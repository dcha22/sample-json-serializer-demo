package com.sample.jsonserializer.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sample.jsonserializer.custom.configure.EpochDeserializer;
import com.sample.jsonserializer.custom.configure.EpochSerializer;

import lombok.Data;

@Data
public class Person {

	private Long id;
	private String firstName;
	private String lastName;
	private int age;
	@JsonSerialize(using = EpochSerializer.class)
	@JsonDeserialize(using = EpochDeserializer.class)
	private long birthDate;
	@JsonProperty(value = "date")
	private LocalDateTime localDateTime;
}
