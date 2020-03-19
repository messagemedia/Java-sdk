package com.messagemedia.api.models;

import java.util.*;

public class SentMessagesBuilder {
    //the instance to build
    private SentMessages sentMessages;

    /**
     * Default constructor to initialize the instance
     */
    public SentMessagesBuilder() {
        sentMessages = new SentMessages();
    }

    /**
     * List of sent messages
     */
    public SentMessagesBuilder data(List<SentMessage> data) {
        sentMessages.setData(data);
        return this;
    }

    public SentMessagesBuilder pagination(Pagination1 pagination) {
        sentMessages.setPagination(pagination);
        return this;
    }

    public SentMessagesBuilder properties(ReportingDetailProperties properties) {
        sentMessages.setProperties(properties);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public SentMessages build() {
        return sentMessages;
    }
}