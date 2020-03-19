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

public class NumberAuthorisationController extends BaseController {
    //private static variables for the singleton pattern
    private static final Object syncObject = new Object();
    private static NumberAuthorisationController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the NumberAuthorisationController class 
     */
    public static NumberAuthorisationController getInstance() {
        if (null == instance) {
            synchronized (syncObject) {
                if (null == instance) {
                    instance = new NumberAuthorisationController();
                }
            }
        }
        return instance;
    }

    /**
     * This endpoint returns a list of 100 numbers that are on the blacklist.  There is a pagination token to retrieve the next 100 numbers
     * In the example response the numbers `+61491570156` and `+61491570157` are on the blacklist and therefore will never receive any messages from you.
     * @return    Returns the Getnumberauthorisationblacklistresponse response from the API call 
     */
    public Getnumberauthorisationblacklistresponse listAllBlockedNumbers(
    ) throws Throwable {

        HttpRequest _request = _buildListAllBlockedNumbersRequest();
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleListAllBlockedNumbersResponse(_context);
    }

    /**
     * This endpoint returns a list of 100 numbers that are on the blacklist.  There is a pagination token to retrieve the next 100 numbers
     * In the example response the numbers `+61491570156` and `+61491570157` are on the blacklist and therefore will never receive any messages from you.
     */
    public void listAllBlockedNumbersAsync(
                final APICallBack<Getnumberauthorisationblacklistresponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildListAllBlockedNumbersRequest();
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            Getnumberauthorisationblacklistresponse returnValue = _handleListAllBlockedNumbersResponse(_context);
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
     * Builds the HttpRequest object for listAllBlockedNumbers
     */
    private HttpRequest _buildListAllBlockedNumbersRequest() throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/number_authorisation/mt/blacklist");
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
     * Processes the response for listAllBlockedNumbers
     * @return An object of type Getnumberauthorisationblacklistresponse
     */
    private Getnumberauthorisationblacklistresponse _handleListAllBlockedNumbersResponse(HttpContext _context)
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
        Getnumberauthorisationblacklistresponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Getnumberauthorisationblacklistresponse>(){});

