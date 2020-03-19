package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class SentMessage 
        implements java.io.Serializable {
    private static final long serialVersionUID = -5625669144113960541L;
    private String account;
    private String content;
    private String deliveredTimestamp;
    private Boolean deliveryReport;
    private String destinationAddress;
    private String destinationAddressCountry;
    private Format1Enum format;
    private String id;
    private String inResponseTo;
    private Object metadata;
    private String sourceAddress;
    private String sourceAddressCountry;
    private Double units;
    private String timestamp;
    /** GETTER
     * Account associated with this message
     */
    @JsonGetter("account")
    public String getAccount ( ) { 
        return this.account;
    }
    
    /** SETTER
     * Account associated with this message
     */
    @JsonSetter("account")
    public void setAccount (String value) { 
        this.account = value;
    }
 
    /** GETTER
     * Content of the message
     */
    @JsonGetter("content")
    public String getContent ( ) { 
        return this.content;
    }
    
    /** SETTER
     * Content of the message
     */
    @JsonSetter("content")
    public void setContent (String value) { 
        this.content = value;
    }
 
    /** GETTER
     * If a delivery report was requested for this message, this is the time at which the message was delivered (or failed to be delivered) to the destination address.
     */
    @JsonGetter("delivered_timestamp")
    public String getDeliveredTimestamp ( ) { 
        return this.deliveredTimestamp;
    }
    
    /** SETTER
     * If a delivery report was requested for this message, this is the time at which the message was delivered (or failed to be delivered) to the destination address.
     */
    @JsonSetter("delivered_timestamp")
    public void setDeliveredTimestamp (String value) { 
        this.deliveredTimestamp = value;
    }
 
    /** GETTER
     * Indicates if a delivery report was requested for this message
     */
    @JsonGetter("delivery_report")
    public Boolean getDeliveryReport ( ) { 
        return this.deliveryReport;
    }
    
    /** SETTER
     * Indicates if a delivery report was requested for this message
     */
    @JsonSetter("delivery_report")
    public void setDeliveryReport (Boolean value) { 
        this.deliveryReport = value;
    }
 
    /** GETTER
     * Address this message was delivered to
     */
    @JsonGetter("destination_address")
    public String getDestinationAddress ( ) { 
        return this.destinationAddress;
    }
    
    /** SETTER
     * Address this message was delivered to
     */
    @JsonSetter("destination_address")
    public void setDestinationAddress (String value) { 
        this.destinationAddress = value;
    }
 
    /** GETTER
     * Country associated with the destination address
     */
    @JsonGetter("destination_address_country")
    public String getDestinationAddressCountry ( ) { 
        return this.destinationAddressCountry;
    }
    
    /** SETTER
     * Country associated with the destination address
     */
    @JsonSetter("destination_address_country")
    public void setDestinationAddressCountry (String value) { 
        this.destinationAddressCountry = value;
    }
 
    /** GETTER
     * Format of message, SMS or TTS (Text To Speech)
     */
    @JsonGetter("format")
    public Format1Enum getFormat ( ) { 
        return this.format;
    }
    
    /** SETTER
     * Format of message, SMS or TTS (Text To Speech)
     */
    @JsonSetter("format")
    public void setFormat (Format1Enum value) { 
        this.format = value;
    }
 
    /** GETTER
     * Unique ID for this message
     */
    @JsonGetter("id")
    public String getId ( ) { 
        return this.id;
    }
    
    /** SETTER
     * Unique ID for this message
     */
    @JsonSetter("id")
    public void setId (String value) { 
        this.id = value;
    }
 
    /** GETTER
     * If this message was sent in response to a received message (an auto response message for example) this is the ID of the received message.
     */
    @JsonGetter("in_response_to")
    public String getInResponseTo ( ) { 
        return this.inResponseTo;
    }
    
    /** SETTER
     * If this message was sent in response to a received message (an auto response message for example) this is the ID of the received message.
     */
    @JsonSetter("in_response_to")
    public void setInResponseTo (String value) { 
        this.inResponseTo = value;
    }
 
    /** GETTER
     * Metadata associated with this message
     */
    @JsonGetter("metadata")
    public Object getMetadata ( ) { 
        return this.metadata;
    }
    
    /** SETTER
     * Metadata associated with this message
     */
    @JsonSetter("metadata")
    public void setMetadata (Object value) { 
        this.metadata = value;
    }
 
    /** GETTER
     * Address this message was sent from
     */
    @JsonGetter("source_address")
    public String getSourceAddress ( ) { 
        return this.sourceAddress;
    }
    
    /** SETTER
     * Address this message was sent from
     */
    @JsonSetter("source_address")
    public void setSourceAddress (String value) { 
        this.sourceAddress = value;
    }
 
    /** GETTER
     * Country associated with the source address
     */
    @JsonGetter("source_address_country")
    public String getSourceAddressCountry ( ) { 
        return this.sourceAddressCountry;
    }
    
    /** SETTER
     * Country associated with the source address
     */
    @JsonSetter("source_address_country")
    public void setSourceAddressCountry (String value) { 
        this.sourceAddressCountry = value;
    }
 
    /** GETTER
     * The total number of calculated SMS units this message cost. 1 SMS unit is defined as 160 GSM characters, or 153 GSM characters for multi-part messages as some characters are used to concatenate the message on the receiving handset.
     * Messages with one or more non-GSM characters will be submitted using UCS-2 encoding. UCS-2 encoding means the message has a maximum of 70 characters per SMS, or 67 characters for multi-part messages.
     */
    @JsonGetter("units")
    public Double getUnits ( ) { 
        return this.units;
    }
    
    /** SETTER
     * The total number of calculated SMS units this message cost. 1 SMS unit is defined as 160 GSM characters, or 153 GSM characters for multi-part messages as some characters are used to concatenate the message on the receiving handset.
     * Messages with one or more non-GSM characters will be submitted using UCS-2 encoding. UCS-2 encoding means the message has a maximum of 70 characters per SMS, or 67 characters for multi-part messages.
     */
    @JsonSetter("units")
    public void setUnits (Double value) { 
        this.units = value;
    }
 
    /** GETTER
     * Date time at which this message was submitted to the API, refer to the delivered timestamp for the time at which the message was delivered (or failed to be delivered) to the destination address.
     */
    @JsonGetter("timestamp")
    public String getTimestamp ( ) { 
        return this.timestamp;
    }
    
    /** SETTER
     * Date time at which this message was submitted to the API, refer to the delivered timestamp for the time at which the message was delivered (or failed to be delivered) to the destination address.
     */
    @JsonSetter("timestamp")
    public void setTimestamp (String value) { 
        this.timestamp = value;
    }
 
}
