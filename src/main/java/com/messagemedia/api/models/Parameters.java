package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Parameters 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5331552696449268689L;
    private String title;
    private String bodyText;
    private String callToAction;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("title")
    public String getTitle ( ) { 
        return this.title;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("title")
    public void setTitle (String value) { 
        this.title = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("bodyText")
    public String getBodyText ( ) { 
        return this.bodyText;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("bodyText")
    public void setBodyText (String value) { 
        this.bodyText = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("callToAction")
    public String getCallToAction ( ) { 
        return this.callToAction;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("callToAction")
    public void setCallToAction (String value) { 
        this.callToAction = value;
    }
 
}
