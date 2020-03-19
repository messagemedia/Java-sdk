package com.messagemedia.api.models;

import java.util.*;

public class RecipientBuilder {
    //the instance to build
    private Recipient recipient;

    /**
     * Default constructor to initialize the instance
     */
    public RecipientBuilder() {
        recipient = new Recipient();
    }

    /**
     * The recipient phone number.  Must be E.164 with a leading '+'
     */
    public RecipientBuilder number(String number) {
        recipient.setNumber(number);
        return this;
    }

    /**
     * The recipient scoped template parameters
     */
    public RecipientBuilder parameters(Object parameters) {
        recipient.setParameters(parameters);
        return this;
    }

    /**
     * A message can be scheduled for delivery in the future by setting the scheduled property. The scheduled property expects a date time specified in ISO 8601 format. The scheduled time must be provided in UTC and be no more than 31 days in the future.
     */
    public RecipientBuilder scheduled(String scheduled) {
        recipient.setScheduled(scheduled);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Recipient build() {
        return recipient;
    }
}