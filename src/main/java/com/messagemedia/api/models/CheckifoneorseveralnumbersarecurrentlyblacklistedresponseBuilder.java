package com.messagemedia.api.models;

import java.util.*;

public class CheckifoneorseveralnumbersarecurrentlyblacklistedresponseBuilder {
    //the instance to build
    private Checkifoneorseveralnumbersarecurrentlyblacklistedresponse checkifoneorseveralnumbersarecurrentlyblacklistedresponse;

    /**
     * Default constructor to initialize the instance
     */
    public CheckifoneorseveralnumbersarecurrentlyblacklistedresponseBuilder() {
        checkifoneorseveralnumbersarecurrentlyblacklistedresponse = new Checkifoneorseveralnumbersarecurrentlyblacklistedresponse();
    }

    public CheckifoneorseveralnumbersarecurrentlyblacklistedresponseBuilder uri(String uri) {
        checkifoneorseveralnumbersarecurrentlyblacklistedresponse.setUri(uri);
        return this;
    }

    public CheckifoneorseveralnumbersarecurrentlyblacklistedresponseBuilder numbers(List<Number> numbers) {
        checkifoneorseveralnumbersarecurrentlyblacklistedresponse.setNumbers(numbers);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Checkifoneorseveralnumbersarecurrentlyblacklistedresponse build() {
        return checkifoneorseveralnumbersarecurrentlyblacklistedresponse;
    }
}