package com.messagemedia.api.models;

import java.util.*;

public class MetadataKeysResponseBuilder {
    //the instance to build
    private MetadataKeysResponse metadataKeysResponse;

    /**
     * Default constructor to initialize the instance
     */
    public MetadataKeysResponseBuilder() {
        metadataKeysResponse = new MetadataKeysResponse();
    }

    public MetadataKeysResponseBuilder data(List<String> data) {
        metadataKeysResponse.setData(data);
        return this;
    }

    public MetadataKeysResponseBuilder properties(Properties properties) {
        metadataKeysResponse.setProperties(properties);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public MetadataKeysResponse build() {
        return metadataKeysResponse;
    }
}