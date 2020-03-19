package com.messagemedia.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Sorting 
        implements java.io.Serializable {
    private static final long serialVersionUID = -50442868059873908L;
    private FieldEnum field;
    private OrderEnum order;
    /** GETTER
     * The value of the sort_by field provided for this report
     */
    @JsonGetter("field")
    public FieldEnum getField ( ) { 
        return this.field;
    }
    
    /** SETTER
     * The value of the sort_by field provided for this report
     */
    @JsonSetter("field")
    public void setField (FieldEnum value) { 
        this.field = value;
    }
 
    /** GETTER
     * The value of the sort_direction field provided for this report
     */
    @JsonGetter("order")
    public OrderEnum getOrder ( ) { 
        return this.order;
    }
    
    /** SETTER
     * The value of the sort_direction field provided for this report
     */
    @JsonSetter("order")
    public void setOrder (OrderEnum value) { 
        this.order = value;
    }
 
}
