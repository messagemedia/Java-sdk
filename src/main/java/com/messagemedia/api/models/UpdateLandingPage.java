package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class UpdateLandingPage 
        implements java.io.Serializable {
    private static final long serialVersionUID = 4785886284292314918L;
    private String name;
    private String templateId;
    private Object parameters;
    private Object fields;
    /** GETTER
     * Landing Page name. Maximum 100 characters.
     */
    @JsonGetter("name")
    public String getName ( ) { 
        return this.name;
    }
    
    /** SETTER
     * Landing Page name. Maximum 100 characters.
     */
    @JsonSetter("name")
    public void setName (String value) { 
        this.name = value;
    }
 
    /** GETTER
     * Template to use for the landing page.
     */
    @JsonGetter("template_id")
    public String getTemplateId ( ) { 
        return this.templateId;
    }
    
    /** SETTER
     * Template to use for the landing page.
     */
    @JsonSetter("template_id")
    public void setTemplateId (String value) { 
        this.templateId = value;
    }
 
    /** GETTER
     * Parameters to use for the landing page and the message content.
     */
    @JsonGetter("parameters")
    public Object getParameters ( ) { 
        return this.parameters;
    }
    
    /** SETTER
     * Parameters to use for the landing page and the message content.
     */
    @JsonSetter("parameters")
    public void setParameters (Object value) { 
        this.parameters = value;
    }
 
    /** GETTER
     * Define the fields that have been used to the paramters.
     */
    @JsonGetter("fields")
    public Object getFields ( ) { 
        return this.fields;
    }
    
    /** SETTER
     * Define the fields that have been used to the paramters.
     */
    @JsonSetter("fields")
    public void setFields (Object value) { 
        this.fields = value;
    }
 
}
