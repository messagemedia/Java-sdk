package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Fields 
        implements java.io.Serializable {
    private static final long serialVersionUID = 1008206006200762069L;
    private Title title;
    private BodyText bodyText;
    private CtaUrl ctaUrl;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("title")
    public Title getTitle ( ) { 
        return this.title;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("title")
    public void setTitle (Title value) { 
        this.title = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("bodyText")
    public BodyText getBodyText ( ) { 
        return this.bodyText;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("bodyText")
    public void setBodyText (BodyText value) { 
        this.bodyText = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("ctaUrl")
    public CtaUrl getCtaUrl ( ) { 
        return this.ctaUrl;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("ctaUrl")
    public void setCtaUrl (CtaUrl value) { 
        this.ctaUrl = value;
    }
 
}
