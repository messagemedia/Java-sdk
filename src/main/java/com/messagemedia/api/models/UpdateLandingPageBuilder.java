package com.messagemedia.api.models;

import java.util.*;

public class UpdateLandingPageBuilder {
    //the instance to build
    private UpdateLandingPage updateLandingPage;

    /**
     * Default constructor to initialize the instance
     */
    public UpdateLandingPageBuilder() {
        updateLandingPage = new UpdateLandingPage();
    }

    /**
     * Landing Page name. Maximum 100 characters.
     */
    public UpdateLandingPageBuilder name(String name) {
        updateLandingPage.setName(name);
        return this;
    }

    /**
     * Template to use for the landing page.
     */
    public UpdateLandingPageBuilder templateId(String templateId) {
        updateLandingPage.setTemplateId(templateId);
        return this;
    }

    /**
     * Parameters to use for the landing page and the message content.
     */
    public UpdateLandingPageBuilder parameters(Object parameters) {
        updateLandingPage.setParameters(parameters);
        return this;
    }

    /**
     * Define the fields that have been used to the paramters.
     */
    public UpdateLandingPageBuilder fields(Object fields) {
        updateLandingPage.setFields(fields);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public UpdateLandingPage build() {
        return updateLandingPage;
    }
}