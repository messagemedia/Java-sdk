package com.messagemedia.api.models;

import java.util.*;

public class SentMessageBuilder {
    //the instance to build
    private SentMessage sentMessage;

    /**
     * Default constructor to initialize the instance
     */
    public SentMessageBuilder() {
        sentMessage = new SentMessage();
    }

    /**
     * Account associated with this message
     */
    public SentMessageBuilder account(String account) {
        sentMessage.setAccount(account);
        return this;
    }

    /**
     * Content of the message
     */
    public SentMessageBuilder content(String content) {
        sentMessage.setContent(content);
        return this;
    }

    /**
     * If a delivery report was requested for this message, this is the time at which the message was delivered (or failed to be delivered) to the destination address.
     */
    public SentMessageBuilder deliveredTimestamp(String deliveredTimestamp) {
        sentMessage.setDeliveredTimestamp(deliveredTimestamp);
        return this;
    }

    /**
     * Indicates if a delivery report was requested for this message
     */
    public SentMessageBuilder deliveryReport(Boolean deliveryReport) {
        sentMessage.setDeliveryReport(deliveryReport);
        return this;
    }

    /**
     * Address this message was delivered to
     */
    public SentMessageBuilder destinationAddress(String destinationAddress) {
        sentMessage.setDestinationAddress(destinationAddress);
        return this;
    }

    /**
     * Country associated with the destination address
     */
    public SentMessageBuilder destinationAddressCountry(String destinationAddressCountry) {
        sentMessage.setDestinationAddressCountry(destinationAddressCountry);
        return this;
    }

    /**
     * Format of message, SMS or TTS (Text To Speech)
     */
    public SentMessageBuilder format(Format1Enum format) {
        sentMessage.setFormat(format);
        return this;
    }

    /**
     * Unique ID for this message
     */
    public SentMessageBuilder id(String id) {
        sentMessage.setId(id);
        return this;
    }

    /**
     * If this message was sent in response to a received message (an auto response message for example) this is the ID of the received message.
     */
    public SentMessageBuilder inResponseTo(String inResponseTo) {
        sentMessage.setInResponseTo(inResponseTo);
        return this;
    }

    /**
     * Metadata associated with this message
     */
    public SentMessageBuilder metadata(Object metadata) {
        sentMessage.setMetadata(metadata);
        return this;
    }

    /**
     * Address this message was sent from
     */
    public SentMessageBuilder sourceAddress(String sourceAddress) {
        sentMessage.setSourceAddress(sourceAddress);
        return this;
    }

    /**
     * Country associated with the source address
     */
    public SentMessageBuilder sourceAddressCountry(String sourceAddressCountry) {
        sentMessage.setSourceAddressCountry(sourceAddressCountry);
        return this;
    }

    /**
     * The total number of calculated SMS units this message cost. 1 SMS unit is defined as 160 GSM characters, or 153 GSM characters for multi-part messages as some characters are used to concatenate the message on the receiving handset.
     * Messages with one or more non-GSM characters will be submitted using UCS-2 encoding. UCS-2 encoding means the message has a maximum of 70 characters per SMS, or 67 characters for multi-part messages.
     */
    public SentMessageBuilder units(Double units) {
        sentMessage.setUnits(units);
        return this;
    }

    /**
     * Date time at which this message was submitted to the API, refer to the delivered timestamp for the time at which the message was delivered (or failed to be delivered) to the destination address.
     */
    public SentMessageBuilder timestamp(String timestamp) {
        sentMessage.setTimestamp(timestamp);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public SentMessage build() {
        return sentMessage;
    }
}