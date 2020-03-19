package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Recipient 
        implements java.io.Serializable {
    private static final long serialVersionUID = 994015256215478551L;
    private String number;
    private Object parameters;
    private String scheduled;
    /** GETTER
     * The recipient phone number.  Must be E.164 with a leading '+'
     */
    @JsonGetter("number")
    public String getNumber ( ) { 
        return this.number;
    }
    
    /** SETTER
     * The recipient phone number.  Must be E.164 with a leading '+'
     */
    @JsonSetter("number")
    public void setNumber (String value) { 
        this.number = value;
    }
 
    /** GETTER
     * The recipient scoped template parameters
     */
    @JsonGetter("parameters")
    public Object getParameters ( ) { 
        return this.parameters;
    }
    
    /** SETTER
     * The recipient scoped template parameters
     */
    @JsonSetter("parameters")
    public void setParameters (Object value) { 
        this.parameters = value;
    }
 
    /** GETTER
     * A message can be scheduled for delivery in the future by setting the scheduled property. The scheduled property expects a date time specified in ISO 8601 format. The scheduled time must be provided in UTC and be no more than 31 days in the future.
     */
    @JsonGetter("scheduled")
    public String getScheduled ( ) { 
        return this.scheduled;
    }
    
    /** SETTER
     * A message can be scheduled for delivery in the future by setting the scheduled property. The scheduled property expects a date time specified in ISO 8601 format. The scheduled time must be provided in UTC and be no more than 31 days in the future.
     */
    @JsonSetter("scheduled")
    public void setScheduled (String value) { 
        this.scheduled = value;
    }
 
}
