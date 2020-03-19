package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Pagination 
        implements java.io.Serializable {
    private static final long serialVersionUID = 8653639671595487609L;
    private String page;
    private String nextUri;
    /** GETTER
     * The pagination token of the next set of results.
     */
    @JsonGetter("page")
    public String getPage ( ) { 
        return this.page;
    }
    
    /** SETTER
     * The pagination token of the next set of results.
     */
    @JsonSetter("page")
    public void setPage (String value) { 
        this.page = value;
    }
 
    /** GETTER
     * The uri pointing to the next set of results.
     */
    @JsonGetter("next_uri")
    public String getNextUri ( ) { 
        return this.nextUri;
    }
    
    /** SETTER
     * The uri pointing to the next set of results.
     */
    @JsonSetter("next_uri")
    public void setNextUri (String value) { 
        this.nextUri = value;
    }
 
}
