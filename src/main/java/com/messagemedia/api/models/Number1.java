package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.messagemedia.api.DateTimeHelper;
import org.joda.time.DateTime;

@JsonInclude(Include.ALWAYS)
public class Number1 
        implements java.io.Serializable {
    private static final long serialVersionUID = 8275577548853110761L;
    private DateTime availableAfter;
    private List<CapabilityEnum> capabilities;
    private ClassificationEnum classification;
    private String country;
    private String id;
    private String phoneNumber;
    private Type1Enum type;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("available_after")
    @JsonSerialize(using=DateTimeHelper.Rfc8601DateTimeSerializer.class)
    public DateTime getAvailableAfter ( ) { 
        return this.availableAfter;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("available_after")
    @JsonDeserialize(using=DateTimeHelper.Rfc8601DateTimeDeserializer.class)
    public void setAvailableAfter (DateTime value) { 
        this.availableAfter = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("capabilities")
    public List<CapabilityEnum> getCapabilities ( ) { 
        return this.capabilities;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("capabilities")
    public void setCapabilities (List<CapabilityEnum> value) { 
        this.capabilities = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("classification")
    public ClassificationEnum getClassification ( ) { 
        return this.classification;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("classification")
    public void setClassification (ClassificationEnum value) { 
        this.classification = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("country")
    public String getCountry ( ) { 
        return this.country;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("country")
    public void setCountry (String value) { 
        this.country = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("id")
    public String getId ( ) { 
        return this.id;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("id")
    public void setId (String value) { 
        this.id = value;
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
    public Type1Enum getType ( ) { 
        return this.type;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("type")
    public void setType (Type1Enum value) { 
        this.type = value;
    }
 
}
