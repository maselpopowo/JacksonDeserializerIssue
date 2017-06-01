package com.example;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DescribableEnumSerializer extends JsonSerializer<DescribableEnum> {

    @Override
    public void serialize(DescribableEnum describableEnum, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name", describableEnum.name());
        jsonGenerator.writeStringField("description", describableEnum.getDescription());
        jsonGenerator.writeEndObject();
    }
}
