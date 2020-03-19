package com.messagemedia.api.models;

import java.util.*;

public class EventSummaryBuilder {
    //the instance to build
    private EventSummary eventSummary;

    /**
     * Default constructor to initialize the instance
     */
    public EventSummaryBuilder() {
        eventSummary = new EventSummary();
    }

    /**
     * The event type to which this summary is for.  See [Event Types](#events-types) for a list of available events.
     */
    public EventSummaryBuilder event(String event) {
        eventSummary.setEvent(event);
        return this;
    }

    /**
     * The event source to which this summary is for, if applicable.
     */
    public EventSummaryBuilder source(String source) {
        eventSummary.setSource(source);
        return this;
    }

    /**
     * The total number of recorded events of this type and source.
     */
    public EventSummaryBuilder totalEvents(double totalEvents) {
        eventSummary.setTotalEvents(totalEvents);
        return this;
    }

    /**
     * The unique number of recipients for which there exists at least one event of this type and source recorded.
     */
    public EventSummaryBuilder uniqueRecipients(double uniqueRecipients) {
        eventSummary.setUniqueRecipients(uniqueRecipients);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public EventSummary build() {
        return eventSummary;
    }
}