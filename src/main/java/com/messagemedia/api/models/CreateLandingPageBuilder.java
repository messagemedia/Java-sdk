package com.messagemedia.api.models;

import java.util.*;

public class CreateLandingPageBuilder {
    //the instance to build
    private CreateLandingPage createLandingPage;

    /**
     * Default constructor to initialize the instance
     */
    public CreateLandingPageBuilder() {
        createLandingPage = new CreateLandingPage();
    }

    /**
     * Landing Page name. Maximum 100 characters.
     */
    public CreateLandingPageBuilder name(String name) {
        createLandingPage.setName(name);
        return this;
    }

    /**
     * Template to use for the landing page.
     */
    public CreateLandingPageBuilder templateId(String templateId) {
        createLandingPage.setTemplateId(templateId);
        return this;
    }

    /**
     * Parameters to use for the landing page and the message content.
     */
    public CreateLandingPageBuilder parameters(Object parameters) {
        createLandingPage.setParameters(parameters);
        return this;
    }

    /**
     * Define the fields that have been used to the paramters.
     */
    public CreateLandingPageBuilder fields(Object fields) {
        createLandingPage.setFields(fields);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public CreateLandingPage build() {
        return createLandingPage;
    }
}