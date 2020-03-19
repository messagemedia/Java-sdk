package com.messagemedia.api.models;

import java.util.*;

public class AssignmentBuilder {
    //the instance to build
    private Assignment assignment;

    /**
     * Default constructor to initialize the instance
     */
    public AssignmentBuilder() {
        assignment = new Assignment();
    }

    public AssignmentBuilder id(String id) {
        assignment.setId(id);
        return this;
    }

    public AssignmentBuilder metadata(LinkedHashMap<String, String> metadata) {
        assignment.setMetadata(metadata);
        return this;
    }

    public AssignmentBuilder numberId(String numberId) {
        assignment.setNumberId(numberId);
        return this;
    }

    public AssignmentBuilder label(String label) {
        assignment.setLabel(label);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Assignment build() {
        return assignment;
    }
}