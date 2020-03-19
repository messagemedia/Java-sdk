package com.messagemedia.api.models;

import java.util.*;

public class AddoneormorenumberstoyourbacklistresponseBuilder {
    //the instance to build
    private Addoneormorenumberstoyourbacklistresponse addoneormorenumberstoyourbacklistresponse;

    /**
     * Default constructor to initialize the instance
     */
    public AddoneormorenumberstoyourbacklistresponseBuilder() {
        addoneormorenumberstoyourbacklistresponse = new Addoneormorenumberstoyourbacklistresponse();
    }

    public AddoneormorenumberstoyourbacklistresponseBuilder uri(String uri) {
        addoneormorenumberstoyourbacklistresponse.setUri(uri);
        return this;
    }

    public AddoneormorenumberstoyourbacklistresponseBuilder numbers(List<String> numbers) {
        addoneormorenumberstoyourbacklistresponse.setNumbers(numbers);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Addoneormorenumberstoyourbacklistresponse build() {
        return addoneormorenumberstoyourbacklistresponse;
    }
}