package com.messagemedia.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public enum Type1Enum {
    MOBILE, //TODO: Write general description for this element
    LANDLINE, //TODO: Write general description for this element
    TOLL_FREE, //TODO: Write general description for this element
    SHORT_CODE; //TODO: Write general description for this element

    private static TreeMap<String, Type1Enum> valueMap = new TreeMap<String, Type1Enum>();
    private String value;

    static {
        MOBILE.value = "MOBILE";
        LANDLINE.value = "LANDLINE";
        TOLL_FREE.value = "TOLL_FREE";
        SHORT_CODE.value = "SHORT_CODE";

        valueMap.put("MOBILE", MOBILE);
        valueMap.put("LANDLINE", LANDLINE);
        valueMap.put("TOLL_FREE", TOLL_FREE);
        valueMap.put("SHORT_CODE", SHORT_CODE);
    }

    /**
     * Returns the enum member associated with the given string value
     * @return The enum member against the given string value */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static Type1Enum fromString(String toConvert) {
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
     * Convert list of Type1Enum values to list of string values
     * @param toConvert The list of Type1Enum values to convert
     * @return List of representative string values */
    public static List<String> toValue(List<Type1Enum> toConvert) {
        if(toConvert == null)
            return null;
        List<String> convertedValues = new ArrayList<String>();
        for (Type1Enum enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
} 