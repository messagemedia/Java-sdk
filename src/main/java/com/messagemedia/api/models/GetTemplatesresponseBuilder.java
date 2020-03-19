package com.messagemedia.api.models;

import java.util.*;

public class GetTemplatesresponseBuilder {
    //the instance to build
    private GetTemplatesresponse getTemplatesresponse;

    /**
     * Default constructor to initialize the instance
     */
    public GetTemplatesresponseBuilder() {
        getTemplatesresponse = new GetTemplatesresponse();
    }

    public GetTemplatesresponseBuilder templates(List<Template> templates) {
        getTemplatesresponse.setTemplates(templates);
        return this;
    }

    public GetTemplatesresponseBuilder pagination(Pagination2 pagination) {
        getTemplatesresponse.setPagination(pagination);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public GetTemplatesresponse build() {
        return getTemplatesresponse;
    }
}