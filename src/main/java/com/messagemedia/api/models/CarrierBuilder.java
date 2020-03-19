package com.messagemedia.api.models;

import java.util.*;

public class CarrierBuilder {
    //the instance to build
    private Carrier carrier;

    /**
     * Default constructor to initialize the instance
     */
    public CarrierBuilder() {
        carrier = new Carrier();
    }

    public CarrierBuilder name(String name) {
        carrier.setName(name);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Carrier build() {
        return carrier;
    }
}