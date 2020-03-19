package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class SendCampaignToRecipientsrequest 
        implements java.io.Serializable {
    private static final long serialVersionUID = -14303639582683916L;
    private List<Recipient> recipients;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("recipients")
    public List<Recipient> getRecipients ( ) { 
        return this.recipients;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("recipients")
    public void setRecipients (List<Recipient> value) { 
        this.recipients = value;
    }
 
}
