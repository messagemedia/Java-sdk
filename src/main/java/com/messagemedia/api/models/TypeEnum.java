package com.messagemedia.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public enum TypeEnum {
    SUMMARY, //TODO: Write general description for this element
    DETAIL; //TODO: Write general description for this element

    private static TreeMap<String, TypeEnum> valueMap = new TreeMap<String, TypeEnum>();
    private String value;

    static {
        SUMMARY.value = "SUMMARY";
        DETAIL.value = "DETAIL";

        valueMap.put("SUMMARY", SUMMARY);
        valueMap.put("DETAIL", DETAIL);
    }

    /**
     * Returns the enum member associated with the given string value
     * @return The enum member against the given string value */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static TypeEnum fromString(String toConvert) {
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
     * Convert list of TypeEnum values to list of string values
     * @param toConvert The list of TypeEnum values to convert
     * @return List of representative string values */
    public static List<String> toValue(List<TypeEnum> toConvert) {
        if(toConvert == null)
            return null;
        List<String> convertedValues = new ArrayList<String>();
        for (TypeEnum enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
} 