package com.messagemedia.api.models;

import java.util.*;

public class CancelscheduledmessagerequestBuilder {
    //the instance to build
    private Cancelscheduledmessagerequest cancelscheduledmessagerequest;

    /**
     * Default constructor to initialize the instance
     */
    public CancelscheduledmessagerequestBuilder() {
        cancelscheduledmessagerequest = new Cancelscheduledmessagerequest();
    }

    /**
     * Must be set to ```cancelled```.
     */
    public CancelscheduledmessagerequestBuilder status(String status) {
        cancelscheduledmessagerequest.setStatus(status);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Cancelscheduledmessagerequest build() {
        return cancelscheduledmessagerequest;
    }
}