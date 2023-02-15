package com.sample.jsonserializer.custom.configure;

import static com.sample.jsonserializer.custom.configure.TeaConstants.LOCAL_DATETIME_SERIALIZER;
import static com.sample.jsonserializer.custom.configure.TeaConstants.LOCAL_DATETIME_SERIALIZER2;
import static com.sample.jsonserializer.custom.configure.TeaConstants.LOCAL_DATE_SERIALIZER;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Configuration
public class TeaObjectMapperConfig {

	
	@Bean
	@Primary
	@Order(Ordered.HIGHEST_PRECEDENCE)
	// NOTE: Even after commenting @Primary and @Order annnotations
	// this is the one that gets used by the serializer on top of the
	// other custom serializers
	// :( not true, it seems that MappingJackson2HttpMessageConverter class 
	// takes precedence
	public ObjectMapper objectMapper() { 
		JavaTimeModule module = new JavaTimeModule();

		module.addSerializer(LOCAL_DATETIME_SERIALIZER)
		.addSerializer(LOCAL_DATE_SERIALIZER);

		return new ObjectMapper() 
				.setSerializationInclusion(JsonInclude.Include.USE_DEFAULTS) // this config will exclude null value attributes
				.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE)
				.registerModule(module); 
	}
}
