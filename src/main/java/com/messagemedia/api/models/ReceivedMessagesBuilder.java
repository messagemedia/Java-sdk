package com.messagemedia.api.models;

import java.util.*;

public class ReceivedMessagesBuilder {
    //the instance to build
    private ReceivedMessages receivedMessages;

    /**
     * Default constructor to initialize the instance
     */
    public ReceivedMessagesBuilder() {
        receivedMessages = new ReceivedMessages();
    }

    /**
     * List of received messages
     */
    public ReceivedMessagesBuilder data(List<ReceivedMessage> data) {
        receivedMessages.setData(data);
        return this;
    }

    public ReceivedMessagesBuilder pagination(Pagination1 pagination) {
        receivedMessages.setPagination(pagination);
        return this;
    }

    public ReceivedMessagesBuilder properties(ReportingDetailProperties properties) {
        receivedMessages.setProperties(properties);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public ReceivedMessages build() {
        return receivedMessages;
    }
}