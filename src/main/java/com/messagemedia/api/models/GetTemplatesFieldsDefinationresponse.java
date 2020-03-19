package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class GetTemplatesFieldsDefinationresponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = -117896699624843451L;
    private Fields2 fields;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("fields")
    public Fields2 getFields ( ) { 
        return this.fields;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("fields")
    public void setFields (Fields2 value) { 
        this.fields = value;
    }
 
}
