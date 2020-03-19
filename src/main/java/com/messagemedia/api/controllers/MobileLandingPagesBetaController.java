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

public class MobileLandingPagesBetaController extends BaseController {
    //private static variables for the singleton pattern
    private static final Object syncObject = new Object();
    private static MobileLandingPagesBetaController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the MobileLandingPagesBetaController class 
     */
    public static MobileLandingPagesBetaController getInstance() {
        if (null == instance) {
            synchronized (syncObject) {
                if (null == instance) {
                    instance = new MobileLandingPagesBetaController();
                }
            }
        }
        return instance;
    }

    /**
     * Mobile Landing Pages Campaigns belonging to the user.Create a new campaign.
     * @param    body    Required parameter: Example: 
     * @return    Returns the CreateNewCampaignresponse response from the API call 
     */
    public CreateNewCampaignresponse createNewCampaign(
                final Campaign body
    ) throws Throwable {

        HttpRequest _request = _buildCreateNewCampaignRequest(body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateNewCampaignResponse(_context);
    }

    /**
     * Mobile Landing Pages Campaigns belonging to the user.Create a new campaign.
     * @param    body    Required parameter: Example: 
     */
    public void createNewCampaignAsync(
                final Campaign body,
                final APICallBack<CreateNewCampaignresponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildCreateNewCampaignRequest(body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            CreateNewCampaignresponse returnValue = _handleCreateNewCampaignResponse(_context);
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
     * Builds the HttpRequest object for createNewCampaign
     */
    private HttpRequest _buildCreateNewCampaignRequest(
                final Campaign body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/beta/smsplus/campaigns");
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
     * Processes the response for createNewCampaign
     * @return An object of type CreateNewCampaignresponse
     */
    private CreateNewCampaignresponse _handleCreateNewCampaignResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new APIException("", _context);
        }
        if (_responseCode == 402) {
            throw new APIException("", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        CreateNewCampaignresponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<CreateNewCampaignresponse>(){});

        return _result;
    }

    /**
     * A single campaign, identified by a unique identifier.Returns the details of a single campaign.
     * @param    id    Required parameter: Example: 
     * @return    Returns the GetCampaignresponse response from the API call 
     */
    public GetCampaignresponse getCampaign(
                final String id
    ) throws Throwable {

        HttpRequest _request = _buildGetCampaignRequest(id);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetCampaignResponse(_context);
    }

    /**
     * A single campaign, identified by a unique identifier.Returns the details of a single campaign.
     * @param    id    Required parameter: Example: 
     */
    public void getCampaignAsync(
                final String id,
                final APICallBack<GetCampaignresponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetCampaignRequest(id);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            GetCampaignresponse returnValue = _handleGetCampaignResponse(_context);
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
     * Builds the HttpRequest object for getCampaign
     */
    private HttpRequest _buildGetCampaignRequest(
                final String id) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/beta/smsplus/campaigns/{id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("id", id);
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
     * Processes the response for getCampaign
     * @return An object of type GetCampaignresponse
     */
    private GetCampaignresponse _handleGetCampaignResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        GetCampaignresponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<GetCampaignresponse>(){});

        return _result;
    }

    /**
     * Sends a campaign message to a group of recipients.
     * @param    id    Required parameter: Example: 
     * @param    body    Required parameter: Example: 
     * @return    Returns the SendCampaignToRecipientsresponse response from the API call 
     */
    public SendCampaignToRecipientsresponse createSendCampaignToRecipients(
                final String id,
                final SendCampaignToRecipientsrequest body
    ) throws Throwable {

        HttpRequest _request = _buildCreateSendCampaignToRecipientsRequest(id, body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateSendCampaignToRecipientsResponse(_context);
    }

    /**
     * Sends a campaign message to a group of recipients.
     * @param    id    Required parameter: Example: 
     * @param    body    Required parameter: Example: 
     */
    public void createSendCampaignToRecipientsAsync(
                final String id,
                final SendCampaignToRecipientsrequest body,
                final APICallBack<SendCampaignToRecipientsresponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildCreateSendCampaignToRecipientsRequest(id, body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            SendCampaignToRecipientsresponse returnValue = _handleCreateSendCampaignToRecipientsResponse(_context);
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
     * Builds the HttpRequest object for createSendCampaignToRecipients
     */
    private HttpRequest _buildCreateSendCampaignToRecipientsRequest(
                final String id,
                final SendCampaignToRecipientsrequest body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/beta/smsplus/campaigns/{id}/recipients");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("id", id);
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);
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
     * Processes the response for createSendCampaignToRecipients
     * @return An object of type SendCampaignToRecipientsresponse
     */
    private SendCampaignToRecipientsresponse _handleCreateSendCampaignToRecipientsResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        SendCampaignToRecipientsresponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<SendCampaignToRecipientsresponse>(){});

        return _result;
    }

    /**
     * The Landing Page datastore makes it easier to create Campiangs based on the saved data.Create a Landing Page.
     * @param    body    Required parameter: Example: 
     * @return    Returns the CreateaLandingPageresponse response from the API call 
     */
    public CreateaLandingPageresponse createaLandingPage(
                final CreateLandingPage body
    ) throws Throwable {

        HttpRequest _request = _buildCreateaLandingPageRequest(body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateaLandingPageResponse(_context);
    }

    /**
     * The Landing Page datastore makes it easier to create Campiangs based on the saved data.Create a Landing Page.
     * @param    body    Required parameter: Example: 
     */
    public void createaLandingPageAsync(
                final CreateLandingPage body,
                final APICallBack<CreateaLandingPageresponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildCreateaLandingPageRequest(body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            CreateaLandingPageresponse returnValue = _handleCreateaLandingPageResponse(_context);
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
     * Builds the HttpRequest object for createaLandingPage
     */
    private HttpRequest _buildCreateaLandingPageRequest(
                final CreateLandingPage body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/beta/smsplus/landing_pages");
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
     * Processes the response for createaLandingPage
     * @return An object of type CreateaLandingPageresponse
     */
    private CreateaLandingPageresponse _handleCreateaLandingPageResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new APIException("", _context);
        }
        if (_responseCode == 402) {
            throw new APIException("", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        CreateaLandingPageresponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<CreateaLandingPageresponse>(){});

        return _result;
    }

    /**
     * The Landing Page datastore makes it easier to create Campiangs based on the saved data.Returns a paginated list of Landing Pages for your account. ```sort_by``` and ```sort_direction``` must both be specified or neither at all (the default sort options are ```DESCENDING``` ```MODIFIED_TIMESTAMP```).
     * @param    pageSize    Optional parameter: Page size between 5 and 100 (default 20)
     * @param    pageToken    Optional parameter: Token to fetch the next page
     * @param    sortBy    Optional parameter: Can be `CREATED_TIMESTAMP` or `UPDATED_TIMESTAMP`
     * @param    sortDirection    Optional parameter: Can be `ASCENDING` or `DESCENDING`
     * @return    Returns the Object response from the API call 
     */
    public Object getLandingPages(
                final String pageSize,
                final String pageToken,
                final String sortBy,
                final String sortDirection
    ) throws Throwable {

        HttpRequest _request = _buildGetLandingPagesRequest(pageSize, pageToken, sortBy, sortDirection);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetLandingPagesResponse(_context);
    }

    /**
     * The Landing Page datastore makes it easier to create Campiangs based on the saved data.Returns a paginated list of Landing Pages for your account. ```sort_by``` and ```sort_direction``` must both be specified or neither at all (the default sort options are ```DESCENDING``` ```MODIFIED_TIMESTAMP```).
     * @param    pageSize    Optional parameter: Page size between 5 and 100 (default 20)
     * @param    pageToken    Optional parameter: Token to fetch the next page
     * @param    sortBy    Optional parameter: Can be `CREATED_TIMESTAMP` or `UPDATED_TIMESTAMP`
     * @param    sortDirection    Optional parameter: Can be `ASCENDING` or `DESCENDING`
     */
    public void getLandingPagesAsync(
                final String pageSize,
                final String pageToken,
                final String sortBy,
                final String sortDirection,
                final APICallBack<Object> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetLandingPagesRequest(pageSize, pageToken, sortBy, sortDirection);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            Object returnValue = _handleGetLandingPagesResponse(_context);
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
     * Builds the HttpRequest object for getLandingPages
     */
    private HttpRequest _buildGetLandingPagesRequest(
                final String pageSize,
                final String pageToken,
                final String sortBy,
                final String sortDirection) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/beta/smsplus/landing_pages");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        if (pageSize != null) {
            _queryParameters.put("page_size", pageSize);
        }
        if (pageToken != null) {
            _queryParameters.put("page_token", pageToken);
        }
        if (sortBy != null) {
            _queryParameters.put("sort_by", sortBy);
        }
        if (sortDirection != null) {
            _queryParameters.put("sort_direction", sortDirection);
        }
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
     * Processes the response for getLandingPages
     * @return An object of type Object
     */
    private Object _handleGetLandingPagesResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 402) {
            throw new APIException("", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        Object _result = _responseBody;

        return _result;
    }

    /**
     * The Landing Page datastore makes it easier to create Campiangs based on the saved data.Update a Landing Page.
     * @param    id    Required parameter: Example: 
     * @param    body    Required parameter: Example: 
     * @return    Returns the UpdateaLandingPageresponse response from the API call 
     */
    public UpdateaLandingPageresponse updateaLandingPage(
                final String id,
                final UpdateLandingPage body
    ) throws Throwable {

        HttpRequest _request = _buildUpdateaLandingPageRequest(id, body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateaLandingPageResponse(_context);
    }

    /**
     * The Landing Page datastore makes it easier to create Campiangs based on the saved data.Update a Landing Page.
     * @param    id    Required parameter: Example: 
     * @param    body    Required parameter: Example: 
     */
    public void updateaLandingPageAsync(
                final String id,
                final UpdateLandingPage body,
                final APICallBack<UpdateaLandingPageresponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildUpdateaLandingPageRequest(id, body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            UpdateaLandingPageresponse returnValue = _handleUpdateaLandingPageResponse(_context);
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
     * Builds the HttpRequest object for updateaLandingPage
     */
    private HttpRequest _buildUpdateaLandingPageRequest(
                final String id,
                final UpdateLandingPage body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/beta/smsplus/landing_pages/{id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("id", id);
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("user-agent", BaseController.userAgent);
        _headers.put("accept", "application/json");
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
     * Processes the response for updateaLandingPage
     * @return An object of type UpdateaLandingPageresponse
     */
    private UpdateaLandingPageresponse _handleUpdateaLandingPageResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new APIException("", _context);
        }
        if (_responseCode == 402) {
            throw new APIException("", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        UpdateaLandingPageresponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<UpdateaLandingPageresponse>(){});

        return _result;
    }

    /**
     * The Landing Page datastore makes it easier to create Campiangs based on the saved data.Delete a Landing Page.
     * @param    id    Required parameter: Example: 
     */
    public void deleteaLandingPage(
                final String id
    ) throws Throwable {

        HttpRequest _request = _buildDeleteaLandingPageRequest(id);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        _handleDeleteaLandingPageResponse(_context);
    }

    /**
     * The Landing Page datastore makes it easier to create Campiangs based on the saved data.Delete a Landing Page.
     * @param    id    Required parameter: Example: 
     */
    public void deleteaLandingPageAsync(
                final String id,
                final APICallBack<Object> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildDeleteaLandingPageRequest(id);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            _handleDeleteaLandingPageResponse(_context);
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
     * Builds the HttpRequest object for deleteaLandingPage
     */
    private HttpRequest _buildDeleteaLandingPageRequest(
                final String id) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/beta/smsplus/landing_pages/{id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("id", id);
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
     * Processes the response for deleteaLandingPage
     */
    private void _handleDeleteaLandingPageResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 402) {
            throw new APIException("", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);


    }

    /**
     * The reporting endpoint provides access to the reporting analytics.
     * ### Events Types
     * The campaign report consists of a series of events, that were generated by recipients when
     * interacting with the generated mobile landing page.  The set of events that are currently supported
     * are as follows:
     * | Event Type        | Event Source | Description                                    |
     * |:------------------|:-------------|:-----------------------------------------------|
     * | `PAGE_OPEN`       | n/a          | The page was opened in a browser.              |
     * | `BUTTON_CLICKED`  | Button label | One of the Call to Action buttons was clicked. |
     * | `FORM_SUBMITTED`  | n/a          | A form has been submitted with the captured data stored in the 'data' field. |Returns the breakdown of events and recipients of a particular campaign.
     * This will contain the following bits of information:
     * - The total number of events recorded for the particular campaign.
     * - The number of unique engagements.  This is the number of recipients for which there exists at least one recorded event.
     * - A breakdown of the number of the total number of events grouped by the event type and event source
     * The event breakdown will return the following information for each event and source type:
     * - The total number of recorded events of that type and source
     * - The number of unique recipients for which that event and source was recorded for at least once
     * For example, if a recipient opened the landing page three times, the number of recorded events will be 3 but the number of unique recipients will be 1.
     * @param    campaignId    Required parameter: The campaign ID
     * @return    Returns the CampaignSummary response from the API call 
     */
    public CampaignSummary getCampaignSummary(
                final String campaignId
    ) throws Throwable {

        HttpRequest _request = _buildGetCampaignSummaryRequest(campaignId);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetCampaignSummaryResponse(_context);
    }

    /**
     * The reporting endpoint provides access to the reporting analytics.
     * ### Events Types
     * The campaign report consists of a series of events, that were generated by recipients when
     * interacting with the generated mobile landing page.  The set of events that are currently supported
     * are as follows:
     * | Event Type        | Event Source | Description                                    |
     * |:------------------|:-------------|:-----------------------------------------------|
     * | `PAGE_OPEN`       | n/a          | The page was opened in a browser.              |
     * | `BUTTON_CLICKED`  | Button label | One of the Call to Action buttons was clicked. |
     * | `FORM_SUBMITTED`  | n/a          | A form has been submitted with the captured data stored in the 'data' field. |Returns the breakdown of events and recipients of a particular campaign.
     * This will contain the following bits of information:
     * - The total number of events recorded for the particular campaign.
     * - The number of unique engagements.  This is the number of recipients for which there exists at least one recorded event.
     * - A breakdown of the number of the total number of events grouped by the event type and event source
     * The event breakdown will return the following information for each event and source type:
     * - The total number of recorded events of that type and source
     * - The number of unique recipients for which that event and source was recorded for at least once
     * For example, if a recipient opened the landing page three times, the number of recorded events will be 3 but the number of unique recipients will be 1.
     * @param    campaignId    Required parameter: The campaign ID
     */
    public void getCampaignSummaryAsync(
                final String campaignId,
                final APICallBack<CampaignSummary> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetCampaignSummaryRequest(campaignId);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            CampaignSummary returnValue = _handleGetCampaignSummaryResponse(_context);
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
     * Builds the HttpRequest object for getCampaignSummary
     */
    private HttpRequest _buildGetCampaignSummaryRequest(
                final String campaignId) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/beta/smsplus/reporting/{campaign_id}/summary");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("campaign_id", campaignId);
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
     * Processes the response for getCampaignSummary
     * @return An object of type CampaignSummary
     */
    private CampaignSummary _handleGetCampaignSummaryResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        CampaignSummary _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<CampaignSummary>(){});

        return _result;
    }

    /**
     * The reporting endpoint provides access to the reporting analytics.
     * ### Events Types
     * The campaign report consists of a series of events, that were generated by recipients when
     * interacting with the generated mobile landing page.  The set of events that are currently supported
     * are as follows:
     * | Event Type        | Event Source | Description                                    |
     * |:------------------|:-------------|:-----------------------------------------------|
     * | `PAGE_OPEN`       | n/a          | The page was opened in a browser.              |
     * | `BUTTON_CLICKED`  | Button label | One of the Call to Action buttons was clicked. |
     * | `FORM_SUBMITTED`  | n/a          | A form has been submitted with the captured data stored in the 'data' field. |Returns a list of events that have occurred for a particular campaign.
     * At this stage, the events are returned in reverse chronological order.
     * @param    campaignId    Required parameter: The campaign ID
     * @param    page    Optional parameter: The page of results to retrieve.  If unspecified, defaults to 0.
     * @param    pageSize    Optional parameter: The size of each page.  Must be between 5 and 100.  Defaults to 25.
     * @return    Returns the ListCampaignEventPage response from the API call 
     */
    public ListCampaignEventPage getCampaignEvents(
                final String campaignId,
                final Double page,
                final Double pageSize
    ) throws Throwable {

        HttpRequest _request = _buildGetCampaignEventsRequest(campaignId, page, pageSize);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetCampaignEventsResponse(_context);
    }

    /**
     * The reporting endpoint provides access to the reporting analytics.
     * ### Events Types
     * The campaign report consists of a series of events, that were generated by recipients when
     * interacting with the generated mobile landing page.  The set of events that are currently supported
     * are as follows:
     * | Event Type        | Event Source | Description                                    |
     * |:------------------|:-------------|:-----------------------------------------------|
     * | `PAGE_OPEN`       | n/a          | The page was opened in a browser.              |
     * | `BUTTON_CLICKED`  | Button label | One of the Call to Action buttons was clicked. |
     * | `FORM_SUBMITTED`  | n/a          | A form has been submitted with the captured data stored in the 'data' field. |Returns a list of events that have occurred for a particular campaign.
     * At this stage, the events are returned in reverse chronological order.
     * @param    campaignId    Required parameter: The campaign ID
     * @param    page    Optional parameter: The page of results to retrieve.  If unspecified, defaults to 0.
     * @param    pageSize    Optional parameter: The size of each page.  Must be between 5 and 100.  Defaults to 25.
     */
    public void getCampaignEventsAsync(
                final String campaignId,
                final Double page,
                final Double pageSize,
                final APICallBack<ListCampaignEventPage> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetCampaignEventsRequest(campaignId, page, pageSize);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            ListCampaignEventPage returnValue = _handleGetCampaignEventsResponse(_context);
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
     * Builds the HttpRequest object for getCampaignEvents
     */
    private HttpRequest _buildGetCampaignEventsRequest(
                final String campaignId,
                final Double page,
                final Double pageSize) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/beta/smsplus/reporting/{campaign_id}/events");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("campaign_id", campaignId);
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        if (page != null) {
            _queryParameters.put("page", page);
        }
        if (pageSize != null) {
            _queryParameters.put("page_size", pageSize);
        }
        APIHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);
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
     * Processes the response for getCampaignEvents
     * @return An object of type ListCampaignEventPage
     */
    private ListCampaignEventPage _handleGetCampaignEventsResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 402) {
            throw new APIException("", _context);
        }
        if (_responseCode == 404) {
            throw new APIException("", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        ListCampaignEventPage _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<ListCampaignEventPage>(){});

        return _result;
    }

    /**
     * The reporting endpoint provides access to the reporting analytics.
     * ### Events Types
     * The campaign report consists of a series of events, that were generated by recipients when
     * interacting with the generated mobile landing page.  The set of events that are currently supported
     * are as follows:
     * | Event Type        | Event Source | Description                                    |
     * |:------------------|:-------------|:-----------------------------------------------|
     * | `PAGE_OPEN`       | n/a          | The page was opened in a browser.              |
     * | `BUTTON_CLICKED`  | Button label | One of the Call to Action buttons was clicked. |
     * | `FORM_SUBMITTED`  | n/a          | A form has been submitted with the captured data stored in the 'data' field. |Produces an unpaginated CSV file of events that have occurred for a particular campaign and emails them to the specified address(es).
     * At this stage, the events are returned in reverse chronological order.
     * @param    campaignId    Required parameter: The campaign ID
     */
    public void getExportCampaignEventsAsync(
                final String campaignId
    ) throws Throwable {

        HttpRequest _request = _buildGetExportCampaignEventsAsyncRequest(campaignId);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        _handleGetExportCampaignEventsAsyncResponse(_context);
    }

    /**
     * The reporting endpoint provides access to the reporting analytics.
     * ### Events Types
     * The campaign report consists of a series of events, that were generated by recipients when
     * interacting with the generated mobile landing page.  The set of events that are currently supported
     * are as follows:
     * | Event Type        | Event Source | Description                                    |
     * |:------------------|:-------------|:-----------------------------------------------|
     * | `PAGE_OPEN`       | n/a          | The page was opened in a browser.              |
     * | `BUTTON_CLICKED`  | Button label | One of the Call to Action buttons was clicked. |
     * | `FORM_SUBMITTED`  | n/a          | A form has been submitted with the captured data stored in the 'data' field. |Produces an unpaginated CSV file of events that have occurred for a particular campaign and emails them to the specified address(es).
     * At this stage, the events are returned in reverse chronological order.
     * @param    campaignId    Required parameter: The campaign ID
     */
    public void getExportCampaignEventsAsyncAsync(
                final String campaignId,
                final APICallBack<Object> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetExportCampaignEventsAsyncRequest(campaignId);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            _handleGetExportCampaignEventsAsyncResponse(_context);
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
     * Builds the HttpRequest object for getExportCampaignEventsAsync
     */
    private HttpRequest _buildGetExportCampaignEventsAsyncRequest(
                final String campaignId) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/beta/smsplus/reporting/{campaign_id}/events/async");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("campaign_id", campaignId);
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);
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
     * Processes the response for getExportCampaignEventsAsync
     */
    private void _handleGetExportCampaignEventsAsyncResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 402) {
            throw new APIException("", _context);
        }
        if (_responseCode == 404) {
            throw new APIException("", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);


    }

    /**
     * Returns a paginated list of Template.
     * @param    pageSize    Optional parameter: Page size between 5 and 100 (default 20)
     * @param    pageToken    Optional parameter: Token to fetch the next page
     * @return    Returns the GetTemplatesresponse response from the API call 
     */
    public GetTemplatesresponse getTemplates(
                final String pageSize,
                final String pageToken
    ) throws Throwable {

        HttpRequest _request = _buildGetTemplatesRequest(pageSize, pageToken);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetTemplatesResponse(_context);
    }

    /**
     * Returns a paginated list of Template.
     * @param    pageSize    Optional parameter: Page size between 5 and 100 (default 20)
     * @param    pageToken    Optional parameter: Token to fetch the next page
     */
    public void getTemplatesAsync(
                final String pageSize,
                final String pageToken,
                final APICallBack<GetTemplatesresponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetTemplatesRequest(pageSize, pageToken);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            GetTemplatesresponse returnValue = _handleGetTemplatesResponse(_context);
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
     * Builds the HttpRequest object for getTemplates
     */
    private HttpRequest _buildGetTemplatesRequest(
                final String pageSize,
                final String pageToken) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/beta/smsplus/templates");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        if (pageSize != null) {
            _queryParameters.put("page_size", pageSize);
        }
        if (pageToken != null) {
            _queryParameters.put("page_token", pageToken);
        }
        APIHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);
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
     * Processes the response for getTemplates
     * @return An object of type GetTemplatesresponse
     */
    private GetTemplatesresponse _handleGetTemplatesResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 402) {
            throw new APIException("", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        GetTemplatesresponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<GetTemplatesresponse>(){});

        return _result;
    }

    /**
     * Returns a list of Template Field Defination.
     * @param    id    Required parameter: Template Id
     * @return    Returns the GetTemplatesFieldsDefinationresponse response from the API call 
     */
    public GetTemplatesFieldsDefinationresponse getTemplatesFieldsDefination(
                final String id
    ) throws Throwable {

        HttpRequest _request = _buildGetTemplatesFieldsDefinationRequest(id);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetTemplatesFieldsDefinationResponse(_context);
    }

    /**
     * Returns a list of Template Field Defination.
     * @param    id    Required parameter: Template Id
     */
    public void getTemplatesFieldsDefinationAsync(
                final String id,
                final APICallBack<GetTemplatesFieldsDefinationresponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetTemplatesFieldsDefinationRequest(id);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            GetTemplatesFieldsDefinationresponse returnValue = _handleGetTemplatesFieldsDefinationResponse(_context);
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
     * Builds the HttpRequest object for getTemplatesFieldsDefination
     */
    private HttpRequest _buildGetTemplatesFieldsDefinationRequest(
                final String id) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/beta/smsplus/templates/{id}/fields");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("id", id);
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
     * Processes the response for getTemplatesFieldsDefination
     * @return An object of type GetTemplatesFieldsDefinationresponse
     */
    private GetTemplatesFieldsDefinationresponse _handleGetTemplatesFieldsDefinationResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 402) {
            throw new APIException("", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        GetTemplatesFieldsDefinationresponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<GetTemplatesFieldsDefinationresponse>(){});

        return _result;
    }

}
