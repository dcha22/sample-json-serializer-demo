package com.sample.jsonserializer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.jsonserializer.model.Person;
import com.fasterxml.jackson.databind.JsonNode;

@SpringBootTest
class SampleJsonSerializerDemoApplicationTests {
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	@Test
	void contextLoads() {
	}
	
	// Json Object Serialization Test with custom serializer..
	@Test
	public void testPersonSerializer() throws Exception {
		Person person = new Person();
		
		person.setFirstName("dilip");
		person.setLastName("chauhan");
		person.setAge(55);
		person.setBirthDate(35586595000L);
		person.setLocalDateTime(null);
		
	    //System.out.println("Person: "+ mapper.writeValueAsString(person));
	    String serializedPerson =  mapper.writeValueAsString(person);
	    
	    Assertions.assertTrue(serializedPerson.equals("{\"id\":null,\"firstName\":\"dilip\",\"lastName\":\"chauhan\",\"age\":55,\"birthDate\":\"02/16/1971\",\"date\":null}"));
	}
	
	
	// JSON deserialization test  with custom deserializer..
	@Test
	public void testDateDeserializer() throws JsonMappingException, JsonProcessingException {
		String jsonStr = "{\"firstName\":\"Salty\",\"lastName\":\"TheSailor\",\"age\":12,\"birthDate\":\"07/10/2012\"}";
		
		JsonNode node = mapper.readTree(jsonStr);
		Person person = mapper.readerFor(Person.class).readValue(jsonStr);
	
		Assertions.assertTrue(person.getFirstName().equals("Salty"));
		Assertions.assertTrue(person.getLastName().equals("TheSailor"));
		Assertions.assertTrue(person.getAge() == 12);
		Assertions.assertTrue(person.getBirthDate() > 0 );
		
	}
}
