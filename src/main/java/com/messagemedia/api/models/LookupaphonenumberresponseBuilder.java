package com.messagemedia.api.models;

import java.util.*;

public class LookupaphonenumberresponseBuilder {
    //the instance to build
    private Lookupaphonenumberresponse lookupaphonenumberresponse;

    /**
     * Default constructor to initialize the instance
     */
    public LookupaphonenumberresponseBuilder() {
        lookupaphonenumberresponse = new Lookupaphonenumberresponse();
    }

    public LookupaphonenumberresponseBuilder countryCode(String countryCode) {
        lookupaphonenumberresponse.setCountryCode(countryCode);
        return this;
    }

    public LookupaphonenumberresponseBuilder phoneNumber(String phoneNumber) {
        lookupaphonenumberresponse.setPhoneNumber(phoneNumber);
        return this;
    }

    public LookupaphonenumberresponseBuilder type(String type) {
        lookupaphonenumberresponse.setType(type);
        return this;
    }

    public LookupaphonenumberresponseBuilder carrier(Carrier carrier) {
        lookupaphonenumberresponse.setCarrier(carrier);
        return this;
    }

    public LookupaphonenumberresponseBuilder result(String result) {
        lookupaphonenumberresponse.setResult(result);
        return this;
    }

    /**
     * A unique number identifying a GSM subscriber
     */
    public LookupaphonenumberresponseBuilder imsi(long imsi) {
        lookupaphonenumberresponse.setImsi(imsi);
        return this;
    }

    /**
     * The location of the mobile number
     */
    public LookupaphonenumberresponseBuilder location(int location) {
        lookupaphonenumberresponse.setLocation(location);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Lookupaphonenumberresponse build() {
        return lookupaphonenumberresponse;
    }
}