package com.sample.jsonserializer.custom.configure;

import static com.sample.jsonserializer.custom.configure.TeaConstants.LOCAL_DATETIME_SERIALIZER;
import static com.sample.jsonserializer.custom.configure.TeaConstants.LOCAL_DATE_SERIALIZER;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;


@Configuration
public class TeaHttpConverterConfiguration {
	
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessgeConverter() {
		
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
								.serializers(LOCAL_DATETIME_SERIALIZER)
								.serializers(LOCAL_DATE_SERIALIZER)
								.serializationInclusion(JsonInclude.Include.NON_NULL)
								.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
								.simpleDateFormat("dd-MM-yy HH:mm");
		
		
		return new MappingJackson2HttpMessageConverter (builder.build());
	}
}
