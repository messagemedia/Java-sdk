package com.messagemedia.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public enum GroupByEnum {
    DAY, //TODO: Write general description for this element
    DESTINATION_ADDRESS, //TODO: Write general description for this element
    DESTINATION_ADDRESS_COUNTRY, //TODO: Write general description for this element
    FORMAT, //TODO: Write general description for this element
    HOUR, //TODO: Write general description for this element
    METADATA_KEY, //TODO: Write general description for this element
    METADATA_VALUE, //TODO: Write general description for this element
    MINUTE, //TODO: Write general description for this element
    MONTH, //TODO: Write general description for this element
    SOURCE_ADDRESS, //TODO: Write general description for this element
    SOURCE_ADDRESS_COUNTRY, //TODO: Write general description for this element
    STATUS, //TODO: Write general description for this element
    STATUS_CODE, //TODO: Write general description for this element
    YEAR, //TODO: Write general description for this element
    ACCOUNT; //TODO: Write general description for this element

    private static TreeMap<String, GroupByEnum> valueMap = new TreeMap<String, GroupByEnum>();
    private String value;

    static {
        DAY.value = "DAY";
        DESTINATION_ADDRESS.value = "DESTINATION_ADDRESS";
        DESTINATION_ADDRESS_COUNTRY.value = "DESTINATION_ADDRESS_COUNTRY";
        FORMAT.value = "FORMAT";
        HOUR.value = "HOUR";
        METADATA_KEY.value = "METADATA_KEY";
        METADATA_VALUE.value = "METADATA_VALUE";
        MINUTE.value = "MINUTE";
        MONTH.value = "MONTH";
        SOURCE_ADDRESS.value = "SOURCE_ADDRESS";
        SOURCE_ADDRESS_COUNTRY.value = "SOURCE_ADDRESS_COUNTRY";
        STATUS.value = "STATUS";
        STATUS_CODE.value = "STATUS_CODE";
        YEAR.value = "YEAR";
        ACCOUNT.value = "ACCOUNT";

        valueMap.put("DAY", DAY);
        valueMap.put("DESTINATION_ADDRESS", DESTINATION_ADDRESS);
        valueMap.put("DESTINATION_ADDRESS_COUNTRY", DESTINATION_ADDRESS_COUNTRY);
        valueMap.put("FORMAT", FORMAT);
        valueMap.put("HOUR", HOUR);
        valueMap.put("METADATA_KEY", METADATA_KEY);
        valueMap.put("METADATA_VALUE", METADATA_VALUE);
        valueMap.put("MINUTE", MINUTE);
        valueMap.put("MONTH", MONTH);
        valueMap.put("SOURCE_ADDRESS", SOURCE_ADDRESS);
        valueMap.put("SOURCE_ADDRESS_COUNTRY", SOURCE_ADDRESS_COUNTRY);
        valueMap.put("STATUS", STATUS);
        valueMap.put("STATUS_CODE", STATUS_CODE);
        valueMap.put("YEAR", YEAR);
        valueMap.put("ACCOUNT", ACCOUNT);
    }

    /**
     * Returns the enum member associated with the given string value
     * @return The enum member against the given string value */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static GroupByEnum fromString(String toConvert) {
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
     * Convert list of GroupByEnum values to list of string values
     * @param toConvert The list of GroupByEnum values to convert
     * @return List of representative string values */
    public static List<String> toValue(List<GroupByEnum> toConvert) {
        if(toConvert == null)
            return null;
        List<String> convertedValues = new ArrayList<String>();
        for (GroupByEnum enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
} 