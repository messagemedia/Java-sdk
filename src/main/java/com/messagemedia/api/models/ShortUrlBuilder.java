package com.messagemedia.api.models;

import java.util.*;

public class ShortUrlBuilder {
    //the instance to build
    private ShortUrl shortUrlInstance;

    /**
     * Default constructor to initialize the instance
     */
    public ShortUrlBuilder() {
        shortUrlInstance = new ShortUrl();
    }

    public ShortUrlBuilder clickCount(Double clickCount) {
        shortUrlInstance.setClickCount(clickCount);
        return this;
    }

    public ShortUrlBuilder viewCount(Double viewCount) {
        shortUrlInstance.setViewCount(viewCount);
        return this;
    }

    public ShortUrlBuilder messageId(String messageId) {
        shortUrlInstance.setMessageId(messageId);
        return this;
    }

    public ShortUrlBuilder longUrl(String longUrl) {
        shortUrlInstance.setLongUrl(longUrl);
        return this;
    }

    public ShortUrlBuilder shortUrl(String shortUrl) {
        shortUrlInstance.setShortUrl(shortUrl);
        return this;
    }

    public ShortUrlBuilder destinationNumber(String destinationNumber) {
        shortUrlInstance.setDestinationNumber(destinationNumber);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public ShortUrl build() {
        return shortUrlInstance;
    }
}