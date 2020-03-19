package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class SummaryReport 
        implements java.io.Serializable {
    private static final long serialVersionUID = 3821684019687715072L;
    private Properties33 properties;
    private List<SummaryReportItem> data;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("properties")
    public Properties33 getProperties ( ) { 
        return this.properties;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("properties")
    public void setProperties (Properties33 value) { 
        this.properties = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("data")
    public List<SummaryReportItem> getData ( ) { 
        return this.data;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("data")
    public void setData (List<SummaryReportItem> value) { 
        this.data = value;
    }
 
}
