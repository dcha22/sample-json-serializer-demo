package com.sample.jsonserializer.custom.configure;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class EpochSerializer extends JsonSerializer<Long> {
	
	static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	@Override
	public void serialize(Long value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		
		LocalDate date = Instant.ofEpochMilli(value)
							.atZone(ZoneId.of("UTC"))
							.toLocalDate();
		String formattedString = date.format(DATE_FORMATTER);
		gen.writeString(formattedString);
	}
}
