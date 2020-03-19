package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Addoneormorenumberstoyourbacklistresponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = -2515886073620596711L;
    private String uri;
    private List<String> numbers;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("uri")
    public String getUri ( ) { 
        return this.uri;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("uri")
    public void setUri (String value) { 
        this.uri = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("numbers")
    public List<String> getNumbers ( ) { 
        return this.numbers;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("numbers")
    public void setNumbers (List<String> value) { 
        this.numbers = value;
    }
 
}
