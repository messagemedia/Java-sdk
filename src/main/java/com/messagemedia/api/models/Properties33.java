package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Properties33 
        implements java.io.Serializable {
    private static final long serialVersionUID = -2152757177595491522L;
    private String endDate;
    private String startDate;
    private Object filters;
    private GroupingEnum grouping;
    private SummaryEnum summary;
    private SummaryFieldEnum summaryField;
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
     * Any filters provided as parameters for this report
     */
    @JsonGetter("filters")
    public Object getFilters ( ) { 
        return this.filters;
    }
    
    /** SETTER
     * Any filters provided as parameters for this report
     */
    @JsonSetter("filters")
    public void setFilters (Object value) { 
        this.filters = value;
    }
 
    /** GETTER
     * The value of the group by parameter provided for this report
     */
    @JsonGetter("grouping")
    public GroupingEnum getGrouping ( ) { 
        return this.grouping;
    }
    
    /** SETTER
     * The value of the group by parameter provided for this report
     */
    @JsonSetter("grouping")
    public void setGrouping (GroupingEnum value) { 
        this.grouping = value;
    }
 
    /** GETTER
     * The value of the summary_by parameter provided for this report
     */
    @JsonGetter("summary")
    public SummaryEnum getSummary ( ) { 
        return this.summary;
    }
    
    /** SETTER
     * The value of the summary_by parameter provided for this report
     */
    @JsonSetter("summary")
    public void setSummary (SummaryEnum value) { 
        this.summary = value;
    }
 
    /** GETTER
     * The value of the summary_field parameter provided for this report
     */
    @JsonGetter("summary_field")
    public SummaryFieldEnum getSummaryField ( ) { 
        return this.summaryField;
    }
    
    /** SETTER
     * The value of the summary_field parameter provided for this report
     */
    @JsonSetter("summary_field")
    public void setSummaryField (SummaryFieldEnum value) { 
        this.summaryField = value;
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
