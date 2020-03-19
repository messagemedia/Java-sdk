package com.messagemedia.api.models;

import java.util.*;

public class FiltersBuilder {
    //the instance to build
    private Filters filters;

    /**
     * Default constructor to initialize the instance
     */
    public FiltersBuilder() {
        filters = new Filters();
    }

    public FiltersBuilder deliveryReport(String deliveryReport) {
        filters.setDeliveryReport(deliveryReport);
        return this;
    }

    public FiltersBuilder destinationAddressCountry(String destinationAddressCountry) {
        filters.setDestinationAddressCountry(destinationAddressCountry);
        return this;
    }

    public FiltersBuilder destinationAddress(String destinationAddress) {
        filters.setDestinationAddress(destinationAddress);
        return this;
    }

    public FiltersBuilder messageFormat(String messageFormat) {
        filters.setMessageFormat(messageFormat);
        return this;
    }

    public FiltersBuilder metadataKey(String metadataKey) {
        filters.setMetadataKey(metadataKey);
        return this;
    }

    public FiltersBuilder metadataValue(String metadataValue) {
        filters.setMetadataValue(metadataValue);
        return this;
    }

    public FiltersBuilder sourceAddressCountry(String sourceAddressCountry) {
        filters.setSourceAddressCountry(sourceAddressCountry);
        return this;
    }

    public FiltersBuilder sourceAddress(String sourceAddress) {
        filters.setSourceAddress(sourceAddress);
        return this;
    }

    public FiltersBuilder statusCode(String statusCode) {
        filters.setStatusCode(statusCode);
        return this;
    }

    public FiltersBuilder status(String status) {
        filters.setStatus(status);
        return this;
    }

    public FiltersBuilder action(String action) {
        filters.setAction(action);
        return this;
    }

    /**
     * List of accounts that were used to generate this report
     */
    public FiltersBuilder accounts(List<String> accounts) {
        filters.setAccounts(accounts);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Filters build() {
        return filters;
    }
}