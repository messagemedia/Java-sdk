package com.messagemedia.api.controllers;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
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

public class ShortTrackableLinksReportsController extends BaseController {
    //private static variables for the singleton pattern
    private static final Object syncObject = new Object();
    private static ShortTrackableLinksReportsController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the ShortTrackableLinksReportsController class 
     */
    public static ShortTrackableLinksReportsController getInstance() {
        if (null == instance) {
            synchronized (syncObject) {
                if (null == instance) {
                    instance = new ShortTrackableLinksReportsController();
                }
            }
        }
        return instance;
    }

    /**
     * Clicks summary report for metadata key value pair, long url and short url.
     * @param    key    Optional parameter: Example: 
     * @param    value    Optional parameter: Example: 
     * @param    url    Optional parameter: Example: 
     * @param    recipient    Optional parameter: Example: 
     * @param    page    Optional parameter: Example: 
     * @param    pageSize    Optional parameter: Example: 
     * @return    Returns the LogSummaryResult response from the API call 
     */
    public LogSummaryResult getLogSummary(
                final String key,
                final String value,
                final String url,
                final String recipient,
                final Double page,
                final Double pageSize
    ) throws Throwable {

        HttpRequest _request = _buildGetLogSummaryRequest(key, value, url, recipient, page, pageSize);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetLogSummaryResponse(_context);
    }

    /**
     * Clicks summary report for metadata key value pair, long url and short url.
     * @param    key    Optional parameter: Example: 
     * @param    value    Optional parameter: Example: 
     * @param    url    Optional parameter: Example: 
     * @param    recipient    Optional parameter: Example: 
     * @param    page    Optional parameter: Example: 
     * @param    pageSize    Optional parameter: Example: 
     */
    public void getLogSummaryAsync(
                final String key,
                final String value,
                final String url,
                final String recipient,
                final Double page,
                final Double pageSize,
                final APICallBack<LogSummaryResult> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetLogSummaryRequest(key, value, url, recipient, page, pageSize);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            LogSummaryResult returnValue = _handleGetLogSummaryResponse(_context);
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
     * Builds the HttpRequest object for getLogSummary
     */
    private HttpRequest _buildGetLogSummaryRequest(
                final String key,
                final String value,
                final String url,
                final String recipient,
                final Double page,
                final Double pageSize) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/reporting/links/summary");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        if (key != null) {
            _queryParameters.put("key", key);
        }
        if (value != null) {
            _queryParameters.put("value", value);
        }
        if (url != null) {
            _queryParameters.put("url", url);
        }
        if (recipient != null) {
            _queryParameters.put("recipient", recipient);
        }
        if (page != null) {
            _queryParameters.put("page", page);
        }
        if (pageSize != null) {
            _queryParameters.put("pageSize", pageSize);
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
     * Processes the response for getLogSummary
     * @return An object of type LogSummaryResult
     */
    private LogSummaryResult _handleGetLogSummaryResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new APIException("Bad Request. Invalid data provided", _context);
        }
        if (_responseCode == 404) {
            throw new APIException("Data cannot be found", _context);
        }
        if (_responseCode == 500) {
            throw new APIException("System Error", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        LogSummaryResult _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<LogSummaryResult>(){});

        return _result;
    }

    /**
     * Detailed clicks report for a hashcode.
     * @param    hash    Required parameter: Example: 
     * @param    page    Optional parameter: Example: 
     * @param    pageSize    Optional parameter: Example: 
     * @return    Returns the LogsDetailResult response from the API call 
     */
    public LogsDetailResult getLogDetail(
                final String hash,
                final Double page,
                final Double pageSize
    ) throws Throwable {

        HttpRequest _request = _buildGetLogDetailRequest(hash, page, pageSize);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetLogDetailResponse(_context);
    }

    /**
     * Detailed clicks report for a hashcode.
     * @param    hash    Required parameter: Example: 
     * @param    page    Optional parameter: Example: 
     * @param    pageSize    Optional parameter: Example: 
     */
    public void getLogDetailAsync(
                final String hash,
                final Double page,
                final Double pageSize,
                final APICallBack<LogsDetailResult> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetLogDetailRequest(hash, page, pageSize);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            LogsDetailResult returnValue = _handleGetLogDetailResponse(_context);
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
     * Builds the HttpRequest object for getLogDetail
     */
    private HttpRequest _buildGetLogDetailRequest(
                final String hash,
                final Double page,
                final Double pageSize) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/reporting/links/detail");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("hash", hash);
        if (page != null) {
            _queryParameters.put("page", page);
        }
        if (pageSize != null) {
            _queryParameters.put("pageSize", pageSize);
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
     * Processes the response for getLogDetail
     * @return An object of type LogsDetailResult
     */
    private LogsDetailResult _handleGetLogDetailResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new APIException("Bad Request. Invalid data provided", _context);
        }
        if (_responseCode == 404) {
            throw new APIException("Data cannot be found", _context);
        }
        if (_responseCode == 500) {
            throw new APIException("System Error", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        LogsDetailResult _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<LogsDetailResult>(){});

        return _result;
    }

}
