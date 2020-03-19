package com.messagemedia.api.models;

import java.util.*;

public class SummaryReportBuilder {
    //the instance to build
    private SummaryReport summaryReport;

    /**
     * Default constructor to initialize the instance
     */
    public SummaryReportBuilder() {
        summaryReport = new SummaryReport();
    }

    public SummaryReportBuilder properties(Properties33 properties) {
        summaryReport.setProperties(properties);
        return this;
    }

    public SummaryReportBuilder data(List<SummaryReportItem> data) {
        summaryReport.setData(data);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public SummaryReport build() {
        return summaryReport;
    }
}