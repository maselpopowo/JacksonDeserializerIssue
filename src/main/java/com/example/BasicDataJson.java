package com.example;

import java.util.Collection;

public class BasicDataJson<T extends ConcernData> {

    private Collection<T> people;

    private DataType type;

    public BasicDataJson() {
    }

    public DataType getType() {
        return type;
    }

    public Collection<T> getPeople() {
        return people;
    }
}
