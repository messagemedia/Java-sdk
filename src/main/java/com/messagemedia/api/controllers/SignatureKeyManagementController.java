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

public class SignatureKeyManagementController extends BaseController {
    //private static variables for the singleton pattern
    private static final Object syncObject = new Object();
    private static SignatureKeyManagementController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the SignatureKeyManagementController class 
     */
    public static SignatureKeyManagementController getInstance() {
        if (null == instance) {
            synchronized (syncObject) {
                if (null == instance) {
                    instance = new SignatureKeyManagementController();
                }
            }
        }
        return instance;
    }

    /**
     * Retrieve the paginated list of signature keys.
     * A successful request for the ```get signature key list``` endpoint will return a response body as follows:
     * ```json
     * [
     *   {
     *     "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31",
     *     "cipher": "RSA",
     *     "digest": "SHA224",
     *     "created": "2018-01-18T10:16:12.364Z",
     *     "enabled": false
     *   }
     * ]
     * ```
     * @param    page    Required parameter: Example: 
     * @param    pageSize    Required parameter: Example: 
     * @return    Returns the List<Getsignaturekeylistresponse> response from the API call 
     */
    public List<Getsignaturekeylistresponse> getSignatureKeyList(
                final String page,
                final String pageSize
    ) throws Throwable {

        HttpRequest _request = _buildGetSignatureKeyListRequest(page, pageSize);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetSignatureKeyListResponse(_context);
    }

