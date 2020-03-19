package com.messagemedia.api.models;

import java.util.*;

public class CampaignEventBuilder {
    //the instance to build
    private CampaignEvent campaignEvent;

    /**
     * Default constructor to initialize the instance
     */
    public CampaignEventBuilder() {
        campaignEvent = new CampaignEvent();
    }

    /**
     * The campaign ID
     */
    public CampaignEventBuilder campaignId(String campaignId) {
        campaignEvent.setCampaignId(campaignId);
        return this;
    }

    /**
     * The recipient ID to which this event corresponds to
     */
    public CampaignEventBuilder recipientId(String recipientId) {
        campaignEvent.setRecipientId(recipientId);
        return this;
    }

    /**
     * The recipient's phone number
     */
    public CampaignEventBuilder number(String number) {
        campaignEvent.setNumber(number);
        return this;
    }

    /**
     * The event type.  See [Event Types](#events-types) for a list of available events.
     */
    public CampaignEventBuilder event(String event) {
        campaignEvent.setEvent(event);
        return this;
    }

    /**
     * The source identifier.  This identifies the element that produced the event.  This may not be applicable for all events.
     */
    public CampaignEventBuilder source(String source) {
        campaignEvent.setSource(source);
        return this;
    }

    /**
     * The timestamp of the event, in ISO 8601 format.
     */
    public CampaignEventBuilder timestamp(String timestamp) {
        campaignEvent.setTimestamp(timestamp);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public CampaignEvent build() {
        return campaignEvent;
    }
}