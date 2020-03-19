package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class MetadataKeysResponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = 6169584913635364068L;
    private List<String> data;
    private Properties properties;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("data")
    public List<String> getData ( ) { 
        return this.data;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("data")
    public void setData (List<String> value) { 
        this.data = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("properties")
    public Properties getProperties ( ) { 
        return this.properties;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("properties")
    public void setProperties (Properties value) { 
        this.properties = value;
    }
 
}
