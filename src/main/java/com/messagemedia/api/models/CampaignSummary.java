package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class CampaignSummary 
        implements java.io.Serializable {
    private static final long serialVersionUID = -763162343624861639L;
    private double totalEvents;
    private double uniqueEngagements;
    private List<EventSummary> eventSummary;
    /** GETTER
     * The total number of events record against this campaign.
     */
    @JsonGetter("total_events")
    public double getTotalEvents ( ) { 
        return this.totalEvents;
    }
    
    /** SETTER
     * The total number of events record against this campaign.
     */
    @JsonSetter("total_events")
    public void setTotalEvents (double value) { 
        this.totalEvents = value;
    }
 
    /** GETTER
     * The unique number of recipients for which there exists at least one recorded event.
     */
    @JsonGetter("unique_engagements")
    public double getUniqueEngagements ( ) { 
        return this.uniqueEngagements;
    }
    
    /** SETTER
     * The unique number of recipients for which there exists at least one recorded event.
     */
    @JsonSetter("unique_engagements")
    public void setUniqueEngagements (double value) { 
        this.uniqueEngagements = value;
    }
 
    /** GETTER
     * The event summary breakdown.
     */
    @JsonGetter("event_summary")
    public List<EventSummary> getEventSummary ( ) { 
        return this.eventSummary;
    }
    
    /** SETTER
     * The event summary breakdown.
     */
    @JsonSetter("event_summary")
    public void setEventSummary (List<EventSummary> value) { 
        this.eventSummary = value;
    }
 
}
