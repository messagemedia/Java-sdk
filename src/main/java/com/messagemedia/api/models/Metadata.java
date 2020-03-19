package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Metadata 
        implements java.io.Serializable {
    private static final long serialVersionUID = 81835054247666654L;
    private String key;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("key")
    public String getKey ( ) { 
        return this.key;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("key")
    public void setKey (String value) { 
        this.key = value;
    }
 
}
