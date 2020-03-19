package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class LogSummaryResult 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5035757281777819042L;
    private Double totalClicks;
    private Double uniqueClicks;
    private Double totalViews;
    private Double uniqueViews;
    private Double shortUrlsGenerated;
    private List<ShortUrl> shortUrls;
    private Pagination1 pagination;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("total_clicks")
    public Double getTotalClicks ( ) { 
        return this.totalClicks;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("total_clicks")
    public void setTotalClicks (Double value) { 
        this.totalClicks = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("unique_clicks")
    public Double getUniqueClicks ( ) { 
        return this.uniqueClicks;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("unique_clicks")
    public void setUniqueClicks (Double value) { 
        this.uniqueClicks = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("total_views")
    public Double getTotalViews ( ) { 
        return this.totalViews;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("total_views")
    public void setTotalViews (Double value) { 
        this.totalViews = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("unique_views")
    public Double getUniqueViews ( ) { 
        return this.uniqueViews;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("unique_views")
    public void setUniqueViews (Double value) { 
        this.uniqueViews = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("short_urls_generated")
    public Double getShortUrlsGenerated ( ) { 
        return this.shortUrlsGenerated;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("short_urls_generated")
    public void setShortUrlsGenerated (Double value) { 
        this.shortUrlsGenerated = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("short_urls")
    public List<ShortUrl> getShortUrls ( ) { 
        return this.shortUrls;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("short_urls")
    public void setShortUrls (List<ShortUrl> value) { 
        this.shortUrls = value;
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
