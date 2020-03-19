package com.messagemedia.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public enum SummaryFieldEnum {
    UNITS, //TODO: Write general description for this element
    MESSAGE_ID; //TODO: Write general description for this element

    private static TreeMap<String, SummaryFieldEnum> valueMap = new TreeMap<String, SummaryFieldEnum>();
    private String value;

    static {
        UNITS.value = "UNITS";
        MESSAGE_ID.value = "MESSAGE_ID";

        valueMap.put("UNITS", UNITS);
        valueMap.put("MESSAGE_ID", MESSAGE_ID);
    }

    /**
     * Returns the enum member associated with the given string value
     * @return The enum member against the given string value */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static SummaryFieldEnum fromString(String toConvert) {
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
     * Convert list of SummaryFieldEnum values to list of string values
     * @param toConvert The list of SummaryFieldEnum values to convert
     * @return List of representative string values */
    public static List<String> toValue(List<SummaryFieldEnum> toConvert) {
        if(toConvert == null)
            return null;
        List<String> convertedValues = new ArrayList<String>();
        for (SummaryFieldEnum enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
} 