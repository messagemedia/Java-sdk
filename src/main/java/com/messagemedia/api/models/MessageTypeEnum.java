package com.messagemedia.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public enum MessageTypeEnum {
    SENT_MESSAGES, //TODO: Write general description for this element
    RECEIVED_MESSAGES; //TODO: Write general description for this element

    private static TreeMap<String, MessageTypeEnum> valueMap = new TreeMap<String, MessageTypeEnum>();
    private String value;

    static {
        SENT_MESSAGES.value = "SENT_MESSAGES";
        RECEIVED_MESSAGES.value = "RECEIVED_MESSAGES";

        valueMap.put("SENT_MESSAGES", SENT_MESSAGES);
        valueMap.put("RECEIVED_MESSAGES", RECEIVED_MESSAGES);
    }

    /**
     * Returns the enum member associated with the given string value
     * @return The enum member against the given string value */
    @com.fasterxml.jackson.annotation.JsonCreator
    public static MessageTypeEnum fromString(String toConvert) {
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
     * Convert list of MessageTypeEnum values to list of string values
     * @param toConvert The list of MessageTypeEnum values to convert
     * @return List of representative string values */
    public static List<String> toValue(List<MessageTypeEnum> toConvert) {
        if(toConvert == null)
            return null;
        List<String> convertedValues = new ArrayList<String>();
        for (MessageTypeEnum enumValue : toConvert) {
            convertedValues.add(enumValue.value);
        }
        return convertedValues;
    }
} 