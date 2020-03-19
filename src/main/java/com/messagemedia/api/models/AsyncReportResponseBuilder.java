package com.messagemedia.api.models;

import java.util.*;

public class AsyncReportResponseBuilder {
    //the instance to build
    private AsyncReportResponse asyncReportResponse;

    /**
     * Default constructor to initialize the instance
     */
    public AsyncReportResponseBuilder() {
        asyncReportResponse = new AsyncReportResponse();
    }

    /**
     * The identifier for this async report
     */
    public AsyncReportResponseBuilder id(String id) {
        asyncReportResponse.setId(id);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public AsyncReportResponse build() {
        return asyncReportResponse;
    }
}