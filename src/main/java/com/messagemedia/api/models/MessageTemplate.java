package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class MessageTemplate 
        implements java.io.Serializable {
    private static final long serialVersionUID = -5907880203468281397L;
    private String content;
    private Object metadata;
    private RichLink richLink;
    private Boolean deliveryReport;
    /** GETTER
     * The message content.  This supports template placeholders.
     */
    @JsonGetter("content")
    public String getContent ( ) { 
        return this.content;
    }
    
    /** SETTER
     * The message content.  This supports template placeholders.
     */
    @JsonSetter("content")
    public void setContent (String value) { 
        this.content = value;
    }
 
    /** GETTER
     * Message metadata.  This will be supplied to URL shortener and UG.  Max 10 keys per campaign.
     */
    @JsonGetter("metadata")
    public Object getMetadata ( ) { 
        return this.metadata;
    }
    
    /** SETTER
     * Message metadata.  This will be supplied to URL shortener and UG.  Max 10 keys per campaign.
     */
    @JsonSetter("metadata")
    public void setMetadata (Object value) { 
        this.metadata = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("rich_link")
    public RichLink getRichLink ( ) { 
        return this.richLink;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("rich_link")
    public void setRichLink (RichLink value) { 
        this.richLink = value;
    }
 
    /** GETTER
     * Request a delivery report for the sent message
     */
    @JsonGetter("delivery_report")
    public Boolean getDeliveryReport ( ) { 
        return this.deliveryReport;
    }
    
    /** SETTER
     * Request a delivery report for the sent message
     */
    @JsonSetter("delivery_report")
    public void setDeliveryReport (Boolean value) { 
        this.deliveryReport = value;
    }
 
}
