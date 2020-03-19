package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class ReceivedMessage 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5956494625777027045L;
    private String account;
    private ActionEnum action;
    private String content;
    private String destinationAddress;
    private String destinationAddressCountry;
    private Format1Enum format;
    private String id;
    private String inResponseTo;
    private Object metadata;
    private String sourceAddress;
    private String sourceAddressCountry;
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
     * Action that was invoked for this message if any, OPT_OUT, OPT_IN, GLOBAL_OPT_OUT
     */
    @JsonGetter("action")
    public ActionEnum getAction ( ) { 
        return this.action;
    }
    
    /** SETTER
     * Action that was invoked for this message if any, OPT_OUT, OPT_IN, GLOBAL_OPT_OUT
     */
    @JsonSetter("action")
    public void setAction (ActionEnum value) { 
        this.action = value;
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
     * Address this message was delivered to. If this message was received in response to a sent message, this is the source address of the sent message
     */
    @JsonGetter("destination_address")
    public String getDestinationAddress ( ) { 
        return this.destinationAddress;
    }
    
    /** SETTER
     * Address this message was delivered to. If this message was received in response to a sent message, this is the source address of the sent message
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
     * Unique ID for this reply
     */
    @JsonGetter("id")
    public String getId ( ) { 
        return this.id;
    }
    
    /** SETTER
     * Unique ID for this reply
     */
    @JsonSetter("id")
    public void setId (String value) { 
        this.id = value;
    }
 
    /** GETTER
     * If this message was received in response to a sent message, this is the ID of the sent message
     */
    @JsonGetter("in_response_to")
    public String getInResponseTo ( ) { 
        return this.inResponseTo;
    }
    
    /** SETTER
     * If this message was received in response to a sent message, this is the ID of the sent message
     */
    @JsonSetter("in_response_to")
    public void setInResponseTo (String value) { 
        this.inResponseTo = value;
    }
 
    /** GETTER
     * If this message was received in response to a sent message, this is the metadata associated with the sent message
     */
    @JsonGetter("metadata")
    public Object getMetadata ( ) { 
        return this.metadata;
    }
    
    /** SETTER
     * If this message was received in response to a sent message, this is the metadata associated with the sent message
     */
    @JsonSetter("metadata")
    public void setMetadata (Object value) { 
        this.metadata = value;
    }
 
    /** GETTER
     * Address this message was received from. If this message was received in response to a sent message, this is the destination address of the sent message.
     */
    @JsonGetter("source_address")
    public String getSourceAddress ( ) { 
        return this.sourceAddress;
    }
    
    /** SETTER
     * Address this message was received from. If this message was received in response to a sent message, this is the destination address of the sent message.
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
     * Date time at which this message was received
     */
    @JsonGetter("timestamp")
    public String getTimestamp ( ) { 
        return this.timestamp;
    }
    
    /** SETTER
     * Date time at which this message was received
     */
    @JsonSetter("timestamp")
    public void setTimestamp (String value) { 
        this.timestamp = value;
    }
 
}
