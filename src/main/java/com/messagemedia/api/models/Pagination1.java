package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Pagination1 
        implements java.io.Serializable {
    private static final long serialVersionUID = 3224538712571339622L;
    private Double page;
    private Double pageSize;
    private Double totalCount;
    private Double pageCount;
    private String nextUri;
    private String previousUri;
    /** GETTER
     * The current page of results
     */
    @JsonGetter("page")
    public Double getPage ( ) { 
        return this.page;
    }
    
    /** SETTER
     * The current page of results
     */
    @JsonSetter("page")
    public void setPage (Double value) { 
        this.page = value;
    }
 
    /** GETTER
     * The amount of results returned per page
     */
    @JsonGetter("page_size")
    public Double getPageSize ( ) { 
        return this.pageSize;
    }
    
    /** SETTER
     * The amount of results returned per page
     */
    @JsonSetter("page_size")
    public void setPageSize (Double value) { 
        this.pageSize = value;
    }
 
    /** GETTER
     * The total number of results in the results set
     */
    @JsonGetter("total_count")
    public Double getTotalCount ( ) { 
        return this.totalCount;
    }
    
    /** SETTER
     * The total number of results in the results set
     */
    @JsonSetter("total_count")
    public void setTotalCount (Double value) { 
        this.totalCount = value;
    }
 
    /** GETTER
     * The total number of pages in the results set
     */
    @JsonGetter("page_count")
    public Double getPageCount ( ) { 
        return this.pageCount;
    }
    
    /** SETTER
     * The total number of pages in the results set
     */
    @JsonSetter("page_count")
    public void setPageCount (Double value) { 
        this.pageCount = value;
    }
 
    /** GETTER
     * Link to the next page of results
     */
    @JsonGetter("next_uri")
    public String getNextUri ( ) { 
        return this.nextUri;
    }
    
    /** SETTER
     * Link to the next page of results
     */
    @JsonSetter("next_uri")
    public void setNextUri (String value) { 
        this.nextUri = value;
    }
 
    /** GETTER
     * Link to the previous page of results
     */
    @JsonGetter("previous_uri")
    public String getPreviousUri ( ) { 
        return this.previousUri;
    }
    
    /** SETTER
     * Link to the previous page of results
     */
    @JsonSetter("previous_uri")
    public void setPreviousUri (String value) { 
        this.previousUri = value;
    }
 
}
