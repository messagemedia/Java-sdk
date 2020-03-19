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

public class DedicatedNumbersController extends BaseController {
    //private static variables for the singleton pattern
    private static final Object syncObject = new Object();
    private static DedicatedNumbersController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the DedicatedNumbersController class 
     */
    public static DedicatedNumbersController getInstance() {
        if (null == instance) {
            synchronized (syncObject) {
                if (null == instance) {
                    instance = new DedicatedNumbersController();
                }
            }
        }
        return instance;
    }

    /**
     * Get a list of available dedicated numbers, filtered by requirements.
     * @param    country    Optional parameter: ISO_3166 country code, 2 character code to filter available numbers by country
     * @param    matching    Optional parameter: filters results by a pattern of digits contained within the number
     * @param    pageSize    Optional parameter: number of results returned per page, default 50
     * @param    serviceTypes    Optional parameter: filter results to include numbers with certain capabilities
     * @param    token    Optional parameter: In paginated data the original request will return with a "next_token" attribute. This token must be entered into subsequent call in the "token" query parameter to obtain the next set of records.
     * @return    Returns the NumbersListResponse response from the API call 
     */
    public NumbersListResponse getNumbers(
                final String country,
                final String matching,
                final Integer pageSize,
                final ServiceTypesEnum serviceTypes,
                final String token
    ) throws Throwable {

        HttpRequest _request = _buildGetNumbersRequest(country, matching, pageSize, serviceTypes, token);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetNumbersResponse(_context);
    }

    /**
     * Get a list of available dedicated numbers, filtered by requirements.
     * @param    country    Optional parameter: ISO_3166 country code, 2 character code to filter available numbers by country
     * @param    matching    Optional parameter: filters results by a pattern of digits contained within the number
     * @param    pageSize    Optional parameter: number of results returned per page, default 50
     * @param    serviceTypes    Optional parameter: filter results to include numbers with certain capabilities
     * @param    token    Optional parameter: In paginated data the original request will return with a "next_token" attribute. This token must be entered into subsequent call in the "token" query parameter to obtain the next set of records.
     */
    public void getNumbersAsync(
                final String country,
                final String matching,
                final Integer pageSize,
                final ServiceTypesEnum serviceTypes,
                final String token,
                final APICallBack<NumbersListResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetNumbersRequest(country, matching, pageSize, serviceTypes, token);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            NumbersListResponse returnValue = _handleGetNumbersResponse(_context);
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
     * Builds the HttpRequest object for getNumbers
     */
    private HttpRequest _buildGetNumbersRequest(
                final String country,
                final String matching,
                final Integer pageSize,
                final ServiceTypesEnum serviceTypes,
                final String token) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/messaging/numbers/dedicated/");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        if (country != null) {
            _queryParameters.put("country", country);
        }
        if (matching != null) {
            _queryParameters.put("matching", matching);
        }
        if (serviceTypes != null) {
            _queryParameters.put("service_types", (serviceTypes != null) ? serviceTypes.value() : null);
        }
        if (token != null) {
            _queryParameters.put("token", token);
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
     * Processes the response for getNumbers
     * @return An object of type NumbersListResponse
     */
    private NumbersListResponse _handleGetNumbersResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 403) {
            throw new M403ResponseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        NumbersListResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<NumbersListResponse>(){});

