package com.messagemedia.api.models;

import java.util.*;

public class NumberBuilder {
    //the instance to build
    private Number numberInstance;

    /**
     * Default constructor to initialize the instance
     */
    public NumberBuilder() {
        numberInstance = new Number();
    }

    public NumberBuilder number(String number) {
        numberInstance.setNumber(number);
        return this;
    }

    public NumberBuilder authorised(boolean authorised) {
        numberInstance.setAuthorised(authorised);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Number build() {
        return numberInstance;
    }
}