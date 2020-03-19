package com.messagemedia.api.models;

import java.util.*;

public class CheckrepliesresponseBuilder {
    //the instance to build
    private Checkrepliesresponse checkrepliesresponse;

    /**
     * Default constructor to initialize the instance
     */
    public CheckrepliesresponseBuilder() {
        checkrepliesresponse = new Checkrepliesresponse();
    }

    /**
     * The oldest 100 unconfirmed replies
     */
    public CheckrepliesresponseBuilder replies(List<Reply> replies) {
        checkrepliesresponse.setReplies(replies);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Checkrepliesresponse build() {
        return checkrepliesresponse;
    }
}