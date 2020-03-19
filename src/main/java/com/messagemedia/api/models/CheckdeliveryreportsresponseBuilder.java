package com.messagemedia.api.models;

import java.util.*;

public class CheckdeliveryreportsresponseBuilder {
    //the instance to build
    private Checkdeliveryreportsresponse checkdeliveryreportsresponse;

    /**
     * Default constructor to initialize the instance
     */
    public CheckdeliveryreportsresponseBuilder() {
        checkdeliveryreportsresponse = new Checkdeliveryreportsresponse();
    }

    /**
     * The oldest 100 unconfirmed delivery reports
     */
    public CheckdeliveryreportsresponseBuilder deliveryReports(List<DeliveryReport> deliveryReports) {
        checkdeliveryreportsresponse.setDeliveryReports(deliveryReports);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Checkdeliveryreportsresponse build() {
        return checkdeliveryreportsresponse;
    }
}