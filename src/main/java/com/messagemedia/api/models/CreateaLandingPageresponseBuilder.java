package com.messagemedia.api.models;

import java.util.*;

public class CreateaLandingPageresponseBuilder {
    //the instance to build
    private CreateaLandingPageresponse createaLandingPageresponse;

    /**
     * Default constructor to initialize the instance
     */
    public CreateaLandingPageresponseBuilder() {
        createaLandingPageresponse = new CreateaLandingPageresponse();
    }

    public CreateaLandingPageresponseBuilder id(String id) {
        createaLandingPageresponse.setId(id);
        return this;
    }

    public CreateaLandingPageresponseBuilder name(String name) {
        createaLandingPageresponse.setName(name);
        return this;
    }

    public CreateaLandingPageresponseBuilder templateId(String templateId) {
        createaLandingPageresponse.setTemplateId(templateId);
        return this;
    }

    public CreateaLandingPageresponseBuilder parameters(Parameters parameters) {
        createaLandingPageresponse.setParameters(parameters);
        return this;
    }

    public CreateaLandingPageresponseBuilder fields(Fields fields) {
        createaLandingPageresponse.setFields(fields);
        return this;
    }

    public CreateaLandingPageresponseBuilder createdTimestamp(String createdTimestamp) {
        createaLandingPageresponse.setCreatedTimestamp(createdTimestamp);
        return this;
    }

    public CreateaLandingPageresponseBuilder modifiedTimestamp(String modifiedTimestamp) {
        createaLandingPageresponse.setModifiedTimestamp(modifiedTimestamp);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public CreateaLandingPageresponse build() {
        return createaLandingPageresponse;
    }
}