package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Campaign 
        implements java.io.Serializable {
    private static final long serialVersionUID = 8130937588435963868L;
    private String templateId;
    private Object parameters;
    private MessageTemplate message;
    /** GETTER
     * Template to use for the landing page
     */
    @JsonGetter("template_id")
    public String getTemplateId ( ) { 
        return this.templateId;
    }
    
    /** SETTER
     * Template to use for the landing page
     */
    @JsonSetter("template_id")
    public void setTemplateId (String value) { 
        this.templateId = value;
    }
 
    /** GETTER
     * Parameters to use for the landing page and the message content
     */
    @JsonGetter("parameters")
    public Object getParameters ( ) { 
        return this.parameters;
    }
    
    /** SETTER
     * Parameters to use for the landing page and the message content
     */
    @JsonSetter("parameters")
    public void setParameters (Object value) { 
        this.parameters = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("message")
    public MessageTemplate getMessage ( ) { 
        return this.message;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("message")
    public void setMessage (MessageTemplate value) { 
        this.message = value;
    }
 
}