        return _result;
    }

    /**
     * Get details about a specific dedicated number.
     * @param    id    Required parameter: unique identifier
     * @param    accept    Required parameter: Example: 
     * @return    Returns the Number response from the API call 
     */
    public Number getNumberById(
                final String id,
                final String accept
    ) throws Throwable {

        HttpRequest _request = _buildGetNumberByIdRequest(id, accept);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetNumberByIdResponse(_context);
    }

    /**
     * Get details about a specific dedicated number.
     * @param    id    Required parameter: unique identifier
     * @param    accept    Required parameter: Example: 
     */
    public void getNumberByIdAsync(
                final String id,
                final String accept,
                final APICallBack<Number> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetNumberByIdRequest(id, accept);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            Number returnValue = _handleGetNumberByIdResponse(_context);
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
     * Builds the HttpRequest object for getNumberById
     */
    private HttpRequest _buildGetNumberByIdRequest(
                final String id,
                final String accept) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/messaging/numbers/dedicated/{id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("id", id);
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("Accept", accept);
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
     * Processes the response for getNumberById
     * @return An object of type Number
     */
    private Number _handleGetNumberByIdResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 403) {
            throw new M403ResponseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        if (_responseCode == 404) {
            throw new ResourceNotFoundException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        Number _result = Integer.parseInt(_responseBody);

        return _result;
    }

    /**
     * Use this endpoint to view details of the assignment including the label and metadata.
     * @param    numberId    Required parameter: unique identifier
     * @param    accept    Required parameter: Example: 
     * @return    Returns the Assignment response from the API call 
     */
    public Assignment getAssignment(
                final String numberId,
                final String accept
    ) throws Throwable {

        HttpRequest _request = _buildGetAssignmentRequest(numberId, accept);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetAssignmentResponse(_context);
    }

    /**
     * Use this endpoint to view details of the assignment including the label and metadata.
     * @param    numberId    Required parameter: unique identifier
     * @param    accept    Required parameter: Example: 
     */
    public void getAssignmentAsync(
                final String numberId,
                final String accept,
                final APICallBack<Assignment> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetAssignmentRequest(numberId, accept);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            Assignment returnValue = _handleGetAssignmentResponse(_context);
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
     * Builds the HttpRequest object for getAssignment
     */
    private HttpRequest _buildGetAssignmentRequest(
                final String numberId,
                final String accept) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/messaging/numbers/dedicated/{numberId}/assignment");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("numberId", numberId);
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("Accept", accept);
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
     * Processes the response for getAssignment
     * @return An object of type Assignment
     */
    private Assignment _handleGetAssignmentResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 403) {
            throw new M403ResponseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        if (_responseCode == 404) {
            throw new ResourceNotFoundException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        Assignment _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Assignment>(){});

        return _result;
    }

    /**
     * Assign the specified number to the authenticated account. 
     * Use the body of the request to specify a label or metadata 
     * for this number assignment.
     * If you receive a *conflict* error then the number that you have selected is unavailable for assignment. 
     * This means that the number is either already assigned to another account, 
     * or has an available_after date in the future. Should this occur, perform 
     * another search and select a different number.
     * @param    numberId    Required parameter: unique identifier
     * @param    accept    Required parameter: Example: 
     * @param    body    Required parameter: Example: 
     * @return    Returns the Assignment response from the API call 
     */
    public Assignment createAssignment(
                final String numberId,
                final String accept,
                final CreateAssignmentrequest body
    ) throws Throwable {

        HttpRequest _request = _buildCreateAssignmentRequest(numberId, accept, body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateAssignmentResponse(_context);
    }

    /**
     * Assign the specified number to the authenticated account. 
     * Use the body of the request to specify a label or metadata 
     * for this number assignment.
     * If you receive a *conflict* error then the number that you have selected is unavailable for assignment. 
     * This means that the number is either already assigned to another account, 
     * or has an available_after date in the future. Should this occur, perform 
     * another search and select a different number.
     * @param    numberId    Required parameter: unique identifier
     * @param    accept    Required parameter: Example: 
     * @param    body    Required parameter: Example: 
     */
    public void createAssignmentAsync(
                final String numberId,
                final String accept,
                final CreateAssignmentrequest body,
                final APICallBack<Assignment> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildCreateAssignmentRequest(numberId, accept, body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            Assignment returnValue = _handleCreateAssignmentResponse(_context);
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
     * Builds the HttpRequest object for createAssignment
     */
    private HttpRequest _buildCreateAssignmentRequest(
                final String numberId,
                final String accept,
                final CreateAssignmentrequest body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/messaging/numbers/dedicated/{numberId}/assignment");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("numberId", numberId);
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("Accept", accept);
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
     * Processes the response for createAssignment
     * @return An object of type Assignment
     */
    private Assignment _handleCreateAssignmentResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 403) {
            throw new M403ResponseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        if (_responseCode == 404) {
            throw new ResourceNotFoundException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        Assignment _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Assignment>(){});

        return _result;
    }

    /**
     * Release the dedicated number from your account.
     * @param    numberId    Required parameter: unique identifier
     * @param    accept    Required parameter: Example: 
     * @return    Returns the InputStream response from the API call 
     */
    public InputStream deleteAssignment(
                final String numberId,
                final String accept
    ) throws Throwable {

        HttpRequest _request = _buildDeleteAssignmentRequest(numberId, accept);
        HttpResponse _response = getClientInstance().executeAsBinary(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleDeleteAssignmentResponse(_context);
    }

    /**
     * Release the dedicated number from your account.
     * @param    numberId    Required parameter: unique identifier
     * @param    accept    Required parameter: Example: 
     */
    public void deleteAssignmentAsync(
                final String numberId,
                final String accept,
                final APICallBack<InputStream> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildDeleteAssignmentRequest(numberId, accept);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsBinaryAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            InputStream returnValue = _handleDeleteAssignmentResponse(_context);
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
     * Builds the HttpRequest object for deleteAssignment
     */
    private HttpRequest _buildDeleteAssignmentRequest(
                final String numberId,
                final String accept) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/messaging/numbers/dedicated/{numberId}/assignment");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("numberId", numberId);
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("Accept", accept);
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
     * Processes the response for deleteAssignment
     * @return An object of type InputStream
     */
    private InputStream _handleDeleteAssignmentResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 403) {
            throw new M403ResponseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        InputStream _result = _response.getRawBody();
        return _result;
    }

    /**
     * Retain the dedicated number assignment, and edit or add additional metadata or title information. You can exclude any data from the body of this request that you do not want updated.
     * @param    numberId    Required parameter: unique identifier
     * @param    accept    Required parameter: Example: 
     * @param    body    Required parameter: Example: 
     * @return    Returns the Assignment response from the API call 
     */
    public Assignment updateAssignment(
                final String numberId,
                final String accept,
                final UpdateAssignmentrequest body
    ) throws Throwable {

        HttpRequest _request = _buildUpdateAssignmentRequest(numberId, accept, body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateAssignmentResponse(_context);
    }

    /**
     * Retain the dedicated number assignment, and edit or add additional metadata or title information. You can exclude any data from the body of this request that you do not want updated.
     * @param    numberId    Required parameter: unique identifier
     * @param    accept    Required parameter: Example: 
     * @param    body    Required parameter: Example: 
     */
    public void updateAssignmentAsync(
                final String numberId,
                final String accept,
                final UpdateAssignmentrequest body,
                final APICallBack<Assignment> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildUpdateAssignmentRequest(numberId, accept, body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            Assignment returnValue = _handleUpdateAssignmentResponse(_context);
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
     * Builds the HttpRequest object for updateAssignment
     */
    private HttpRequest _buildUpdateAssignmentRequest(
                final String numberId,
                final String accept,
                final UpdateAssignmentrequest body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/messaging/numbers/dedicated/{numberId}/assignment");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("numberId", numberId);
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("Accept", accept);
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
     * Processes the response for updateAssignment
     * @return An object of type Assignment
     */
    private Assignment _handleUpdateAssignmentResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 403) {
            throw new M403ResponseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        Assignment _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Assignment>(){});

        return _result;
    }

    /**
     * Get assigned numbers
     * @param    accept    Required parameter: Example: 
     * @param    pageSize    Optional parameter: Number of results returned per page, default 50
     * @param    token    Optional parameter: In paginated data the original request will return with a "next_token" attribute. This token must be entered into subsequent call in the "token" query parameter to obtain the next set of records.
     * @param    numberId    Optional parameter: Unique identifier of a specific number
     * @param    matching    Optional parameter: Filters results by a pattern of digits contained within the number
     * @param    country    Optional parameter: Filter results by ISO_3166 country code, 2 character code to filter available numbers by country
     * @param    type    Optional parameter: Filter results by Number type
     * @param    classification    Optional parameter: Filter results by Number Classification
     * @param    serviceTypes    Optional parameter: Filter results by capabilities
     * @param    label    Optional parameter: Filter results by a matching label
     * @param    sortBy    Optional parameter: Sort results by property
     * @param    sortDirection    Optional parameter: Sort direction
     * @return    Returns the AssignedNumberListResponse response from the API call 
     */
    public AssignedNumberListResponse getAssignedNumbers(
                final String accept,
                final Integer pageSize,
                final String token,
                final String numberId,
                final String matching,
                final String country,
                final Type1Enum type,
                final ClassificationEnum classification,
                final ServiceTypesEnum serviceTypes,
                final String label,
                final SortByEnum sortBy,
                final SortDirectionEnum sortDirection
    ) throws Throwable {

        HttpRequest _request = _buildGetAssignedNumbersRequest(accept, pageSize, token, numberId, matching, country, type, classification, serviceTypes, label, sortBy, sortDirection);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetAssignedNumbersResponse(_context);
    }

    /**
     * Get assigned numbers
     * @param    accept    Required parameter: Example: 
     * @param    pageSize    Optional parameter: Number of results returned per page, default 50
     * @param    token    Optional parameter: In paginated data the original request will return with a "next_token" attribute. This token must be entered into subsequent call in the "token" query parameter to obtain the next set of records.
     * @param    numberId    Optional parameter: Unique identifier of a specific number
     * @param    matching    Optional parameter: Filters results by a pattern of digits contained within the number
     * @param    country    Optional parameter: Filter results by ISO_3166 country code, 2 character code to filter available numbers by country
     * @param    type    Optional parameter: Filter results by Number type
     * @param    classification    Optional parameter: Filter results by Number Classification
     * @param    serviceTypes    Optional parameter: Filter results by capabilities
     * @param    label    Optional parameter: Filter results by a matching label
     * @param    sortBy    Optional parameter: Sort results by property
     * @param    sortDirection    Optional parameter: Sort direction
     */
    public void getAssignedNumbersAsync(
                final String accept,
                final Integer pageSize,
                final String token,
                final String numberId,
                final String matching,
                final String country,
                final Type1Enum type,
                final ClassificationEnum classification,
                final ServiceTypesEnum serviceTypes,
                final String label,
                final SortByEnum sortBy,
                final SortDirectionEnum sortDirection,
                final APICallBack<AssignedNumberListResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetAssignedNumbersRequest(accept, pageSize, token, numberId, matching, country, type, classification, serviceTypes, label, sortBy, sortDirection);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            AssignedNumberListResponse returnValue = _handleGetAssignedNumbersResponse(_context);
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
     * Builds the HttpRequest object for getAssignedNumbers
     */
    private HttpRequest _buildGetAssignedNumbersRequest(
                final String accept,
                final Integer pageSize,
                final String token,
                final String numberId,
                final String matching,
                final String country,
                final Type1Enum type,
                final ClassificationEnum classification,
                final ServiceTypesEnum serviceTypes,
                final String label,
                final SortByEnum sortBy,
                final SortDirectionEnum sortDirection) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/messaging/numbers/dedicated/assignments");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        if (token != null) {
            _queryParameters.put("token", token);
        }
        if (numberId != null) {
            _queryParameters.put("number_id", numberId);
        }
        if (matching != null) {
            _queryParameters.put("matching", matching);
        }
        if (country != null) {
            _queryParameters.put("country", country);
        }
        if (type != null) {
            _queryParameters.put("type", (type != null) ? type.value() : null);
        }
        if (classification != null) {
            _queryParameters.put("classification", (classification != null) ? classification.value() : null);
        }
        if (serviceTypes != null) {
            _queryParameters.put("service_types", (serviceTypes != null) ? serviceTypes.value() : null);
        }
        if (label != null) {
            _queryParameters.put("label", label);
        }
        if (sortBy != null) {
            _queryParameters.put("sort_by", (sortBy != null) ? sortBy.value() : null);
        }
        if (sortDirection != null) {
            _queryParameters.put("sort_direction", (sortDirection != null) ? sortDirection.value() : null);
        }
        APIHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("Accept", accept);
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
     * Processes the response for getAssignedNumbers
     * @return An object of type AssignedNumberListResponse
     */
    private AssignedNumberListResponse _handleGetAssignedNumbersResponse(HttpContext _context)
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
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        AssignedNumberListResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<AssignedNumberListResponse>(){});

        return _result;
    }

}
