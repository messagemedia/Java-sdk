package com.messagemedia.api.controllers;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.messagemedia.api.*;
import com.messagemedia.api.models.*;
import com.messagemedia.api.exceptions.*;
import com.messagemedia.api.http.client.HttpClient;
import com.messagemedia.api.http.client.HttpContext;
import com.messagemedia.api.http.request.HttpRequest;
import com.messagemedia.api.http.response.HttpResponse;
import com.messagemedia.api.http.response.HttpStringResponse;
import com.messagemedia.api.http.client.APICallBack;
import com.messagemedia.api.controllers.syncwrapper.APICallBackCatcher;

public class WebhooksManagementController extends BaseController {
    //private static variables for the singleton pattern
    private static final Object syncObject = new Object();
    private static WebhooksManagementController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the WebhooksManagementController class 
     */
    public static WebhooksManagementController getInstance() {
        if (null == instance) {
            synchronized (syncObject) {
                if (null == instance) {
                    instance = new WebhooksManagementController();
                }
            }
        }
        return instance;
    }

    /**
     * Retrieve all the webhooks created for the connected account.
     * A successful request to the retrieve webhook endpoint will return a response body as follows:
     * ```
     * {
     *     "page": 0,
     *     "pageSize": 100,
     *     "pageData": [
     *         {
     *             "url": "https://webhook.com",
     *             "method": "POST",
     *             "id": "8805c9d8-bef7-41c7-906a-69ede93aa024",
     *             "encoding": "JSON",
     *             "events": [
     *                 "RECEIVED_SMS"
     *             ],
     *             "headers": {},
     *             "template": "{\"id\":\"$mtId\", \"status\":\"$statusCode\"}"
     *         }
     *     ]
     * }
     * ```
     * *Note: Response 400 is returned when the `page` query parameter is not valid or the `pageSize` query parameter is not valid.*
     * @param    page    Optional parameter: Example: 
     * @param    pageSize    Optional parameter: Example: 
     * @return    Returns the Object response from the API call 
     */
    public Object retrieveWebhook(
                final Integer page,
                final Integer pageSize
    ) throws Throwable {

        HttpRequest _request = _buildRetrieveWebhookRequest(page, pageSize);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRetrieveWebhookResponse(_context);
    }

