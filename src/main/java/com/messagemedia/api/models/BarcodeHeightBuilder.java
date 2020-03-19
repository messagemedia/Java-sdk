package com.messagemedia.api.models;

import java.util.*;

public class BarcodeHeightBuilder {
    //the instance to build
    private BarcodeHeight barcodeHeight;

    /**
     * Default constructor to initialize the instance
     */
    public BarcodeHeightBuilder() {
        barcodeHeight = new BarcodeHeight();
    }

    public BarcodeHeightBuilder type(String type) {
        barcodeHeight.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public BarcodeHeight build() {
        return barcodeHeight;
    }
}