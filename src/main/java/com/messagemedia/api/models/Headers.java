package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Headers 
        implements java.io.Serializable {
    private static final long serialVersionUID = 19539033948231793L;
    private String account;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Account")
    public String getAccount ( ) { 
        return this.account;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Account")
    public void setAccount (String value) { 
        this.account = value;
    }
 
}
