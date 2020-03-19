package com.messagemedia.api.models;

import java.util.*;

public class ConfirmrepliesasreceivedrequestBuilder {
    //the instance to build
    private Confirmrepliesasreceivedrequest confirmrepliesasreceivedrequest;

    /**
     * Default constructor to initialize the instance
     */
    public ConfirmrepliesasreceivedrequestBuilder() {
        confirmrepliesasreceivedrequest = new Confirmrepliesasreceivedrequest();
    }

    /**
     * The UUID of the *reply* to be confirmed (note: not the UUID of the message it is in response to)
     */
    public ConfirmrepliesasreceivedrequestBuilder replyIds(List<UUID> replyIds) {
        confirmrepliesasreceivedrequest.setReplyIds(replyIds);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Confirmrepliesasreceivedrequest build() {
        return confirmrepliesasreceivedrequest;
    }
}