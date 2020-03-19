package com.messagemedia.api.models;

import java.util.*;
import org.joda.time.DateTime;

public class Number1Builder {
    //the instance to build
    private Number1 number1;

    /**
     * Default constructor to initialize the instance
     */
    public Number1Builder() {
        number1 = new Number1();
    }

    public Number1Builder availableAfter(DateTime availableAfter) {
        number1.setAvailableAfter(availableAfter);
        return this;
    }

    public Number1Builder capabilities(List<CapabilityEnum> capabilities) {
        number1.setCapabilities(capabilities);
        return this;
    }

    public Number1Builder classification(ClassificationEnum classification) {
        number1.setClassification(classification);
        return this;
    }

    public Number1Builder country(String country) {
        number1.setCountry(country);
        return this;
    }

    public Number1Builder id(String id) {
        number1.setId(id);
        return this;
    }

    public Number1Builder phoneNumber(String phoneNumber) {
        number1.setPhoneNumber(phoneNumber);
        return this;
    }

    public Number1Builder type(Type1Enum type) {
        number1.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Number1 build() {
        return number1;
    }
}