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
import com.messagemedia.api.controllers.NumberAuthorisationController;

import com.fasterxml.jackson.core.type.TypeReference;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class NumberAuthorisationControllerTest extends ControllerTestBase {
    
    /**
     * Controller instance (for all tests)
     */
    private static NumberAuthorisationController controller;
    
    /**
     * Setup test class
     */
    @BeforeClass
    public static void setUpClass() {
        controller = getClient().getNumberAuthorisation();
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
     * This endpoint returns a list of 100 numbers that are on the blacklist.  There is a pagination token to retrieve the next 100 numbers

In the example response the numbers `+61491570156` and `+61491570157` are on the blacklist and therefore will never receive any messages from you.
     * @throws Throwable
     */
    @Test
    public void testTestListAllBlockedNumbers() throws Throwable {

        // Set callback and perform API call
        Getnumberauthorisationblacklistresponse result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.listAllBlockedNumbers();
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

    }

    /**
     * This endpoint allows you to add one or more numbers to your blacklist. You can add up to 10 numbers in one request.
NOTE: numbers need to be in international format and therefore start with a +
     * @throws Throwable
     */
    @Test
    public void testTestAddOneOrMoreNumbersToYourBacklist() throws Throwable {
        // Parameters for the API call
        Addoneormorenumberstoyourbacklistrequest body = APIHelper.deserialize("{\"numbers\":[\"+61491570156\",\"+61491570157\"]}", new TypeReference<Addoneormorenumberstoyourbacklistrequest>(){});

        // Set callback and perform API call
        Addoneormorenumberstoyourbacklistresponse result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.addOneOrMoreNumbersToYourBacklist(body);
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
                "{\"uri\":\"/v1/number_authorisation/mt/blacklist\",\"numbers\":[\"+61491570156\",\"+61491570157\"]}", 
                TestHelper.convertStreamToString(httpResponse.getResponse().getRawBody()), 
                false, true, false));
    }

}
