package com.messagemedia.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public enum ActionEnum {
    MYACCOUNT001, //TODO: Write general description for this element
    OPT_OUT, //TODO: Write general description for this element
    OPT_IN, //TODO: Write general description for this element
    GLOBAL_OPT_OUT; //TODO: Write general description for this element

    private static TreeMap<String, ActionEnum> valueMap = new TreeMap<String, ActionEnum>();
    private String value;

    static {
        MYACCOUNT001.value = "MyAccount001";
        OPT_OUT.value = "OPT_OUT";
        OPT_IN.value = "OPT_IN";
        GLOBAL_OPT_OUT.value = "GLOBAL_OPT_OUT";

        valueMap.put("MyAccount001", MYACCOUNT001);
        valueMap.put("OPT_OUT", OPT_OUT);
        valueMap.put("OPT_IN", OPT_IN);
        valueMap.put("GLOBAL_OPT_OUT", GLOBAL_OPT_OUT);
    }

    /**
     * Returns the enum member associated with the given string value
     * @return The enum member against the given string value */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static ActionEnum fromString(String toConvert) {
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
     * Convert list of ActionEnum values to list of string values
     * @param toConvert The list of ActionEnum values to convert
     * @return List of representative string values */
    public static List<String> toValue(List<ActionEnum> toConvert) {
        if(toConvert == null)
            return null;
        List<String> convertedValues = new ArrayList<String>();
        for (ActionEnum enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
} 