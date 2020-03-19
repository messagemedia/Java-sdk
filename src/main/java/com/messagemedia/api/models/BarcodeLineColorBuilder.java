package com.messagemedia.api.models;

import java.util.*;

public class BarcodeLineColorBuilder {
    //the instance to build
    private BarcodeLineColor barcodeLineColor;

    /**
     * Default constructor to initialize the instance
     */
    public BarcodeLineColorBuilder() {
        barcodeLineColor = new BarcodeLineColor();
    }

    public BarcodeLineColorBuilder type(String type) {
        barcodeLineColor.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public BarcodeLineColor build() {
        return barcodeLineColor;
    }
}