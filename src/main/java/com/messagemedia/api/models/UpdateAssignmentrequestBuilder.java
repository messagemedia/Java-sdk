package com.messagemedia.api.models;

import java.util.*;

public class UpdateAssignmentrequestBuilder {
    //the instance to build
    private UpdateAssignmentrequest updateAssignmentrequest;

    /**
     * Default constructor to initialize the instance
     */
    public UpdateAssignmentrequestBuilder() {
        updateAssignmentrequest = new UpdateAssignmentrequest();
    }

    public UpdateAssignmentrequestBuilder label(String label) {
        updateAssignmentrequest.setLabel(label);
        return this;
    }

    public UpdateAssignmentrequestBuilder metadata(LinkedHashMap<String, String> metadata) {
        updateAssignmentrequest.setMetadata(metadata);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public UpdateAssignmentrequest build() {
        return updateAssignmentrequest;
    }
}