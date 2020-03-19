package com.messagemedia.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public enum FieldEnum {
    ACCOUNT, //TODO: Write general description for this element
    DELIVERED_TIMESTAMP, //TODO: Write general description for this element
    MESSAGE_EXPIRY_TIMESTAMP, //TODO: Write general description for this element
    DELIVERY_REPORT, //TODO: Write general description for this element
    DESTINATION_ADDRESS, //TODO: Write general description for this element
    DESTINATION_ADDRESS_COUNTRY, //TODO: Write general description for this element
    FORMAT, //TODO: Write general description for this element
    SOURCE_ADDRESS, //TODO: Write general description for this element
    SOURCE_ADDRESS_COUNTRY, //TODO: Write general description for this element
    STATUS, //TODO: Write general description for this element
    STATUS_CODE, //TODO: Write general description for this element
    UNITS, //TODO: Write general description for this element
    TIMESTAMP; //TODO: Write general description for this element

    private static TreeMap<String, FieldEnum> valueMap = new TreeMap<String, FieldEnum>();
    private String value;

    static {
        ACCOUNT.value = "ACCOUNT";
        DELIVERED_TIMESTAMP.value = "DELIVERED_TIMESTAMP";
        MESSAGE_EXPIRY_TIMESTAMP.value = "MESSAGE_EXPIRY_TIMESTAMP";
        DELIVERY_REPORT.value = "DELIVERY_REPORT";
        DESTINATION_ADDRESS.value = "DESTINATION_ADDRESS";
        DESTINATION_ADDRESS_COUNTRY.value = "DESTINATION_ADDRESS_COUNTRY";
        FORMAT.value = "FORMAT";
        SOURCE_ADDRESS.value = "SOURCE_ADDRESS";
        SOURCE_ADDRESS_COUNTRY.value = "SOURCE_ADDRESS_COUNTRY";
        STATUS.value = "STATUS";
        STATUS_CODE.value = "STATUS_CODE";
        UNITS.value = "UNITS";
        TIMESTAMP.value = "TIMESTAMP";

        valueMap.put("ACCOUNT", ACCOUNT);
        valueMap.put("DELIVERED_TIMESTAMP", DELIVERED_TIMESTAMP);
        valueMap.put("MESSAGE_EXPIRY_TIMESTAMP", MESSAGE_EXPIRY_TIMESTAMP);
        valueMap.put("DELIVERY_REPORT", DELIVERY_REPORT);
        valueMap.put("DESTINATION_ADDRESS", DESTINATION_ADDRESS);
        valueMap.put("DESTINATION_ADDRESS_COUNTRY", DESTINATION_ADDRESS_COUNTRY);
        valueMap.put("FORMAT", FORMAT);
        valueMap.put("SOURCE_ADDRESS", SOURCE_ADDRESS);
        valueMap.put("SOURCE_ADDRESS_COUNTRY", SOURCE_ADDRESS_COUNTRY);
        valueMap.put("STATUS", STATUS);
        valueMap.put("STATUS_CODE", STATUS_CODE);
        valueMap.put("UNITS", UNITS);
        valueMap.put("TIMESTAMP", TIMESTAMP);
    }

    /**
     * Returns the enum member associated with the given string value
     * @return The enum member against the given string value */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static FieldEnum fromString(String toConvert) {
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
     * Convert list of FieldEnum values to list of string values
     * @param toConvert The list of FieldEnum values to convert
     * @return List of representative string values */
    public static List<String> toValue(List<FieldEnum> toConvert) {
        if(toConvert == null)
            return null;
        List<String> convertedValues = new ArrayList<String>();
        for (FieldEnum enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
} 