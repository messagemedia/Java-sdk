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

public class MessagingReportsController extends BaseController {
    //private static variables for the singleton pattern
    private static final Object syncObject = new Object();
    private static MessagingReportsController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the MessagingReportsController class 
     */
    public static MessagingReportsController getInstance() {
        if (null == instance) {
            synchronized (syncObject) {
                if (null == instance) {
                    instance = new MessagingReportsController();
                }
            }
        }
        return instance;
    }

    /**
     * Returns a list of metadata keys
     * @param    messageType    Required parameter: Message type. Possible values are sent messages and received messages.
     * @param    startDate    Required parameter: Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format
     * @param    endDate    Required parameter: End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format
     * @param    accounts    Optional parameter: Filter results by a specific account. By default results  will be returned for the account associated with the authentication  credentials and all sub accounts.
     * @param    timezone    Optional parameter: The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'.
     * @return    Returns the MetadataKeysResponse response from the API call 
     */
    public MetadataKeysResponse getMetadataKeys(
                final MessageTypeEnum messageType,
                final String startDate,
                final String endDate,
                final List<String> accounts,
                final String timezone
    ) throws Throwable {

        HttpRequest _request = _buildGetMetadataKeysRequest(messageType, startDate, endDate, accounts, timezone);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetMetadataKeysResponse(_context);
    }

