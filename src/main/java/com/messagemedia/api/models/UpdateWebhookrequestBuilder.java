package com.messagemedia.api.models;

import java.util.*;

public class UpdateWebhookrequestBuilder {
    //the instance to build
    private UpdateWebhookrequest updateWebhookrequest;

    /**
     * Default constructor to initialize the instance
     */
    public UpdateWebhookrequestBuilder() {
        updateWebhookrequest = new UpdateWebhookrequest();
    }

    public UpdateWebhookrequestBuilder url(String url) {
        updateWebhookrequest.setUrl(url);
        return this;
    }

    public UpdateWebhookrequestBuilder method(String method) {
        updateWebhookrequest.setMethod(method);
        return this;
    }

    public UpdateWebhookrequestBuilder encoding(String encoding) {
        updateWebhookrequest.setEncoding(encoding);
        return this;
    }

    public UpdateWebhookrequestBuilder events(List<String> events) {
        updateWebhookrequest.setEvents(events);
        return this;
    }

    public UpdateWebhookrequestBuilder template(String template) {
        updateWebhookrequest.setTemplate(template);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public UpdateWebhookrequest build() {
        return updateWebhookrequest;
    }
}