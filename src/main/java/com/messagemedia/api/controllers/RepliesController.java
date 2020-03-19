package com.messagemedia.api.controllers;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

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

public class RepliesController extends BaseController {
    //private static variables for the singleton pattern
    private static final Object syncObject = new Object();
    private static RepliesController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the RepliesController class 
     */
    public static RepliesController getInstance() {
        if (null == instance) {
            synchronized (syncObject) {
                if (null == instance) {
                    instance = new RepliesController();
                }
            }
        }
        return instance;
    }

    /**
     * Check for any replies that have been received.
     * Replies are messages that have been sent from a handset in response to a message sent by an
     * application or messages that have been sent from a handset to a inbound number associated with
     * an account, known as a dedicated inbound number (contact <support@messagemedia.com> for more
     * information on dedicated inbound numbers).
     * Each request to the check replies endpoint will return any replies received that have not yet
     * been confirmed using the confirm replies endpoint. A response from the check replies endpoint
     * will have the following structure:
     * ```json
     * {
     *     "replies": [
     *         {
     *             "metadata": {
     *                 "key1": "value1",
     *                 "key2": "value2"
     *             },
     *             "message_id": "877c19ef-fa2e-4cec-827a-e1df9b5509f7",
     *             "reply_id": "a175e797-2b54-468b-9850-41a3eab32f74",
     *             "date_received": "2016-12-07T08:43:00.850Z",
     *             "callback_url": "https://my.callback.url.com",
     *             "destination_number": "+61491570156",
     *             "source_number": "+61491570157",
     *             "vendor_account_id": {
     *                 "vendor_id": "MessageMedia",
     *                 "account_id": "MyAccount"
     *             },
     *             "content": "My first reply!"
     *         },
     *         {
     *             "metadata": {
     *                 "key1": "value1",
     *                 "key2": "value2"
     *             },
     *             "message_id": "8f2f5927-2e16-4f1c-bd43-47dbe2a77ae4",
     *             "reply_id": "3d8d53d8-01d3-45dd-8cfa-4dfc81600f7f",
     *             "date_received": "2016-12-07T08:43:00.850Z",
     *             "callback_url": "https://my.callback.url.com",
     *             "destination_number": "+61491570157",
     *             "source_number": "+61491570158",
     *             "vendor_account_id": {
     *                 "vendor_id": "MessageMedia",
     *                 "account_id": "MyAccount"
     *             },
     *             "content": "My second reply!"
     *         }
     *     ]
     * }
     * ```
     * Each reply will contain details about the reply message, as well as details of the message the reply was sent
     * in response to, including any metadata specified. Every reply will have a reply ID to be used with the
     * confirm replies endpoint.
     * *Note: The source number and destination number properties in a reply are the inverse of those
     * specified in the message the reply is in response to. The source number of the reply message is the
     * same as the destination number of the original message, and the destination number of the reply
     * message is the same as the source number of the original message. If a source number
     * wasn't specified in the original message, then the destination number property will not be present
     * in the reply message.*
     * Subsequent requests to the check replies endpoint will return the same reply messages and a maximum
     * of 100 replies will be returned in each request. Applications should use the confirm replies endpoint
     * in the following pattern so that replies that have been processed are no longer returned in
     * subsequent check replies requests.
     * 1. Call check replies endpoint
     * 2. Process each reply message
     * 3. Confirm all processed reply messages using the confirm replies endpoint
     * *Note: It is recommended to use the Webhooks feature to receive reply messages rather than polling
     * the check replies endpoint.*
     * @return    Returns the Checkrepliesresponse response from the API call 
     */
    public Checkrepliesresponse getCheckReplies(
    ) throws Throwable {

        HttpRequest _request = _buildGetCheckRepliesRequest();
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetCheckRepliesResponse(_context);
    }

