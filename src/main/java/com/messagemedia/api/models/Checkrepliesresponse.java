package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Checkrepliesresponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = -62528624481813120L;
    private List<Reply> replies;
    /** GETTER
     * The oldest 100 unconfirmed replies
     */
    @JsonGetter("replies")
    public List<Reply> getReplies ( ) { 
        return this.replies;
    }
    
    /** SETTER
     * The oldest 100 unconfirmed replies
     */
    @JsonSetter("replies")
    public void setReplies (List<Reply> value) { 
        this.replies = value;
    }
 
}
