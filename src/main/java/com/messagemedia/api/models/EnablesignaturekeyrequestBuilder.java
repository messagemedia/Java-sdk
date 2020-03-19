package com.messagemedia.api.models;

import java.util.*;

public class EnablesignaturekeyrequestBuilder {
    //the instance to build
    private Enablesignaturekeyrequest enablesignaturekeyrequest;

    /**
     * Default constructor to initialize the instance
     */
    public EnablesignaturekeyrequestBuilder() {
        enablesignaturekeyrequest = new Enablesignaturekeyrequest();
    }

    public EnablesignaturekeyrequestBuilder keyId(String keyId) {
        enablesignaturekeyrequest.setKeyId(keyId);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Enablesignaturekeyrequest build() {
        return enablesignaturekeyrequest;
    }
}