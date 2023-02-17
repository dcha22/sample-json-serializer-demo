package com.sample.jsonserializer.custom.configure;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class EpochDeserializer extends JsonDeserializer<Long> {
	
	static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	@Override
	public Long deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		LocalDate localDate = LocalDate.parse(p.getText(), DATE_FORMATTER);
		
		ZonedDateTime zonedDt = localDate.atStartOfDay(ZoneId.of("UTC"));
		Long millis = zonedDt.toInstant().toEpochMilli();
		return millis;
	}
}
