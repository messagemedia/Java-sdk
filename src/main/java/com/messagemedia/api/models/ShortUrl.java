package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class ShortUrl 
        implements java.io.Serializable {
    private static final long serialVersionUID = -6484270800661752008L;
    private Double clickCount;
    private Double viewCount;
    private String messageId;
    private String longUrl;
    private String shortUrl;
    private String destinationNumber;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("click_count")
    public Double getClickCount ( ) { 
        return this.clickCount;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("click_count")
    public void setClickCount (Double value) { 
        this.clickCount = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("view_count")
    public Double getViewCount ( ) { 
        return this.viewCount;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("view_count")
    public void setViewCount (Double value) { 
        this.viewCount = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("message_id")
    public String getMessageId ( ) { 
        return this.messageId;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("message_id")
    public void setMessageId (String value) { 
        this.messageId = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("long_url")
    public String getLongUrl ( ) { 
        return this.longUrl;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("long_url")
    public void setLongUrl (String value) { 
        this.longUrl = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("short_url")
    public String getShortUrl ( ) { 
        return this.shortUrl;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("short_url")
    public void setShortUrl (String value) { 
        this.shortUrl = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("destination_number")
    public String getDestinationNumber ( ) { 
        return this.destinationNumber;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("destination_number")
    public void setDestinationNumber (String value) { 
        this.destinationNumber = value;
    }
 
}
