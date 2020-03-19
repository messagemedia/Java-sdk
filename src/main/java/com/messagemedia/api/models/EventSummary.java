package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class EventSummary 
        implements java.io.Serializable {
    private static final long serialVersionUID = -2013246121475942060L;
    private String event;
    private String source;
    private double totalEvents;
    private double uniqueRecipients;
    /** GETTER
     * The event type to which this summary is for.  See [Event Types](#events-types) for a list of available events.
     */
    @JsonGetter("event")
    public String getEvent ( ) { 
        return this.event;
    }
    
    /** SETTER
     * The event type to which this summary is for.  See [Event Types](#events-types) for a list of available events.
     */
    @JsonSetter("event")
    public void setEvent (String value) { 
        this.event = value;
    }
 
    /** GETTER
     * The event source to which this summary is for, if applicable.
     */
    @JsonGetter("source")
    public String getSource ( ) { 
        return this.source;
    }
    
    /** SETTER
     * The event source to which this summary is for, if applicable.
     */
    @JsonSetter("source")
    public void setSource (String value) { 
        this.source = value;
    }
 
    /** GETTER
     * The total number of recorded events of this type and source.
     */
    @JsonGetter("total_events")
    public double getTotalEvents ( ) { 
        return this.totalEvents;
    }
    
    /** SETTER
     * The total number of recorded events of this type and source.
     */
    @JsonSetter("total_events")
    public void setTotalEvents (double value) { 
        this.totalEvents = value;
    }
 
    /** GETTER
     * The unique number of recipients for which there exists at least one event of this type and source recorded.
     */
    @JsonGetter("unique_recipients")
    public double getUniqueRecipients ( ) { 
        return this.uniqueRecipients;
    }
    
    /** SETTER
     * The unique number of recipients for which there exists at least one event of this type and source recorded.
     */
    @JsonSetter("unique_recipients")
    public void setUniqueRecipients (double value) { 
        this.uniqueRecipients = value;
    }
 
}
