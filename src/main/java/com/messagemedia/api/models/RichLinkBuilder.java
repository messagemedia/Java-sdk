package com.messagemedia.api.models;

import java.util.*;

public class RichLinkBuilder {
    //the instance to build
    private RichLink richLink;

    /**
     * Default constructor to initialize the instance
     */
    public RichLinkBuilder() {
        richLink = new RichLink();
    }

    /**
     * The image field is used to specify the url of the media file that you want to show in the link preview. Supported file formats include png, jpeg and gif.
     */
    public RichLinkBuilder image(String image) {
        richLink.setImage(image);
        return this;
    }

    /**
     * The (optional) title that appears on your unfurled link. Maximum 80  characters.
     */
    public RichLinkBuilder title(String title) {
        richLink.setTitle(title);
        return this;
    }

    /**
     * An optional description, maximum 150 characters.
     */
    public RichLinkBuilder description(String description) {
        richLink.setDescription(description);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public RichLink build() {
        return richLink;
    }
}