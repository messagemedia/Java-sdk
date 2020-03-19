package com.messagemedia.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public enum OrderEnum {
    ASCENDING, //TODO: Write general description for this element
    DESCENDING; //TODO: Write general description for this element

    private static TreeMap<String, OrderEnum> valueMap = new TreeMap<String, OrderEnum>();
    private String value;

    static {
        ASCENDING.value = "ASCENDING";
        DESCENDING.value = "DESCENDING";

        valueMap.put("ASCENDING", ASCENDING);
        valueMap.put("DESCENDING", DESCENDING);
    }

    /**
     * Returns the enum member associated with the given string value
     * @return The enum member against the given string value */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static OrderEnum fromString(String toConvert) {
        return valueMap.get(toConvert);
    }

    /**
     * Returns the string value associated with the enum member
     * @return The string value against enum member */
    @com.fasterxml.jackson.annotation.JsonValue
    public String value() {
        return value;
    }
        
    /**
     * Get string representation of this enum
     */
    @Override
    public String toString() {
        return value.toString();
    }

    /**
     * Convert list of OrderEnum values to list of string values
     * @param toConvert The list of OrderEnum values to convert
     * @return List of representative string values */
    public static List<String> toValue(List<OrderEnum> toConvert) {
        if(toConvert == null)
            return null;
        List<String> convertedValues = new ArrayList<String>();
        for (OrderEnum enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
} 