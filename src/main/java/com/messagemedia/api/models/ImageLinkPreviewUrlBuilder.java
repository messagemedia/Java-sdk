package com.messagemedia.api.models;

import java.util.*;

public class ImageLinkPreviewUrlBuilder {
    //the instance to build
    private ImageLinkPreviewUrl imageLinkPreviewUrl;

    /**
     * Default constructor to initialize the instance
     */
    public ImageLinkPreviewUrlBuilder() {
        imageLinkPreviewUrl = new ImageLinkPreviewUrl();
    }

    public ImageLinkPreviewUrlBuilder type(String type) {
        imageLinkPreviewUrl.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public ImageLinkPreviewUrl build() {
        return imageLinkPreviewUrl;
    }
}