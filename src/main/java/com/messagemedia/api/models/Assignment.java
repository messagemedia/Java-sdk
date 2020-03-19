package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Assignment 
        implements java.io.Serializable {
    private static final long serialVersionUID = -5423155289860478917L;
    private String id;
    private LinkedHashMap<String, String> metadata;
    private String numberId;
    private String label;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("id")
    public String getId ( ) { 
        return this.id;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("id")
    public void setId (String value) { 
        this.id = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("metadata")
    public LinkedHashMap<String, String> getMetadata ( ) { 
        return this.metadata;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("metadata")
    public void setMetadata (LinkedHashMap<String, String> value) { 
        this.metadata = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("number_id")
    public String getNumberId ( ) { 
        return this.numberId;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("number_id")
    public void setNumberId (String value) { 
        this.numberId = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("label")
    public String getLabel ( ) { 
        return this.label;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("label")
    public void setLabel (String value) { 
        this.label = value;
    }
 
}
