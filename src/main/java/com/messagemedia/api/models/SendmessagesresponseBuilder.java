package com.messagemedia.api.models;

import java.util.*;

public class SendmessagesresponseBuilder {
    //the instance to build
    private Sendmessagesresponse sendmessagesresponse;

    /**
     * Default constructor to initialize the instance
     */
    public SendmessagesresponseBuilder() {
        sendmessagesresponse = new Sendmessagesresponse();
    }

    public SendmessagesresponseBuilder messages(List<Message> messages) {
        sendmessagesresponse.setMessages(messages);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Sendmessagesresponse build() {
        return sendmessagesresponse;
    }
}