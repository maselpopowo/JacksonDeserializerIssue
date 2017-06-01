package com.example;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

public class DataJsonDeserializer {

    private final ObjectMapper objectMapper;

    private final Map<DataType, Class<? extends ConcernData>> typeMapping = ImmutableMap.of(
        DataType.ABSENCE, EmployeeAbsence.class,
        DataType.NEW_NAME, EmployeeNewName.class
    );

    private final Map<DataType, Class<? extends BasicDataJson>> typeToJson = ImmutableMap.of(
        DataType.ABSENCE, DataJson.class,
        DataType.NEW_NAME, BasicDataJson.class
    );

    public DataJsonDeserializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public BasicDataJson read(String json) throws IOException {
        DataType type = getType(json);

        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(
            typeToJson.get(type), typeMapping.get(type));
        return objectMapper.readValue(json, javaType);
    }

    private DataType getType(String json) throws IOException {
        JsonNode root = objectMapper.readTree(json);
        JsonNode type = root.get("type");
        String typeName = type.get("name").asText();
        return DataType.valueOf(typeName);
    }
}
