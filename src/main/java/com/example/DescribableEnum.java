package com.example;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = DescribableEnumSerializer.class)
public interface DescribableEnum {

    String getDescription();

    String name();
}

