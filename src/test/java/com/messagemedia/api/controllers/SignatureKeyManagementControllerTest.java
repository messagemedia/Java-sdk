package com.messagemedia.api.controllers;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.messagemedia.api.models.*;
import com.messagemedia.api.exceptions.*;
import com.messagemedia.api.APIHelper;
import com.messagemedia.api.DateTimeHelper;
import com.messagemedia.api.Configuration;
import com.messagemedia.api.testing.TestHelper;
import com.messagemedia.api.controllers.SignatureKeyManagementController;

import com.fasterxml.jackson.core.type.TypeReference;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class SignatureKeyManagementControllerTest extends ControllerTestBase {
    
    /**
     * Controller instance (for all tests)
     */
    private static SignatureKeyManagementController controller;
    
    /**
     * Setup test class
     */
    @BeforeClass
    public static void setUpClass() {
        controller = getClient().getSignatureKeyManagement();
    }

    /**
     * Tear down test class
     * @throws IOException
     */
    @AfterClass
    public static void tearDownClass() throws IOException {
        controller = null;
    }

    /**
     * This will create a key pair:

- The ```private key``` stored in MessageMedia is used to create the signature.

- The ```public key``` is returned and stored at your side to verify the signature in callbacks.

You need to enable your signature key after creating.

The most basic body has the following structure:

```json
{
    "digest": "SHA224",
    "cipher": "RSA"
}
```

- ```digest``` is used to hash the message. The valid values for digest type are: SHA224, SHA256, SHA512

- ```cipher``` is used to encrypt the hashed message. The valid value for cipher type is: RSA

A successful request for the ```create signature key``` endpoint will return a response body as follows:

```json
{
    "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31",
    "public_key": "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCTIxtRyT5CuOD74r7UCT+AKzWNxvaAP9myjAqR7+vBnJKEvoPnmbKTnm6uLlxutnMbjKrnCCWnQ9vtBVnnd+ElhwLDPADfMcJoOqwi7mTcxucckeEbBsfsgYRfdacxgSZL8hVD1hLViQr3xwjEIkJcx1w3x8npvwMuTY0uW8+PjwIDAQAB",
    "cipher": "RSA",
    "digest": "SHA224",
    "created": "2018-01-18T10:16:12.364Z",
    "enabled": false
}
```

The response body of a successful POST request to the ```create signature key``` endpoint will contain six properties:

- ```key_id``` will be a 36 character UUID which can be used to enable, delete or get the details.

- ```public_key``` is used to decrypt the signature.

- ```cipher``` same as cipher in request body.

- ```digest``` same as digest in request body.

- ```created``` is the created date.

- ```enabled``` is false for the new signature key. You can use the ```enable signature key``` endpoint to set this field to true.
     * @throws Throwable
     */
    @Test
    public void testTestCreateSignatureKey() throws Throwable {
        // Parameters for the API call
        String accept = "application/json";
        Createsignaturekeyrequest body = APIHelper.deserialize("{\"digest\":\"SHA224\",\"cipher\":\"RSA\"}", new TypeReference<Createsignaturekeyrequest>(){});

        // Set callback and perform API call
        Createsignaturekeyresponse result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.createSignatureKey(accept, body);
        } catch(APIException e) {};

       // Test whether the response is null
        assertNotNull("Response is null", 
                httpResponse.getResponse());
        // Test response code
        assertEquals("Status is not 201", 
                201, httpResponse.getResponse().getStatusCode());

        // Test headers
        Map<String, String> headers = new LinkedHashMap<String, String>();
        headers.put("Content-Type", "application/json");
        
        assertTrue("Headers do not match", TestHelper.areHeadersProperSubsetOf(
                headers, httpResponse.getResponse().getHeaders(), true));

        // Test whether the captured response is as we expected
        assertNotNull("Result does not exist", 
                result);
        assertTrue("Response body does not match in keys", TestHelper.isJsonObjectProperSubsetOf(
                "{\"key_id\":\"7ca628a8-08b0-4e42-aeb8-960b37049c31\",\"public_key\":\"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCTIxtRyT5CuOD74r7UCT+AKzWNxvaAP9myjAqR7+vBnJKEvoPnmbKTnm6uLlxutnMbjKrnCCWnQ9vtBVnnd+ElhwLDPADfMcJoOqwi7mTcxucckeEbBsfsgYRfdacxgSZL8hVD1hLViQr3xwjEIkJcx1w3x8npvwMuTY0uW8+PjwIDAQAB\",\"cipher\":\"RSA\",\"digest\":\"SHA224\",\"created\":\"2018-01-18T10:16:12.364Z\",\"enabled\":false}", 
                TestHelper.convertStreamToString(httpResponse.getResponse().getRawBody()), 
                false, true, false));
    }

    /**
     * Enable a signature key using the key_id returned in the ```create signature key``` endpoint.
There is only one signature key is enabled at the one moment in time. So if you enable the new signature key, the old one will be disabled.

The most basic body has the following structure:

```json
{
    "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31"
}
```

The response body of a successful PATCH request to ```enable signature key``` endpoint will contain the ```enabled``` properties with the value is true as follows:

```json
{
    "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31",
    "cipher": "RSA",
    "digest": "SHA224",
    "created": "2018-01-18T10:16:12.364Z",
    "enabled": true
}
```

*Note: If an invalid or non-existent key_id parameter is specified in the request, then an HTTP 404 Not Found response will be returned*
     * @throws Throwable
     */
    @Test
    public void testTestEnableSignatureKey() throws Throwable {
        // Parameters for the API call
        String accept = "application/json";
        Enablesignaturekeyrequest body = APIHelper.deserialize("{\"key_id\":\"7ca628a8-08b0-4e42-aeb8-960b37049c31\"}", new TypeReference<Enablesignaturekeyrequest>(){});

        // Set callback and perform API call
        Enablesignaturekeyresponse result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.updateEnableSignatureKey(accept, body);
        } catch(APIException e) {};

       // Test whether the response is null
        assertNotNull("Response is null", 
                httpResponse.getResponse());
        // Test response code
        assertEquals("Status is not 200", 
                200, httpResponse.getResponse().getStatusCode());

        // Test headers
        Map<String, String> headers = new LinkedHashMap<String, String>();
        headers.put("Content-Type", "application/json");
        
        assertTrue("Headers do not match", TestHelper.areHeadersProperSubsetOf(
                headers, httpResponse.getResponse().getHeaders(), true));

        // Test whether the captured response is as we expected
        assertNotNull("Result does not exist", 
                result);
        assertTrue("Response body does not match in keys", TestHelper.isJsonObjectProperSubsetOf(
                "{\"key_id\":\"7ca628a8-08b0-4e42-aeb8-960b37049c31\",\"cipher\":\"RSA\",\"digest\":\"SHA224\",\"created\":\"2018-01-18T10:16:12.364Z\",\"enabled\":true}", 
                TestHelper.convertStreamToString(httpResponse.getResponse().getRawBody()), 
                false, true, false));
    }

    /**
     * Retrieve the currently enabled signature key.

A successful request for the ```get enabled signature key``` endpoint will return a response body as follows:

```json
{
    "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31",
    "cipher": "RSA",
    "digest": "SHA224",
    "created": "2018-01-18T10:16:12.364Z",
    "enabled": true
}
```

*Note: If there is no enabled signature key, then an HTTP 404 Not Found response will be returned*
     * @throws Throwable
     */
    @Test
    public void testTestGetEnabledSignatureKey() throws Throwable {

        // Set callback and perform API call
        Getenabledsignaturekeyresponse result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.getEnabledSignatureKey();
        } catch(APIException e) {};

       // Test whether the response is null
        assertNotNull("Response is null", 
                httpResponse.getResponse());
        // Test response code
        assertEquals("Status is not 200", 
                200, httpResponse.getResponse().getStatusCode());

        // Test headers
        Map<String, String> headers = new LinkedHashMap<String, String>();
        headers.put("Content-Type", "application/json");
        
        assertTrue("Headers do not match", TestHelper.areHeadersProperSubsetOf(
                headers, httpResponse.getResponse().getHeaders(), true));

        // Test whether the captured response is as we expected
        assertNotNull("Result does not exist", 
                result);
        assertTrue("Response body does not match in keys", TestHelper.isJsonObjectProperSubsetOf(
                "{\"key_id\":\"7ca628a8-08b0-4e42-aeb8-960b37049c31\",\"cipher\":\"RSA\",\"digest\":\"SHA224\",\"created\":\"2018-01-18T10:16:12.364Z\",\"enabled\":true}", 
                TestHelper.convertStreamToString(httpResponse.getResponse().getRawBody()), 
                false, true, false));
    }

    /**
     * Disable the current enabled signature key.

A successful request for the ```disable the current enabled signature key.``` endpoint will return no content when successful.
If there is an enabled key, it will be disabled; and the 204 status code is returned.
If there is no key or no enabled key, the 204 status code is also returned.
     * @throws Throwable
     */
    @Test
    public void testTestDisableTheCurrentEnabledSignatureKey() throws Throwable {

        // Set callback and perform API call
        controller.setHttpCallBack(httpResponse);
        try {
        controller.deleteDisableTheCurrentEnabledSignatureKey();
        } catch(APIException e) {};

       // Test whether the response is null
        assertNotNull("Response is null", 
                httpResponse.getResponse());
        // Test response code
        assertEquals("Status is not 204", 
                204, httpResponse.getResponse().getStatusCode());

    }

}
