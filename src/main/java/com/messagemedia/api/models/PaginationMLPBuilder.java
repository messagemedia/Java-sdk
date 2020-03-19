package com.messagemedia.api.models;

import java.util.*;

public class PaginationMLPBuilder {
    //the instance to build
    private PaginationMLP paginationMLP;

    /**
     * Default constructor to initialize the instance
     */
    public PaginationMLPBuilder() {
        paginationMLP = new PaginationMLP();
    }

    public PaginationMLPBuilder nextPageToken(String nextPageToken) {
        paginationMLP.setNextPageToken(nextPageToken);
        return this;
    }

    public PaginationMLPBuilder pageSize(int pageSize) {
        paginationMLP.setPageSize(pageSize);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public PaginationMLP build() {
        return paginationMLP;
    }
}