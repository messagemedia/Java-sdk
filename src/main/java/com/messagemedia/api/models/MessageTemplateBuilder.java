package com.messagemedia.api.models;

import java.util.*;

public class MessageTemplateBuilder {
    //the instance to build
    private MessageTemplate messageTemplate;

    /**
     * Default constructor to initialize the instance
     */
    public MessageTemplateBuilder() {
        messageTemplate = new MessageTemplate();
    }

    /**
     * The message content.  This supports template placeholders.
     */
    public MessageTemplateBuilder content(String content) {
        messageTemplate.setContent(content);
        return this;
    }

    /**
     * Message metadata.  This will be supplied to URL shortener and UG.  Max 10 keys per campaign.
     */
    public MessageTemplateBuilder metadata(Object metadata) {
        messageTemplate.setMetadata(metadata);
        return this;
    }

    public MessageTemplateBuilder richLink(RichLink richLink) {
        messageTemplate.setRichLink(richLink);
        return this;
    }

    /**
     * Request a delivery report for the sent message
     */
    public MessageTemplateBuilder deliveryReport(Boolean deliveryReport) {
        messageTemplate.setDeliveryReport(deliveryReport);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public MessageTemplate build() {
        return messageTemplate;
    }
}