package com.messagemedia.api.models;

import java.util.*;

public class CreateNewCampaignresponseBuilder {
    //the instance to build
    private CreateNewCampaignresponse createNewCampaignresponse;

    /**
     * Default constructor to initialize the instance
     */
    public CreateNewCampaignresponseBuilder() {
        createNewCampaignresponse = new CreateNewCampaignresponse();
    }

    public CreateNewCampaignresponseBuilder id(String id) {
        createNewCampaignresponse.setId(id);
        return this;
    }

    public CreateNewCampaignresponseBuilder templateId(String templateId) {
        createNewCampaignresponse.setTemplateId(templateId);
        return this;
    }

    public CreateNewCampaignresponseBuilder parameters(Parameters parameters) {
        createNewCampaignresponse.setParameters(parameters);
        return this;
    }

    public CreateNewCampaignresponseBuilder message(Message message) {
        createNewCampaignresponse.setMessage(message);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public CreateNewCampaignresponse build() {
        return createNewCampaignresponse;
    }
}