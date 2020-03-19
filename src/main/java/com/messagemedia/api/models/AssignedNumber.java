package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class AssignedNumber 
        implements java.io.Serializable {
    private static final long serialVersionUID = 6585698787370795281L;
    private Assignment assignment;
    private Number number;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("assignment")
    public Assignment getAssignment ( ) { 
        return this.assignment;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("assignment")
    public void setAssignment (Assignment value) { 
        this.assignment = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("number")
    public Number getNumber ( ) { 
        return this.number;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("number")
    public void setNumber (Number value) { 
        this.number = value;
    }
 
}
