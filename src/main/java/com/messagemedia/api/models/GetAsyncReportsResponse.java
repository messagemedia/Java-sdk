package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class GetAsyncReportsResponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = 1273113689141505799L;
    private List<AsyncReport> data;
    private Pagination1 pagination;
    /** GETTER
     * List of asynchronous reports
     */
    @JsonGetter("data")
    public List<AsyncReport> getData ( ) { 
        return this.data;
    }
    
    /** SETTER
     * List of asynchronous reports
     */
    @JsonSetter("data")
    public void setData (List<AsyncReport> value) { 
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
