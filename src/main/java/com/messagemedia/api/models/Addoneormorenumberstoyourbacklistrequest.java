package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Addoneormorenumberstoyourbacklistrequest 
        implements java.io.Serializable {
    private static final long serialVersionUID = 113958682404399322L;
    private List<String> numbers;
    /** GETTER
     * Array of numbers to be added to the blacklist. These should be specified in E.164 international format. For information on E.164, please refer to http://en.wikipedia.org/wiki/E.164.
     */
    @JsonGetter("numbers")
    public List<String> getNumbers ( ) { 
        return this.numbers;
    }
    
    /** SETTER
     * Array of numbers to be added to the blacklist. These should be specified in E.164 international format. For information on E.164, please refer to http://en.wikipedia.org/wiki/E.164.
     */
    @JsonSetter("numbers")
    public void setNumbers (List<String> value) { 
        this.numbers = value;
    }
 
}
