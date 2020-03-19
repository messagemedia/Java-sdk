package com.messagemedia.api.models;

import java.util.*;

public class FieldsBuilder {
    //the instance to build
    private Fields fields;

    /**
     * Default constructor to initialize the instance
     */
    public FieldsBuilder() {
        fields = new Fields();
    }

    public FieldsBuilder title(Title title) {
        fields.setTitle(title);
        return this;
    }

    public FieldsBuilder bodyText(BodyText bodyText) {
        fields.setBodyText(bodyText);
        return this;
    }

    public FieldsBuilder ctaUrl(CtaUrl ctaUrl) {
        fields.setCtaUrl(ctaUrl);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Fields build() {
        return fields;
    }
}