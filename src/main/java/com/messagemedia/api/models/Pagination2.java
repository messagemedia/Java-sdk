package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Pagination2 
        implements java.io.Serializable {
    private static final long serialVersionUID = 2105154498300794819L;
    private double page;
    private double pageSize;
    private double totalCount;
    /** GETTER
     * The current page number
     */
    @JsonGetter("page")
    public double getPage ( ) { 
        return this.page;
    }
    
    /** SETTER
     * The current page number
     */
    @JsonSetter("page")
    public void setPage (double value) { 
        this.page = value;
    }
 
    /** GETTER
     * The requested page size
     */
    @JsonGetter("page_size")
    public double getPageSize ( ) { 
        return this.pageSize;
    }
    
    /** SETTER
     * The requested page size
     */
    @JsonSetter("page_size")
    public void setPageSize (double value) { 
        this.pageSize = value;
    }
 
    /** GETTER
     * The total number of items that match the query
     */
    @JsonGetter("total_count")
    public double getTotalCount ( ) { 
        return this.totalCount;
    }
    
    /** SETTER
     * The total number of items that match the query
     */
    @JsonSetter("total_count")
    public void setTotalCount (double value) { 
        this.totalCount = value;
    }
 
}
