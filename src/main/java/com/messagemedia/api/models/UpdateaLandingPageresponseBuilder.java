package com.messagemedia.api.models;

import java.util.*;

public class UpdateaLandingPageresponseBuilder {
    //the instance to build
    private UpdateaLandingPageresponse updateaLandingPageresponse;

    /**
     * Default constructor to initialize the instance
     */
    public UpdateaLandingPageresponseBuilder() {
        updateaLandingPageresponse = new UpdateaLandingPageresponse();
    }

    public UpdateaLandingPageresponseBuilder id(String id) {
        updateaLandingPageresponse.setId(id);
        return this;
    }

    public UpdateaLandingPageresponseBuilder name(String name) {
        updateaLandingPageresponse.setName(name);
        return this;
    }

    public UpdateaLandingPageresponseBuilder templateId(String templateId) {
        updateaLandingPageresponse.setTemplateId(templateId);
        return this;
    }

    public UpdateaLandingPageresponseBuilder parameters(Parameters4 parameters) {
        updateaLandingPageresponse.setParameters(parameters);
        return this;
    }

    public UpdateaLandingPageresponseBuilder fields(Fields fields) {
        updateaLandingPageresponse.setFields(fields);
        return this;
    }

    public UpdateaLandingPageresponseBuilder createdTimestamp(String createdTimestamp) {
        updateaLandingPageresponse.setCreatedTimestamp(createdTimestamp);
        return this;
    }

    public UpdateaLandingPageresponseBuilder modifiedTimestamp(String modifiedTimestamp) {
        updateaLandingPageresponse.setModifiedTimestamp(modifiedTimestamp);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public UpdateaLandingPageresponse build() {
        return updateaLandingPageresponse;
    }
}