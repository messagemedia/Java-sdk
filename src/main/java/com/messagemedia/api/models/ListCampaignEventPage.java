package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class ListCampaignEventPage 
        implements java.io.Serializable {
    private static final long serialVersionUID = 9183610517421028159L;
    private List<CampaignEvent> events;
    private Pagination1 pagination;
    /** GETTER
     * The list of campaign events.
     */
    @JsonGetter("events")
    public List<CampaignEvent> getEvents ( ) { 
        return this.events;
    }
    
    /** SETTER
     * The list of campaign events.
     */
    @JsonSetter("events")
    public void setEvents (List<CampaignEvent> value) { 
        this.events = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("pagination")
    public Pagination1 getPagination ( ) { 
        return this.pagination;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("pagination")
    public void setPagination (Pagination1 value) { 
        this.pagination = value;
    }
 
}
