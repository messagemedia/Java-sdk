package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class CampaignEvent 
        implements java.io.Serializable {
    private static final long serialVersionUID = 7216473879215569886L;
    private String campaignId;
    private String recipientId;
    private String number;
    private String event;
    private String source;
    private String timestamp;
    /** GETTER
     * The campaign ID
     */
    @JsonGetter("campaign_id")
    public String getCampaignId ( ) { 
        return this.campaignId;
    }
    
    /** SETTER
     * The campaign ID
     */
    @JsonSetter("campaign_id")
    public void setCampaignId (String value) { 
        this.campaignId = value;
    }
 
    /** GETTER
     * The recipient ID to which this event corresponds to
     */
    @JsonGetter("recipient_id")
    public String getRecipientId ( ) { 
        return this.recipientId;
    }
    
    /** SETTER
     * The recipient ID to which this event corresponds to
     */
    @JsonSetter("recipient_id")
    public void setRecipientId (String value) { 
        this.recipientId = value;
    }
 
    /** GETTER
     * The recipient's phone number
     */
    @JsonGetter("number")
    public String getNumber ( ) { 
        return this.number;
    }
    
    /** SETTER
     * The recipient's phone number
     */
    @JsonSetter("number")
    public void setNumber (String value) { 
        this.number = value;
    }
 
    /** GETTER
     * The event type.  See [Event Types](#events-types) for a list of available events.
     */
    @JsonGetter("event")
    public String getEvent ( ) { 
        return this.event;
    }
    
    /** SETTER
     * The event type.  See [Event Types](#events-types) for a list of available events.
     */
    @JsonSetter("event")
    public void setEvent (String value) { 
        this.event = value;
    }
 
    /** GETTER
     * The source identifier.  This identifies the element that produced the event.  This may not be applicable for all events.
     */
    @JsonGetter("source")
    public String getSource ( ) { 
        return this.source;
    }
    
    /** SETTER
     * The source identifier.  This identifies the element that produced the event.  This may not be applicable for all events.
     */
    @JsonSetter("source")
    public void setSource (String value) { 
        this.source = value;
    }
 
    /** GETTER
     * The timestamp of the event, in ISO 8601 format.
     */
    @JsonGetter("timestamp")
    public String getTimestamp ( ) { 
        return this.timestamp;
    }
    
    /** SETTER
     * The timestamp of the event, in ISO 8601 format.
     */
    @JsonSetter("timestamp")
    public void setTimestamp (String value) { 
        this.timestamp = value;
    }
 
}
