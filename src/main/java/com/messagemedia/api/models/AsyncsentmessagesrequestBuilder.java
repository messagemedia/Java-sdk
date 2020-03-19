package com.messagemedia.api.models;

import java.util.*;

public class AsyncsentmessagesrequestBuilder {
    //the instance to build
    private Asyncsentmessagesrequest asyncsentmessagesrequest;

    /**
     * Default constructor to initialize the instance
     */
    public AsyncsentmessagesrequestBuilder() {
        asyncsentmessagesrequest = new Asyncsentmessagesrequest();
    }

    /**
     * End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     */
    public AsyncsentmessagesrequestBuilder endDate(String endDate) {
        asyncsentmessagesrequest.setEndDate(endDate);
        return this;
    }

    /**
     * Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     */
    public AsyncsentmessagesrequestBuilder startDate(String startDate) {
        asyncsentmessagesrequest.setStartDate(startDate);
        return this;
    }

    /**
     * Function to apply when summarising results
     */
    public AsyncsentmessagesrequestBuilder summaryBy(SummaryByEnum summaryBy) {
        asyncsentmessagesrequest.setSummaryBy(summaryBy);
        return this;
    }

    /**
     * The value of the summary_field parameter provided for this report
     */
    public AsyncsentmessagesrequestBuilder summaryField(SummaryFieldEnum summaryField) {
        asyncsentmessagesrequest.setSummaryField(summaryField);
        return this;
    }

    /**
     * List of fields to group results set by
     */
    public AsyncsentmessagesrequestBuilder groupBy(List<GroupByEnum> groupBy) {
        asyncsentmessagesrequest.setGroupBy(groupBy);
        return this;
    }

    /**
     * Automatically set a date range based on the period value. Can't be combined with start_date and end_date.
     */
    public AsyncsentmessagesrequestBuilder period(PeriodEnum period) {
        asyncsentmessagesrequest.setPeriod(period);
        return this;
    }

    /**
     * The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'.
     */
    public AsyncsentmessagesrequestBuilder timezone(String timezone) {
        asyncsentmessagesrequest.setTimezone(timezone);
        return this;
    }

    /**
     * Filter results by a specific account. By default results
     * will be returned for the account associated with the authentication
     * credentials and all sub accounts.
     */
    public AsyncsentmessagesrequestBuilder accounts(List<String> accounts) {
        asyncsentmessagesrequest.setAccounts(accounts);
        return this;
    }

    /**
     * Filter results by destination address country.
     */
    public AsyncsentmessagesrequestBuilder destinationAddressCountry(String destinationAddressCountry) {
        asyncsentmessagesrequest.setDestinationAddressCountry(destinationAddressCountry);
        return this;
    }

    /**
     * Filter results by destination address.
     */
    public AsyncsentmessagesrequestBuilder destinationAddress(String destinationAddress) {
        asyncsentmessagesrequest.setDestinationAddress(destinationAddress);
        return this;
    }

    /**
     * Format of message, SMS or TTS (Text To Speech)
     */
    public AsyncsentmessagesrequestBuilder messageFormat(Format1Enum messageFormat) {
        asyncsentmessagesrequest.setMessageFormat(messageFormat);
        return this;
    }

    /**
     * Filter results for messages that include a metadata key.
     */
    public AsyncsentmessagesrequestBuilder metadataKey(String metadataKey) {
        asyncsentmessagesrequest.setMetadataKey(metadataKey);
        return this;
    }

    /**
     * Filter results for messages that include a metadata key containing this value. If this parameter is provided, the metadata_key parameter must also be provided.
     */
    public AsyncsentmessagesrequestBuilder metadataValue(String metadataValue) {
        asyncsentmessagesrequest.setMetadataValue(metadataValue);
        return this;
    }

    /**
     * Filter results by source address country.
     */
    public AsyncsentmessagesrequestBuilder sourceAddressCountry(String sourceAddressCountry) {
        asyncsentmessagesrequest.setSourceAddressCountry(sourceAddressCountry);
        return this;
    }

    /**
     * Filter results by source address.
     */
    public AsyncsentmessagesrequestBuilder sourceAddress(String sourceAddress) {
        asyncsentmessagesrequest.setSourceAddress(sourceAddress);
        return this;
    }

    /**
     * Filter results by delivery report.
     */
    public AsyncsentmessagesrequestBuilder deliveryReport(Boolean deliveryReport) {
        asyncsentmessagesrequest.setDeliveryReport(deliveryReport);
        return this;
    }

    /**
     * Filter results by message status code.
     */
    public AsyncsentmessagesrequestBuilder statusCode(String statusCode) {
        asyncsentmessagesrequest.setStatusCode(statusCode);
        return this;
    }

    /**
     * Delivery options for this asynchronous report.
     */
    public AsyncsentmessagesrequestBuilder deliveryOptions(List<DeliveryOptionsBody> deliveryOptions) {
        asyncsentmessagesrequest.setDeliveryOptions(deliveryOptions);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Asyncsentmessagesrequest build() {
        return asyncsentmessagesrequest;
    }
}