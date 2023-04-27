Jackson Json Serialization and Deserialization

Spring Boot uses Jackson library by default to serialize and deserialize 
json data objects

If you want to change the format for certain properties in Json, you can use 
custom serialization and here are options for customization:

- Some basic customization can be done by defining properties in application.properties
	file, such as: 
	spring.jackson.serialization.write-dates-as-timestamps=false

- By setting properties on the class properties such as: 
	JsonProperty(value = "date")
	private LocalDateTime localDateTime;

- By defining  a custom class and adding it to the class that you want to 
  apply the customization on, for example:
  
  	@JsonSerialize(using = TeaCustomSerializer.class)
	public class Tea {...

- By adding bean definitions of the following types in a @Configuration class:
	a. MappingJackson2HttpMessageConverter
	b. ObjectMapper and adding customization to the object mapper
	The customization defined here will be applied globally
