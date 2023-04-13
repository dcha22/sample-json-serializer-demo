package com.sample.jsonserializer.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sample.jsonserializer.custom.configure.TeaCustomSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// You can add a custom Serializer at the class level as below

//@JsonSerialize(using = TeaCustomSerializer.class)
public class Tea {
	private String teaName;
	private String teaType;
	private Date date;
	private LocalDate localDate;
	private LocalDateTime localDateTime;
}
