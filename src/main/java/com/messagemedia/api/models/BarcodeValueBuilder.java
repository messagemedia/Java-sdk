package com.messagemedia.api.models;

import java.util.*;

public class BarcodeValueBuilder {
    //the instance to build
    private BarcodeValue barcodeValue;

    /**
     * Default constructor to initialize the instance
     */
    public BarcodeValueBuilder() {
        barcodeValue = new BarcodeValue();
    }

    public BarcodeValueBuilder type(String type) {
        barcodeValue.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public BarcodeValue build() {
        return barcodeValue;
    }
}