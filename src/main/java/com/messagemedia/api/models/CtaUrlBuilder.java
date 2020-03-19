package com.messagemedia.api.models;

import java.util.*;

public class CtaUrlBuilder {
    //the instance to build
    private CtaUrl ctaUrl;

    /**
     * Default constructor to initialize the instance
     */
    public CtaUrlBuilder() {
        ctaUrl = new CtaUrl();
    }

    public CtaUrlBuilder type(String type) {
        ctaUrl.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public CtaUrl build() {
        return ctaUrl;
    }
}