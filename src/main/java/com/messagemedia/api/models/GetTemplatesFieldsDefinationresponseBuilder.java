package com.messagemedia.api.models;

import java.util.*;

public class GetTemplatesFieldsDefinationresponseBuilder {
    //the instance to build
    private GetTemplatesFieldsDefinationresponse getTemplatesFieldsDefinationresponse;

    /**
     * Default constructor to initialize the instance
     */
    public GetTemplatesFieldsDefinationresponseBuilder() {
        getTemplatesFieldsDefinationresponse = new GetTemplatesFieldsDefinationresponse();
    }

    public GetTemplatesFieldsDefinationresponseBuilder fields(Fields2 fields) {
        getTemplatesFieldsDefinationresponse.setFields(fields);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public GetTemplatesFieldsDefinationresponse build() {
        return getTemplatesFieldsDefinationresponse;
    }
}