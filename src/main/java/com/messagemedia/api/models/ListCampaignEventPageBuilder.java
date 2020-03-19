package com.messagemedia.api.models;

import java.util.*;

public class ListCampaignEventPageBuilder {
    //the instance to build
    private ListCampaignEventPage listCampaignEventPage;

    /**
     * Default constructor to initialize the instance
     */
    public ListCampaignEventPageBuilder() {
        listCampaignEventPage = new ListCampaignEventPage();
    }

    /**
     * The list of campaign events.
     */
    public ListCampaignEventPageBuilder events(List<CampaignEvent> events) {
        listCampaignEventPage.setEvents(events);
        return this;
    }

    public ListCampaignEventPageBuilder pagination(Pagination1 pagination) {
        listCampaignEventPage.setPagination(pagination);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public ListCampaignEventPage build() {
        return listCampaignEventPage;
    }
}