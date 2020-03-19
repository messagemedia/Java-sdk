package com.messagemedia.api.models;

import java.util.*;

public class LogSummaryResultBuilder {
    //the instance to build
    private LogSummaryResult logSummaryResult;

    /**
     * Default constructor to initialize the instance
     */
    public LogSummaryResultBuilder() {
        logSummaryResult = new LogSummaryResult();
    }

    public LogSummaryResultBuilder totalClicks(Double totalClicks) {
        logSummaryResult.setTotalClicks(totalClicks);
        return this;
    }

    public LogSummaryResultBuilder uniqueClicks(Double uniqueClicks) {
        logSummaryResult.setUniqueClicks(uniqueClicks);
        return this;
    }

    public LogSummaryResultBuilder totalViews(Double totalViews) {
        logSummaryResult.setTotalViews(totalViews);
        return this;
    }

    public LogSummaryResultBuilder uniqueViews(Double uniqueViews) {
        logSummaryResult.setUniqueViews(uniqueViews);
        return this;
    }

    public LogSummaryResultBuilder shortUrlsGenerated(Double shortUrlsGenerated) {
        logSummaryResult.setShortUrlsGenerated(shortUrlsGenerated);
        return this;
    }

    public LogSummaryResultBuilder shortUrls(List<ShortUrl> shortUrls) {
        logSummaryResult.setShortUrls(shortUrls);
        return this;
    }

    public LogSummaryResultBuilder pagination(Pagination1 pagination) {
        logSummaryResult.setPagination(pagination);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public LogSummaryResult build() {
        return logSummaryResult;
    }
}