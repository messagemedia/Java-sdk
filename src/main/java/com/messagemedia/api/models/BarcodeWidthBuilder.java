package com.messagemedia.api.models;

import java.util.*;

public class BarcodeWidthBuilder {
    //the instance to build
    private BarcodeWidth barcodeWidth;

    /**
     * Default constructor to initialize the instance
     */
    public BarcodeWidthBuilder() {
        barcodeWidth = new BarcodeWidth();
    }

    public BarcodeWidthBuilder type(String type) {
        barcodeWidth.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public BarcodeWidth build() {
        return barcodeWidth;
    }
}