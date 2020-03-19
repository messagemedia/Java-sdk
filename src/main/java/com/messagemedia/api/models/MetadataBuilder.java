package com.messagemedia.api.models;

import java.util.*;

public class MetadataBuilder {
    //the instance to build
    private Metadata metadata;

    /**
     * Default constructor to initialize the instance
     */
    public MetadataBuilder() {
        metadata = new Metadata();
    }

    public MetadataBuilder key(String key) {
        metadata.setKey(key);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Metadata build() {
        return metadata;
    }
}