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

public class MessagesController extends BaseController {
    //private static variables for the singleton pattern
    private static final Object syncObject = new Object();
    private static MessagesController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the MessagesController class 
     */
    public static MessagesController getInstance() {
        if (null == instance) {
            synchronized (syncObject) {
                if (null == instance) {
                    instance = new MessagesController();
                }
            }
        }
        return instance;
    }

    /**
     * Retrieve the current status of a message using the message ID returned
     * in the send messages end point.
     * A successful request to the get message status endpoint will return a
     * response body as follows:
     * ```json
     * {
     *     "format": "SMS",
     *     "content": "My first message!",
     *     "metadata": {
     *         "key1": "value1",
     *         "key2": "value2"
     *     },
     *     "message_id": "877c19ef-fa2e-4cec-827a-e1df9b5509f7",
     *     "callback_url": "https://my.callback.url.com",
     *     "delivery_report": true,
     *     "destination_number": "+61401760575",
     *     "scheduled": "2016-11-03T11:49:02.807Z",
     *     "source_number": "+61491570157",
     *     "source_number_type": "INTERNATIONAL",
     *     "message_expiry_timestamp": "2016-11-03T11:49:02.807Z",
     *     "status": "enroute"
     * }
     * ```
     * The status property of the response indicates the current status of the
     * message. See the Delivery Reports section of this documentation for more information on message
     * statues.
     * *Note: If an invalid or non existent message ID parameter is specified
     * in the request, then a HTTP 404 Not Found response will be returned*
     * @param    messageId    Required parameter: 36 character UUID.
     * @return    Returns the Getmessagestatusresponse response from the API call 
     */
    public Getmessagestatusresponse getMessageStatus(
                final String messageId
    ) throws Throwable {

        HttpRequest _request = _buildGetMessageStatusRequest(messageId);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetMessageStatusResponse(_context);
    }

