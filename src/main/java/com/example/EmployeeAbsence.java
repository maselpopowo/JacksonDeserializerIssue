package com.example;

public class EmployeeAbsence extends CommonConcernData implements AbsenceDescriptor{

    private Integer numberOfDays;

    public EmployeeAbsence() {
    }

    @Override
    public Integer getNumberOfDays() {
        return numberOfDays;
    }
}
