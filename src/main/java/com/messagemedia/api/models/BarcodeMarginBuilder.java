package com.messagemedia.api.models;

import java.util.*;

public class BarcodeMarginBuilder {
    //the instance to build
    private BarcodeMargin barcodeMargin;

    /**
     * Default constructor to initialize the instance
     */
    public BarcodeMarginBuilder() {
        barcodeMargin = new BarcodeMargin();
    }

    public BarcodeMarginBuilder type(String type) {
        barcodeMargin.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public BarcodeMargin build() {
        return barcodeMargin;
    }
}