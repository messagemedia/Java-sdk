package com.messagemedia.api.models;

import java.util.*;

public class AsyncreceivedmessagessummaryrequestBuilder {
    //the instance to build
    private Asyncreceivedmessagessummaryrequest asyncreceivedmessagessummaryrequest;

    /**
     * Default constructor to initialize the instance
     */
    public AsyncreceivedmessagessummaryrequestBuilder() {
        asyncreceivedmessagessummaryrequest = new Asyncreceivedmessagessummaryrequest();
    }

    /**
     * End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     */
    public AsyncreceivedmessagessummaryrequestBuilder endDate(String endDate) {
        asyncreceivedmessagessummaryrequest.setEndDate(endDate);
        return this;
    }

    /**
     * Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     */
    public AsyncreceivedmessagessummaryrequestBuilder startDate(String startDate) {
        asyncreceivedmessagessummaryrequest.setStartDate(startDate);
        return this;
    }

    /**
     * Function to apply when summarising results
     */
    public AsyncreceivedmessagessummaryrequestBuilder summaryBy(SummaryByEnum summaryBy) {
        asyncreceivedmessagessummaryrequest.setSummaryBy(summaryBy);
        return this;
    }

    /**
     * The value of the summary_field parameter provided for this report
     */
    public AsyncreceivedmessagessummaryrequestBuilder summaryField(SummaryFieldEnum summaryField) {
        asyncreceivedmessagessummaryrequest.setSummaryField(summaryField);
        return this;
    }

    /**
     * List of fields to group results set by
     */
    public AsyncreceivedmessagessummaryrequestBuilder groupBy(List<GroupByEnum> groupBy) {
        asyncreceivedmessagessummaryrequest.setGroupBy(groupBy);
        return this;
    }

    /**
     * Automatically set a date range based on the period value. Can't be combined with start_date and end_date.
     */
    public AsyncreceivedmessagessummaryrequestBuilder period(PeriodEnum period) {
        asyncreceivedmessagessummaryrequest.setPeriod(period);
        return this;
    }

    /**
     * The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'.
     */
    public AsyncreceivedmessagessummaryrequestBuilder timezone(String timezone) {
        asyncreceivedmessagessummaryrequest.setTimezone(timezone);
        return this;
    }

    /**
     * Filter results by a specific account. By default results
     * will be returned for the account associated with the authentication
     * credentials and all sub accounts.
     */
    public AsyncreceivedmessagessummaryrequestBuilder accounts(List<String> accounts) {
        asyncreceivedmessagessummaryrequest.setAccounts(accounts);
        return this;
    }

    /**
     * Filter results by destination address country.
     */
    public AsyncreceivedmessagessummaryrequestBuilder destinationAddressCountry(String destinationAddressCountry) {
        asyncreceivedmessagessummaryrequest.setDestinationAddressCountry(destinationAddressCountry);
        return this;
    }

    /**
     * Filter results by destination address.
     */
    public AsyncreceivedmessagessummaryrequestBuilder destinationAddress(String destinationAddress) {
        asyncreceivedmessagessummaryrequest.setDestinationAddress(destinationAddress);
        return this;
    }

    /**
     * Format of message, SMS or TTS (Text To Speech)
     */
    public AsyncreceivedmessagessummaryrequestBuilder messageFormat(Format1Enum messageFormat) {
        asyncreceivedmessagessummaryrequest.setMessageFormat(messageFormat);
        return this;
    }

    /**
     * Filter results for messages that include a metadata key.
     */
    public AsyncreceivedmessagessummaryrequestBuilder metadataKey(String metadataKey) {
        asyncreceivedmessagessummaryrequest.setMetadataKey(metadataKey);
        return this;
    }

    /**
     * Filter results for messages that include a metadata key containing this value. If this parameter is provided, the metadata_key parameter must also be provided.
     */
    public AsyncreceivedmessagessummaryrequestBuilder metadataValue(String metadataValue) {
        asyncreceivedmessagessummaryrequest.setMetadataValue(metadataValue);
        return this;
    }

    /**
     * Filter results by source address country.
     */
    public AsyncreceivedmessagessummaryrequestBuilder sourceAddressCountry(String sourceAddressCountry) {
        asyncreceivedmessagessummaryrequest.setSourceAddressCountry(sourceAddressCountry);
        return this;
    }

    /**
     * Filter results by source address.
     */
    public AsyncreceivedmessagessummaryrequestBuilder sourceAddress(String sourceAddress) {
        asyncreceivedmessagessummaryrequest.setSourceAddress(sourceAddress);
        return this;
    }

    /**
     * Action that was invoked for this message if any, OPT_OUT, OPT_IN, GLOBAL_OPT_OUT
     */
    public AsyncreceivedmessagessummaryrequestBuilder action(ActionEnum action) {
        asyncreceivedmessagessummaryrequest.setAction(action);
        return this;
    }

    /**
     * Delivery options for this asynchronous report.
     */
    public AsyncreceivedmessagessummaryrequestBuilder deliveryOptions(List<DeliveryOptionsBody> deliveryOptions) {
        asyncreceivedmessagessummaryrequest.setDeliveryOptions(deliveryOptions);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Asyncreceivedmessagessummaryrequest build() {
        return asyncreceivedmessagessummaryrequest;
    }
}