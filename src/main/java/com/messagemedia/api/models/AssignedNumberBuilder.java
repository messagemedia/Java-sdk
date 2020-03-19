package com.messagemedia.api.models;

import java.util.*;

public class AssignedNumberBuilder {
    //the instance to build
    private AssignedNumber assignedNumber;

    /**
     * Default constructor to initialize the instance
     */
    public AssignedNumberBuilder() {
        assignedNumber = new AssignedNumber();
    }

    public AssignedNumberBuilder assignment(Assignment assignment) {
        assignedNumber.setAssignment(assignment);
        return this;
    }

    public AssignedNumberBuilder number(Number number) {
        assignedNumber.setNumber(number);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public AssignedNumber build() {
        return assignedNumber;
    }
}