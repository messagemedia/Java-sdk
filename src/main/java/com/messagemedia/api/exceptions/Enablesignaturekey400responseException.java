package com.messagemedia.api.exceptions;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.messagemedia.api.http.client.HttpContext;

public class Enablesignaturekey400responseException 
        extends APIException
        implements java.io.Serializable {
    private static final long serialVersionUID = 1893343198054576286L;
    private String message;
    private List<String> details;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("message")
    public String getMessage ( ) { 
        return this.message;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("message")
    private void setMessage (String value) { 
        this.message = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("details")
    public List<String> getDetails ( ) { 
        return this.details;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("details")
    private void setDetails (List<String> value) { 
        this.details = value;
    }
 
    /**
     * Initialization constructor
     * @param   reason  The reason for throwing exception
     * @param   context The http context of the API exception
     */
    public Enablesignaturekey400responseException(String reason, HttpContext context) {
        super(reason, context);
    }
}
