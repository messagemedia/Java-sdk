package com.messagemedia.api.models;

import java.util.*;

public class PrimaryButtonLinkBuilder {
    //the instance to build
    private PrimaryButtonLink primaryButtonLink;

    /**
     * Default constructor to initialize the instance
     */
    public PrimaryButtonLinkBuilder() {
        primaryButtonLink = new PrimaryButtonLink();
    }

    public PrimaryButtonLinkBuilder type(String type) {
        primaryButtonLink.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public PrimaryButtonLink build() {
        return primaryButtonLink;
    }
}