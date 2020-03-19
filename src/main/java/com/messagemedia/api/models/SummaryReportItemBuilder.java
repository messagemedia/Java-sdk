package com.messagemedia.api.models;

import java.util.*;

public class SummaryReportItemBuilder {
    //the instance to build
    private SummaryReportItem summaryReportItem;

    /**
     * Default constructor to initialize the instance
     */
    public SummaryReportItemBuilder() {
        summaryReportItem = new SummaryReportItem();
    }

    public SummaryReportItemBuilder group(String group) {
        summaryReportItem.setGroup(group);
        return this;
    }

    public SummaryReportItemBuilder value(Double value) {
        summaryReportItem.setValue(value);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public SummaryReportItem build() {
        return summaryReportItem;
    }
}