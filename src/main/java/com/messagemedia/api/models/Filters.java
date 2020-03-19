package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Filters 
        implements java.io.Serializable {
    private static final long serialVersionUID = -4162312228221410708L;
    private String deliveryReport;
    private String destinationAddressCountry;
    private String destinationAddress;
    private String messageFormat;
    private String metadataKey;
    private String metadataValue;
    private String sourceAddressCountry;
    private String sourceAddress;
    private String statusCode;
    private String status;
    private String action;
    private List<String> accounts;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("delivery_report")
    public String getDeliveryReport ( ) { 
        return this.deliveryReport;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("delivery_report")
    public void setDeliveryReport (String value) { 
        this.deliveryReport = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("destination_address_country")
    public String getDestinationAddressCountry ( ) { 
        return this.destinationAddressCountry;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("destination_address_country")
    public void setDestinationAddressCountry (String value) { 
        this.destinationAddressCountry = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("destination_address")
    public String getDestinationAddress ( ) { 
        return this.destinationAddress;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("destination_address")
    public void setDestinationAddress (String value) { 
        this.destinationAddress = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("message_format")
    public String getMessageFormat ( ) { 
        return this.messageFormat;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("message_format")
    public void setMessageFormat (String value) { 
        this.messageFormat = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("metadata_key")
    public String getMetadataKey ( ) { 
        return this.metadataKey;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("metadata_key")
    public void setMetadataKey (String value) { 
        this.metadataKey = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("metadata_value")
    public String getMetadataValue ( ) { 
        return this.metadataValue;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("metadata_value")
    public void setMetadataValue (String value) { 
        this.metadataValue = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("source_address_country")
    public String getSourceAddressCountry ( ) { 
        return this.sourceAddressCountry;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("source_address_country")
    public void setSourceAddressCountry (String value) { 
        this.sourceAddressCountry = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("source_address")
    public String getSourceAddress ( ) { 
        return this.sourceAddress;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("source_address")
    public void setSourceAddress (String value) { 
        this.sourceAddress = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("status_code")
    public String getStatusCode ( ) { 
        return this.statusCode;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("status_code")
    public void setStatusCode (String value) { 
        this.statusCode = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("status")
    public String getStatus ( ) { 
        return this.status;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("status")
    public void setStatus (String value) { 
        this.status = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("action")
    public String getAction ( ) { 
        return this.action;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("action")
    public void setAction (String value) { 
        this.action = value;
    }
 
    /** GETTER
     * List of accounts that were used to generate this report
     */
    @JsonGetter("accounts")
    public List<String> getAccounts ( ) { 
        return this.accounts;
    }
    
    /** SETTER
     * List of accounts that were used to generate this report
     */
    @JsonSetter("accounts")
    public void setAccounts (List<String> value) { 
        this.accounts = value;
    }
 
}
