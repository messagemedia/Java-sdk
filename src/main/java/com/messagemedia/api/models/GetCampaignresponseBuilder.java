package com.messagemedia.api.models;

import java.util.*;

public class GetCampaignresponseBuilder {
    //the instance to build
    private GetCampaignresponse getCampaignresponse;

    /**
     * Default constructor to initialize the instance
     */
    public GetCampaignresponseBuilder() {
        getCampaignresponse = new GetCampaignresponse();
    }

    public GetCampaignresponseBuilder id(String id) {
        getCampaignresponse.setId(id);
        return this;
    }

    public GetCampaignresponseBuilder templateId(String templateId) {
        getCampaignresponse.setTemplateId(templateId);
        return this;
    }

    public GetCampaignresponseBuilder parameters(Parameters parameters) {
        getCampaignresponse.setParameters(parameters);
        return this;
    }

    public GetCampaignresponseBuilder message(Message message) {
        getCampaignresponse.setMessage(message);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public GetCampaignresponse build() {
        return getCampaignresponse;
    }
}