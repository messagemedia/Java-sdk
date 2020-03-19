package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Parameters4 
        implements java.io.Serializable {
    private static final long serialVersionUID = -6883979450912102351L;
    private String pageTitle;
    private String pageText;
    private String callToAction;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("pageTitle")
    public String getPageTitle ( ) { 
        return this.pageTitle;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("pageTitle")
    public void setPageTitle (String value) { 
        this.pageTitle = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("pageText")
    public String getPageText ( ) { 
        return this.pageText;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("pageText")
    public void setPageText (String value) { 
        this.pageText = value;
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
