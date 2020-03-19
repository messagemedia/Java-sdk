package com.messagemedia.api.models;

import java.util.*;

public class NumbersListResponseBuilder {
    //the instance to build
    private NumbersListResponse numbersListResponse;

    /**
     * Default constructor to initialize the instance
     */
    public NumbersListResponseBuilder() {
        numbersListResponse = new NumbersListResponse();
    }

    public NumbersListResponseBuilder data(List<Number1> data) {
        numbersListResponse.setData(data);
        return this;
    }

    public NumbersListResponseBuilder pagination(Pagination1 pagination) {
        numbersListResponse.setPagination(pagination);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public NumbersListResponse build() {
        return numbersListResponse;
    }
}