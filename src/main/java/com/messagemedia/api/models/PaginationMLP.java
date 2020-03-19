package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class PaginationMLP 
        implements java.io.Serializable {
    private static final long serialVersionUID = -3885638629379911331L;
    private String nextPageToken;
    private int pageSize;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("next_page_token")
    public String getNextPageToken ( ) { 
        return this.nextPageToken;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("next_page_token")
    public void setNextPageToken (String value) { 
        this.nextPageToken = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("page_size")
    public int getPageSize ( ) { 
        return this.pageSize;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("page_size")
    public void setPageSize (int value) { 
        this.pageSize = value;
    }
 
}
