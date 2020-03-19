package com.messagemedia.api.models;

import java.util.*;

public class AddoneormorenumberstoyourbacklistrequestBuilder {
    //the instance to build
    private Addoneormorenumberstoyourbacklistrequest addoneormorenumberstoyourbacklistrequest;

    /**
     * Default constructor to initialize the instance
     */
    public AddoneormorenumberstoyourbacklistrequestBuilder() {
        addoneormorenumberstoyourbacklistrequest = new Addoneormorenumberstoyourbacklistrequest();
    }

    /**
     * Array of numbers to be added to the blacklist. These should be specified in E.164 international format. For information on E.164, please refer to http://en.wikipedia.org/wiki/E.164.
     */
    public AddoneormorenumberstoyourbacklistrequestBuilder numbers(List<String> numbers) {
        addoneormorenumberstoyourbacklistrequest.setNumbers(numbers);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Addoneormorenumberstoyourbacklistrequest build() {
        return addoneormorenumberstoyourbacklistrequest;
    }
}