package com.messagemedia.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public enum PeriodEnum {
    TODAY, //TODO: Write general description for this element
    YESTERDAY, //TODO: Write general description for this element
    THIS_WEEK, //TODO: Write general description for this element
    LAST_WEEK, //TODO: Write general description for this element
    THIS_MONTH, //TODO: Write general description for this element
    LAST_MONTH, //TODO: Write general description for this element
    LAST_7_DAYS, //TODO: Write general description for this element
    LAST_30_DAYS; //TODO: Write general description for this element

    private static TreeMap<String, PeriodEnum> valueMap = new TreeMap<String, PeriodEnum>();
    private String value;

    static {
        TODAY.value = "TODAY";
        YESTERDAY.value = "YESTERDAY";
        THIS_WEEK.value = "THIS_WEEK";
        LAST_WEEK.value = "LAST_WEEK";
        THIS_MONTH.value = "THIS_MONTH";
        LAST_MONTH.value = "LAST_MONTH";
        LAST_7_DAYS.value = "LAST_7_DAYS";
        LAST_30_DAYS.value = "LAST_30_DAYS";

        valueMap.put("TODAY", TODAY);
        valueMap.put("YESTERDAY", YESTERDAY);
        valueMap.put("THIS_WEEK", THIS_WEEK);
        valueMap.put("LAST_WEEK", LAST_WEEK);
        valueMap.put("THIS_MONTH", THIS_MONTH);
        valueMap.put("LAST_MONTH", LAST_MONTH);
        valueMap.put("LAST_7_DAYS", LAST_7_DAYS);
        valueMap.put("LAST_30_DAYS", LAST_30_DAYS);
    }

    /**
     * Returns the enum member associated with the given string value
     * @return The enum member against the given string value */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static PeriodEnum fromString(String toConvert) {
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
     * Convert list of PeriodEnum values to list of string values
     * @param toConvert The list of PeriodEnum values to convert
     * @return List of representative string values */
    public static List<String> toValue(List<PeriodEnum> toConvert) {
        if(toConvert == null)
            return null;
        List<String> convertedValues = new ArrayList<String>();
        for (PeriodEnum enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
} 