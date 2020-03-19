package com.messagemedia.api.models;

import java.util.*;
import org.joda.time.DateTime;

public class GetmessagestatusresponseBuilder {
    //the instance to build
    private Getmessagestatusresponse getmessagestatusresponse;

    /**
     * Default constructor to initialize the instance
     */
    public GetmessagestatusresponseBuilder() {
        getmessagestatusresponse = new Getmessagestatusresponse();
    }

    /**
     * URL replies and delivery reports to this message will be pushed to
     */
    public GetmessagestatusresponseBuilder callbackUrl(String callbackUrl) {
        getmessagestatusresponse.setCallbackUrl(callbackUrl);
        return this;
    }

    /**
     * Content of the message
     */
    public GetmessagestatusresponseBuilder content(String content) {
        getmessagestatusresponse.setContent(content);
        return this;
    }

    /**
     * Destination number of the message
     */
    public GetmessagestatusresponseBuilder destinationNumber(String destinationNumber) {
        getmessagestatusresponse.setDestinationNumber(destinationNumber);
        return this;
    }

    /**
     * Request a delivery report for this message
     */
    public GetmessagestatusresponseBuilder deliveryReport(Boolean deliveryReport) {
        getmessagestatusresponse.setDeliveryReport(deliveryReport);
        return this;
    }

    /**
     * Format of message, SMS or TTS (Text To Speech).
     */
    public GetmessagestatusresponseBuilder format(FormatEnum format) {
        getmessagestatusresponse.setFormat(format);
        return this;
    }

    /**
     * Date time after which the message expires and will not be sent
     */
    public GetmessagestatusresponseBuilder messageExpiryTimestamp(DateTime messageExpiryTimestamp) {
        getmessagestatusresponse.setMessageExpiryTimestamp(messageExpiryTimestamp);
        return this;
    }

    /**
     * Metadata for the message specified as a set of key value pairs, each key can be up to 100 characters long and each value can be up to 256 characters long
     * ```
     * {
     *    "myKey": "myValue",
     *    "anotherKey": "anotherValue"
     * }
     * ```
     */
    public GetmessagestatusresponseBuilder metadata(Object metadata) {
        getmessagestatusresponse.setMetadata(metadata);
        return this;
    }

    /**
     * Scheduled delivery date time of the message
     */
    public GetmessagestatusresponseBuilder scheduled(DateTime scheduled) {
        getmessagestatusresponse.setScheduled(scheduled);
        return this;
    }

    public GetmessagestatusresponseBuilder sourceNumber(String sourceNumber) {
        getmessagestatusresponse.setSourceNumber(sourceNumber);
        return this;
    }

    /**
     * Type of source address specified, this can be INTERNATIONAL, ALPHANUMERIC or SHORTCODE
     */
    public GetmessagestatusresponseBuilder sourceNumberType(SourceNumberTypeEnum sourceNumberType) {
        getmessagestatusresponse.setSourceNumberType(sourceNumberType);
        return this;
    }

    /**
     * Unique ID of this message
     */
    public GetmessagestatusresponseBuilder messageId(UUID messageId) {
        getmessagestatusresponse.setMessageId(messageId);
        return this;
    }

    /**
     * The status of the message
     */
    public GetmessagestatusresponseBuilder status(StatusEnum status) {
        getmessagestatusresponse.setStatus(status);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Getmessagestatusresponse build() {
        return getmessagestatusresponse;
    }
}