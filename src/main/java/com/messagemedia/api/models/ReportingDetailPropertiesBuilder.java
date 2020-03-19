package com.messagemedia.api.models;

import java.util.*;

public class ReportingDetailPropertiesBuilder {
    //the instance to build
    private ReportingDetailProperties reportingDetailProperties;

    /**
     * Default constructor to initialize the instance
     */
    public ReportingDetailPropertiesBuilder() {
        reportingDetailProperties = new ReportingDetailProperties();
    }

    /**
     * End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     */
    public ReportingDetailPropertiesBuilder endDate(String endDate) {
        reportingDetailProperties.setEndDate(endDate);
        return this;
    }

    /**
     * Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     */
    public ReportingDetailPropertiesBuilder startDate(String startDate) {
        reportingDetailProperties.setStartDate(startDate);
        return this;
    }

    public ReportingDetailPropertiesBuilder sorting(Sorting sorting) {
        reportingDetailProperties.setSorting(sorting);
        return this;
    }

    public ReportingDetailPropertiesBuilder filters(Filters filters) {
        reportingDetailProperties.setFilters(filters);
        return this;
    }

    public ReportingDetailPropertiesBuilder timezone(String timezone) {
        reportingDetailProperties.setTimezone(timezone);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public ReportingDetailProperties build() {
        return reportingDetailProperties;
    }
}