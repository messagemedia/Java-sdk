package com.messagemedia.api.models;

import java.util.*;

public class AssignedNumberListResponseBuilder {
    //the instance to build
    private AssignedNumberListResponse assignedNumberListResponse;

    /**
     * Default constructor to initialize the instance
     */
    public AssignedNumberListResponseBuilder() {
        assignedNumberListResponse = new AssignedNumberListResponse();
    }

    public AssignedNumberListResponseBuilder data(List<AssignedNumber> data) {
        assignedNumberListResponse.setData(data);
        return this;
    }

    public AssignedNumberListResponseBuilder pagination(Pagination1 pagination) {
        assignedNumberListResponse.setPagination(pagination);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public AssignedNumberListResponse build() {
        return assignedNumberListResponse;
    }
}