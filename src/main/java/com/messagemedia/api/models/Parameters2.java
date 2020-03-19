package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Parameters2 
        implements java.io.Serializable {
    private static final long serialVersionUID = 4728779129737057632L;
    private String firstName;
    private String lastName;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("firstName")
    public String getFirstName ( ) { 
        return this.firstName;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("firstName")
    public void setFirstName (String value) { 
        this.firstName = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("lastName")
    public String getLastName ( ) { 
        return this.lastName;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("lastName")
    public void setLastName (String value) { 
        this.lastName = value;
    }
 
}