    /**
     * Retrieve the current status of a message using the message ID returned
     * in the send messages end point.
     * A successful request to the get message status endpoint will return a
     * response body as follows:
     * ```json
     * {
     *     "format": "SMS",
     *     "content": "My first message!",
     *     "metadata": {
     *         "key1": "value1",
     *         "key2": "value2"
     *     },
     *     "message_id": "877c19ef-fa2e-4cec-827a-e1df9b5509f7",
     *     "callback_url": "https://my.callback.url.com",
     *     "delivery_report": true,
     *     "destination_number": "+61401760575",
     *     "scheduled": "2016-11-03T11:49:02.807Z",
     *     "source_number": "+61491570157",
     *     "source_number_type": "INTERNATIONAL",
     *     "message_expiry_timestamp": "2016-11-03T11:49:02.807Z",
     *     "status": "enroute"
     * }
     * ```
     * The status property of the response indicates the current status of the
     * message. See the Delivery Reports section of this documentation for more information on message
     * statues.
     * *Note: If an invalid or non existent message ID parameter is specified
     * in the request, then a HTTP 404 Not Found response will be returned*
     * @param    messageId    Required parameter: 36 character UUID.
     */
    public void getMessageStatusAsync(
                final String messageId,
                final APICallBack<Getmessagestatusresponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetMessageStatusRequest(messageId);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            Getmessagestatusresponse returnValue = _handleGetMessageStatusResponse(_context);
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
     * Builds the HttpRequest object for getMessageStatus
     */
    private HttpRequest _buildGetMessageStatusRequest(
                final String messageId) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/messages/{messageId}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("messageId", messageId);
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);
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
     * Processes the response for getMessageStatus
     * @return An object of type Getmessagestatusresponse
     */
    private Getmessagestatusresponse _handleGetMessageStatusResponse(HttpContext _context)
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
        Getmessagestatusresponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Getmessagestatusresponse>(){});

        return _result;
    }

    /**
     * Cancel a scheduled message that has not yet been delivered.
     * A scheduled message can be cancelled by updating the status of a message
     * from ```scheduled``` to ```cancelled```. This is done by submitting a PUT request to the
     * messages endpoint using the message ID as a parameter (the same endpoint used above to retrieve
     * the status of a message).
     * The body of the request simply needs to contain a ```status``` property with the value set to ```cancelled```.
     * ```json
     * {
     *     "status": "cancelled"
     * }
     * ```
     * *Note: Only messages with a status of scheduled can be cancelled. If an invalid or non existent message ID parameter is specified in the request, then a HTTP 404 Not Found response will be returned*
     * @param    messageId    Required parameter: 36 character UUID.
     * @param    body    Required parameter: Parameters of a message to change.
     */
    public void updateCancelScheduledMessage(
                final String messageId,
                final Cancelscheduledmessagerequest body
    ) throws Throwable {

        HttpRequest _request = _buildUpdateCancelScheduledMessageRequest(messageId, body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        _handleUpdateCancelScheduledMessageResponse(_context);
    }

    /**
     * Cancel a scheduled message that has not yet been delivered.
     * A scheduled message can be cancelled by updating the status of a message
     * from ```scheduled``` to ```cancelled```. This is done by submitting a PUT request to the
     * messages endpoint using the message ID as a parameter (the same endpoint used above to retrieve
     * the status of a message).
     * The body of the request simply needs to contain a ```status``` property with the value set to ```cancelled```.
     * ```json
     * {
     *     "status": "cancelled"
     * }
     * ```
     * *Note: Only messages with a status of scheduled can be cancelled. If an invalid or non existent message ID parameter is specified in the request, then a HTTP 404 Not Found response will be returned*
     * @param    messageId    Required parameter: 36 character UUID.
     * @param    body    Required parameter: Parameters of a message to change.
     */
    public void updateCancelScheduledMessageAsync(
                final String messageId,
                final Cancelscheduledmessagerequest body,
                final APICallBack<Object> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildUpdateCancelScheduledMessageRequest(messageId, body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            _handleUpdateCancelScheduledMessageResponse(_context);
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
     * Builds the HttpRequest object for updateCancelScheduledMessage
     */
    private HttpRequest _buildUpdateCancelScheduledMessageRequest(
                final String messageId,
                final Cancelscheduledmessagerequest body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/messages/{messageId}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("messageId", messageId);
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("user-agent", BaseController.userAgent);
        _headers.put("content-type", "application/json");


        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().putBody(_queryUrl, _headers, APIHelper.serialize(body),
                Configuration.basicAuthUserName, Configuration.basicAuthPassword);

        // Invoke the callback before request if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for updateCancelScheduledMessage
     */
    private void _handleUpdateCancelScheduledMessageResponse(HttpContext _context)
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


    }

    /**
     * Submit one or more (up to 100 per request) SMS, MMS or text to voice
     * messages for delivery.
     * The most basic message has the following structure:
     * ```json
     * {
     *     "messages": [
     *         {
     *             "content": "My first message!",
     *             "destination_number": "+61491570156"
     *         }
     *     ]
     * }
     * ```
     * More advanced delivery features can be specified by setting the
     * following properties in a message:
     * - ```callback_url``` A URL can be included with each message to which
     * Webhooks will be pushed to via a HTTP POST request. Webhooks will be sent if and when the status of the message changes as it is processed (if the delivery report property of the request is set to ```true```) and when replies are received. Specifying a callback URL is optional.
     * - ```content``` The content of the message. This can be a Unicode string, up to 5,000 characters long.
     *   Message content is required.
     * - ```delivery_report``` Delivery reports can be requested with each
     * message. If delivery reports are requested, a webhook will be submitted to the ```callback_url``` property specified for the message (or to the webhooks)
     *   specified for the account every time the status of the message changes as it is processed. The
     *   current status of the message can also be retrieved via the Delivery Reports endpoint of the
     *   Messages API. Delivery reports are optional and by default will not be requested.
     * - ```destination_number``` The destination number the message should be
     * delivered to. This should be specified in E.164
     *   international format. For information on E.164, please refer to http://en.wikipedia.org/wiki/E.164.
     *   A destination number is required.
     * - ```format``` The format specifies which format the message will be
     * sent as, ```SMS``` (text message), ```MMS``` (multimedia message)
     *   or ```TTS``` (text to speech). With ```TTS``` format, we will call the destination number and read out the
     *   message using a computer generated voice. Specifying a format is optional, by default ```SMS``` will be used.
     * - ```source_number``` A source number may be specified for the message,
     * this will be the number that
     *   the message appears from on the handset. By default this feature is _not_ available and will be ignored
     *   in the request. Please contact <support@messagemedia.com> for more information. Specifying a source
     *   number is optional and a by default a source number will be assigned to the message.
     * - ```media``` The media is used to specify the url of the media file
     * that you are trying to send. Supported file formats include png, jpeg
     * and gif. ```format``` parameter must be set to ```MMS``` for this to
     * work.
     * - ```subject``` The subject field is used to denote subject of the MMS
     * message and has a maximum size of 64 characters long. Specifying a
     * subject is optional.
     * - ```source_number_type``` If a source number is specified, the type of
     * source number may also be
     *   specified. This is recommended when using a source address type that is not an internationally
     *   formatted number, available options are ```INTERNATIONAL```, ```ALPHANUMERIC``` or ```SHORTCODE```. Specifying a
     *   source number type is only valid when the ```source_number``` parameter is specified and is optional.
     *   If a source number is specified and no source number type is specified, the source number type will be
     *   inferred from the source number, however this may be inaccurate.
     * - ```scheduled``` A message can be scheduled for delivery in the future
     * by setting the scheduled property.
     *   The scheduled property expects a date time specified in ISO 8601 format. The scheduled time must be
     *   provided in UTC and is optional. If no scheduled property is set, the message will be delivered immediately.
     * - ```message_expiry_timestamp``` A message expiry timestamp can be
     * provided to specify the latest time
     *   at which the message should be delivered. If the message cannot be delivered before the specified
     *   message expiry timestamp elapses, the message will be discarded. Specifying a message expiry 
     *   timestamp is optional.
     * - ```metadata``` Metadata can be included with the message which will
     * then be included with any delivery
     *   reports or replies matched to the message. This can be used to create powerful two-way messaging
     *   applications without having to store persistent data in the application. Up to 10 key / value metadata data
     *   pairs can be specified in a message. Each key can be up to 100 characters long, and each value up to 
     *   256 characters long. Specifying metadata for a message is optional.
     * The response body of a successful POST request to the messages endpoint
     * will include a ```messages``` property which contains a list of all messages submitted. The list of
     * messages submitted will reflect the list of messages included in the request, but each message
     * will also contain two new properties, ```message_id``` and ```status```. The returned message ID
     * will be a 36 character UUID which can be used to check the status of the message via the Get Message
     * Status endpoint. The status of the message which reflect the status of the message at submission
     * time which will always be ```queued```. See the Delivery Reports section of this documentation for
     * more information on message statues.
     * *Note: when sending multiple messages in a request, all messages must be valid for the request 
     * to be successful. If any messages in the request are invalid, no messages will be sent.*
     * @param    body    Required parameter: Example: 
     * @return    Returns the Sendmessagesresponse response from the API call 
     */
    public Sendmessagesresponse createSendMessages(
                final Sendmessagesrequest body
    ) throws Throwable {

        HttpRequest _request = _buildCreateSendMessagesRequest(body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateSendMessagesResponse(_context);
    }

    /**
     * Submit one or more (up to 100 per request) SMS, MMS or text to voice
     * messages for delivery.
     * The most basic message has the following structure:
     * ```json
     * {
     *     "messages": [
     *         {
     *             "content": "My first message!",
     *             "destination_number": "+61491570156"
     *         }
     *     ]
     * }
     * ```
     * More advanced delivery features can be specified by setting the
     * following properties in a message:
     * - ```callback_url``` A URL can be included with each message to which
     * Webhooks will be pushed to via a HTTP POST request. Webhooks will be sent if and when the status of the message changes as it is processed (if the delivery report property of the request is set to ```true```) and when replies are received. Specifying a callback URL is optional.
     * - ```content``` The content of the message. This can be a Unicode string, up to 5,000 characters long.
     *   Message content is required.
     * - ```delivery_report``` Delivery reports can be requested with each
     * message. If delivery reports are requested, a webhook will be submitted to the ```callback_url``` property specified for the message (or to the webhooks)
     *   specified for the account every time the status of the message changes as it is processed. The
     *   current status of the message can also be retrieved via the Delivery Reports endpoint of the
     *   Messages API. Delivery reports are optional and by default will not be requested.
     * - ```destination_number``` The destination number the message should be
     * delivered to. This should be specified in E.164
     *   international format. For information on E.164, please refer to http://en.wikipedia.org/wiki/E.164.
     *   A destination number is required.
     * - ```format``` The format specifies which format the message will be
     * sent as, ```SMS``` (text message), ```MMS``` (multimedia message)
     *   or ```TTS``` (text to speech). With ```TTS``` format, we will call the destination number and read out the
     *   message using a computer generated voice. Specifying a format is optional, by default ```SMS``` will be used.
     * - ```source_number``` A source number may be specified for the message,
     * this will be the number that
     *   the message appears from on the handset. By default this feature is _not_ available and will be ignored
     *   in the request. Please contact <support@messagemedia.com> for more information. Specifying a source
     *   number is optional and a by default a source number will be assigned to the message.
     * - ```media``` The media is used to specify the url of the media file
     * that you are trying to send. Supported file formats include png, jpeg
     * and gif. ```format``` parameter must be set to ```MMS``` for this to
     * work.
     * - ```subject``` The subject field is used to denote subject of the MMS
     * message and has a maximum size of 64 characters long. Specifying a
     * subject is optional.
     * - ```source_number_type``` If a source number is specified, the type of
     * source number may also be
     *   specified. This is recommended when using a source address type that is not an internationally
     *   formatted number, available options are ```INTERNATIONAL```, ```ALPHANUMERIC``` or ```SHORTCODE```. Specifying a
     *   source number type is only valid when the ```source_number``` parameter is specified and is optional.
     *   If a source number is specified and no source number type is specified, the source number type will be
     *   inferred from the source number, however this may be inaccurate.
     * - ```scheduled``` A message can be scheduled for delivery in the future
     * by setting the scheduled property.
     *   The scheduled property expects a date time specified in ISO 8601 format. The scheduled time must be
     *   provided in UTC and is optional. If no scheduled property is set, the message will be delivered immediately.
     * - ```message_expiry_timestamp``` A message expiry timestamp can be
     * provided to specify the latest time
     *   at which the message should be delivered. If the message cannot be delivered before the specified
     *   message expiry timestamp elapses, the message will be discarded. Specifying a message expiry 
     *   timestamp is optional.
     * - ```metadata``` Metadata can be included with the message which will
     * then be included with any delivery
     *   reports or replies matched to the message. This can be used to create powerful two-way messaging
     *   applications without having to store persistent data in the application. Up to 10 key / value metadata data
     *   pairs can be specified in a message. Each key can be up to 100 characters long, and each value up to 
     *   256 characters long. Specifying metadata for a message is optional.
     * The response body of a successful POST request to the messages endpoint
     * will include a ```messages``` property which contains a list of all messages submitted. The list of
     * messages submitted will reflect the list of messages included in the request, but each message
     * will also contain two new properties, ```message_id``` and ```status```. The returned message ID
     * will be a 36 character UUID which can be used to check the status of the message via the Get Message
     * Status endpoint. The status of the message which reflect the status of the message at submission
     * time which will always be ```queued```. See the Delivery Reports section of this documentation for
     * more information on message statues.
     * *Note: when sending multiple messages in a request, all messages must be valid for the request 
     * to be successful. If any messages in the request are invalid, no messages will be sent.*
     * @param    body    Required parameter: Example: 
     */
    public void createSendMessagesAsync(
                final Sendmessagesrequest body,
                final APICallBack<Sendmessagesresponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildCreateSendMessagesRequest(body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            Sendmessagesresponse returnValue = _handleCreateSendMessagesResponse(_context);
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
     * Builds the HttpRequest object for createSendMessages
     */
    private HttpRequest _buildCreateSendMessagesRequest(
                final Sendmessagesrequest body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/messages");
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("user-agent", BaseController.userAgent);
        _headers.put("accept", "application/json");
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
     * Processes the response for createSendMessages
     * @return An object of type Sendmessagesresponse
     */
    private Sendmessagesresponse _handleCreateSendMessagesResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new BadRequestException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        if (_responseCode == 403) {
            throw new M403ResponseException("Unauthorised", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        Sendmessagesresponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Sendmessagesresponse>(){});

        return _result;
    }

}