    /**
     * Retrieve all the webhooks created for the connected account.
     * A successful request to the retrieve webhook endpoint will return a response body as follows:
     * ```
     * {
     *     "page": 0,
     *     "pageSize": 100,
     *     "pageData": [
     *         {
     *             "url": "https://webhook.com",
     *             "method": "POST",
     *             "id": "8805c9d8-bef7-41c7-906a-69ede93aa024",
     *             "encoding": "JSON",
     *             "events": [
     *                 "RECEIVED_SMS"
     *             ],
     *             "headers": {},
     *             "template": "{\"id\":\"$mtId\", \"status\":\"$statusCode\"}"
     *         }
     *     ]
     * }
     * ```
     * *Note: Response 400 is returned when the `page` query parameter is not valid or the `pageSize` query parameter is not valid.*
     * @param    page    Optional parameter: Example: 
     * @param    pageSize    Optional parameter: Example: 
     */
    public void retrieveWebhookAsync(
                final Integer page,
                final Integer pageSize,
                final APICallBack<Object> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildRetrieveWebhookRequest(page, pageSize);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            Object returnValue = _handleRetrieveWebhookResponse(_context);
                            callBack.onSuccess(_context, returnValue);
                        } catch (Exception e) {
                            callBack.onFailure(_context, e);
                        }
                    }

                    public void onFailure(HttpContext _context, Throwable _exception) {
                        // Let the caller know of the failure
                        callBack.onFailure(_context, _exception);
                    }
                });
            }
        };

        // Execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * Builds the HttpRequest object for retrieveWebhook
     */
    private HttpRequest _buildRetrieveWebhookRequest(
                final Integer page,
                final Integer pageSize) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/webhooks/messages");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();

        APIHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("user-agent", BaseController.userAgent);


        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null,
                Configuration.basicAuthUserName, Configuration.basicAuthPassword);

        // Invoke the callback before request if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for retrieveWebhook
     * @return An object of type Object
     */
    private Object _handleRetrieveWebhookResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new UpdateWebhook400responseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        Object _result = _responseBody;

        return _result;
    }

    /**
     * Create a webhook for one or more of the specified events.
     * A webhook would typically have the following structure:
     * ```
     * { 
     *   "url": "http://webhook.com",
     *   "method": "POST",
     *   "encoding": "JSON",  
     *   "headers": {"Account": "DeveloperPortal7000"  },  
     *   "events": ["RECEIVED_SMS"  ],
     *   "template": {
     *     "id":"$mtId",
     *     "status":"$statusCode"}
     *   }
     * ```
     * A valid webhook must consist of the following properties:
     * - ```url``` The configured URL which will trigger the webhook when a selected event occurs.
     * - ```method``` The methods to map CRUD (create, retrieve, update, delete) operations to HTTP requests.
     * - ```encoding``` Webhooks can be delivered using different content types. You can choose from ```JSON```, ```FORM_ENCODED``` or ```XML```. This will automatically add the Content-Type header for you so you don't have to add it again in the `headers` property.
     * - ```headers``` HTTP header fields which provide required information about the request or response, or about the object sent in the message body. This should NOT include the `Content-Type` header.
     * - ```events``` Event or events that will trigger the webhook. Atleast one event should be present.
     * - ```template``` The structure of the payload that will be returned. You can format this in JSON or XML.
     * #### Types of Events
     * You can select all of the events (listed below) or combine them in whatever way you like but atleast one event must be used. Otherwise, the webhook won't be created.
     * A webhook will be triggered when any one or more of the events occur:
     * + **SMS** 
     *   + `RECEIVED_SMS` Receive an SMS
     *   + `OPT_OUT_SMS` Opt-out occured
     * + **MMS**
     *   + `RECEIVED_MMS` Receive an MMS
     * + **DR (Delivery Reports)**
     *   + `ENROUTE_DR` Message is enroute
     *   + `EXPIRED_DR` Message has expired
     *   + `REJECTED_DR` Message is rejected
     *   + `FAILED_DR` Message has failed
     *   + `DELIVERED_DR` Message is delivered
     *   + `SUBMITTED_DR` Message is submitted
     * #### Template Parameters
     * You can choose what to include in the data that will be sent as the payload via the Webhook. It's upto you to choose what format you would like the payload to be returned. You can choose between JSON or XML.
     * Keep in my mind, if you've chosen JSON as the format, you must escape the JSON in the template value (see example above).
     * The table illustrates a list of all the parameters that can be included in the template and which event types it can be applied to.
     * | Data  | Parameter Name | Example | Event Type |
     * |:--|--|--|--:|
     * | **Service Type**  | $type| `SMS` | `DR` `MO` `MO MMS` |
     * | **Message ID**  | $mtId, $messageId| `877c19ef-fa2e-4cec-827a-e1df9b5509f7` | `DR` `MO` `MO MMS`|
     * | **Delivery Report ID** |$drId, $reportId| `01e1fa0a-6e27-4945-9cdb-18644b4de043` | `DR` |
     * | **Reply ID**| $moId, $replyId| `a175e797-2b54-468b-9850-41a3eab32f74` | `MO` `MO MMS` |
     * | **Account ID**  | $accountId| `DeveloperPortal7000` | `DR` `MO` `MO MMS` |
     * | **Message Timestamp**  | $submittedTimestamp| `2016-12-07T08:43:00.850Z` | `DR` `MO` `MO MMS` |
     * | **Provider Timestamp**  | $receivedTimestamp| `2016-12-07T08:44:00.850Z` | `DR` `MO` `MO MMS` |
     * | **Message Status** | $status| `enroute` | `DR` |\n| **Status Code**  | $statusCode| `200` | `DR` |
     * | **External Metadata** | $metadata.get('key')| `name` | `DR` `MO` `MO MMS` |
     * | **Source Address**| $sourceAddress| `+61491570156` | `DR` `MO` `MO MMS` |
     * | **Destination Address**| $destinationAddress| `+61491593156` | `MO` `MO MMS` |
     * | **Message Content**| $mtContent, $messageContent| `Hi Derp` | `DR` `MO` `MO MMS` |
     * | **Reply Content**| $moContent, $replyContent| `Hello Derpina` | `MO` `MO MMS` |
     * | **Retry Count**| $retryCount| `1` | `DR` `MO` `MO MMS` |
     * *Note: A 400 response will be returned if the `url` is invalid, the `events`, `encoding` or `method` is null or the `headers` has a Content-Type  attribute.*
     * @param    body    Required parameter: Example: 
     * @return    Returns the Object response from the API call 
     */
    public Object createWebhook(
                final CreateWebhookrequest body
    ) throws Throwable {

        HttpRequest _request = _buildCreateWebhookRequest(body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateWebhookResponse(_context);
    }

    /**
     * Create a webhook for one or more of the specified events.
     * A webhook would typically have the following structure:
     * ```
     * { 
     *   "url": "http://webhook.com",
     *   "method": "POST",
     *   "encoding": "JSON",  
     *   "headers": {"Account": "DeveloperPortal7000"  },  
     *   "events": ["RECEIVED_SMS"  ],
     *   "template": {
     *     "id":"$mtId",
     *     "status":"$statusCode"}
     *   }
     * ```
     * A valid webhook must consist of the following properties:
     * - ```url``` The configured URL which will trigger the webhook when a selected event occurs.
     * - ```method``` The methods to map CRUD (create, retrieve, update, delete) operations to HTTP requests.
     * - ```encoding``` Webhooks can be delivered using different content types. You can choose from ```JSON```, ```FORM_ENCODED``` or ```XML```. This will automatically add the Content-Type header for you so you don't have to add it again in the `headers` property.
     * - ```headers``` HTTP header fields which provide required information about the request or response, or about the object sent in the message body. This should NOT include the `Content-Type` header.
     * - ```events``` Event or events that will trigger the webhook. Atleast one event should be present.
     * - ```template``` The structure of the payload that will be returned. You can format this in JSON or XML.
     * #### Types of Events
     * You can select all of the events (listed below) or combine them in whatever way you like but atleast one event must be used. Otherwise, the webhook won't be created.
     * A webhook will be triggered when any one or more of the events occur:
     * + **SMS** 
     *   + `RECEIVED_SMS` Receive an SMS
     *   + `OPT_OUT_SMS` Opt-out occured
     * + **MMS**
     *   + `RECEIVED_MMS` Receive an MMS
     * + **DR (Delivery Reports)**
     *   + `ENROUTE_DR` Message is enroute
     *   + `EXPIRED_DR` Message has expired
     *   + `REJECTED_DR` Message is rejected
     *   + `FAILED_DR` Message has failed
     *   + `DELIVERED_DR` Message is delivered
     *   + `SUBMITTED_DR` Message is submitted
     * #### Template Parameters
     * You can choose what to include in the data that will be sent as the payload via the Webhook. It's upto you to choose what format you would like the payload to be returned. You can choose between JSON or XML.
     * Keep in my mind, if you've chosen JSON as the format, you must escape the JSON in the template value (see example above).
     * The table illustrates a list of all the parameters that can be included in the template and which event types it can be applied to.
     * | Data  | Parameter Name | Example | Event Type |
     * |:--|--|--|--:|
     * | **Service Type**  | $type| `SMS` | `DR` `MO` `MO MMS` |
     * | **Message ID**  | $mtId, $messageId| `877c19ef-fa2e-4cec-827a-e1df9b5509f7` | `DR` `MO` `MO MMS`|
     * | **Delivery Report ID** |$drId, $reportId| `01e1fa0a-6e27-4945-9cdb-18644b4de043` | `DR` |
     * | **Reply ID**| $moId, $replyId| `a175e797-2b54-468b-9850-41a3eab32f74` | `MO` `MO MMS` |
     * | **Account ID**  | $accountId| `DeveloperPortal7000` | `DR` `MO` `MO MMS` |
     * | **Message Timestamp**  | $submittedTimestamp| `2016-12-07T08:43:00.850Z` | `DR` `MO` `MO MMS` |
     * | **Provider Timestamp**  | $receivedTimestamp| `2016-12-07T08:44:00.850Z` | `DR` `MO` `MO MMS` |
     * | **Message Status** | $status| `enroute` | `DR` |\n| **Status Code**  | $statusCode| `200` | `DR` |
     * | **External Metadata** | $metadata.get('key')| `name` | `DR` `MO` `MO MMS` |
     * | **Source Address**| $sourceAddress| `+61491570156` | `DR` `MO` `MO MMS` |
     * | **Destination Address**| $destinationAddress| `+61491593156` | `MO` `MO MMS` |
     * | **Message Content**| $mtContent, $messageContent| `Hi Derp` | `DR` `MO` `MO MMS` |
     * | **Reply Content**| $moContent, $replyContent| `Hello Derpina` | `MO` `MO MMS` |
     * | **Retry Count**| $retryCount| `1` | `DR` `MO` `MO MMS` |
     * *Note: A 400 response will be returned if the `url` is invalid, the `events`, `encoding` or `method` is null or the `headers` has a Content-Type  attribute.*
     * @param    body    Required parameter: Example: 
     */
    public void createWebhookAsync(
                final CreateWebhookrequest body,
                final APICallBack<Object> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildCreateWebhookRequest(body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            Object returnValue = _handleCreateWebhookResponse(_context);
                            callBack.onSuccess(_context, returnValue);
                        } catch (Exception e) {
                            callBack.onFailure(_context, e);
                        }
                    }

                    public void onFailure(HttpContext _context, Throwable _exception) {
                        // Let the caller know of the failure
                        callBack.onFailure(_context, _exception);
                    }
                });
            }
        };

        // Execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * Builds the HttpRequest object for createWebhook
     */
    private HttpRequest _buildCreateWebhookRequest(
                final CreateWebhookrequest body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/webhooks/messages");
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("user-agent", BaseController.userAgent);
        _headers.put("content-type", "application/json");


        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(body),
                Configuration.basicAuthUserName, Configuration.basicAuthPassword);

        // Invoke the callback before request if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for createWebhook
     * @return An object of type Object
     */
    private Object _handleCreateWebhookResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new UpdateWebhook400responseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        if (_responseCode == 409) {
            throw new UpdateWebhook400responseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        Object _result = _responseBody;

        return _result;
    }

    /**
     * Delete a webhook that was previously created for the connected account.
     * A webhook can be cancelled by appending the UUID of the webhook to the endpoint and submitting a DELETE request to the /webhooks/messages endpoint.
     * A successful request to the retrieve webhook endpoint will return a null response.
     * *Note: Only pre-created webhooks can be deleted. If an invalid or non existent webhook ID parameter is specified in the request, then a HTTP 404 Not Found response will be returned.*
     * @param    webhookId    Required parameter: Example: 
     */
    public void deleteWebhook(
                final UUID webhookId
    ) throws Throwable {

        HttpRequest _request = _buildDeleteWebhookRequest(webhookId);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        _handleDeleteWebhookResponse(_context);
    }

    /**
     * Delete a webhook that was previously created for the connected account.
     * A webhook can be cancelled by appending the UUID of the webhook to the endpoint and submitting a DELETE request to the /webhooks/messages endpoint.
     * A successful request to the retrieve webhook endpoint will return a null response.
     * *Note: Only pre-created webhooks can be deleted. If an invalid or non existent webhook ID parameter is specified in the request, then a HTTP 404 Not Found response will be returned.*
     * @param    webhookId    Required parameter: Example: 
     */
    public void deleteWebhookAsync(
                final UUID webhookId,
                final APICallBack<Object> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildDeleteWebhookRequest(webhookId);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            _handleDeleteWebhookResponse(_context);
                            callBack.onSuccess(_context, null);
                        } catch (Exception e) {
                            callBack.onFailure(_context, e);
                        }
                    }

                    public void onFailure(HttpContext _context, Throwable _exception) {
                        // Let the caller know of the failure
                        callBack.onFailure(_context, _exception);
                    }
                });
            }
        };

        // Execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * Builds the HttpRequest object for deleteWebhook
     */
    private HttpRequest _buildDeleteWebhookRequest(
                final UUID webhookId) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/webhooks/messages/{webhookId}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("webhookId", webhookId);
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("user-agent", BaseController.userAgent);


        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().delete(_queryUrl, _headers, null,
                Configuration.basicAuthUserName, Configuration.basicAuthPassword);

        // Invoke the callback before request if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for deleteWebhook
     */
    private void _handleDeleteWebhookResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 404) {
            throw new APIException("", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);


    }

    /**
     * Update a webhook. You can update individual attributes or all of them by submitting a PATCH request to the /webhooks/messages endpoint (the same endpoint used above to delete a webhook)
     * A successful request to the retrieve webhook endpoint will return a response body as follows:
     * ```
     * {
     *     "url": "https://webhook.com",
     *     "method": "POST",
     *     "id": "04442623-0961-464e-9cbc-ec50804e0413",
     *     "encoding": "JSON",
     *     "events": [
     *         "RECEIVED_SMS"
     *     ],
     *     "headers": {},
     *     "template": "{\"id\":\"$mtId\", \"status\":\"$statusCode\"}"
     * }
     * ```
     * *Note: Only pre-created webhooks can be deleted. If an invalid or non existent webhook ID parameter is specified in the request, then a HTTP 404 Not Found response will be returned.*
     * @param    webhookId    Required parameter: Example: 
     * @param    body    Required parameter: Example: 
     * @return    Returns the Object response from the API call 
     */
    public Object updateWebhook(
                final UUID webhookId,
                final UpdateWebhookrequest body
    ) throws Throwable {

        HttpRequest _request = _buildUpdateWebhookRequest(webhookId, body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateWebhookResponse(_context);
    }

    /**
     * Update a webhook. You can update individual attributes or all of them by submitting a PATCH request to the /webhooks/messages endpoint (the same endpoint used above to delete a webhook)
     * A successful request to the retrieve webhook endpoint will return a response body as follows:
     * ```
     * {
     *     "url": "https://webhook.com",
     *     "method": "POST",
     *     "id": "04442623-0961-464e-9cbc-ec50804e0413",
     *     "encoding": "JSON",
     *     "events": [
     *         "RECEIVED_SMS"
     *     ],
     *     "headers": {},
     *     "template": "{\"id\":\"$mtId\", \"status\":\"$statusCode\"}"
     * }
     * ```
     * *Note: Only pre-created webhooks can be deleted. If an invalid or non existent webhook ID parameter is specified in the request, then a HTTP 404 Not Found response will be returned.*
     * @param    webhookId    Required parameter: Example: 
     * @param    body    Required parameter: Example: 
     */
    public void updateWebhookAsync(
                final UUID webhookId,
                final UpdateWebhookrequest body,
                final APICallBack<Object> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildUpdateWebhookRequest(webhookId, body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            Object returnValue = _handleUpdateWebhookResponse(_context);
                            callBack.onSuccess(_context, returnValue);
                        } catch (Exception e) {
                            callBack.onFailure(_context, e);
                        }
                    }

                    public void onFailure(HttpContext _context, Throwable _exception) {
                        // Let the caller know of the failure
                        callBack.onFailure(_context, _exception);
                    }
                });
            }
        };

        // Execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * Builds the HttpRequest object for updateWebhook
     */
    private HttpRequest _buildUpdateWebhookRequest(
                final UUID webhookId,
                final UpdateWebhookrequest body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/webhooks/messages/{webhookId}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("webhookId", webhookId);
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("user-agent", BaseController.userAgent);
        _headers.put("content-type", "application/json");


        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().patchBody(_queryUrl, _headers, APIHelper.serialize(body),
                Configuration.basicAuthUserName, Configuration.basicAuthPassword);

        // Invoke the callback before request if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for updateWebhook
     * @return An object of type Object
     */
    private Object _handleUpdateWebhookResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new UpdateWebhook400responseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        if (_responseCode == 404) {
            throw new APIException("", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        Object _result = _responseBody;

        return _result;
    }

}
