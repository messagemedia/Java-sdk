package com.messagemedia.api.models;

import java.util.*;

public class AsyncsentmessagesdetailrequestBuilder {
    //the instance to build
    private Asyncsentmessagesdetailrequest asyncsentmessagesdetailrequest;

    /**
     * Default constructor to initialize the instance
     */
    public AsyncsentmessagesdetailrequestBuilder() {
        asyncsentmessagesdetailrequest = new Asyncsentmessagesdetailrequest();
    }

    /**
     * End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     */
    public AsyncsentmessagesdetailrequestBuilder endDate(String endDate) {
        asyncsentmessagesdetailrequest.setEndDate(endDate);
        return this;
    }

    /**
     * Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     */
    public AsyncsentmessagesdetailrequestBuilder startDate(String startDate) {
        asyncsentmessagesdetailrequest.setStartDate(startDate);
        return this;
    }

    /**
     * Automatically set a date range based on the period value. Can't be combined with start_date and end_date.
     */
    public AsyncsentmessagesdetailrequestBuilder period(PeriodEnum period) {
        asyncsentmessagesdetailrequest.setPeriod(period);
        return this;
    }

    /**
     * Field to sort results set by
     */
    public AsyncsentmessagesdetailrequestBuilder sortBy(SortByEnum sortBy) {
        asyncsentmessagesdetailrequest.setSortBy(sortBy);
        return this;
    }

    /**
     * Order to sort results by.
     */
    public AsyncsentmessagesdetailrequestBuilder sortDirection(SortDirectionEnum sortDirection) {
        asyncsentmessagesdetailrequest.setSortDirection(sortDirection);
        return this;
    }

    /**
     * The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'.
     */
    public AsyncsentmessagesdetailrequestBuilder timezone(String timezone) {
        asyncsentmessagesdetailrequest.setTimezone(timezone);
        return this;
    }

    /**
     * Filter results by a specific account. By default results
     * will be returned for the account associated with the authentication
     * credentials and all sub accounts.
     */
    public AsyncsentmessagesdetailrequestBuilder accounts(List<String> accounts) {
        asyncsentmessagesdetailrequest.setAccounts(accounts);
        return this;
    }

    /**
     * Filter results by destination address country.
     */
    public AsyncsentmessagesdetailrequestBuilder destinationAddressCountry(String destinationAddressCountry) {
        asyncsentmessagesdetailrequest.setDestinationAddressCountry(destinationAddressCountry);
        return this;
    }

    /**
     * Filter results by destination address.
     */
    public AsyncsentmessagesdetailrequestBuilder destinationAddress(String destinationAddress) {
        asyncsentmessagesdetailrequest.setDestinationAddress(destinationAddress);
        return this;
    }

    /**
     * Format of message, SMS or TTS (Text To Speech)
     */
    public AsyncsentmessagesdetailrequestBuilder messageFormat(Format1Enum messageFormat) {
        asyncsentmessagesdetailrequest.setMessageFormat(messageFormat);
        return this;
    }

    /**
     * Filter results for messages that include a metadata key.
     */
    public AsyncsentmessagesdetailrequestBuilder metadataKey(String metadataKey) {
        asyncsentmessagesdetailrequest.setMetadataKey(metadataKey);
        return this;
    }

    /**
     * Filter results for messages that include a metadata key containing this value. If this parameter is provided, the metadata_key parameter must also be provided.
     */
    public AsyncsentmessagesdetailrequestBuilder metadataValue(String metadataValue) {
        asyncsentmessagesdetailrequest.setMetadataValue(metadataValue);
        return this;
    }

    /**
     * Filter results by source address country.
     */
    public AsyncsentmessagesdetailrequestBuilder sourceAddressCountry(String sourceAddressCountry) {
        asyncsentmessagesdetailrequest.setSourceAddressCountry(sourceAddressCountry);
        return this;
    }

    /**
     * Filter results by source address.
     */
    public AsyncsentmessagesdetailrequestBuilder sourceAddress(String sourceAddress) {
        asyncsentmessagesdetailrequest.setSourceAddress(sourceAddress);
        return this;
    }

    /**
     * Filter results by message status. Can't be combined with statuses.
     */
    public AsyncsentmessagesdetailrequestBuilder status(Status1Enum status) {
        asyncsentmessagesdetailrequest.setStatus(status);
        return this;
    }

    /**
     * Filter results by message statuses. Can't be combined with status.
     */
    public AsyncsentmessagesdetailrequestBuilder statuses(List<StatusesEnum> statuses) {
        asyncsentmessagesdetailrequest.setStatuses(statuses);
        return this;
    }

    /**
     * Filter results by message status code.
     */
    public AsyncsentmessagesdetailrequestBuilder statusCode(String statusCode) {
        asyncsentmessagesdetailrequest.setStatusCode(statusCode);
        return this;
    }

    /**
     * Filter results by delivery report.
     */
    public AsyncsentmessagesdetailrequestBuilder deliveryReport(Boolean deliveryReport) {
        asyncsentmessagesdetailrequest.setDeliveryReport(deliveryReport);
        return this;
    }

    /**
     * Delivery options for this asynchronous report.
     */
    public AsyncsentmessagesdetailrequestBuilder deliveryOptions(List<DeliveryOptionsBody> deliveryOptions) {
        asyncsentmessagesdetailrequest.setDeliveryOptions(deliveryOptions);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Asyncsentmessagesdetailrequest build() {
        return asyncsentmessagesdetailrequest;
    }
}