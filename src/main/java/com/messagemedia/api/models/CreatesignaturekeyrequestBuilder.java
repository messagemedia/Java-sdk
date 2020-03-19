package com.messagemedia.api.models;

import java.util.*;

public class CreatesignaturekeyrequestBuilder {
    //the instance to build
    private Createsignaturekeyrequest createsignaturekeyrequest;

    /**
     * Default constructor to initialize the instance
     */
    public CreatesignaturekeyrequestBuilder() {
        createsignaturekeyrequest = new Createsignaturekeyrequest();
    }

    public CreatesignaturekeyrequestBuilder digest(String digest) {
        createsignaturekeyrequest.setDigest(digest);
        return this;
    }

    public CreatesignaturekeyrequestBuilder cipher(String cipher) {
        createsignaturekeyrequest.setCipher(cipher);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Createsignaturekeyrequest build() {
        return createsignaturekeyrequest;
    }
}