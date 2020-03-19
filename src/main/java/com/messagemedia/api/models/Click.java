package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Click 
        implements java.io.Serializable {
    private static final long serialVersionUID = -4905943701987666393L;
    private String dt;
    private String userAgent;
    private String ip;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("dt")
    public String getDt ( ) { 
        return this.dt;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("dt")
    public void setDt (String value) { 
        this.dt = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("user_agent")
    public String getUserAgent ( ) { 
        return this.userAgent;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("user_agent")
    public void setUserAgent (String value) { 
        this.userAgent = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("ip")
    public String getIp ( ) { 
        return this.ip;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("ip")
    public void setIp (String value) { 
        this.ip = value;
    }
 
}
