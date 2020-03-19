package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Number 
        implements java.io.Serializable {
    private static final long serialVersionUID = 8164497253603727143L;
    private String number;
    private boolean authorised;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("number")
    public String getNumber ( ) { 
        return this.number;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("number")
    public void setNumber (String value) { 
        this.number = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("authorised")
    public boolean getAuthorised ( ) { 
        return this.authorised;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("authorised")
    public void setAuthorised (boolean value) { 
        this.authorised = value;
    }
 
}
