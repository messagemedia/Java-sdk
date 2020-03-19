package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Checkdeliveryreportsresponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = -122347476611672383L;
    private List<DeliveryReport> deliveryReports;
    /** GETTER
     * The oldest 100 unconfirmed delivery reports
     */
    @JsonGetter("delivery_reports")
    public List<DeliveryReport> getDeliveryReports ( ) { 
        return this.deliveryReports;
    }
    
    /** SETTER
     * The oldest 100 unconfirmed delivery reports
     */
    @JsonSetter("delivery_reports")
    public void setDeliveryReports (List<DeliveryReport> value) { 
        this.deliveryReports = value;
    }
 
}
