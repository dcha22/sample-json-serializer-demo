package com.sample.jsonserializer.custom.configure;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sample.jsonserializer.model.Tea;

public class TeaCustomSerializer  extends StdSerializer<Tea>{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	
	protected TeaCustomSerializer() {
		this(null);
	}

	protected TeaCustomSerializer(Class<Tea> t) {
		super(t);
	}

	@Override
	public void serialize(Tea value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject(); // writes '{'
		provider.defaultSerializeField("TEANAME", value.getTeaName(), gen);
		provider.defaultSerializeField("TeaType", value.getTeaType(), gen);
		provider.defaultSerializeField("Local_Date", value.getLocalDate(), gen);
		gen.writeEndObject(); // writes '}'
	}
	
	
}
