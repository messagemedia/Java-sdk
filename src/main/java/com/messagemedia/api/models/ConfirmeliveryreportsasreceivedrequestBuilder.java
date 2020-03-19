package com.messagemedia.api.models;

import java.util.*;

public class ConfirmeliveryreportsasreceivedrequestBuilder {
    //the instance to build
    private Confirmeliveryreportsasreceivedrequest confirmeliveryreportsasreceivedrequest;

    /**
     * Default constructor to initialize the instance
     */
    public ConfirmeliveryreportsasreceivedrequestBuilder() {
        confirmeliveryreportsasreceivedrequest = new Confirmeliveryreportsasreceivedrequest();
    }

    /**
     * Array of unique IDs for the delivery report that this notification represents
     */
    public ConfirmeliveryreportsasreceivedrequestBuilder deliveryReportIds(List<UUID> deliveryReportIds) {
        confirmeliveryreportsasreceivedrequest.setDeliveryReportIds(deliveryReportIds);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Confirmeliveryreportsasreceivedrequest build() {
        return confirmeliveryreportsasreceivedrequest;
    }
}