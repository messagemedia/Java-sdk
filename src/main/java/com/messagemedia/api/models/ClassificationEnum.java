package com.messagemedia.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public enum ClassificationEnum {
    BRONZE, //TODO: Write general description for this element
    SILVER, //TODO: Write general description for this element
    GOLD; //TODO: Write general description for this element

    private static TreeMap<String, ClassificationEnum> valueMap = new TreeMap<String, ClassificationEnum>();
    private String value;

    static {
        BRONZE.value = "BRONZE";
        SILVER.value = "SILVER";
        GOLD.value = "GOLD";

        valueMap.put("BRONZE", BRONZE);
        valueMap.put("SILVER", SILVER);
        valueMap.put("GOLD", GOLD);
    }

    /**
     * Returns the enum member associated with the given string value
     * @return The enum member against the given string value */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static ClassificationEnum fromString(String toConvert) {
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
     * Convert list of ClassificationEnum values to list of string values
     * @param toConvert The list of ClassificationEnum values to convert
     * @return List of representative string values */
    public static List<String> toValue(List<ClassificationEnum> toConvert) {
        if(toConvert == null)
            return null;
        List<String> convertedValues = new ArrayList<String>();
        for (ClassificationEnum enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
} 