package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class UpdateaLandingPageresponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = -5834592285331816673L;
    private String id;
    private String name;
    private String templateId;
    private Parameters4 parameters;
    private Fields fields;
    private String createdTimestamp;
    private String modifiedTimestamp;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("id")
    public String getId ( ) { 
        return this.id;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("id")
    public void setId (String value) { 
        this.id = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("name")
    public String getName ( ) { 
        return this.name;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("name")
    public void setName (String value) { 
        this.name = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("template_id")
    public String getTemplateId ( ) { 
        return this.templateId;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("template_id")
    public void setTemplateId (String value) { 
        this.templateId = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("parameters")
    public Parameters4 getParameters ( ) { 
        return this.parameters;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("parameters")
    public void setParameters (Parameters4 value) { 
        this.parameters = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("fields")
    public Fields getFields ( ) { 
        return this.fields;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("fields")
    public void setFields (Fields value) { 
        this.fields = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("created_timestamp")
    public String getCreatedTimestamp ( ) { 
        return this.createdTimestamp;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("created_timestamp")
    public void setCreatedTimestamp (String value) { 
        this.createdTimestamp = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("modified_timestamp")
    public String getModifiedTimestamp ( ) { 
        return this.modifiedTimestamp;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("modified_timestamp")
    public void setModifiedTimestamp (String value) { 
        this.modifiedTimestamp = value;
    }
 
}
