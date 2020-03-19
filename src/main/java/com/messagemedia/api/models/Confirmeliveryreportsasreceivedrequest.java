package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Confirmeliveryreportsasreceivedrequest 
        implements java.io.Serializable {
    private static final long serialVersionUID = -130017721959720301L;
    private List<UUID> deliveryReportIds;
    /** GETTER
     * Array of unique IDs for the delivery report that this notification represents
     */
    @JsonGetter("delivery_report_ids")
    public List<UUID> getDeliveryReportIds ( ) { 
        return this.deliveryReportIds;
    }
    
    /** SETTER
     * Array of unique IDs for the delivery report that this notification represents
     */
    @JsonSetter("delivery_report_ids")
    public void setDeliveryReportIds (List<UUID> value) { 
        this.deliveryReportIds = value;
    }
 
}
