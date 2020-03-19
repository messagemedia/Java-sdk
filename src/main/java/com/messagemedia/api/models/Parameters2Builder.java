package com.messagemedia.api.models;

import java.util.*;

public class Parameters2Builder {
    //the instance to build
    private Parameters2 parameters2;

    /**
     * Default constructor to initialize the instance
     */
    public Parameters2Builder() {
        parameters2 = new Parameters2();
    }

    public Parameters2Builder firstName(String firstName) {
        parameters2.setFirstName(firstName);
        return this;
    }

    public Parameters2Builder lastName(String lastName) {
        parameters2.setLastName(lastName);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Parameters2 build() {
        return parameters2;
    }
}