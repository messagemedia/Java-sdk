package com.messagemedia.api.models;

import java.util.*;

public class Pagination2Builder {
    //the instance to build
    private Pagination2 pagination2;

    /**
     * Default constructor to initialize the instance
     */
    public Pagination2Builder() {
        pagination2 = new Pagination2();
    }

    /**
     * The current page number
     */
    public Pagination2Builder page(double page) {
        pagination2.setPage(page);
        return this;
    }

    /**
     * The requested page size
     */
    public Pagination2Builder pageSize(double pageSize) {
        pagination2.setPageSize(pageSize);
        return this;
    }

    /**
     * The total number of items that match the query
     */
    public Pagination2Builder totalCount(double totalCount) {
        pagination2.setTotalCount(totalCount);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Pagination2 build() {
        return pagination2;
    }
}