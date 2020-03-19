package com.messagemedia.api.models;

import java.util.*;

public class BarcodeDisplayValueBuilder {
    //the instance to build
    private BarcodeDisplayValue barcodeDisplayValue;

    /**
     * Default constructor to initialize the instance
     */
    public BarcodeDisplayValueBuilder() {
        barcodeDisplayValue = new BarcodeDisplayValue();
    }

    public BarcodeDisplayValueBuilder type(String type) {
        barcodeDisplayValue.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public BarcodeDisplayValue build() {
        return barcodeDisplayValue;
    }
}