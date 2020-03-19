package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Enablesignaturekeyrequest 
        implements java.io.Serializable {
    private static final long serialVersionUID = 28589013140673531L;
    private String keyId;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("key_id")
    public String getKeyId ( ) { 
        return this.keyId;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("key_id")
    public void setKeyId (String value) { 
        this.keyId = value;
    }
 
}