    /**
     * Retrieve the paginated list of signature keys.
     * A successful request for the ```get signature key list``` endpoint will return a response body as follows:
     * ```json
     * [
     *   {
     *     "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31",
     *     "cipher": "RSA",
     *     "digest": "SHA224",
     *     "created": "2018-01-18T10:16:12.364Z",
     *     "enabled": false
     *   }
     * ]
     * ```
     * @param    page    Required parameter: Example: 
     * @param    pageSize    Required parameter: Example: 
     */
    public void getSignatureKeyListAsync(
                final String page,
                final String pageSize,
                final APICallBack<List<Getsignaturekeylistresponse>> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetSignatureKeyListRequest(page, pageSize);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            List<Getsignaturekeylistresponse> returnValue = _handleGetSignatureKeyListResponse(_context);
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
     * Builds the HttpRequest object for getSignatureKeyList
     */
    private HttpRequest _buildGetSignatureKeyListRequest(
                final String page,
                final String pageSize) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/iam/signature_keys");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("page", page);
        _templateParameters.put("page_size", pageSize);
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
     * Processes the response for getSignatureKeyList
     * @return An object of type List<Getsignaturekeylistresponse>
     */
    private List<Getsignaturekeylistresponse> _handleGetSignatureKeyListResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new Enablesignaturekey400responseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        if (_responseCode == 403) {
            throw new Disablethecurrentenabledsignaturekey403responseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        List<Getsignaturekeylistresponse> _result = APIHelper.deserialize(_responseBody,
									new TypeReference<List<Getsignaturekeylistresponse>>(){});

        return _result;
    }

    /**
     * This will create a key pair:
     * - The ```private key``` stored in MessageMedia is used to create the signature.
     * - The ```public key``` is returned and stored at your side to verify the signature in callbacks.
     * You need to enable your signature key after creating.
     * The most basic body has the following structure:
     * ```json
     * {
     *     "digest": "SHA224",
     *     "cipher": "RSA"
     * }
     * ```
     * - ```digest``` is used to hash the message. The valid values for digest type are: SHA224, SHA256, SHA512
     * - ```cipher``` is used to encrypt the hashed message. The valid value for cipher type is: RSA
     * A successful request for the ```create signature key``` endpoint will return a response body as follows:
     * ```json
     * {
     *     "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31",
     *     "public_key": "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCTIxtRyT5CuOD74r7UCT+AKzWNxvaAP9myjAqR7+vBnJKEvoPnmbKTnm6uLlxutnMbjKrnCCWnQ9vtBVnnd+ElhwLDPADfMcJoOqwi7mTcxucckeEbBsfsgYRfdacxgSZL8hVD1hLViQr3xwjEIkJcx1w3x8npvwMuTY0uW8+PjwIDAQAB",
     *     "cipher": "RSA",
     *     "digest": "SHA224",
     *     "created": "2018-01-18T10:16:12.364Z",
     *     "enabled": false
     * }
     * ```
     * The response body of a successful POST request to the ```create signature key``` endpoint will contain six properties:
     * - ```key_id``` will be a 36 character UUID which can be used to enable, delete or get the details.
     * - ```public_key``` is used to decrypt the signature.
     * - ```cipher``` same as cipher in request body.
     * - ```digest``` same as digest in request body.
     * - ```created``` is the created date.
     * - ```enabled``` is false for the new signature key. You can use the ```enable signature key``` endpoint to set this field to true.
     * @param    accept    Required parameter: Example: 
     * @param    body    Required parameter: Example: 
     * @return    Returns the Createsignaturekeyresponse response from the API call 
     */
    public Createsignaturekeyresponse createSignatureKey(
                final String accept,
                final Createsignaturekeyrequest body
    ) throws Throwable {

        HttpRequest _request = _buildCreateSignatureKeyRequest(accept, body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleCreateSignatureKeyResponse(_context);
    }

    /**
     * This will create a key pair:
     * - The ```private key``` stored in MessageMedia is used to create the signature.
     * - The ```public key``` is returned and stored at your side to verify the signature in callbacks.
     * You need to enable your signature key after creating.
     * The most basic body has the following structure:
     * ```json
     * {
     *     "digest": "SHA224",
     *     "cipher": "RSA"
     * }
     * ```
     * - ```digest``` is used to hash the message. The valid values for digest type are: SHA224, SHA256, SHA512
     * - ```cipher``` is used to encrypt the hashed message. The valid value for cipher type is: RSA
     * A successful request for the ```create signature key``` endpoint will return a response body as follows:
     * ```json
     * {
     *     "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31",
     *     "public_key": "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCTIxtRyT5CuOD74r7UCT+AKzWNxvaAP9myjAqR7+vBnJKEvoPnmbKTnm6uLlxutnMbjKrnCCWnQ9vtBVnnd+ElhwLDPADfMcJoOqwi7mTcxucckeEbBsfsgYRfdacxgSZL8hVD1hLViQr3xwjEIkJcx1w3x8npvwMuTY0uW8+PjwIDAQAB",
     *     "cipher": "RSA",
     *     "digest": "SHA224",
     *     "created": "2018-01-18T10:16:12.364Z",
     *     "enabled": false
     * }
     * ```
     * The response body of a successful POST request to the ```create signature key``` endpoint will contain six properties:
     * - ```key_id``` will be a 36 character UUID which can be used to enable, delete or get the details.
     * - ```public_key``` is used to decrypt the signature.
     * - ```cipher``` same as cipher in request body.
     * - ```digest``` same as digest in request body.
     * - ```created``` is the created date.
     * - ```enabled``` is false for the new signature key. You can use the ```enable signature key``` endpoint to set this field to true.
     * @param    accept    Required parameter: Example: 
     * @param    body    Required parameter: Example: 
     */
    public void createSignatureKeyAsync(
                final String accept,
                final Createsignaturekeyrequest body,
                final APICallBack<Createsignaturekeyresponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildCreateSignatureKeyRequest(accept, body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            Createsignaturekeyresponse returnValue = _handleCreateSignatureKeyResponse(_context);
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
     * Builds the HttpRequest object for createSignatureKey
     */
    private HttpRequest _buildCreateSignatureKeyRequest(
                final String accept,
                final Createsignaturekeyrequest body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/iam/signature_keys");
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
     * Processes the response for createSignatureKey
     * @return An object of type Createsignaturekeyresponse
     */
    private Createsignaturekeyresponse _handleCreateSignatureKeyResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new Enablesignaturekey400responseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        if (_responseCode == 403) {
            throw new Disablethecurrentenabledsignaturekey403responseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        Createsignaturekeyresponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Createsignaturekeyresponse>(){});

        return _result;
    }

    /**
     * Retrieve the current detail of a signature key using the key_id returned in the ```create signature key``` endpoint.
     * A successful request for the ```get signature key detail``` endpoint will return a response body as follows:
     * ```json
     * {
     *     "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31",
     *     "cipher": "RSA",
     *     "digest": "SHA224",
     *     "created": "2018-01-18T10:16:12.364Z",
     *     "enabled": false
     * }
     * ```
     * *Note: If an invalid or non-existent key_id parameter is specified in the request, then an HTTP 404 Not Found response will be returned*
     * @param    keyId    Required parameter: Example: 
     * @return    Returns the Getsignaturekeydetailresponse response from the API call 
     */
    public Getsignaturekeydetailresponse getSignatureKeyDetail(
                final String keyId
    ) throws Throwable {

        HttpRequest _request = _buildGetSignatureKeyDetailRequest(keyId);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetSignatureKeyDetailResponse(_context);
    }

    /**
     * Retrieve the current detail of a signature key using the key_id returned in the ```create signature key``` endpoint.
     * A successful request for the ```get signature key detail``` endpoint will return a response body as follows:
     * ```json
     * {
     *     "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31",
     *     "cipher": "RSA",
     *     "digest": "SHA224",
     *     "created": "2018-01-18T10:16:12.364Z",
     *     "enabled": false
     * }
     * ```
     * *Note: If an invalid or non-existent key_id parameter is specified in the request, then an HTTP 404 Not Found response will be returned*
     * @param    keyId    Required parameter: Example: 
     */
    public void getSignatureKeyDetailAsync(
                final String keyId,
                final APICallBack<Getsignaturekeydetailresponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetSignatureKeyDetailRequest(keyId);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            Getsignaturekeydetailresponse returnValue = _handleGetSignatureKeyDetailResponse(_context);
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
     * Builds the HttpRequest object for getSignatureKeyDetail
     */
    private HttpRequest _buildGetSignatureKeyDetailRequest(
                final String keyId) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/iam/signature_keys/{key_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("key_id", keyId);
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
     * Processes the response for getSignatureKeyDetail
     * @return An object of type Getsignaturekeydetailresponse
     */
    private Getsignaturekeydetailresponse _handleGetSignatureKeyDetailResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new Enablesignaturekey400responseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        if (_responseCode == 403) {
            throw new Disablethecurrentenabledsignaturekey403responseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        if (_responseCode == 404) {
            throw new Disablethecurrentenabledsignaturekey403responseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        Getsignaturekeydetailresponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Getsignaturekeydetailresponse>(){});

        return _result;
    }

    /**
     * Delete a signature key using the key_id returned in the ```create signature key``` endpoint.
     * A successful request for the ```delete signature key``` endpoint will return an empty response body.
     * *Note: If an invalid or non-existent key_id parameter is specified in the request, then an HTTP 404 Not Found response will be returned*
     * @param    keyId    Required parameter: Example: 
     */
    public void deleteSignatureKey(
                final String keyId
    ) throws Throwable {

        HttpRequest _request = _buildDeleteSignatureKeyRequest(keyId);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        _handleDeleteSignatureKeyResponse(_context);
    }

    /**
     * Delete a signature key using the key_id returned in the ```create signature key``` endpoint.
     * A successful request for the ```delete signature key``` endpoint will return an empty response body.
     * *Note: If an invalid or non-existent key_id parameter is specified in the request, then an HTTP 404 Not Found response will be returned*
     * @param    keyId    Required parameter: Example: 
     */
    public void deleteSignatureKeyAsync(
                final String keyId,
                final APICallBack<Object> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildDeleteSignatureKeyRequest(keyId);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            _handleDeleteSignatureKeyResponse(_context);
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
     * Builds the HttpRequest object for deleteSignatureKey
     */
    private HttpRequest _buildDeleteSignatureKeyRequest(
                final String keyId) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/iam/signature_keys/{key_id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("key_id", keyId);
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
     * Processes the response for deleteSignatureKey
     */
    private void _handleDeleteSignatureKeyResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 403) {
            throw new Disablethecurrentenabledsignaturekey403responseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        if (_responseCode == 404) {
            throw new Disablethecurrentenabledsignaturekey403responseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);


    }

    /**
     * Enable a signature key using the key_id returned in the ```create signature key``` endpoint.
     * There is only one signature key is enabled at the one moment in time. So if you enable the new signature key, the old one will be disabled.
     * The most basic body has the following structure:
     * ```json
     * {
     *     "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31"
     * }
     * ```
     * The response body of a successful PATCH request to ```enable signature key``` endpoint will contain the ```enabled``` properties with the value is true as follows:
     * ```json
     * {
     *     "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31",
     *     "cipher": "RSA",
     *     "digest": "SHA224",
     *     "created": "2018-01-18T10:16:12.364Z",
     *     "enabled": true
     * }
     * ```
     * *Note: If an invalid or non-existent key_id parameter is specified in the request, then an HTTP 404 Not Found response will be returned*
     * @param    accept    Required parameter: Example: 
     * @param    body    Required parameter: Example: 
     * @return    Returns the Enablesignaturekeyresponse response from the API call 
     */
    public Enablesignaturekeyresponse updateEnableSignatureKey(
                final String accept,
                final Enablesignaturekeyrequest body
    ) throws Throwable {

        HttpRequest _request = _buildUpdateEnableSignatureKeyRequest(accept, body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleUpdateEnableSignatureKeyResponse(_context);
    }

    /**
     * Enable a signature key using the key_id returned in the ```create signature key``` endpoint.
     * There is only one signature key is enabled at the one moment in time. So if you enable the new signature key, the old one will be disabled.
     * The most basic body has the following structure:
     * ```json
     * {
     *     "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31"
     * }
     * ```
     * The response body of a successful PATCH request to ```enable signature key``` endpoint will contain the ```enabled``` properties with the value is true as follows:
     * ```json
     * {
     *     "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31",
     *     "cipher": "RSA",
     *     "digest": "SHA224",
     *     "created": "2018-01-18T10:16:12.364Z",
     *     "enabled": true
     * }
     * ```
     * *Note: If an invalid or non-existent key_id parameter is specified in the request, then an HTTP 404 Not Found response will be returned*
     * @param    accept    Required parameter: Example: 
     * @param    body    Required parameter: Example: 
     */
    public void updateEnableSignatureKeyAsync(
                final String accept,
                final Enablesignaturekeyrequest body,
                final APICallBack<Enablesignaturekeyresponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildUpdateEnableSignatureKeyRequest(accept, body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            Enablesignaturekeyresponse returnValue = _handleUpdateEnableSignatureKeyResponse(_context);
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
     * Builds the HttpRequest object for updateEnableSignatureKey
     */
    private HttpRequest _buildUpdateEnableSignatureKeyRequest(
                final String accept,
                final Enablesignaturekeyrequest body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/iam/signature_keys/enabled");
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
     * Processes the response for updateEnableSignatureKey
     * @return An object of type Enablesignaturekeyresponse
     */
    private Enablesignaturekeyresponse _handleUpdateEnableSignatureKeyResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new Enablesignaturekey400responseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        if (_responseCode == 403) {
            throw new Disablethecurrentenabledsignaturekey403responseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        if (_responseCode == 404) {
            throw new Disablethecurrentenabledsignaturekey403responseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        Enablesignaturekeyresponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Enablesignaturekeyresponse>(){});

        return _result;
    }

    /**
     * Retrieve the currently enabled signature key.
     * A successful request for the ```get enabled signature key``` endpoint will return a response body as follows:
     * ```json
     * {
     *     "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31",
     *     "cipher": "RSA",
     *     "digest": "SHA224",
     *     "created": "2018-01-18T10:16:12.364Z",
     *     "enabled": true
     * }
     * ```
     * *Note: If there is no enabled signature key, then an HTTP 404 Not Found response will be returned*
     * @return    Returns the Getenabledsignaturekeyresponse response from the API call 
     */
    public Getenabledsignaturekeyresponse getEnabledSignatureKey(
    ) throws Throwable {

        HttpRequest _request = _buildGetEnabledSignatureKeyRequest();
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetEnabledSignatureKeyResponse(_context);
    }

    /**
     * Retrieve the currently enabled signature key.
     * A successful request for the ```get enabled signature key``` endpoint will return a response body as follows:
     * ```json
     * {
     *     "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31",
     *     "cipher": "RSA",
     *     "digest": "SHA224",
     *     "created": "2018-01-18T10:16:12.364Z",
     *     "enabled": true
     * }
     * ```
     * *Note: If there is no enabled signature key, then an HTTP 404 Not Found response will be returned*
     */
    public void getEnabledSignatureKeyAsync(
                final APICallBack<Getenabledsignaturekeyresponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetEnabledSignatureKeyRequest();
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            Getenabledsignaturekeyresponse returnValue = _handleGetEnabledSignatureKeyResponse(_context);
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
     * Builds the HttpRequest object for getEnabledSignatureKey
     */
    private HttpRequest _buildGetEnabledSignatureKeyRequest() throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/iam/signature_keys/enabled");
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
     * Processes the response for getEnabledSignatureKey
     * @return An object of type Getenabledsignaturekeyresponse
     */
    private Getenabledsignaturekeyresponse _handleGetEnabledSignatureKeyResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 403) {
            throw new Disablethecurrentenabledsignaturekey403responseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        if (_responseCode == 404) {
            throw new Disablethecurrentenabledsignaturekey403responseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        Getenabledsignaturekeyresponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<Getenabledsignaturekeyresponse>(){});

        return _result;
    }

    /**
     * Disable the current enabled signature key.
     * A successful request for the ```disable the current enabled signature key.``` endpoint will return no content when successful.
     * If there is an enabled key, it will be disabled; and the 204 status code is returned.
     * If there is no key or no enabled key, the 204 status code is also returned.
     */
    public void deleteDisableTheCurrentEnabledSignatureKey(
    ) throws Throwable {

        HttpRequest _request = _buildDeleteDisableTheCurrentEnabledSignatureKeyRequest();
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        _handleDeleteDisableTheCurrentEnabledSignatureKeyResponse(_context);
    }

    /**
     * Disable the current enabled signature key.
     * A successful request for the ```disable the current enabled signature key.``` endpoint will return no content when successful.
     * If there is an enabled key, it will be disabled; and the 204 status code is returned.
     * If there is no key or no enabled key, the 204 status code is also returned.
     */
    public void deleteDisableTheCurrentEnabledSignatureKeyAsync(
                final APICallBack<Object> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildDeleteDisableTheCurrentEnabledSignatureKeyRequest();
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            _handleDeleteDisableTheCurrentEnabledSignatureKeyResponse(_context);
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
     * Builds the HttpRequest object for deleteDisableTheCurrentEnabledSignatureKey
     */
    private HttpRequest _buildDeleteDisableTheCurrentEnabledSignatureKeyRequest() throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/v1/iam/signature_keys/enabled");
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
     * Processes the response for deleteDisableTheCurrentEnabledSignatureKey
     */
    private void _handleDeleteDisableTheCurrentEnabledSignatureKeyResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 403) {
            throw new Disablethecurrentenabledsignaturekey403responseException("Unexpected error in API call. See HTTP response body for details.", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);


    }

}
