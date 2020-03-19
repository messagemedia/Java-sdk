package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Getnumberauthorisationblacklistresponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = -2372514496129062642L;
    private String uri;
    private List<String> numbers;
    private Pagination pagination;
    /** GETTER
     * URL of the current API call, used to show the current pagination token for calls subsequent to the first one in the case of paginated data.
     */
    @JsonGetter("uri")
    public String getUri ( ) { 
        return this.uri;
    }
    
    /** SETTER
     * URL of the current API call, used to show the current pagination token for calls subsequent to the first one in the case of paginated data.
     */
    @JsonSetter("uri")
    public void setUri (String value) { 
        this.uri = value;
    }
 
    /** GETTER
     * List of numbers belonging to the blacklist.
     */
    @JsonGetter("numbers")
    public List<String> getNumbers ( ) { 
        return this.numbers;
    }
    
    /** SETTER
     * List of numbers belonging to the blacklist.
     */
    @JsonSetter("numbers")
    public void setNumbers (List<String> value) { 
        this.numbers = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("pagination")
    public Pagination getPagination ( ) { 
        return this.pagination;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("pagination")
    public void setPagination (Pagination value) { 
        this.pagination = value;
    }
 
}
