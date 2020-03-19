package com.messagemedia.api.models;

import java.util.*;

public class CampaignBuilder {
    //the instance to build
    private Campaign campaign;

    /**
     * Default constructor to initialize the instance
     */
    public CampaignBuilder() {
        campaign = new Campaign();
    }

    /**
     * Template to use for the landing page
     */
    public CampaignBuilder templateId(String templateId) {
        campaign.setTemplateId(templateId);
        return this;
    }

    /**
     * Parameters to use for the landing page and the message content
     */
    public CampaignBuilder parameters(Object parameters) {
        campaign.setParameters(parameters);
        return this;
    }

    public CampaignBuilder message(MessageTemplate message) {
        campaign.setMessage(message);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Campaign build() {
        return campaign;
    }
}