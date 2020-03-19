package com.messagemedia.api.models;

import java.util.*;

public class Properties33Builder {
    //the instance to build
    private Properties33 properties33;

    /**
     * Default constructor to initialize the instance
     */
    public Properties33Builder() {
        properties33 = new Properties33();
    }

    /**
     * End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     */
    public Properties33Builder endDate(String endDate) {
        properties33.setEndDate(endDate);
        return this;
    }

    /**
     * Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     */
    public Properties33Builder startDate(String startDate) {
        properties33.setStartDate(startDate);
        return this;
    }

    /**
     * Any filters provided as parameters for this report
     */
    public Properties33Builder filters(Object filters) {
        properties33.setFilters(filters);
        return this;
    }

    /**
     * The value of the group by parameter provided for this report
     */
    public Properties33Builder grouping(GroupingEnum grouping) {
        properties33.setGrouping(grouping);
        return this;
    }

    /**
     * The value of the summary_by parameter provided for this report
     */
    public Properties33Builder summary(SummaryEnum summary) {
        properties33.setSummary(summary);
        return this;
    }

    /**
     * The value of the summary_field parameter provided for this report
     */
    public Properties33Builder summaryField(SummaryFieldEnum summaryField) {
        properties33.setSummaryField(summaryField);
        return this;
    }

    public Properties33Builder timezone(String timezone) {
        properties33.setTimezone(timezone);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Properties33 build() {
        return properties33;
    }
}