    /**
     * Check for any replies that have been received.
     * Replies are messages that have been sent from a handset in response to a message sent by an
     * application or messages that have been sent from a handset to a inbound number associated with
     * an account, known as a dedicated inbound number (contact <support@messagemedia.com> for more
     * information on dedicated inbound numbers).
     * Each request to the check replies endpoint will return any replies received that have not yet
     * been confirmed using the confirm replies endpoint. A response from the check replies endpoint
     * will have the following structure:
     * ```json
     * {
     *     "replies": [
     *         {
     *             "metadata": {
     *                 "key1": "value1",
     *                 "key2": "value2"
     *             },
     *             "message_id": "877c19ef-fa2e-4cec-827a-e1df9b5509f7",
     *             "reply_id": "a175e797-2b54-468b-9850-41a3eab32f74",
     *             "date_received": "2016-12-07T08:43:00.850Z",
     *             "callback_url": "https://my.callback.url.com",
     *             "destination_number": "+61491570156",
     *             "source_number": "+61491570157",
     *             "vendor_account_id": {
     *                 "vendor_id": "MessageMedia",
     *                 "account_id": "MyAccount"
     *             },
     *             "content": "My first reply!"
     *         },
     *         {
     *             "metadata": {
     *                 "key1": "value1",
     *                 "key2": "value2"
     *             },
     *             "message_id": "8f2f5927-2e16-4f1c-bd43-47dbe2a77ae4",
     *             "reply_id": "3d8d53d8-01d3-45dd-8cfa-4dfc81600f7f",
     *             "date_received": "2016-12-07T08:43:00.850Z",
     *             "callback_url": "https://my.callback.url.com",
     *             "destination_number": "+61491570157",
     *             "source_number": "+61491570158",
     *             "vendor_account_id": {
     *                 "vendor_id": "MessageMedia",
     *                 "account_id": "MyAccount"
     *             },
     *             "content": "My second reply!"
     *         }
     *     ]
     * }
     * ```
     * Each reply will contain details about the reply message, as well as details of the message the reply was sent
     * in response to, including any metadata specified. Every reply will have a reply ID to be used with the
     * confirm replies endpoint.
     * *Note: The source number and destination number properties in a reply are the inverse of those
     * specified in the message the reply is in response to. The source number of the reply message is the
     * same as the destination number of the original message, and the destination number of the reply
     * message is the same as the source number of the original message. If a source number
     * wasn't specified in the original message, then the destination number property will not be present
     * in the reply message.*
     * Subsequent requests to the check replies endpoint will return the same reply messages and a maximum
     * of 100 replies will be returned in each request. Applications should use the confirm replies endpoint
     * in the following pattern so that replies that have been processed are no longer returned in
     * subsequent check replies requests.
     * 1. Call check replies endpoint
     * 2. Process each reply message
     * 3. Confirm all processed reply messages using the confirm replies endpoint
     * *Note: It is recommended to use the Webhooks feature to receive reply messages rather than polling
     * the check replies endpoint.*
     */
    public void getCheckRepliesAsync(
                final APICallBack<Checkrepliesresponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetCheckRepliesRequest();
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            Checkrepliesresponse returnValue = _handleGetCheckRepliesResponse(_context);
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
     * Builds the HttpRequest object for getCheckReplies
     */
    private HttpRequest _buildGetCheckRepliesRequest() throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/replies");
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("user-agent", BaseController.userAgent);
        _headers.put("accept", "application/json");


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
     * Processes the response for getCheckReplies
     * @return An object of type Checkrepliesresponse
     */
    private Checkrepliesresponse _handleGetCheckRepliesResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 403) {
            throw new M403ResponseException("Unauthorised", _context);
        }
        if (_responseCode == 404) {
            throw new ResourceNotFoundException("Resource not found", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        Checkrepliesresponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Checkrepliesresponse>(){});

        return _result;
    }

    /**
     * Mark a reply message as confirmed so it is no longer returned in check replies requests.
     * The confirm replies endpoint is intended to be used in conjunction with the check replies endpoint
     * to allow for robust processing of reply messages. Once one or more reply messages have been processed
     * they can then be confirmed using the confirm replies endpoint so they are no longer returned in
     * subsequent check replies requests.
     * The confirm replies endpoint takes a list of reply IDs as follows:
     * ```json
     * {
     *     "reply_ids": [
     *         "011dcead-6988-4ad6-a1c7-6b6c68ea628d",
     *         "3487b3fa-6586-4979-a233-2d1b095c7718",
     *         "ba28e94b-c83d-4759-98e7-ff9c7edb87a1"
     *     ]
     * }
     * ```
     * Up to 100 replies can be confirmed in a single confirm replies request.
     * @param    body    Required parameter: Example: 
     * @return    Returns the Object response from the API call 
     */
    public Object createConfirmRepliesAsReceived(
                final Confirmrepliesasreceivedrequest body
    ) throws Throwable {

        HttpRequest _request = _buildCreateConfirmRepliesAsReceivedRequest(body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateConfirmRepliesAsReceivedResponse(_context);
    }

    /**
     * Mark a reply message as confirmed so it is no longer returned in check replies requests.
     * The confirm replies endpoint is intended to be used in conjunction with the check replies endpoint
     * to allow for robust processing of reply messages. Once one or more reply messages have been processed
     * they can then be confirmed using the confirm replies endpoint so they are no longer returned in
     * subsequent check replies requests.
     * The confirm replies endpoint takes a list of reply IDs as follows:
     * ```json
     * {
     *     "reply_ids": [
     *         "011dcead-6988-4ad6-a1c7-6b6c68ea628d",
     *         "3487b3fa-6586-4979-a233-2d1b095c7718",
     *         "ba28e94b-c83d-4759-98e7-ff9c7edb87a1"
     *     ]
     * }
     * ```
     * Up to 100 replies can be confirmed in a single confirm replies request.
     * @param    body    Required parameter: Example: 
     */
    public void createConfirmRepliesAsReceivedAsync(
                final Confirmrepliesasreceivedrequest body,
                final APICallBack<Object> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildCreateConfirmRepliesAsReceivedRequest(body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            Object returnValue = _handleCreateConfirmRepliesAsReceivedResponse(_context);
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
     * Builds the HttpRequest object for createConfirmRepliesAsReceived
     */
    private HttpRequest _buildCreateConfirmRepliesAsReceivedRequest(
                final Confirmrepliesasreceivedrequest body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/replies/confirmed");
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
     * Processes the response for createConfirmRepliesAsReceived
     * @return An object of type Object
     */
    private Object _handleCreateConfirmRepliesAsReceivedResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new BadRequestException("Bad request", _context);
        }
        if (_responseCode == 403) {
            throw new M403ResponseException("Unauthorised", _context);
        }
        if (_responseCode == 404) {
            throw new ResourceNotFoundException("Resource not found", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        Object _result = _responseBody;

        return _result;
    }

}
