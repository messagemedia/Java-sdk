package com.messagemedia.api.models;

import java.util.*;

public class ImageHeaderUrlBuilder {
    //the instance to build
    private ImageHeaderUrl imageHeaderUrl;

    /**
     * Default constructor to initialize the instance
     */
    public ImageHeaderUrlBuilder() {
        imageHeaderUrl = new ImageHeaderUrl();
    }

    public ImageHeaderUrlBuilder type(String type) {
        imageHeaderUrl.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public ImageHeaderUrl build() {
        return imageHeaderUrl;
    }
}