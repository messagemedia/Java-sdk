package com.messagemedia.api.models;

import java.util.*;

public class DeliveryOptionsBodyBuilder {
    //the instance to build
    private DeliveryOptionsBody deliveryOptionsBody;

    /**
     * Default constructor to initialize the instance
     */
    public DeliveryOptionsBodyBuilder() {
        deliveryOptionsBody = new DeliveryOptionsBody();
    }

    /**
     * How to deliver the report.
     */
    public DeliveryOptionsBodyBuilder deliveryType(String deliveryType) {
        deliveryOptionsBody.setDeliveryType(deliveryType);
        return this;
    }

    /**
     * A list of email addresses to use as the recipient of the email. Only works for EMAIL delivery type
     */
    public DeliveryOptionsBodyBuilder deliveryAddresses(List<String> deliveryAddresses) {
        deliveryOptionsBody.setDeliveryAddresses(deliveryAddresses);
        return this;
    }

    /**
     * Format of the report.
     */
    public DeliveryOptionsBodyBuilder deliveryFormat(String deliveryFormat) {
        deliveryOptionsBody.setDeliveryFormat(deliveryFormat);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public DeliveryOptionsBody build() {
        return deliveryOptionsBody;
    }
}