package com.messagemedia.api.models;

import java.util.*;

public class GetAsyncReportsResponseBuilder {
    //the instance to build
    private GetAsyncReportsResponse getAsyncReportsResponse;

    /**
     * Default constructor to initialize the instance
     */
    public GetAsyncReportsResponseBuilder() {
        getAsyncReportsResponse = new GetAsyncReportsResponse();
    }

    /**
     * List of asynchronous reports
     */
    public GetAsyncReportsResponseBuilder data(List<AsyncReport> data) {
        getAsyncReportsResponse.setData(data);
        return this;
    }

    public GetAsyncReportsResponseBuilder pagination(Pagination1 pagination) {
        getAsyncReportsResponse.setPagination(pagination);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public GetAsyncReportsResponse build() {
        return getAsyncReportsResponse;
    }
}