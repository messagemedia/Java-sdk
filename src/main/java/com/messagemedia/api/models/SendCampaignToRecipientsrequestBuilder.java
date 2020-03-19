package com.messagemedia.api.models;

import java.util.*;

public class SendCampaignToRecipientsrequestBuilder {
    //the instance to build
    private SendCampaignToRecipientsrequest sendCampaignToRecipientsrequest;

    /**
     * Default constructor to initialize the instance
     */
    public SendCampaignToRecipientsrequestBuilder() {
        sendCampaignToRecipientsrequest = new SendCampaignToRecipientsrequest();
    }

    public SendCampaignToRecipientsrequestBuilder recipients(List<Recipient> recipients) {
        sendCampaignToRecipientsrequest.setRecipients(recipients);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public SendCampaignToRecipientsrequest build() {
        return sendCampaignToRecipientsrequest;
    }
}