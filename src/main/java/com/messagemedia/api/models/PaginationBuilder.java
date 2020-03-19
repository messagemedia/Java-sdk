package com.messagemedia.api.models;

import java.util.*;

public class PaginationBuilder {
    //the instance to build
    private Pagination pagination;

    /**
     * Default constructor to initialize the instance
     */
    public PaginationBuilder() {
        pagination = new Pagination();
    }

    /**
     * The pagination token of the next set of results.
     */
    public PaginationBuilder page(String page) {
        pagination.setPage(page);
        return this;
    }

    /**
     * The uri pointing to the next set of results.
     */
    public PaginationBuilder nextUri(String nextUri) {
        pagination.setNextUri(nextUri);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Pagination build() {
        return pagination;
    }
}