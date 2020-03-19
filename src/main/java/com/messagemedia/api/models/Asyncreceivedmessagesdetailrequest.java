package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Asyncreceivedmessagesdetailrequest 
        implements java.io.Serializable {
    private static final long serialVersionUID = -7898887157246509028L;
    private String endDate;
    private String startDate;
    private PeriodEnum period;
    private SortByEnum sortBy;
    private SortDirectionEnum sortDirection;
    private String timezone;
    private List<String> accounts;
    private String destinationAddressCountry;
    private String destinationAddress;
    private Format1Enum messageFormat;
    private String metadataKey;
    private String metadataValue;
    private String sourceAddressCountry;
    private String sourceAddress;
    private ActionEnum action;
    private List<DeliveryOptionsBody> deliveryOptions;
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
     * Automatically set a date range based on the period value. Can't be combined with start_date and end_date.
     */
    @JsonGetter("period")
    public PeriodEnum getPeriod ( ) { 
        return this.period;
    }
    
    /** SETTER
     * Automatically set a date range based on the period value. Can't be combined with start_date and end_date.
     */
    @JsonSetter("period")
    public void setPeriod (PeriodEnum value) { 
        this.period = value;
    }
 
    /** GETTER
     * Field to sort results set by
     */
    @JsonGetter("sort_by")
    public SortByEnum getSortBy ( ) { 
        return this.sortBy;
    }
    
    /** SETTER
     * Field to sort results set by
     */
    @JsonSetter("sort_by")
    public void setSortBy (SortByEnum value) { 
        this.sortBy = value;
    }
 
    /** GETTER
     * Order to sort results by.
     */
    @JsonGetter("sort_direction")
    public SortDirectionEnum getSortDirection ( ) { 
        return this.sortDirection;
    }
    
    /** SETTER
     * Order to sort results by.
     */
    @JsonSetter("sort_direction")
    public void setSortDirection (SortDirectionEnum value) { 
        this.sortDirection = value;
    }
 
    /** GETTER
     * The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'.
     */
    @JsonGetter("timezone")
    public String getTimezone ( ) { 
        return this.timezone;
    }
    
    /** SETTER
     * The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'.
     */
    @JsonSetter("timezone")
    public void setTimezone (String value) { 
        this.timezone = value;
    }
 
    /** GETTER
     * Filter results by a specific account. By default results
     * will be returned for the account associated with the authentication
     * credentials and all sub accounts.
     */
    @JsonGetter("accounts")
    public List<String> getAccounts ( ) { 
        return this.accounts;
    }
    
    /** SETTER
     * Filter results by a specific account. By default results
     * will be returned for the account associated with the authentication
     * credentials and all sub accounts.
     */
    @JsonSetter("accounts")
    public void setAccounts (List<String> value) { 
        this.accounts = value;
    }
 
    /** GETTER
     * Filter results by destination address country.
     */
    @JsonGetter("destination_address_country")
    public String getDestinationAddressCountry ( ) { 
        return this.destinationAddressCountry;
    }
    
    /** SETTER
     * Filter results by destination address country.
     */
    @JsonSetter("destination_address_country")
    public void setDestinationAddressCountry (String value) { 
        this.destinationAddressCountry = value;
    }
 
    /** GETTER
     * Filter results by destination address.
     */
    @JsonGetter("destination_address")
    public String getDestinationAddress ( ) { 
        return this.destinationAddress;
    }
    
    /** SETTER
     * Filter results by destination address.
     */
    @JsonSetter("destination_address")
    public void setDestinationAddress (String value) { 
        this.destinationAddress = value;
    }
 
    /** GETTER
     * Format of message, SMS or TTS (Text To Speech)
     */
    @JsonGetter("message_format")
    public Format1Enum getMessageFormat ( ) { 
        return this.messageFormat;
    }
    
    /** SETTER
     * Format of message, SMS or TTS (Text To Speech)
     */
    @JsonSetter("message_format")
    public void setMessageFormat (Format1Enum value) { 
        this.messageFormat = value;
    }
 
    /** GETTER
     * Filter results for messages that include a metadata key.
     */
    @JsonGetter("metadata_key")
    public String getMetadataKey ( ) { 
        return this.metadataKey;
    }
    
    /** SETTER
     * Filter results for messages that include a metadata key.
     */
    @JsonSetter("metadata_key")
    public void setMetadataKey (String value) { 
        this.metadataKey = value;
    }
 
    /** GETTER
     * Filter results for messages that include a metadata key containing this value. If this parameter is provided, the metadata_key parameter must also be provided.
     */
    @JsonGetter("metadata_value")
    public String getMetadataValue ( ) { 
        return this.metadataValue;
    }
    
    /** SETTER
     * Filter results for messages that include a metadata key containing this value. If this parameter is provided, the metadata_key parameter must also be provided.
     */
    @JsonSetter("metadata_value")
    public void setMetadataValue (String value) { 
        this.metadataValue = value;
    }
 
    /** GETTER
     * Filter results by source address country.
     */
    @JsonGetter("source_address_country")
    public String getSourceAddressCountry ( ) { 
        return this.sourceAddressCountry;
    }
    
    /** SETTER
     * Filter results by source address country.
     */
    @JsonSetter("source_address_country")
    public void setSourceAddressCountry (String value) { 
        this.sourceAddressCountry = value;
    }
 
    /** GETTER
     * Filter results by source address.
     */
    @JsonGetter("source_address")
    public String getSourceAddress ( ) { 
        return this.sourceAddress;
    }
    
    /** SETTER
     * Filter results by source address.
     */
    @JsonSetter("source_address")
    public void setSourceAddress (String value) { 
        this.sourceAddress = value;
    }
 
    /** GETTER
     * Action that was invoked for this message if any, OPT_OUT, OPT_IN, GLOBAL_OPT_OUT
     */
    @JsonGetter("action")
    public ActionEnum getAction ( ) { 
        return this.action;
    }
    
    /** SETTER
     * Action that was invoked for this message if any, OPT_OUT, OPT_IN, GLOBAL_OPT_OUT
     */
    @JsonSetter("action")
    public void setAction (ActionEnum value) { 
        this.action = value;
    }
 
    /** GETTER
     * Delivery options for this asynchronous report.
     */
    @JsonGetter("delivery_options")
    public List<DeliveryOptionsBody> getDeliveryOptions ( ) { 
        return this.deliveryOptions;
    }
    
    /** SETTER
     * Delivery options for this asynchronous report.
     */
    @JsonSetter("delivery_options")
    public void setDeliveryOptions (List<DeliveryOptionsBody> value) { 
        this.deliveryOptions = value;
    }
 
}
