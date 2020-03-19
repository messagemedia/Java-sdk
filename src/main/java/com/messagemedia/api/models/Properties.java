package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Properties 
        implements java.io.Serializable {
    private static final long serialVersionUID = 1811909414787122833L;
    private String endDate;
    private String startDate;
    private List<String> accounts;
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
     * List of accounts that were considered when fetching the metadata keys.
     */
    @JsonGetter("accounts")
    public List<String> getAccounts ( ) { 
        return this.accounts;
    }
    
    /** SETTER
     * List of accounts that were considered when fetching the metadata keys.
     */
    @JsonSetter("accounts")
    public void setAccounts (List<String> value) { 
        this.accounts = value;
    }
 
}
