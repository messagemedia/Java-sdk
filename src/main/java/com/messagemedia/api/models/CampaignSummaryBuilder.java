package com.messagemedia.api.models;

import java.util.*;

public class CampaignSummaryBuilder {
    //the instance to build
    private CampaignSummary campaignSummary;

    /**
     * Default constructor to initialize the instance
     */
    public CampaignSummaryBuilder() {
        campaignSummary = new CampaignSummary();
    }

    /**
     * The total number of events record against this campaign.
     */
    public CampaignSummaryBuilder totalEvents(double totalEvents) {
        campaignSummary.setTotalEvents(totalEvents);
        return this;
    }

    /**
     * The unique number of recipients for which there exists at least one recorded event.
     */
    public CampaignSummaryBuilder uniqueEngagements(double uniqueEngagements) {
        campaignSummary.setUniqueEngagements(uniqueEngagements);
        return this;
    }

    /**
     * The event summary breakdown.
     */
    public CampaignSummaryBuilder eventSummary(List<EventSummary> eventSummary) {
        campaignSummary.setEventSummary(eventSummary);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public CampaignSummary build() {
        return campaignSummary;
    }
}