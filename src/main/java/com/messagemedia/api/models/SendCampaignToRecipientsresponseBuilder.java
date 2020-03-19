package com.messagemedia.api.models;

import java.util.*;

public class SendCampaignToRecipientsresponseBuilder {
    //the instance to build
    private SendCampaignToRecipientsresponse sendCampaignToRecipientsresponse;

    /**
     * Default constructor to initialize the instance
     */
    public SendCampaignToRecipientsresponseBuilder() {
        sendCampaignToRecipientsresponse = new SendCampaignToRecipientsresponse();
    }

    public SendCampaignToRecipientsresponseBuilder recipients(List<Recipient1> recipients) {
        sendCampaignToRecipientsresponse.setRecipients(recipients);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public SendCampaignToRecipientsresponse build() {
        return sendCampaignToRecipientsresponse;
    }
}