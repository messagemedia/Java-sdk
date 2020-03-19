package com.messagemedia.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public enum Status1Enum {
    CANCELLED, //TODO: Write general description for this element
    DELIVERED, //TODO: Write general description for this element
    ENROUTE, //TODO: Write general description for this element
    EXPIRED, //TODO: Write general description for this element
    HELD, //TODO: Write general description for this element
    PROCESSED, //TODO: Write general description for this element
    PROCESSING, //TODO: Write general description for this element
    QUEUED, //TODO: Write general description for this element
    REJECTED, //TODO: Write general description for this element
    SCHEDULED, //TODO: Write general description for this element
    SUBMITTED; //TODO: Write general description for this element

    private static TreeMap<String, Status1Enum> valueMap = new TreeMap<String, Status1Enum>();
    private String value;

    static {
        CANCELLED.value = "CANCELLED";
        DELIVERED.value = "DELIVERED";
        ENROUTE.value = "ENROUTE";
        EXPIRED.value = "EXPIRED";
        HELD.value = "HELD";
        PROCESSED.value = "PROCESSED";
        PROCESSING.value = "PROCESSING";
        QUEUED.value = "QUEUED";
        REJECTED.value = "REJECTED";
        SCHEDULED.value = "SCHEDULED";
        SUBMITTED.value = "SUBMITTED";

        valueMap.put("CANCELLED", CANCELLED);
        valueMap.put("DELIVERED", DELIVERED);
        valueMap.put("ENROUTE", ENROUTE);
        valueMap.put("EXPIRED", EXPIRED);
        valueMap.put("HELD", HELD);
        valueMap.put("PROCESSED", PROCESSED);
        valueMap.put("PROCESSING", PROCESSING);
        valueMap.put("QUEUED", QUEUED);
        valueMap.put("REJECTED", REJECTED);
        valueMap.put("SCHEDULED", SCHEDULED);
        valueMap.put("SUBMITTED", SUBMITTED);
    }

    /**
     * Returns the enum member associated with the given string value
     * @return The enum member against the given string value */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static Status1Enum fromString(String toConvert) {
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
     * Convert list of Status1Enum values to list of string values
     * @param toConvert The list of Status1Enum values to convert
     * @return List of representative string values */
    public static List<String> toValue(List<Status1Enum> toConvert) {
        if(toConvert == null)
            return null;
        List<String> convertedValues = new ArrayList<String>();
        for (Status1Enum enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
} 