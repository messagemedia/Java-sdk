package com.messagemedia.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public enum ReportStatusEnum {
    REQUESTED, //TODO: Write general description for this element
    RUNNING, //TODO: Write general description for this element
    CANCELLED, //TODO: Write general description for this element
    DONE; //TODO: Write general description for this element

    private static TreeMap<String, ReportStatusEnum> valueMap = new TreeMap<String, ReportStatusEnum>();
    private String value;

    static {
        REQUESTED.value = "REQUESTED";
        RUNNING.value = "RUNNING";
        CANCELLED.value = "CANCELLED";
        DONE.value = "DONE";

        valueMap.put("REQUESTED", REQUESTED);
        valueMap.put("RUNNING", RUNNING);
        valueMap.put("CANCELLED", CANCELLED);
        valueMap.put("DONE", DONE);
    }

    /**
     * Returns the enum member associated with the given string value
     * @return The enum member against the given string value */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static ReportStatusEnum fromString(String toConvert) {
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
     * Convert list of ReportStatusEnum values to list of string values
     * @param toConvert The list of ReportStatusEnum values to convert
     * @return List of representative string values */
    public static List<String> toValue(List<ReportStatusEnum> toConvert) {
        if(toConvert == null)
            return null;
        List<String> convertedValues = new ArrayList<String>();
        for (ReportStatusEnum enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
} 