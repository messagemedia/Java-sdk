package com.messagemedia.api.models;

import java.util.*;

public class Parameters4Builder {
    //the instance to build
    private Parameters4 parameters4;

    /**
     * Default constructor to initialize the instance
     */
    public Parameters4Builder() {
        parameters4 = new Parameters4();
    }

    public Parameters4Builder pageTitle(String pageTitle) {
        parameters4.setPageTitle(pageTitle);
        return this;
    }

    public Parameters4Builder pageText(String pageText) {
        parameters4.setPageText(pageText);
        return this;
    }

    public Parameters4Builder callToAction(String callToAction) {
        parameters4.setCallToAction(callToAction);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Parameters4 build() {
        return parameters4;
    }
}