    /**
     * Returns a list of metadata keys
     * @param    messageType    Required parameter: Message type. Possible values are sent messages and received messages.
     * @param    startDate    Required parameter: Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format
     * @param    endDate    Required parameter: End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format
     * @param    accounts    Optional parameter: Filter results by a specific account. By default results  will be returned for the account associated with the authentication  credentials and all sub accounts.
     * @param    timezone    Optional parameter: The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'.
     */
    public void getMetadataKeysAsync(
                final MessageTypeEnum messageType,
                final String startDate,
                final String endDate,
                final List<String> accounts,
                final String timezone,
                final APICallBack<MetadataKeysResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetMetadataKeysRequest(messageType, startDate, endDate, accounts, timezone);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            MetadataKeysResponse returnValue = _handleGetMetadataKeysResponse(_context);
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
     * Builds the HttpRequest object for getMetadataKeys
     */
    private HttpRequest _buildGetMetadataKeysRequest(
                final MessageTypeEnum messageType,
                final String startDate,
                final String endDate,
                final List<String> accounts,
                final String timezone) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/reporting/{messageType}/metadata/keys");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("messageType", (messageType != null) ? messageType.value() : null);
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("start_date", startDate);
        _queryParameters.put("end_date", endDate);
        if (accounts != null) {
            _queryParameters.put("accounts", accounts);
        }
        if (timezone != null) {
            _queryParameters.put("timezone", timezone);
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
     * Processes the response for getMetadataKeys
     * @return An object of type MetadataKeysResponse
     */
    private MetadataKeysResponse _handleGetMetadataKeysResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new APIException("Bad Request. Check the json response for more details on what went wrong.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        MetadataKeysResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<MetadataKeysResponse>(){});

        return _result;
    }

    /**
     * Lists asynchronous reports.
     * @param    page    Optional parameter: Page number for paging through paginated result sets.
     * @param    pageSize    Optional parameter: Number of results to return in a page for paginated result sets.
     * @return    Returns the GetAsyncReportsResponse response from the API call 
     */
    public GetAsyncReportsResponse getAsyncReports(
                final Double page,
                final Double pageSize
    ) throws Throwable {

        HttpRequest _request = _buildGetAsyncReportsRequest(page, pageSize);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetAsyncReportsResponse(_context);
    }

    /**
     * Lists asynchronous reports.
     * @param    page    Optional parameter: Page number for paging through paginated result sets.
     * @param    pageSize    Optional parameter: Number of results to return in a page for paginated result sets.
     */
    public void getAsyncReportsAsync(
                final Double page,
                final Double pageSize,
                final APICallBack<GetAsyncReportsResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetAsyncReportsRequest(page, pageSize);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            GetAsyncReportsResponse returnValue = _handleGetAsyncReportsResponse(_context);
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
     * Builds the HttpRequest object for getAsyncReports
     */
    private HttpRequest _buildGetAsyncReportsRequest(
                final Double page,
                final Double pageSize) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/reporting/async_reports");

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
     * Processes the response for getAsyncReports
     * @return An object of type GetAsyncReportsResponse
     */
    private GetAsyncReportsResponse _handleGetAsyncReportsResponse(HttpContext _context)
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
        GetAsyncReportsResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<GetAsyncReportsResponse>(){});

        return _result;
    }

    /**
     * Gets a single asynchronous report.
     * @param    reportId    Required parameter: Unique ID of the async report
     * @return    Returns the AsyncReport response from the API call 
     */
    public AsyncReport getAsyncReportById(
                final String reportId
    ) throws Throwable {

        HttpRequest _request = _buildGetAsyncReportByIdRequest(reportId);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetAsyncReportByIdResponse(_context);
    }

    /**
     * Gets a single asynchronous report.
     * @param    reportId    Required parameter: Unique ID of the async report
     */
    public void getAsyncReportByIdAsync(
                final String reportId,
                final APICallBack<AsyncReport> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetAsyncReportByIdRequest(reportId);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            AsyncReport returnValue = _handleGetAsyncReportByIdResponse(_context);
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
     * Builds the HttpRequest object for getAsyncReportById
     */
    private HttpRequest _buildGetAsyncReportByIdRequest(
                final String reportId) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/reporting/async_reports/{report_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("report_id", reportId);
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
     * Processes the response for getAsyncReportById
     * @return An object of type AsyncReport
     */
    private AsyncReport _handleGetAsyncReportByIdResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new APIException("Bad Request. Check the json response for more details on what went wrong.", _context);
        }
        if (_responseCode == 404) {
            throw new APIException("The requested report was not found.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        AsyncReport _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<AsyncReport>(){});

        return _result;
    }

    /**
     * Gets the data of an asynchronous report.
     * @param    reportId    Required parameter: Unique ID of the async report
     * @return    Returns the InputStream response from the API call 
     */
    public InputStream getAsyncReportDataById(
                final String reportId
    ) throws Throwable {

        HttpRequest _request = _buildGetAsyncReportDataByIdRequest(reportId);
        HttpResponse _response = getClientInstance().executeAsBinary(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetAsyncReportDataByIdResponse(_context);
    }

    /**
     * Gets the data of an asynchronous report.
     * @param    reportId    Required parameter: Unique ID of the async report
     */
    public void getAsyncReportDataByIdAsync(
                final String reportId,
                final APICallBack<InputStream> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetAsyncReportDataByIdRequest(reportId);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsBinaryAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            InputStream returnValue = _handleGetAsyncReportDataByIdResponse(_context);
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
     * Builds the HttpRequest object for getAsyncReportDataById
     */
    private HttpRequest _buildGetAsyncReportDataByIdRequest(
                final String reportId) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/reporting/async_reports/{report_id}/data");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("report_id", reportId);
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
     * Processes the response for getAsyncReportDataById
     * @return An object of type InputStream
     */
    private InputStream _handleGetAsyncReportDataByIdResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new APIException("Bad Request. Check the json response for more details on what went wrong.", _context);
        }
        if (_responseCode == 404) {
            throw new APIException("Report not found or not finished.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        InputStream _result = _response.getRawBody();
        return _result;
    }

    /**
     * Submits a request to generate an async detail report
     * @param    body    Required parameter: Example: 
     * @return    Returns the AsyncReportResponse response from the API call 
     */
    public AsyncReportResponse createSubmitReceivedMessagesDetail(
                final Asyncreceivedmessagesdetailrequest body
    ) throws Throwable {

        HttpRequest _request = _buildCreateSubmitReceivedMessagesDetailRequest(body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateSubmitReceivedMessagesDetailResponse(_context);
    }

    /**
     * Submits a request to generate an async detail report
     * @param    body    Required parameter: Example: 
     */
    public void createSubmitReceivedMessagesDetailAsync(
                final Asyncreceivedmessagesdetailrequest body,
                final APICallBack<AsyncReportResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildCreateSubmitReceivedMessagesDetailRequest(body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            AsyncReportResponse returnValue = _handleCreateSubmitReceivedMessagesDetailResponse(_context);
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
     * Builds the HttpRequest object for createSubmitReceivedMessagesDetail
     */
    private HttpRequest _buildCreateSubmitReceivedMessagesDetailRequest(
                final Asyncreceivedmessagesdetailrequest body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/reporting/received_messages/detail/async");
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
     * Processes the response for createSubmitReceivedMessagesDetail
     * @return An object of type AsyncReportResponse
     */
    private AsyncReportResponse _handleCreateSubmitReceivedMessagesDetailResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new APIException("Bad Request. Check the json response for more details on what went wrong.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        AsyncReportResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<AsyncReportResponse>(){});

        return _result;
    }

    /**
     * Returns a list message received
     * @param    endDate    Required parameter: End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     * @param    startDate    Required parameter: Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     * @param    accounts    Optional parameter: Filter results by a specific account. By default results  will be returned for the account associated with the authentication  credentials and all sub accounts.
     * @param    action    Optional parameter: Filter results by the action that was invoked for this message.
     * @param    destinationAddressCountry    Optional parameter: Filter results by destination address country.
     * @param    destinationAddress    Optional parameter: Filter results by destination address.
     * @param    messageFormat    Optional parameter: Filter results by message format.
     * @param    metadataKey    Optional parameter: Filter results for messages that include a metadata key.
     * @param    metadataValue    Optional parameter: Filter results for messages that include a metadata key containing this value. If this parameter is provided, the metadata_key parameter must also be provided.
     * @param    page    Optional parameter: Page number for paging through paginated result sets.
     * @param    pageSize    Optional parameter: Number of results to return in a page for paginated result sets.
     * @param    sortBy    Optional parameter: Field to sort results set by
     * @param    sortDirection    Optional parameter: Order to sort results by.
     * @param    sourceAddressCountry    Optional parameter: Filter results by source address country.
     * @param    sourceAddress    Optional parameter: Filter results by source address.
     * @param    timezone    Optional parameter: The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'.
     * @return    Returns the ReceivedMessages response from the API call 
     */
    public ReceivedMessages getReceivedMessagesDetail(
                final String endDate,
                final String startDate,
                final List<String> accounts,
                final ActionEnum action,
                final String destinationAddressCountry,
                final String destinationAddress,
                final Format1Enum messageFormat,
                final String metadataKey,
                final String metadataValue,
                final Double page,
                final Double pageSize,
                final SortByEnum sortBy,
                final SortDirectionEnum sortDirection,
                final String sourceAddressCountry,
                final String sourceAddress,
                final String timezone
    ) throws Throwable {

        HttpRequest _request = _buildGetReceivedMessagesDetailRequest(endDate, startDate, accounts, action, destinationAddressCountry, destinationAddress, messageFormat, metadataKey, metadataValue, page, pageSize, sortBy, sortDirection, sourceAddressCountry, sourceAddress, timezone);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetReceivedMessagesDetailResponse(_context);
    }

    /**
     * Returns a list message received
     * @param    endDate    Required parameter: End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     * @param    startDate    Required parameter: Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     * @param    accounts    Optional parameter: Filter results by a specific account. By default results  will be returned for the account associated with the authentication  credentials and all sub accounts.
     * @param    action    Optional parameter: Filter results by the action that was invoked for this message.
     * @param    destinationAddressCountry    Optional parameter: Filter results by destination address country.
     * @param    destinationAddress    Optional parameter: Filter results by destination address.
     * @param    messageFormat    Optional parameter: Filter results by message format.
     * @param    metadataKey    Optional parameter: Filter results for messages that include a metadata key.
     * @param    metadataValue    Optional parameter: Filter results for messages that include a metadata key containing this value. If this parameter is provided, the metadata_key parameter must also be provided.
     * @param    page    Optional parameter: Page number for paging through paginated result sets.
     * @param    pageSize    Optional parameter: Number of results to return in a page for paginated result sets.
     * @param    sortBy    Optional parameter: Field to sort results set by
     * @param    sortDirection    Optional parameter: Order to sort results by.
     * @param    sourceAddressCountry    Optional parameter: Filter results by source address country.
     * @param    sourceAddress    Optional parameter: Filter results by source address.
     * @param    timezone    Optional parameter: The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'.
     */
    public void getReceivedMessagesDetailAsync(
                final String endDate,
                final String startDate,
                final List<String> accounts,
                final ActionEnum action,
                final String destinationAddressCountry,
                final String destinationAddress,
                final Format1Enum messageFormat,
                final String metadataKey,
                final String metadataValue,
                final Double page,
                final Double pageSize,
                final SortByEnum sortBy,
                final SortDirectionEnum sortDirection,
                final String sourceAddressCountry,
                final String sourceAddress,
                final String timezone,
                final APICallBack<ReceivedMessages> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetReceivedMessagesDetailRequest(endDate, startDate, accounts, action, destinationAddressCountry, destinationAddress, messageFormat, metadataKey, metadataValue, page, pageSize, sortBy, sortDirection, sourceAddressCountry, sourceAddress, timezone);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            ReceivedMessages returnValue = _handleGetReceivedMessagesDetailResponse(_context);
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
     * Builds the HttpRequest object for getReceivedMessagesDetail
     */
    private HttpRequest _buildGetReceivedMessagesDetailRequest(
                final String endDate,
                final String startDate,
                final List<String> accounts,
                final ActionEnum action,
                final String destinationAddressCountry,
                final String destinationAddress,
                final Format1Enum messageFormat,
                final String metadataKey,
                final String metadataValue,
                final Double page,
                final Double pageSize,
                final SortByEnum sortBy,
                final SortDirectionEnum sortDirection,
                final String sourceAddressCountry,
                final String sourceAddress,
                final String timezone) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/reporting/received_messages/detail");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("end_date", endDate);
        _queryParameters.put("start_date", startDate);
        if (accounts != null) {
            _queryParameters.put("accounts", accounts);
        }
        if (action != null) {
            _queryParameters.put("action", (action != null) ? action.value() : null);
        }
        if (destinationAddressCountry != null) {
            _queryParameters.put("destination_address_country", destinationAddressCountry);
        }
        if (destinationAddress != null) {
            _queryParameters.put("destination_address", destinationAddress);
        }
        if (messageFormat != null) {
            _queryParameters.put("message_format", (messageFormat != null) ? messageFormat.value() : null);
        }
        if (metadataKey != null) {
            _queryParameters.put("metadata_key", metadataKey);
        }
        if (metadataValue != null) {
            _queryParameters.put("metadata_value", metadataValue);
        }
        if (page != null) {
            _queryParameters.put("page", page);
        }
        if (pageSize != null) {
            _queryParameters.put("page_size", pageSize);
        }
        if (sortBy != null) {
            _queryParameters.put("sort_by", (sortBy != null) ? sortBy.value() : null);
        }
        if (sortDirection != null) {
            _queryParameters.put("sort_direction", (sortDirection != null) ? sortDirection.value() : null);
        }
        if (sourceAddressCountry != null) {
            _queryParameters.put("source_address_country", sourceAddressCountry);
        }
        if (sourceAddress != null) {
            _queryParameters.put("source_address", sourceAddress);
        }
        if (timezone != null) {
            _queryParameters.put("timezone", timezone);
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
     * Processes the response for getReceivedMessagesDetail
     * @return An object of type ReceivedMessages
     */
    private ReceivedMessages _handleGetReceivedMessagesDetailResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new APIException("Bad Request. Check the json response for more details on what went wrong.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        ReceivedMessages _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<ReceivedMessages>(){});

        return _result;
    }

    /**
     * Submits a request to generate an async detail report
     * @param    body    Required parameter: Example: 
     * @return    Returns the AsyncReportResponse response from the API call 
     */
    public AsyncReportResponse createSubmitSentMessagesDetail(
                final Asyncsentmessagesdetailrequest body
    ) throws Throwable {

        HttpRequest _request = _buildCreateSubmitSentMessagesDetailRequest(body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateSubmitSentMessagesDetailResponse(_context);
    }

    /**
     * Submits a request to generate an async detail report
     * @param    body    Required parameter: Example: 
     */
    public void createSubmitSentMessagesDetailAsync(
                final Asyncsentmessagesdetailrequest body,
                final APICallBack<AsyncReportResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildCreateSubmitSentMessagesDetailRequest(body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            AsyncReportResponse returnValue = _handleCreateSubmitSentMessagesDetailResponse(_context);
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
     * Builds the HttpRequest object for createSubmitSentMessagesDetail
     */
    private HttpRequest _buildCreateSubmitSentMessagesDetailRequest(
                final Asyncsentmessagesdetailrequest body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/reporting/sent_messages/detail/async");
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
     * Processes the response for createSubmitSentMessagesDetail
     * @return An object of type AsyncReportResponse
     */
    private AsyncReportResponse _handleCreateSubmitSentMessagesDetailResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new APIException("Bad Request. Check the json response for more details on what went wrong.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        AsyncReportResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<AsyncReportResponse>(){});

        return _result;
    }

    /**
     * Returns a list of message sent
     * @param    endDate    Required parameter: End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     * @param    startDate    Required parameter: Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     * @param    accounts    Optional parameter: Filter results by a specific account. By default results  will be returned for the account associated with the authentication  credentials and all sub accounts.
     * @param    deliveryReport    Optional parameter: Filter results by delivery report.
     * @param    destinationAddressCountry    Optional parameter: Filter results by destination address country.
     * @param    destinationAddress    Optional parameter: Filter results by destination address.
     * @param    messageFormat    Optional parameter: Filter results by message format.
     * @param    metadataKey    Optional parameter: Filter results for messages that include a metadata key.
     * @param    metadataValue    Optional parameter: Filter results for messages that include a metadata key containing this value. If this parameter is provided, the metadata_key parameter must also be provided.
     * @param    statusCode    Optional parameter: Filter results by message status code.
     * @param    status    Optional parameter: Filter results by message status. Can't be combined with statuses.
     * @param    statuses    Optional parameter: Filter results by message status. Can't be combined with status.{array}
     * @param    page    Optional parameter: Page number for paging through paginated result sets.
     * @param    pageSize    Optional parameter: Number of results to return in a page for paginated result sets.
     * @param    sortBy    Optional parameter: Field to sort results set by
     * @param    sortDirection    Optional parameter: Order to sort results by.
     * @param    sourceAddressCountry    Optional parameter: Filter results by source address country.
     * @param    sourceAddress    Optional parameter: Filter results by source address.
     * @param    timezone    Optional parameter: The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'.
     * @return    Returns the SentMessages response from the API call 
     */
    public SentMessages getSentMessagesDetail(
                final String endDate,
                final String startDate,
                final List<String> accounts,
                final Boolean deliveryReport,
                final String destinationAddressCountry,
                final String destinationAddress,
                final Format1Enum messageFormat,
                final String metadataKey,
                final String metadataValue,
                final String statusCode,
                final Status1Enum status,
                final StatusesEnum statuses,
                final Double page,
                final Double pageSize,
                final SortByEnum sortBy,
                final SortDirectionEnum sortDirection,
                final String sourceAddressCountry,
                final String sourceAddress,
                final String timezone
    ) throws Throwable {

        HttpRequest _request = _buildGetSentMessagesDetailRequest(endDate, startDate, accounts, deliveryReport, destinationAddressCountry, destinationAddress, messageFormat, metadataKey, metadataValue, statusCode, status, statuses, page, pageSize, sortBy, sortDirection, sourceAddressCountry, sourceAddress, timezone);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetSentMessagesDetailResponse(_context);
    }

    /**
     * Returns a list of message sent
     * @param    endDate    Required parameter: End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     * @param    startDate    Required parameter: Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     * @param    accounts    Optional parameter: Filter results by a specific account. By default results  will be returned for the account associated with the authentication  credentials and all sub accounts.
     * @param    deliveryReport    Optional parameter: Filter results by delivery report.
     * @param    destinationAddressCountry    Optional parameter: Filter results by destination address country.
     * @param    destinationAddress    Optional parameter: Filter results by destination address.
     * @param    messageFormat    Optional parameter: Filter results by message format.
     * @param    metadataKey    Optional parameter: Filter results for messages that include a metadata key.
     * @param    metadataValue    Optional parameter: Filter results for messages that include a metadata key containing this value. If this parameter is provided, the metadata_key parameter must also be provided.
     * @param    statusCode    Optional parameter: Filter results by message status code.
     * @param    status    Optional parameter: Filter results by message status. Can't be combined with statuses.
     * @param    statuses    Optional parameter: Filter results by message status. Can't be combined with status.{array}
     * @param    page    Optional parameter: Page number for paging through paginated result sets.
     * @param    pageSize    Optional parameter: Number of results to return in a page for paginated result sets.
     * @param    sortBy    Optional parameter: Field to sort results set by
     * @param    sortDirection    Optional parameter: Order to sort results by.
     * @param    sourceAddressCountry    Optional parameter: Filter results by source address country.
     * @param    sourceAddress    Optional parameter: Filter results by source address.
     * @param    timezone    Optional parameter: The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'.
     */
    public void getSentMessagesDetailAsync(
                final String endDate,
                final String startDate,
                final List<String> accounts,
                final Boolean deliveryReport,
                final String destinationAddressCountry,
                final String destinationAddress,
                final Format1Enum messageFormat,
                final String metadataKey,
                final String metadataValue,
                final String statusCode,
                final Status1Enum status,
                final StatusesEnum statuses,
                final Double page,
                final Double pageSize,
                final SortByEnum sortBy,
                final SortDirectionEnum sortDirection,
                final String sourceAddressCountry,
                final String sourceAddress,
                final String timezone,
                final APICallBack<SentMessages> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetSentMessagesDetailRequest(endDate, startDate, accounts, deliveryReport, destinationAddressCountry, destinationAddress, messageFormat, metadataKey, metadataValue, statusCode, status, statuses, page, pageSize, sortBy, sortDirection, sourceAddressCountry, sourceAddress, timezone);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            SentMessages returnValue = _handleGetSentMessagesDetailResponse(_context);
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
     * Builds the HttpRequest object for getSentMessagesDetail
     */
    private HttpRequest _buildGetSentMessagesDetailRequest(
                final String endDate,
                final String startDate,
                final List<String> accounts,
                final Boolean deliveryReport,
                final String destinationAddressCountry,
                final String destinationAddress,
                final Format1Enum messageFormat,
                final String metadataKey,
                final String metadataValue,
                final String statusCode,
                final Status1Enum status,
                final StatusesEnum statuses,
                final Double page,
                final Double pageSize,
                final SortByEnum sortBy,
                final SortDirectionEnum sortDirection,
                final String sourceAddressCountry,
                final String sourceAddress,
                final String timezone) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/reporting/sent_messages/detail");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("end_date", endDate);
        _queryParameters.put("start_date", startDate);
        if (accounts != null) {
            _queryParameters.put("accounts", accounts);
        }
        if (deliveryReport != null) {
            _queryParameters.put("delivery_report", deliveryReport);
        }
        if (destinationAddressCountry != null) {
            _queryParameters.put("destination_address_country", destinationAddressCountry);
        }
        if (destinationAddress != null) {
            _queryParameters.put("destination_address", destinationAddress);
        }
        if (messageFormat != null) {
            _queryParameters.put("message_format", (messageFormat != null) ? messageFormat.value() : null);
        }
        if (metadataKey != null) {
            _queryParameters.put("metadata_key", metadataKey);
        }
        if (metadataValue != null) {
            _queryParameters.put("metadata_value", metadataValue);
        }
        if (statusCode != null) {
            _queryParameters.put("status_code", statusCode);
        }
        if (status != null) {
            _queryParameters.put("status", (status != null) ? status.value() : null);
        }
        if (statuses != null) {
            _queryParameters.put("statuses", (statuses != null) ? statuses.value() : null);
        }
        if (page != null) {
            _queryParameters.put("page", page);
        }
        if (pageSize != null) {
            _queryParameters.put("page_size", pageSize);
        }
        if (sortBy != null) {
            _queryParameters.put("sort_by", (sortBy != null) ? sortBy.value() : null);
        }
        if (sortDirection != null) {
            _queryParameters.put("sort_direction", (sortDirection != null) ? sortDirection.value() : null);
        }
        if (sourceAddressCountry != null) {
            _queryParameters.put("source_address_country", sourceAddressCountry);
        }
        if (sourceAddress != null) {
            _queryParameters.put("source_address", sourceAddress);
        }
        if (timezone != null) {
            _queryParameters.put("timezone", timezone);
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
     * Processes the response for getSentMessagesDetail
     * @return An object of type SentMessages
     */
    private SentMessages _handleGetSentMessagesDetailResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new APIException("Bad Request. Check the json response for more details on what went wrong.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        SentMessages _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<SentMessages>(){});

        return _result;
    }

    /**
     * Submits a summarised report of received messages
     * @param    body    Required parameter: Example: 
     * @return    Returns the AsyncReportResponse response from the API call 
     */
    public AsyncReportResponse createSubmitReceivedMessagesSummary(
                final Asyncreceivedmessagessummaryrequest body
    ) throws Throwable {

        HttpRequest _request = _buildCreateSubmitReceivedMessagesSummaryRequest(body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateSubmitReceivedMessagesSummaryResponse(_context);
    }

    /**
     * Submits a summarised report of received messages
     * @param    body    Required parameter: Example: 
     */
    public void createSubmitReceivedMessagesSummaryAsync(
                final Asyncreceivedmessagessummaryrequest body,
                final APICallBack<AsyncReportResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildCreateSubmitReceivedMessagesSummaryRequest(body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            AsyncReportResponse returnValue = _handleCreateSubmitReceivedMessagesSummaryResponse(_context);
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
     * Builds the HttpRequest object for createSubmitReceivedMessagesSummary
     */
    private HttpRequest _buildCreateSubmitReceivedMessagesSummaryRequest(
                final Asyncreceivedmessagessummaryrequest body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/reporting/received_messages/summary/async");
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
     * Processes the response for createSubmitReceivedMessagesSummary
     * @return An object of type AsyncReportResponse
     */
    private AsyncReportResponse _handleCreateSubmitReceivedMessagesSummaryResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new APIException("Bad Request. Check the json response for more details on what went wrong.", _context);
        }
        if (_responseCode == 501) {
            throw new APIException("The group_by combination is not currently implemented", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        AsyncReportResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<AsyncReportResponse>(){});

        return _result;
    }

    /**
     * Returns a summarised report of messages received
     * @param    endDate    Required parameter: End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     * @param    startDate    Required parameter: Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     * @param    groupBy    Required parameter: List of fields to group results set by{array}
     * @param    accounts    Optional parameter: Filter results by a specific account. By default results  will be returned for the account associated with the authentication  credentials and all sub accounts.
     * @param    destinationAddressCountry    Optional parameter: Filter results by destination address country.
     * @param    destinationAddress    Optional parameter: Filter results by destination address.
     * @param    messageFormat    Optional parameter: Filter results by message format.
     * @param    metadataKey    Optional parameter: Filter results for messages that include a metadata key.
     * @param    metadataValue    Optional parameter: Filter results for messages that include a metadata key containing this value. If this parameter is provided, the metadata_key parameter must also be provided.
     * @param    summaryBy    Optional parameter: Function to apply when summarising results
     * @param    summaryField    Optional parameter: Field to summarise results by
     * @param    sourceAddressCountry    Optional parameter: Filter results by source address country.
     * @param    sourceAddress    Optional parameter: Filter results by source address.
     * @param    timezone    Optional parameter: The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'.
     * @return    Returns the SummaryReport response from the API call 
     */
    public SummaryReport getReceivedMessagesSummary(
                final String endDate,
                final String startDate,
                final GroupByEnum groupBy,
                final List<String> accounts,
                final String destinationAddressCountry,
                final String destinationAddress,
                final Format1Enum messageFormat,
                final String metadataKey,
                final String metadataValue,
                final SummaryByEnum summaryBy,
                final SummaryFieldEnum summaryField,
                final String sourceAddressCountry,
                final String sourceAddress,
                final String timezone
    ) throws Throwable {

        HttpRequest _request = _buildGetReceivedMessagesSummaryRequest(endDate, startDate, groupBy, accounts, destinationAddressCountry, destinationAddress, messageFormat, metadataKey, metadataValue, summaryBy, summaryField, sourceAddressCountry, sourceAddress, timezone);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetReceivedMessagesSummaryResponse(_context);
    }

    /**
     * Returns a summarised report of messages received
     * @param    endDate    Required parameter: End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     * @param    startDate    Required parameter: Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     * @param    groupBy    Required parameter: List of fields to group results set by{array}
     * @param    accounts    Optional parameter: Filter results by a specific account. By default results  will be returned for the account associated with the authentication  credentials and all sub accounts.
     * @param    destinationAddressCountry    Optional parameter: Filter results by destination address country.
     * @param    destinationAddress    Optional parameter: Filter results by destination address.
     * @param    messageFormat    Optional parameter: Filter results by message format.
     * @param    metadataKey    Optional parameter: Filter results for messages that include a metadata key.
     * @param    metadataValue    Optional parameter: Filter results for messages that include a metadata key containing this value. If this parameter is provided, the metadata_key parameter must also be provided.
     * @param    summaryBy    Optional parameter: Function to apply when summarising results
     * @param    summaryField    Optional parameter: Field to summarise results by
     * @param    sourceAddressCountry    Optional parameter: Filter results by source address country.
     * @param    sourceAddress    Optional parameter: Filter results by source address.
     * @param    timezone    Optional parameter: The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'.
     */
    public void getReceivedMessagesSummaryAsync(
                final String endDate,
                final String startDate,
                final GroupByEnum groupBy,
                final List<String> accounts,
                final String destinationAddressCountry,
                final String destinationAddress,
                final Format1Enum messageFormat,
                final String metadataKey,
                final String metadataValue,
                final SummaryByEnum summaryBy,
                final SummaryFieldEnum summaryField,
                final String sourceAddressCountry,
                final String sourceAddress,
                final String timezone,
                final APICallBack<SummaryReport> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetReceivedMessagesSummaryRequest(endDate, startDate, groupBy, accounts, destinationAddressCountry, destinationAddress, messageFormat, metadataKey, metadataValue, summaryBy, summaryField, sourceAddressCountry, sourceAddress, timezone);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            SummaryReport returnValue = _handleGetReceivedMessagesSummaryResponse(_context);
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
     * Builds the HttpRequest object for getReceivedMessagesSummary
     */
    private HttpRequest _buildGetReceivedMessagesSummaryRequest(
                final String endDate,
                final String startDate,
                final GroupByEnum groupBy,
                final List<String> accounts,
                final String destinationAddressCountry,
                final String destinationAddress,
                final Format1Enum messageFormat,
                final String metadataKey,
                final String metadataValue,
                final SummaryByEnum summaryBy,
                final SummaryFieldEnum summaryField,
                final String sourceAddressCountry,
                final String sourceAddress,
                final String timezone) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/reporting/received_messages/summary");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("end_date", endDate);
        _queryParameters.put("start_date", startDate);
        _queryParameters.put("group_by", (groupBy != null) ? groupBy.value() : null);
        if (accounts != null) {
            _queryParameters.put("accounts", accounts);
        }
        if (destinationAddressCountry != null) {
            _queryParameters.put("destination_address_country", destinationAddressCountry);
        }
        if (destinationAddress != null) {
            _queryParameters.put("destination_address", destinationAddress);
        }
        if (messageFormat != null) {
            _queryParameters.put("message_format", (messageFormat != null) ? messageFormat.value() : null);
        }
        if (metadataKey != null) {
            _queryParameters.put("metadata_key", metadataKey);
        }
        if (metadataValue != null) {
            _queryParameters.put("metadata_value", metadataValue);
        }
        if (summaryBy != null) {
            _queryParameters.put("summary_by", (summaryBy != null) ? summaryBy.value() : null);
        }
        if (summaryField != null) {
            _queryParameters.put("summary_field", (summaryField != null) ? summaryField.value() : null);
        }
        if (sourceAddressCountry != null) {
            _queryParameters.put("source_address_country", sourceAddressCountry);
        }
        if (sourceAddress != null) {
            _queryParameters.put("source_address", sourceAddress);
        }
        if (timezone != null) {
            _queryParameters.put("timezone", timezone);
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
     * Processes the response for getReceivedMessagesSummary
     * @return An object of type SummaryReport
     */
    private SummaryReport _handleGetReceivedMessagesSummaryResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new APIException("Bad Request. Check the json response for more details on what went wrong.", _context);
        }
        if (_responseCode == 501) {
            throw new APIException("The group_by combination is not currently implemented", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        SummaryReport _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<SummaryReport>(){});

        return _result;
    }

    /**
     * Submits a summarised report of sent messages
     * @param    body    Required parameter: Example: 
     * @return    Returns the AsyncReportResponse response from the API call 
     */
    public AsyncReportResponse createSubmitSentMessagesSummary(
                final Asyncsentmessagesrequest body
    ) throws Throwable {

        HttpRequest _request = _buildCreateSubmitSentMessagesSummaryRequest(body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateSubmitSentMessagesSummaryResponse(_context);
    }

    /**
     * Submits a summarised report of sent messages
     * @param    body    Required parameter: Example: 
     */
    public void createSubmitSentMessagesSummaryAsync(
                final Asyncsentmessagesrequest body,
                final APICallBack<AsyncReportResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildCreateSubmitSentMessagesSummaryRequest(body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            AsyncReportResponse returnValue = _handleCreateSubmitSentMessagesSummaryResponse(_context);
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
     * Builds the HttpRequest object for createSubmitSentMessagesSummary
     */
    private HttpRequest _buildCreateSubmitSentMessagesSummaryRequest(
                final Asyncsentmessagesrequest body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/reporting/sent_messages/summary/async");
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
     * Processes the response for createSubmitSentMessagesSummary
     * @return An object of type AsyncReportResponse
     */
    private AsyncReportResponse _handleCreateSubmitSentMessagesSummaryResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new APIException("Bad Request. Check the json response for more details on what went wrong.", _context);
        }
        if (_responseCode == 501) {
            throw new APIException("The group_by combination is not currently implemented", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        AsyncReportResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<AsyncReportResponse>(){});

        return _result;
    }

    /**
     * Returns a summarised report of messages sent
     * @param    endDate    Required parameter: End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     * @param    startDate    Required parameter: Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     * @param    groupBy    Required parameter: List of fields to group results set by{array}
     * @param    accounts    Optional parameter: Filter results by a specific account. By default results  will be returned for the account associated with the authentication  credentials and all sub accounts.
     * @param    deliveryReport    Optional parameter: Filter results by delivery report.
     * @param    destinationAddressCountry    Optional parameter: Filter results by destination address country.
     * @param    destinationAddress    Optional parameter: Filter results by destination address.
     * @param    summaryBy    Optional parameter: Function to apply when summarising results
     * @param    summaryField    Optional parameter: Field to summarise results by
     * @param    messageFormat    Optional parameter: Filter results by message format.
     * @param    metadataKey    Optional parameter: Filter results for messages that include a metadata key.
     * @param    metadataValue    Optional parameter: Filter results for messages that include a metadata key containing this value. If this parameter is provided, the metadata_key parameter must also be provided.
     * @param    statusCode    Optional parameter: Filter results by message status code.
     * @param    sourceAddressCountry    Optional parameter: Filter results by source address country.
     * @param    sourceAddress    Optional parameter: Filter results by source address.
     * @param    timezone    Optional parameter: The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'.
     * @return    Returns the SummaryReport response from the API call 
     */
    public SummaryReport getSentMessagesSummary(
                final String endDate,
                final String startDate,
                final GroupByEnum groupBy,
                final List<String> accounts,
                final Boolean deliveryReport,
                final String destinationAddressCountry,
                final String destinationAddress,
                final SummaryByEnum summaryBy,
                final SummaryFieldEnum summaryField,
                final Format1Enum messageFormat,
                final String metadataKey,
                final String metadataValue,
                final String statusCode,
                final String sourceAddressCountry,
                final String sourceAddress,
                final String timezone
    ) throws Throwable {

        HttpRequest _request = _buildGetSentMessagesSummaryRequest(endDate, startDate, groupBy, accounts, deliveryReport, destinationAddressCountry, destinationAddress, summaryBy, summaryField, messageFormat, metadataKey, metadataValue, statusCode, sourceAddressCountry, sourceAddress, timezone);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetSentMessagesSummaryResponse(_context);
    }

    /**
     * Returns a summarised report of messages sent
     * @param    endDate    Required parameter: End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     * @param    startDate    Required parameter: Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format.
     * @param    groupBy    Required parameter: List of fields to group results set by{array}
     * @param    accounts    Optional parameter: Filter results by a specific account. By default results  will be returned for the account associated with the authentication  credentials and all sub accounts.
     * @param    deliveryReport    Optional parameter: Filter results by delivery report.
     * @param    destinationAddressCountry    Optional parameter: Filter results by destination address country.
     * @param    destinationAddress    Optional parameter: Filter results by destination address.
     * @param    summaryBy    Optional parameter: Function to apply when summarising results
     * @param    summaryField    Optional parameter: Field to summarise results by
     * @param    messageFormat    Optional parameter: Filter results by message format.
     * @param    metadataKey    Optional parameter: Filter results for messages that include a metadata key.
     * @param    metadataValue    Optional parameter: Filter results for messages that include a metadata key containing this value. If this parameter is provided, the metadata_key parameter must also be provided.
     * @param    statusCode    Optional parameter: Filter results by message status code.
     * @param    sourceAddressCountry    Optional parameter: Filter results by source address country.
     * @param    sourceAddress    Optional parameter: Filter results by source address.
     * @param    timezone    Optional parameter: The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'.
     */
    public void getSentMessagesSummaryAsync(
                final String endDate,
                final String startDate,
                final GroupByEnum groupBy,
                final List<String> accounts,
                final Boolean deliveryReport,
                final String destinationAddressCountry,
                final String destinationAddress,
                final SummaryByEnum summaryBy,
                final SummaryFieldEnum summaryField,
                final Format1Enum messageFormat,
                final String metadataKey,
                final String metadataValue,
                final String statusCode,
                final String sourceAddressCountry,
                final String sourceAddress,
                final String timezone,
                final APICallBack<SummaryReport> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetSentMessagesSummaryRequest(endDate, startDate, groupBy, accounts, deliveryReport, destinationAddressCountry, destinationAddress, summaryBy, summaryField, messageFormat, metadataKey, metadataValue, statusCode, sourceAddressCountry, sourceAddress, timezone);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            SummaryReport returnValue = _handleGetSentMessagesSummaryResponse(_context);
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
     * Builds the HttpRequest object for getSentMessagesSummary
     */
    private HttpRequest _buildGetSentMessagesSummaryRequest(
                final String endDate,
                final String startDate,
                final GroupByEnum groupBy,
                final List<String> accounts,
                final Boolean deliveryReport,
                final String destinationAddressCountry,
                final String destinationAddress,
                final SummaryByEnum summaryBy,
                final SummaryFieldEnum summaryField,
                final Format1Enum messageFormat,
                final String metadataKey,
                final String metadataValue,
                final String statusCode,
                final String sourceAddressCountry,
                final String sourceAddress,
                final String timezone) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/reporting/sent_messages/summary");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        _queryParameters.put("end_date", endDate);
        _queryParameters.put("start_date", startDate);
        _queryParameters.put("group_by", (groupBy != null) ? groupBy.value() : null);
        if (accounts != null) {
            _queryParameters.put("accounts", accounts);
        }
        if (deliveryReport != null) {
            _queryParameters.put("delivery_report", deliveryReport);
        }
        if (destinationAddressCountry != null) {
            _queryParameters.put("destination_address_country", destinationAddressCountry);
        }
        if (destinationAddress != null) {
            _queryParameters.put("destination_address", destinationAddress);
        }
        if (summaryBy != null) {
            _queryParameters.put("summary_by", (summaryBy != null) ? summaryBy.value() : null);
        }
        if (summaryField != null) {
            _queryParameters.put("summary_field", (summaryField != null) ? summaryField.value() : null);
        }
        if (messageFormat != null) {
            _queryParameters.put("message_format", (messageFormat != null) ? messageFormat.value() : null);
        }
        if (metadataKey != null) {
            _queryParameters.put("metadata_key", metadataKey);
        }
        if (metadataValue != null) {
            _queryParameters.put("metadata_value", metadataValue);
        }
        if (statusCode != null) {
            _queryParameters.put("status_code", statusCode);
        }
        if (sourceAddressCountry != null) {
            _queryParameters.put("source_address_country", sourceAddressCountry);
        }
        if (sourceAddress != null) {
            _queryParameters.put("source_address", sourceAddress);
        }
        if (timezone != null) {
            _queryParameters.put("timezone", timezone);
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
     * Processes the response for getSentMessagesSummary
     * @return An object of type SummaryReport
     */
    private SummaryReport _handleGetSentMessagesSummaryResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new APIException("Bad Request. Check the json response for more details on what went wrong.", _context);
        }
        if (_responseCode == 501) {
            throw new APIException("The group_by combination is not currently implemented", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        SummaryReport _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<SummaryReport>(){});

        return _result;
    }

}
