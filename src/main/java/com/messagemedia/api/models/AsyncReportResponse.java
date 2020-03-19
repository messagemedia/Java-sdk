package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class AsyncReportResponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = -22627339751062744L;
    private String id;
    /** GETTER
     * The identifier for this async report
     */
    @JsonGetter("id")
    public String getId ( ) { 
        return this.id;
    }
    
    /** SETTER
     * The identifier for this async report
     */
    @JsonSetter("id")
    public void setId (String value) { 
        this.id = value;
    }
 
}
