package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Lookupaphonenumberresponse 
        implements java.io.Serializable {
    private static final long serialVersionUID = 2599660256429772429L;
    private String countryCode;
    private String phoneNumber;
    private String type;
    private Carrier carrier;
    private String result;
    private long imsi;
    private int location;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("country_code")
    public String getCountryCode ( ) { 
        return this.countryCode;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("country_code")
    public void setCountryCode (String value) { 
        this.countryCode = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("phone_number")
    public String getPhoneNumber ( ) { 
        return this.phoneNumber;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("phone_number")
    public void setPhoneNumber (String value) { 
        this.phoneNumber = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("type")
    public String getType ( ) { 
        return this.type;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("type")
    public void setType (String value) { 
        this.type = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("carrier")
    public Carrier getCarrier ( ) { 
        return this.carrier;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("carrier")
    public void setCarrier (Carrier value) { 
        this.carrier = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("result")
    public String getResult ( ) { 
        return this.result;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("result")
    public void setResult (String value) { 
        this.result = value;
    }
 
    /** GETTER
     * A unique number identifying a GSM subscriber
     */
    @JsonGetter("imsi")
    public long getImsi ( ) { 
        return this.imsi;
    }
    
    /** SETTER
     * A unique number identifying a GSM subscriber
     */
    @JsonSetter("imsi")
    public void setImsi (long value) { 
        this.imsi = value;
    }
 
    /** GETTER
     * The location of the mobile number
     */
    @JsonGetter("location")
    public int getLocation ( ) { 
        return this.location;
    }
    
    /** SETTER
     * The location of the mobile number
     */
    @JsonSetter("location")
    public void setLocation (int value) { 
        this.location = value;
    }
 
}
