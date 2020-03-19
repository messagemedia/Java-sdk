package com.messagemedia.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public enum SortByEnum {
    ACCOUNT, //TODO: Write general description for this element
    ACTION, //TODO: Write general description for this element
    DESTINATION_ADDRESS, //TODO: Write general description for this element
    DESTINATION_ADDRESS_COUNTRY, //TODO: Write general description for this element
    FORMAT, //TODO: Write general description for this element
    SOURCE_ADDRESS, //TODO: Write general description for this element
    SOURCE_ADDRESS_COUNTRY, //TODO: Write general description for this element
    TIMESTAMP; //TODO: Write general description for this element

    private static TreeMap<String, SortByEnum> valueMap = new TreeMap<String, SortByEnum>();
    private String value;

    static {
        ACCOUNT.value = "ACCOUNT";
        ACTION.value = "ACTION";
        DESTINATION_ADDRESS.value = "DESTINATION_ADDRESS";
        DESTINATION_ADDRESS_COUNTRY.value = "DESTINATION_ADDRESS_COUNTRY";
        FORMAT.value = "FORMAT";
        SOURCE_ADDRESS.value = "SOURCE_ADDRESS";
        SOURCE_ADDRESS_COUNTRY.value = "SOURCE_ADDRESS_COUNTRY";
        TIMESTAMP.value = "TIMESTAMP";

        valueMap.put("ACCOUNT", ACCOUNT);
        valueMap.put("ACTION", ACTION);
        valueMap.put("DESTINATION_ADDRESS", DESTINATION_ADDRESS);
        valueMap.put("DESTINATION_ADDRESS_COUNTRY", DESTINATION_ADDRESS_COUNTRY);
        valueMap.put("FORMAT", FORMAT);
        valueMap.put("SOURCE_ADDRESS", SOURCE_ADDRESS);
        valueMap.put("SOURCE_ADDRESS_COUNTRY", SOURCE_ADDRESS_COUNTRY);
        valueMap.put("TIMESTAMP", TIMESTAMP);
    }

    /**
     * Returns the enum member associated with the given string value
     * @return The enum member against the given string value */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static SortByEnum fromString(String toConvert) {
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
     * Convert list of SortByEnum values to list of string values
     * @param toConvert The list of SortByEnum values to convert
     * @return List of representative string values */
    public static List<String> toValue(List<SortByEnum> toConvert) {
        if(toConvert == null)
            return null;
        List<String> convertedValues = new ArrayList<String>();
        for (SortByEnum enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
} 