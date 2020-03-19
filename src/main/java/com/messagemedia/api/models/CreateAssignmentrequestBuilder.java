package com.messagemedia.api.models;

import java.util.*;

public class CreateAssignmentrequestBuilder {
    //the instance to build
    private CreateAssignmentrequest createAssignmentrequest;

    /**
     * Default constructor to initialize the instance
     */
    public CreateAssignmentrequestBuilder() {
        createAssignmentrequest = new CreateAssignmentrequest();
    }

    public CreateAssignmentrequestBuilder label(String label) {
        createAssignmentrequest.setLabel(label);
        return this;
    }

    public CreateAssignmentrequestBuilder metadata(LinkedHashMap<String, String> metadata) {
        createAssignmentrequest.setMetadata(metadata);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public CreateAssignmentrequest build() {
        return createAssignmentrequest;
    }
}