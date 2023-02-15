package com.sample.jsonserializer.custom.configure;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class TeaConstants {
	public static final String DATETIME_FORMAT = "dd-MM-yyyy HH:mm:ss";
	
	public static final LocalDateTime FIXED_DATE = LocalDateTime.now();
	
	public static LocalDateTimeSerializer LOCAL_DATETIME_SERIALIZER = 
			new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
	
	public static final String DATETIME_FORMAT2 = "dd-MM-yyyy HH:mm";
	public static LocalDateTimeSerializer LOCAL_DATETIME_SERIALIZER2 = 
			new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT2));
	
	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static LocalDateSerializer LOCAL_DATE_SERIALIZER = 
			new LocalDateSerializer(DateTimeFormatter.ofPattern(DATE_FORMAT));
}
