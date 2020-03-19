package com.messagemedia.api.models;

import java.util.*;

public class SortingBuilder {
    //the instance to build
    private Sorting sorting;

    /**
     * Default constructor to initialize the instance
     */
    public SortingBuilder() {
        sorting = new Sorting();
    }

    /**
     * The value of the sort_by field provided for this report
     */
    public SortingBuilder field(FieldEnum field) {
        sorting.setField(field);
        return this;
    }

    /**
     * The value of the sort_direction field provided for this report
     */
    public SortingBuilder order(OrderEnum order) {
        sorting.setOrder(order);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Sorting build() {
        return sorting;
    }
}