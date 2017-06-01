package com.example;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = DataType.Deserializer.class)
public enum DataType implements DescribableEnum{
    ABSENCE("Absence"),
    NEW_NAME("New Name");

    private final String description;

    DataType(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    static class Deserializer extends EnumDeserializer<DataType> {
    }
}
