package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class ReceivedMessages 
        implements java.io.Serializable {
    private static final long serialVersionUID = -6113592323523785367L;
    private List<ReceivedMessage> data;
    private Pagination1 pagination;
    private ReportingDetailProperties properties;
    /** GETTER
     * List of received messages
     */
    @JsonGetter("data")
    public List<ReceivedMessage> getData ( ) { 
        return this.data;
    }
    
    /** SETTER
     * List of received messages
     */
    @JsonSetter("data")
    public void setData (List<ReceivedMessage> value) { 
        this.data = value;
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
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("properties")
    public ReportingDetailProperties getProperties ( ) { 
        return this.properties;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("properties")
    public void setProperties (ReportingDetailProperties value) { 
        this.properties = value;
    }
 
}
