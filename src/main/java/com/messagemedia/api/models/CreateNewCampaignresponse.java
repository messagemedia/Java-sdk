package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class CreateNewCampaignresponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = -4733596207487286084L;
    private String id;
    private String templateId;
    private Parameters parameters;
    private Message message;
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
    public Parameters getParameters ( ) { 
        return this.parameters;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("parameters")
    public void setParameters (Parameters value) { 
        this.parameters = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("message")
    public Message getMessage ( ) { 
        return this.message;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("message")
    public void setMessage (Message value) { 
        this.message = value;
    }
 
}
