package com.example;

public class DataJson<T extends ConcernData> extends BasicDataJson {

    private String description;

    public DataJson() {
    }

    public String getDescription() {
        return description;
    }
}
