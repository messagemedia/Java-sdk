package com.messagemedia.api.models;

import java.util.*;

public class SendmessagesrequestBuilder {
    //the instance to build
    private Sendmessagesrequest sendmessagesrequest;

    /**
     * Default constructor to initialize the instance
     */
    public SendmessagesrequestBuilder() {
        sendmessagesrequest = new Sendmessagesrequest();
    }

    public SendmessagesrequestBuilder messages(List<Message> messages) {
        sendmessagesrequest.setMessages(messages);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Sendmessagesrequest build() {
        return sendmessagesrequest;
    }
}