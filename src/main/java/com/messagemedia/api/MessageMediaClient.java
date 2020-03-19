package com.messagemedia.api;

import com.messagemedia.api.controllers.*;
import com.messagemedia.api.http.client.HttpClient;

public class MessageMediaClient {
    /**
     * Singleton access to Messages controller
     * @return	Returns the MessagesController instance 
     */
    public MessagesController getMessages() {
        return MessagesController.getInstance();
    }

    /**
     * Singleton access to DeliveryReports controller
     * @return	Returns the DeliveryReportsController instance 
     */
    public DeliveryReportsController getDeliveryReports() {
        return DeliveryReportsController.getInstance();
    }

    /**
     * Singleton access to Replies controller
     * @return	Returns the RepliesController instance 
     */
    public RepliesController getReplies() {
        return RepliesController.getInstance();
    }

    /**
     * Singleton access to Lookups controller
     * @return	Returns the LookupsController instance 
     */
    public LookupsController getLookups() {
        return LookupsController.getInstance();
    }

    /**
     * Singleton access to NumberAuthorisation controller
     * @return	Returns the NumberAuthorisationController instance 
     */
    public NumberAuthorisationController getNumberAuthorisation() {
        return NumberAuthorisationController.getInstance();
    }

    /**
     * Singleton access to DedicatedNumbers controller
     * @return	Returns the DedicatedNumbersController instance 
     */
    public DedicatedNumbersController getDedicatedNumbers() {
        return DedicatedNumbersController.getInstance();
    }

    /**
     * Singleton access to MessagingReports controller
     * @return	Returns the MessagingReportsController instance 
     */
    public MessagingReportsController getMessagingReports() {
        return MessagingReportsController.getInstance();
    }

    /**
     * Singleton access to ShortTrackableLinksReports controller
     * @return	Returns the ShortTrackableLinksReportsController instance 
     */
    public ShortTrackableLinksReportsController getShortTrackableLinksReports() {
        return ShortTrackableLinksReportsController.getInstance();
    }

    /**
     * Singleton access to WebhooksManagement controller
     * @return	Returns the WebhooksManagementController instance 
     */
    public WebhooksManagementController getWebhooksManagement() {
        return WebhooksManagementController.getInstance();
    }

    /**
     * Singleton access to SignatureKeyManagement controller
     * @return	Returns the SignatureKeyManagementController instance 
     */
    public SignatureKeyManagementController getSignatureKeyManagement() {
        return SignatureKeyManagementController.getInstance();
    }

    /**
     * Singleton access to MobileLandingPagesBeta controller
     * @return	Returns the MobileLandingPagesBetaController instance 
     */
    public MobileLandingPagesBetaController getMobileLandingPagesBeta() {
        return MobileLandingPagesBetaController.getInstance();
    }

    /**
     * Get the shared http client currently being used for API calls
     * @return The http client instance currently being used
     */
    public HttpClient getSharedHttpClient() {
        return BaseController.getClientInstance();
    }
    
    /**
     * Set a shared http client to be used for API calls
     * @param httpClient The http client to use
     */
    public void setSharedHttpClient(HttpClient httpClient) {
        BaseController.setClientInstance(httpClient);
    }

    /**
     * Default constructor 
     */     
    public MessageMediaClient() {
    }

    /**
     * Client initialization constructor 
     */     
    public MessageMediaClient(String basicAuthUserName, String basicAuthPassword) {
        this();
        Configuration.basicAuthUserName = basicAuthUserName;
        Configuration.basicAuthPassword = basicAuthPassword;
    }
}