package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class ReportingDetailProperties 
        implements java.io.Serializable {
    private static final long serialVersionUID = -1160252792789075238L;
    private String endDate;
    private String startDate;
    private Sorting sorting;
    private Filters filters;
    private String timezone;
    /** GETTER
     * End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     */
    @JsonGetter("end_date")
    public String getEndDate ( ) { 
        return this.endDate;
    }
    
    /** SETTER
     * End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     */
    @JsonSetter("end_date")
    public void setEndDate (String value) { 
        this.endDate = value;
    }
 
    /** GETTER
     * Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     */
    @JsonGetter("start_date")
    public String getStartDate ( ) { 
        return this.startDate;
    }
    
    /** SETTER
     * Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     */
    @JsonSetter("start_date")
    public void setStartDate (String value) { 
        this.startDate = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("sorting")
    public Sorting getSorting ( ) { 
        return this.sorting;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("sorting")
    public void setSorting (Sorting value) { 
        this.sorting = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("filters")
    public Filters getFilters ( ) { 
        return this.filters;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("filters")
    public void setFilters (Filters value) { 
        this.filters = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("timezone")
    public String getTimezone ( ) { 
        return this.timezone;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("timezone")
    public void setTimezone (String value) { 
        this.timezone = value;
    }
 
}
