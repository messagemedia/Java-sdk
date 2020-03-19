package com.messagemedia.api.models;

import java.util.*;

public class LogsDetailResultBuilder {
    //the instance to build
    private LogsDetailResult logsDetailResult;

    /**
     * Default constructor to initialize the instance
     */
    public LogsDetailResultBuilder() {
        logsDetailResult = new LogsDetailResult();
    }

    public LogsDetailResultBuilder messageId(String messageId) {
        logsDetailResult.setMessageId(messageId);
        return this;
    }

    public LogsDetailResultBuilder longUrl(String longUrl) {
        logsDetailResult.setLongUrl(longUrl);
        return this;
    }

    public LogsDetailResultBuilder shortUrl(String shortUrl) {
        logsDetailResult.setShortUrl(shortUrl);
        return this;
    }

    public LogsDetailResultBuilder destinationNumber(String destinationNumber) {
        logsDetailResult.setDestinationNumber(destinationNumber);
        return this;
    }

    public LogsDetailResultBuilder clickCount(Double clickCount) {
        logsDetailResult.setClickCount(clickCount);
        return this;
    }

    public LogsDetailResultBuilder viewCount(Double viewCount) {
        logsDetailResult.setViewCount(viewCount);
        return this;
    }

    public LogsDetailResultBuilder clicks(List<Click> clicks) {
        logsDetailResult.setClicks(clicks);
        return this;
    }

    public LogsDetailResultBuilder views(List<View> views) {
        logsDetailResult.setViews(views);
        return this;
    }

    public LogsDetailResultBuilder pagination(Pagination1 pagination) {
        logsDetailResult.setPagination(pagination);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public LogsDetailResult build() {
        return logsDetailResult;
    }
}