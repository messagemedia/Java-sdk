package com.messagemedia.api.models;

import java.util.*;

public class PropertiesBuilder {
    //the instance to build
    private Properties properties;

    /**
     * Default constructor to initialize the instance
     */
    public PropertiesBuilder() {
        properties = new Properties();
    }

    /**
     * End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     */
    public PropertiesBuilder endDate(String endDate) {
        properties.setEndDate(endDate);
        return this;
    }

    /**
     * Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     */
    public PropertiesBuilder startDate(String startDate) {
        properties.setStartDate(startDate);
        return this;
    }

    /**
     * List of accounts that were considered when fetching the metadata keys.
     */
    public PropertiesBuilder accounts(List<String> accounts) {
        properties.setAccounts(accounts);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Properties build() {
        return properties;
    }
}