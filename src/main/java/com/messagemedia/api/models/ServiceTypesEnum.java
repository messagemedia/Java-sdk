package com.messagemedia.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public enum ServiceTypesEnum {
    SMS, //TODO: Write general description for this element
    TTS, //TODO: Write general description for this element
    MMS; //TODO: Write general description for this element

    private static TreeMap<String, ServiceTypesEnum> valueMap = new TreeMap<String, ServiceTypesEnum>();
    private String value;

    static {
        SMS.value = "SMS";
        TTS.value = "TTS";
        MMS.value = "MMS";

        valueMap.put("SMS", SMS);
        valueMap.put("TTS", TTS);
        valueMap.put("MMS", MMS);
    }

    /**
     * Returns the enum member associated with the given string value
     * @return The enum member against the given string value */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static ServiceTypesEnum fromString(String toConvert) {
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
     * Convert list of ServiceTypesEnum values to list of string values
     * @param toConvert The list of ServiceTypesEnum values to convert
     * @return List of representative string values */
    public static List<String> toValue(List<ServiceTypesEnum> toConvert) {
        if(toConvert == null)
            return null;
        List<String> convertedValues = new ArrayList<String>();
        for (ServiceTypesEnum enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
} 