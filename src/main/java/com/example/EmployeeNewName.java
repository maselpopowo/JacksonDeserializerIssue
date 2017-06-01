package com.example;

public class EmployeeNewName extends CommonConcernData implements NameChangeDescriptor {

    private String name;

    public EmployeeNewName() {
    }

    @Override
    public String getNewName() {
        return name;
    }
}
