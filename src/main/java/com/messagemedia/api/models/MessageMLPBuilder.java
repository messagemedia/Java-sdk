package com.messagemedia.api.models;

import java.util.*;

public class MessageMLPBuilder {
    //the instance to build
    private MessageMLP messageMLP;

    /**
     * Default constructor to initialize the instance
     */
    public MessageMLPBuilder() {
        messageMLP = new MessageMLP();
    }

    public MessageMLPBuilder content(String content) {
        messageMLP.setContent(content);
        return this;
    }

    public MessageMLPBuilder metadata(LinkedHashMap<String, String> metadata) {
        messageMLP.setMetadata(metadata);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public MessageMLP build() {
        return messageMLP;
    }
}