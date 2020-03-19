package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Createsignaturekeyrequest 
        implements java.io.Serializable {
    private static final long serialVersionUID = 4100831257125610541L;
    private String digest;
    private String cipher;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("digest")
    public String getDigest ( ) { 
        return this.digest;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("digest")
    public void setDigest (String value) { 
        this.digest = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("cipher")
    public String getCipher ( ) { 
        return this.cipher;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("cipher")
    public void setCipher (String value) { 
        this.cipher = value;
    }
 
}
