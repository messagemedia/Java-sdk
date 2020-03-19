package com.messagemedia.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public enum SummaryEnum {
    COUNT, //TODO: Write general description for this element
    SUM; //TODO: Write general description for this element

    private static TreeMap<String, SummaryEnum> valueMap = new TreeMap<String, SummaryEnum>();
    private String value;

    static {
        COUNT.value = "COUNT";
        SUM.value = "SUM";

        valueMap.put("COUNT", COUNT);
        valueMap.put("SUM", SUM);
    }

    /**
     * Returns the enum member associated with the given string value
     * @return The enum member against the given string value */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static SummaryEnum fromString(String toConvert) {
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
     * Convert list of SummaryEnum values to list of string values
     * @param toConvert The list of SummaryEnum values to convert
     * @return List of representative string values */
    public static List<String> toValue(List<SummaryEnum> toConvert) {
        if(toConvert == null)
            return null;
        List<String> convertedValues = new ArrayList<String>();
        for (SummaryEnum enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
} 