package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class AssignedNumberListResponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = 8958497876130501461L;
    private List<AssignedNumber> data;
    private Pagination1 pagination;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("data")
    public List<AssignedNumber> getData ( ) { 
        return this.data;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("data")
    public void setData (List<AssignedNumber> value) { 
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
 
}