        return _result;
    }

    /**
     * This endpoint allows you to add one or more numbers to your blacklist. You can add up to 10 numbers in one request.
     * NOTE: numbers need to be in international format and therefore start with a +
     * @param    body    Required parameter: Example: 
     * @return    Returns the Addoneormorenumberstoyourbacklistresponse response from the API call 
     */
    public Addoneormorenumberstoyourbacklistresponse addOneOrMoreNumbersToYourBacklist(
                final Addoneormorenumberstoyourbacklistrequest body
    ) throws Throwable {

        HttpRequest _request = _buildAddOneOrMoreNumbersToYourBacklistRequest(body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleAddOneOrMoreNumbersToYourBacklistResponse(_context);
    }

    /**
     * This endpoint allows you to add one or more numbers to your blacklist. You can add up to 10 numbers in one request.
     * NOTE: numbers need to be in international format and therefore start with a +
     * @param    body    Required parameter: Example: 
     */
    public void addOneOrMoreNumbersToYourBacklistAsync(
                final Addoneormorenumberstoyourbacklistrequest body,
                final APICallBack<Addoneormorenumberstoyourbacklistresponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildAddOneOrMoreNumbersToYourBacklistRequest(body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            Addoneormorenumberstoyourbacklistresponse returnValue = _handleAddOneOrMoreNumbersToYourBacklistResponse(_context);
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
     * Builds the HttpRequest object for addOneOrMoreNumbersToYourBacklist
     */
    private HttpRequest _buildAddOneOrMoreNumbersToYourBacklistRequest(
                final Addoneormorenumberstoyourbacklistrequest body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/number_authorisation/mt/blacklist");
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
     * Processes the response for addOneOrMoreNumbersToYourBacklist
     * @return An object of type Addoneormorenumberstoyourbacklistresponse
     */
    private Addoneormorenumberstoyourbacklistresponse _handleAddOneOrMoreNumbersToYourBacklistResponse(HttpContext _context)
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
        Addoneormorenumberstoyourbacklistresponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Addoneormorenumberstoyourbacklistresponse>(){});

        return _result;
    }

    /**
     * This endpoint allows you to remove a number from the blacklist.  Only one number can be deleted per request.
     * In the example +61491570157 will be removed from the blacklist.
     * NOTE:  numbers need to be in international format and therefore start with a +
     * @param    number    Required parameter: a number in international format e.g. ```+61491570156```
     * @return    Returns the InputStream response from the API call 
     */
    public InputStream removeANumberFromTheBlacklist(
                final String number
    ) throws Throwable {

        HttpRequest _request = _buildRemoveANumberFromTheBlacklistRequest(number);
        HttpResponse _response = getClientInstance().executeAsBinary(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleRemoveANumberFromTheBlacklistResponse(_context);
    }

    /**
     * This endpoint allows you to remove a number from the blacklist.  Only one number can be deleted per request.
     * In the example +61491570157 will be removed from the blacklist.
     * NOTE:  numbers need to be in international format and therefore start with a +
     * @param    number    Required parameter: a number in international format e.g. ```+61491570156```
     */
    public void removeANumberFromTheBlacklistAsync(
                final String number,
                final APICallBack<InputStream> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildRemoveANumberFromTheBlacklistRequest(number);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsBinaryAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            InputStream returnValue = _handleRemoveANumberFromTheBlacklistResponse(_context);
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
     * Builds the HttpRequest object for removeANumberFromTheBlacklist
     */
    private HttpRequest _buildRemoveANumberFromTheBlacklistRequest(
                final String number) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/number_authorisation/mt/blacklist/{number}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("number", number);
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
     * Processes the response for removeANumberFromTheBlacklist
     * @return An object of type InputStream
     */
    private InputStream _handleRemoveANumberFromTheBlacklistResponse(HttpContext _context)
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

        //extract result from the http response
        InputStream _result = _response.getRawBody();
        return _result;
    }

    /**
     * This endpoints lists for each requested number if you are authorised (which means the number is not blacklisted) to send to this number.
     * In the example given +61491570157 is on the blacklist.
     * NOTE: We do this call for you internally no matter what. Use this endpoint only if you want to have some indication upfront. If you send a message which is on the blacklist, we issue a delivery receipt with the appropriate status code.
     * @param    numbers    Required parameter: one or more numbers in international format seperate by a comma, e.g. ```+61491570156,+61491570157```
     * @return    Returns the Checkifoneorseveralnumbersarecurrentlyblacklistedresponse response from the API call 
     */
    public Checkifoneorseveralnumbersarecurrentlyblacklistedresponse getCheckIfOneOrSeveralNumbersAreCurrentlyBlacklisted(
                final List<String> numbers
    ) throws Throwable {

        HttpRequest _request = _buildGetCheckIfOneOrSeveralNumbersAreCurrentlyBlacklistedRequest(numbers);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetCheckIfOneOrSeveralNumbersAreCurrentlyBlacklistedResponse(_context);
    }

    /**
     * This endpoints lists for each requested number if you are authorised (which means the number is not blacklisted) to send to this number.
     * In the example given +61491570157 is on the blacklist.
     * NOTE: We do this call for you internally no matter what. Use this endpoint only if you want to have some indication upfront. If you send a message which is on the blacklist, we issue a delivery receipt with the appropriate status code.
     * @param    numbers    Required parameter: one or more numbers in international format seperate by a comma, e.g. ```+61491570156,+61491570157```
     */
    public void getCheckIfOneOrSeveralNumbersAreCurrentlyBlacklistedAsync(
                final List<String> numbers,
                final APICallBack<Checkifoneorseveralnumbersarecurrentlyblacklistedresponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetCheckIfOneOrSeveralNumbersAreCurrentlyBlacklistedRequest(numbers);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            Checkifoneorseveralnumbersarecurrentlyblacklistedresponse returnValue = _handleGetCheckIfOneOrSeveralNumbersAreCurrentlyBlacklistedResponse(_context);
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
     * Builds the HttpRequest object for getCheckIfOneOrSeveralNumbersAreCurrentlyBlacklisted
     */
    private HttpRequest _buildGetCheckIfOneOrSeveralNumbersAreCurrentlyBlacklistedRequest(
                final List<String> numbers) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/number_authorisation/is_authorised/{numbers}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("numbers", numbers);
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
     * Processes the response for getCheckIfOneOrSeveralNumbersAreCurrentlyBlacklisted
     * @return An object of type Checkifoneorseveralnumbersarecurrentlyblacklistedresponse
     */
    private Checkifoneorseveralnumbersarecurrentlyblacklistedresponse _handleGetCheckIfOneOrSeveralNumbersAreCurrentlyBlacklistedResponse(HttpContext _context)
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
        Checkifoneorseveralnumbersarecurrentlyblacklistedresponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Checkifoneorseveralnumbersarecurrentlyblacklistedresponse>(){});

        return _result;
    }

}
