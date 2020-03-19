package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class LogsDetailResult 
        implements java.io.Serializable {
    private static final long serialVersionUID = -2695352177124655348L;
    private String messageId;
    private String longUrl;
    private String shortUrl;
    private String destinationNumber;
    private Double clickCount;
    private Double viewCount;
    private List<Click> clicks;
    private List<View> views;
    private Pagination1 pagination;
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
    @JsonGetter("clicks")
    public List<Click> getClicks ( ) { 
        return this.clicks;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("clicks")
    public void setClicks (List<Click> value) { 
        this.clicks = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("views")
    public List<View> getViews ( ) { 
        return this.views;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("views")
    public void setViews (List<View> value) { 
        this.views = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("pagination")
    public Pagination1 getPagination ( ) { 
        return this.pagination;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("pagination")
    public void setPagination (Pagination1 value) { 
        this.pagination = value;
    }
 
}
