package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Enablesignaturekeyresponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = 4369659884713392099L;
    private String keyId;
    private String cipher;
    private String digest;
    private String created;
    private Boolean enabled;
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
    @JsonGetter("created")
    public String getCreated ( ) { 
        return this.created;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("created")
    public void setCreated (String value) { 
        this.created = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("enabled")
    public Boolean getEnabled ( ) { 
        return this.enabled;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("enabled")
    public void setEnabled (Boolean value) { 
        this.enabled = value;
    }
 
}
