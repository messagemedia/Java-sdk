package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class GetTemplatesresponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = -7152416918830691355L;
    private List<Template> templates;
    private Pagination2 pagination;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("templates")
    public List<Template> getTemplates ( ) { 
        return this.templates;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("templates")
    public void setTemplates (List<Template> value) { 
        this.templates = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("pagination")
    public Pagination2 getPagination ( ) { 
        return this.pagination;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("pagination")
    public void setPagination (Pagination2 value) { 
        this.pagination = value;
    }
 
}
