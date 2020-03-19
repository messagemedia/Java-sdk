package com.messagemedia.api.models;

import java.util.*;

public class ReceivedMessageBuilder {
    //the instance to build
    private ReceivedMessage receivedMessage;

    /**
     * Default constructor to initialize the instance
     */
    public ReceivedMessageBuilder() {
        receivedMessage = new ReceivedMessage();
    }

    /**
     * Account associated with this message
     */
    public ReceivedMessageBuilder account(String account) {
        receivedMessage.setAccount(account);
        return this;
    }

    /**
     * Action that was invoked for this message if any, OPT_OUT, OPT_IN, GLOBAL_OPT_OUT
     */
    public ReceivedMessageBuilder action(ActionEnum action) {
        receivedMessage.setAction(action);
        return this;
    }

    /**
     * Content of the message
     */
    public ReceivedMessageBuilder content(String content) {
        receivedMessage.setContent(content);
        return this;
    }

    /**
     * Address this message was delivered to. If this message was received in response to a sent message, this is the source address of the sent message
     */
    public ReceivedMessageBuilder destinationAddress(String destinationAddress) {
        receivedMessage.setDestinationAddress(destinationAddress);
        return this;
    }

    /**
     * Country associated with the destination address
     */
    public ReceivedMessageBuilder destinationAddressCountry(String destinationAddressCountry) {
        receivedMessage.setDestinationAddressCountry(destinationAddressCountry);
        return this;
    }

    /**
     * Format of message, SMS or TTS (Text To Speech)
     */
    public ReceivedMessageBuilder format(Format1Enum format) {
        receivedMessage.setFormat(format);
        return this;
    }

    /**
     * Unique ID for this reply
     */
    public ReceivedMessageBuilder id(String id) {
        receivedMessage.setId(id);
        return this;
    }

    /**
     * If this message was received in response to a sent message, this is the ID of the sent message
     */
    public ReceivedMessageBuilder inResponseTo(String inResponseTo) {
        receivedMessage.setInResponseTo(inResponseTo);
        return this;
    }

    /**
     * If this message was received in response to a sent message, this is the metadata associated with the sent message
     */
    public ReceivedMessageBuilder metadata(Object metadata) {
        receivedMessage.setMetadata(metadata);
        return this;
    }

    /**
     * Address this message was received from. If this message was received in response to a sent message, this is the destination address of the sent message.
     */
    public ReceivedMessageBuilder sourceAddress(String sourceAddress) {
        receivedMessage.setSourceAddress(sourceAddress);
        return this;
    }

    /**
     * Country associated with the source address
     */
    public ReceivedMessageBuilder sourceAddressCountry(String sourceAddressCountry) {
        receivedMessage.setSourceAddressCountry(sourceAddressCountry);
        return this;
    }

    /**
     * Date time at which this message was received
     */
    public ReceivedMessageBuilder timestamp(String timestamp) {
        receivedMessage.setTimestamp(timestamp);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public ReceivedMessage build() {
        return receivedMessage;
    }
}