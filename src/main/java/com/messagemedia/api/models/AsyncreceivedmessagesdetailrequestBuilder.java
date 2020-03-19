package com.messagemedia.api.models;

import java.util.*;

public class AsyncreceivedmessagesdetailrequestBuilder {
    //the instance to build
    private Asyncreceivedmessagesdetailrequest asyncreceivedmessagesdetailrequest;

    /**
     * Default constructor to initialize the instance
     */
    public AsyncreceivedmessagesdetailrequestBuilder() {
        asyncreceivedmessagesdetailrequest = new Asyncreceivedmessagesdetailrequest();
    }

    /**
     * End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     */
    public AsyncreceivedmessagesdetailrequestBuilder endDate(String endDate) {
        asyncreceivedmessagesdetailrequest.setEndDate(endDate);
        return this;
    }

    /**
     * Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     */
    public AsyncreceivedmessagesdetailrequestBuilder startDate(String startDate) {
        asyncreceivedmessagesdetailrequest.setStartDate(startDate);
        return this;
    }

    /**
     * Automatically set a date range based on the period value. Can't be combined with start_date and end_date.
     */
    public AsyncreceivedmessagesdetailrequestBuilder period(PeriodEnum period) {
        asyncreceivedmessagesdetailrequest.setPeriod(period);
        return this;
    }

    /**
     * Field to sort results set by
     */
    public AsyncreceivedmessagesdetailrequestBuilder sortBy(SortByEnum sortBy) {
        asyncreceivedmessagesdetailrequest.setSortBy(sortBy);
        return this;
    }

    /**
     * Order to sort results by.
     */
    public AsyncreceivedmessagesdetailrequestBuilder sortDirection(SortDirectionEnum sortDirection) {
        asyncreceivedmessagesdetailrequest.setSortDirection(sortDirection);
        return this;
    }

    /**
     * The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'.
     */
    public AsyncreceivedmessagesdetailrequestBuilder timezone(String timezone) {
        asyncreceivedmessagesdetailrequest.setTimezone(timezone);
        return this;
    }

    /**
     * Filter results by a specific account. By default results
     * will be returned for the account associated with the authentication
     * credentials and all sub accounts.
     */
    public AsyncreceivedmessagesdetailrequestBuilder accounts(List<String> accounts) {
        asyncreceivedmessagesdetailrequest.setAccounts(accounts);
        return this;
    }

    /**
     * Filter results by destination address country.
     */
    public AsyncreceivedmessagesdetailrequestBuilder destinationAddressCountry(String destinationAddressCountry) {
        asyncreceivedmessagesdetailrequest.setDestinationAddressCountry(destinationAddressCountry);
        return this;
    }

    /**
     * Filter results by destination address.
     */
    public AsyncreceivedmessagesdetailrequestBuilder destinationAddress(String destinationAddress) {
        asyncreceivedmessagesdetailrequest.setDestinationAddress(destinationAddress);
        return this;
    }

    /**
     * Format of message, SMS or TTS (Text To Speech)
     */
    public AsyncreceivedmessagesdetailrequestBuilder messageFormat(Format1Enum messageFormat) {
        asyncreceivedmessagesdetailrequest.setMessageFormat(messageFormat);
        return this;
    }

    /**
     * Filter results for messages that include a metadata key.
     */
    public AsyncreceivedmessagesdetailrequestBuilder metadataKey(String metadataKey) {
        asyncreceivedmessagesdetailrequest.setMetadataKey(metadataKey);
        return this;
    }

    /**
     * Filter results for messages that include a metadata key containing this value. If this parameter is provided, the metadata_key parameter must also be provided.
     */
    public AsyncreceivedmessagesdetailrequestBuilder metadataValue(String metadataValue) {
        asyncreceivedmessagesdetailrequest.setMetadataValue(metadataValue);
        return this;
    }

    /**
     * Filter results by source address country.
     */
    public AsyncreceivedmessagesdetailrequestBuilder sourceAddressCountry(String sourceAddressCountry) {
        asyncreceivedmessagesdetailrequest.setSourceAddressCountry(sourceAddressCountry);
        return this;
    }

    /**
     * Filter results by source address.
     */
    public AsyncreceivedmessagesdetailrequestBuilder sourceAddress(String sourceAddress) {
        asyncreceivedmessagesdetailrequest.setSourceAddress(sourceAddress);
        return this;
    }

    /**
     * Action that was invoked for this message if any, OPT_OUT, OPT_IN, GLOBAL_OPT_OUT
     */
    public AsyncreceivedmessagesdetailrequestBuilder action(ActionEnum action) {
        asyncreceivedmessagesdetailrequest.setAction(action);
        return this;
    }

    /**
     * Delivery options for this asynchronous report.
     */
    public AsyncreceivedmessagesdetailrequestBuilder deliveryOptions(List<DeliveryOptionsBody> deliveryOptions) {
        asyncreceivedmessagesdetailrequest.setDeliveryOptions(deliveryOptions);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Asyncreceivedmessagesdetailrequest build() {
        return asyncreceivedmessagesdetailrequest;
    }
}