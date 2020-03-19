package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class SummaryReportItem 
        implements java.io.Serializable {
    private static final long serialVersionUID = -3953793729547024175L;
    private String group;
    private Double value;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("group")
    public String getGroup ( ) { 
        return this.group;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("group")
    public void setGroup (String value) { 
        this.group = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("value")
    public Double getValue ( ) { 
        return this.value;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("value")
    public void setValue (Double value) { 
        this.value = value;
    }
 
}
