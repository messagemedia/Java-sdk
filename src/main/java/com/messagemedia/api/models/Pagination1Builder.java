package com.messagemedia.api.models;

import java.util.*;

public class Pagination1Builder {
    //the instance to build
    private Pagination1 pagination1;

    /**
     * Default constructor to initialize the instance
     */
    public Pagination1Builder() {
        pagination1 = new Pagination1();
    }

    /**
     * The current page of results
     */
    public Pagination1Builder page(Double page) {
        pagination1.setPage(page);
        return this;
    }

    /**
     * The amount of results returned per page
     */
    public Pagination1Builder pageSize(Double pageSize) {
        pagination1.setPageSize(pageSize);
        return this;
    }

    /**
     * The total number of results in the results set
     */
    public Pagination1Builder totalCount(Double totalCount) {
        pagination1.setTotalCount(totalCount);
        return this;
    }

    /**
     * The total number of pages in the results set
     */
    public Pagination1Builder pageCount(Double pageCount) {
        pagination1.setPageCount(pageCount);
        return this;
    }

    /**
     * Link to the next page of results
     */
    public Pagination1Builder nextUri(String nextUri) {
        pagination1.setNextUri(nextUri);
        return this;
    }

    /**
     * Link to the previous page of results
     */
    public Pagination1Builder previousUri(String previousUri) {
        pagination1.setPreviousUri(previousUri);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Pagination1 build() {
        return pagination1;
    }
}