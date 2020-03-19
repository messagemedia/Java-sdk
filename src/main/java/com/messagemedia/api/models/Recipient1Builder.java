package com.messagemedia.api.models;

import java.util.*;

public class Recipient1Builder {
    //the instance to build
    private Recipient1 recipient1;

    /**
     * Default constructor to initialize the instance
     */
    public Recipient1Builder() {
        recipient1 = new Recipient1();
    }

    public Recipient1Builder id(String id) {
        recipient1.setId(id);
        return this;
    }

    public Recipient1Builder number(String number) {
        recipient1.setNumber(number);
        return this;
    }

    public Recipient1Builder parameters(Parameters2 parameters) {
        recipient1.setParameters(parameters);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Recipient1 build() {
        return recipient1;
    }
}