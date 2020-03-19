package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class SendCampaignToRecipientsresponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = -107440103422145826L;
    private List<Recipient1> recipients;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("recipients")
    public List<Recipient1> getRecipients ( ) { 
        return this.recipients;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("recipients")
    public void setRecipients (List<Recipient1> value) { 
        this.recipients = value;
    }
 
}
