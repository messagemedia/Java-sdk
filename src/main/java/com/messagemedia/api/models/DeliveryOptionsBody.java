package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class DeliveryOptionsBody 
        implements java.io.Serializable {
    private static final long serialVersionUID = -3122346645985953220L;
    private String deliveryType;
    private List<String> deliveryAddresses;
    private String deliveryFormat;
    /** GETTER
     * How to deliver the report.
     */
    @JsonGetter("delivery_type")
    public String getDeliveryType ( ) { 
        return this.deliveryType;
    }
    
    /** SETTER
     * How to deliver the report.
     */
    @JsonSetter("delivery_type")
    public void setDeliveryType (String value) { 
        this.deliveryType = value;
    }
 
    /** GETTER
     * A list of email addresses to use as the recipient of the email. Only works for EMAIL delivery type
     */
    @JsonGetter("delivery_addresses")
    public List<String> getDeliveryAddresses ( ) { 
        return this.deliveryAddresses;
    }
    
    /** SETTER
     * A list of email addresses to use as the recipient of the email. Only works for EMAIL delivery type
     */
    @JsonSetter("delivery_addresses")
    public void setDeliveryAddresses (List<String> value) { 
        this.deliveryAddresses = value;
    }
 
    /** GETTER
     * Format of the report.
     */
    @JsonGetter("delivery_format")
    public String getDeliveryFormat ( ) { 
        return this.deliveryFormat;
    }
    
    /** SETTER
     * Format of the report.
     */
    @JsonSetter("delivery_format")
    public void setDeliveryFormat (String value) { 
        this.deliveryFormat = value;
    }
 
}
