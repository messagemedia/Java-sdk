package com.messagemedia.api.exceptions;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.messagemedia.api.http.client.HttpContext;

public class Lookupaphonenumber404responseException 
        extends APIException
        implements java.io.Serializable {
    private static final long serialVersionUID = -130044657180313264L;
    private String message;
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
 
    /**
     * Initialization constructor
     * @param   reason  The reason for throwing exception
     * @param   context The http context of the API exception
     */
    public Lookupaphonenumber404responseException(String reason, HttpContext context) {
        super(reason, context);
    }
}
