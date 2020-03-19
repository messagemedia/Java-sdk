package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Confirmrepliesasreceivedrequest 
        implements java.io.Serializable {
    private static final long serialVersionUID = 64984732236561641L;
    private List<UUID> replyIds;
    /** GETTER
     * The UUID of the *reply* to be confirmed (note: not the UUID of the message it is in response to)
     */
    @JsonGetter("reply_ids")
    public List<UUID> getReplyIds ( ) { 
        return this.replyIds;
    }
    
    /** SETTER
     * The UUID of the *reply* to be confirmed (note: not the UUID of the message it is in response to)
     */
    @JsonSetter("reply_ids")
    public void setReplyIds (List<UUID> value) { 
        this.replyIds = value;
    }
 
}
