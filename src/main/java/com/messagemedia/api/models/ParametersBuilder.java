package com.messagemedia.api.models;

import java.util.*;

public class ParametersBuilder {
    //the instance to build
    private Parameters parameters;

    /**
     * Default constructor to initialize the instance
     */
    public ParametersBuilder() {
        parameters = new Parameters();
    }

    public ParametersBuilder title(String title) {
        parameters.setTitle(title);
        return this;
    }

    public ParametersBuilder bodyText(String bodyText) {
        parameters.setBodyText(bodyText);
        return this;
    }

    public ParametersBuilder callToAction(String callToAction) {
        parameters.setCallToAction(callToAction);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Parameters build() {
        return parameters;
    }
}