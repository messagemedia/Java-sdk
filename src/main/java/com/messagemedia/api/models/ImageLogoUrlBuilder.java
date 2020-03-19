package com.messagemedia.api.models;

import java.util.*;

public class ImageLogoUrlBuilder {
    //the instance to build
    private ImageLogoUrl imageLogoUrl;

    /**
     * Default constructor to initialize the instance
     */
    public ImageLogoUrlBuilder() {
        imageLogoUrl = new ImageLogoUrl();
    }

    public ImageLogoUrlBuilder type(String type) {
        imageLogoUrl.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public ImageLogoUrl build() {
        return imageLogoUrl;
    }
}