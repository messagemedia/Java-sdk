package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class SentMessages 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5736763227024951006L;
    private List<SentMessage> data;
    private Pagination1 pagination;
    private ReportingDetailProperties properties;
    /** GETTER
     * List of sent messages
     */
    @JsonGetter("data")
    public List<SentMessage> getData ( ) { 
        return this.data;
    }
    
    /** SETTER
     * List of sent messages
     */
    @JsonSetter("data")
    public void setData (List<SentMessage> value) { 
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
