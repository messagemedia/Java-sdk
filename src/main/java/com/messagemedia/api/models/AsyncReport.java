package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class AsyncReport 
        implements java.io.Serializable {
    private static final long serialVersionUID = 2836860421747439650L;
    private String id;
    private MessageTypeEnum messageType;
    private TypeEnum type;
    private ReportStatusEnum reportStatus;
    private String createdDatetime;
    private String lastModifiedDatetime;
    /** GETTER
     * Unique ID for this reply
     */
    @JsonGetter("id")
    public String getId ( ) { 
        return this.id;
    }
    
    /** SETTER
     * Unique ID for this reply
     */
    @JsonSetter("id")
    public void setId (String value) { 
        this.id = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("message_type")
    public MessageTypeEnum getMessageType ( ) { 
        return this.messageType;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("message_type")
    public void setMessageType (MessageTypeEnum value) { 
        this.messageType = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("type")
    public TypeEnum getType ( ) { 
        return this.type;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("type")
    public void setType (TypeEnum value) { 
        this.type = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("report_status")
    public ReportStatusEnum getReportStatus ( ) { 
        return this.reportStatus;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("report_status")
    public void setReportStatus (ReportStatusEnum value) { 
        this.reportStatus = value;
    }
 
    /** GETTER
     * Date time at which this report was created.
     */
    @JsonGetter("created_datetime")
    public String getCreatedDatetime ( ) { 
        return this.createdDatetime;
    }
    
    /** SETTER
     * Date time at which this report was created.
     */
    @JsonSetter("created_datetime")
    public void setCreatedDatetime (String value) { 
        this.createdDatetime = value;
    }
 
    /** GETTER
     * Date time at which this report was last modified.
     */
    @JsonGetter("last_modified_datetime")
    public String getLastModifiedDatetime ( ) { 
        return this.lastModifiedDatetime;
    }
    
    /** SETTER
     * Date time at which this report was last modified.
     */
    @JsonSetter("last_modified_datetime")
    public void setLastModifiedDatetime (String value) { 
        this.lastModifiedDatetime = value;
    }
 
}
