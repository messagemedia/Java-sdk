package com.messagemedia.api.models;

import java.util.*;

public class CreateWebhookrequestBuilder {
    //the instance to build
    private CreateWebhookrequest createWebhookrequest;

    /**
     * Default constructor to initialize the instance
     */
    public CreateWebhookrequestBuilder() {
        createWebhookrequest = new CreateWebhookrequest();
    }

    public CreateWebhookrequestBuilder url(String url) {
        createWebhookrequest.setUrl(url);
        return this;
    }

    public CreateWebhookrequestBuilder method(String method) {
        createWebhookrequest.setMethod(method);
        return this;
    }

    public CreateWebhookrequestBuilder encoding(String encoding) {
        createWebhookrequest.setEncoding(encoding);
        return this;
    }

    public CreateWebhookrequestBuilder headers(Headers headers) {
        createWebhookrequest.setHeaders(headers);
        return this;
    }

    public CreateWebhookrequestBuilder events(List<String> events) {
        createWebhookrequest.setEvents(events);
        return this;
    }

    public CreateWebhookrequestBuilder template(String template) {
        createWebhookrequest.setTemplate(template);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public CreateWebhookrequest build() {
        return createWebhookrequest;
    }
}