package com.messagemedia.api.models;

import java.util.*;

public class SecondaryButtonLinkBuilder {
    //the instance to build
    private SecondaryButtonLink secondaryButtonLink;

    /**
     * Default constructor to initialize the instance
     */
    public SecondaryButtonLinkBuilder() {
        secondaryButtonLink = new SecondaryButtonLink();
    }

    public SecondaryButtonLinkBuilder type(String type) {
        secondaryButtonLink.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public SecondaryButtonLink build() {
        return secondaryButtonLink;
    }
}