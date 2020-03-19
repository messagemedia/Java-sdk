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
import com.messagemedia.api.controllers.DedicatedNumbersController;

import com.fasterxml.jackson.core.type.TypeReference;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class DedicatedNumbersControllerTest extends ControllerTestBase {
    
    /**
     * Controller instance (for all tests)
     */
    private static DedicatedNumbersController controller;
    
    /**
     * Setup test class
     */
    @BeforeClass
    public static void setUpClass() {
        controller = getClient().getDedicatedNumbers();
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
     * Get a list of available dedicated numbers, filtered by requirements.
     * @throws Throwable
     */
    @Test
    public void testTestGetNumbers() throws Throwable {
        // Parameters for the API call
        String country = "AU";
        String matching = "223344";
        Integer pageSize = 3;
        ServiceTypesEnum serviceTypes = ServiceTypesEnum.fromString("SMS");
        String token = "example";

        // Set callback and perform API call
        NumbersListResponse result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.getNumbers(country, matching, pageSize, serviceTypes, token);
        } catch(APIException e) {};

       // Test whether the response is null
        assertNotNull("Response is null", 
                httpResponse.getResponse());
        // Test response code
        assertEquals("Status is not 200", 
                200, httpResponse.getResponse().getStatusCode());

        // Test headers
        Map<String, String> headers = new LinkedHashMap<String, String>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        
        assertTrue("Headers do not match", TestHelper.areHeadersProperSubsetOf(
                headers, httpResponse.getResponse().getHeaders(), true));

        // Test whether the captured response is as we expected
        assertNotNull("Result does not exist", 
                result);
        assertTrue("Response body does not match in keys", TestHelper.isJsonObjectProperSubsetOf(
                "{\"pagination\":{\"next_token\":\"0428d673-0f75-4063-9493-e89d75f13438\",\"page_size\":5},\"data\":[{\"id\":\"03cf54ad-a4a3-4cd1-afd5-e0ca2cf158a3\",\"phone_number\":\"+61436489205\",\"country\":\"AU\",\"type\":\"MOBILE\",\"classification\":\"BRONZE\",\"available_after\":\"2019-08-06T23:56:15.633Z\",\"capabilities\":[\"SMS\"]}]}", 
                TestHelper.convertStreamToString(httpResponse.getResponse().getRawBody()), 
                false, true, false));
    }

    /**
     * Use this endpoint to view details of the assignment including the label and metadata.
     * @throws Throwable
     */
    @Test
    public void testTestGetAssignment() throws Throwable {
        // Parameters for the API call
        String numberId = "e2014bc7-5fed-4e27-bd8c-XXXXXXXXXXX";
        String accept = "application/json;charset=UTF-8";

        // Set callback and perform API call
        Assignment result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.getAssignment(numberId, accept);
        } catch(APIException e) {};

       // Test whether the response is null
        assertNotNull("Response is null", 
                httpResponse.getResponse());
        // Test response code
        assertEquals("Status is not 200", 
                200, httpResponse.getResponse().getStatusCode());

        // Test headers
        Map<String, String> headers = new LinkedHashMap<String, String>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        
        assertTrue("Headers do not match", TestHelper.areHeadersProperSubsetOf(
                headers, httpResponse.getResponse().getHeaders(), true));

        // Test whether the captured response is as we expected
        assertNotNull("Result does not exist", 
                result);
        assertTrue("Response body does not match in keys", TestHelper.isJsonObjectProperSubsetOf(
                "{\"metadata\":{\"key1\":\"value1\"},\"label\":\"LabelTest0\",\"id\":\"be3cb602-7c00-4c87-ae4b-b8defc04f179\",\"number_id\":\"b9ee3fe8-2c20-47b1-96e9-c5d12d7ed985\"}", 
                TestHelper.convertStreamToString(httpResponse.getResponse().getRawBody()), 
                false, true, false));
    }

    /**
     * Assign the specified number to the authenticated account. 
Use the body of the request to specify a label or metadata 
for this number assignment.

If you receive a *conflict* error then the number that you have selected is unavailable for assignment. 
This means that the number is either already assigned to another account, 
or has an available_after date in the future. Should this occur, perform 
another search and select a different number.
     * @throws Throwable
     */
    @Test
    public void testTestCreateAssignment() throws Throwable {
        // Parameters for the API call
        String numberId = "e2014bc7-5fed-4e27-bd8c-XXXXXXXXXXX";
        String accept = "application/json;charset=UTF-8";
        CreateAssignmentrequest body = APIHelper.deserialize("{\"label\":\"ExampleLabel\",\"metadata\":{\"Key1\":\"value1\",\"Key2\":\"value2\"}}", new TypeReference<CreateAssignmentrequest>(){});

        // Set callback and perform API call
        Assignment result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.createAssignment(numberId, accept, body);
        } catch(APIException e) {};

       // Test whether the response is null
        assertNotNull("Response is null", 
                httpResponse.getResponse());
        // Test response code
        assertEquals("Status is not 201", 
                201, httpResponse.getResponse().getStatusCode());

        // Test headers
        Map<String, String> headers = new LinkedHashMap<String, String>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        
        assertTrue("Headers do not match", TestHelper.areHeadersProperSubsetOf(
                headers, httpResponse.getResponse().getHeaders(), true));

        // Test whether the captured response is as we expected
        assertNotNull("Result does not exist", 
                result);
        assertTrue("Response body does not match in keys", TestHelper.isJsonObjectProperSubsetOf(
                "{\"label\":\"cillum irure\",\"number_id\":\"et pariatur\"}", 
                TestHelper.convertStreamToString(httpResponse.getResponse().getRawBody()), 
                false, true, false));
    }

    /**
     * Release the dedicated number from your account.
     * @throws Throwable
     */
    @Test
    public void testTestDeleteAssignment() throws Throwable {
        // Parameters for the API call
        String numberId = "e2014bc7-5fed-4e27-bd8c-XXXXXXXXXXX";
        String accept = "application/json;charset=UTF-8";

        // Set callback and perform API call
        InputStream result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.deleteAssignment(numberId, accept);
        } catch(APIException e) {};

       // Test whether the response is null
        assertNotNull("Response is null", 
                httpResponse.getResponse());
        // Test response code
        assertEquals("Status is not 204", 
                204, httpResponse.getResponse().getStatusCode());

        // Test headers
        Map<String, String> headers = new LinkedHashMap<String, String>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        
        assertTrue("Headers do not match", TestHelper.areHeadersProperSubsetOf(
                headers, httpResponse.getResponse().getHeaders(), true));

    }

    /**
     * Retain the dedicated number assignment, and edit or add additional metadata or title information. You can exclude any data from the body of this request that you do not want updated.
     * @throws Throwable
     */
    @Test
    public void testTestUpdateAssignment() throws Throwable {
        // Parameters for the API call
        String numberId = "e2014bc7-5fed-4e27-bd8c-XXXXXXXXXXX";
        String accept = "application/json;charset=UTF-8";
        UpdateAssignmentrequest body = APIHelper.deserialize("{\"label\":\"ExampleLabel\",\"metadata\":{\"Key1\":\"value1\",\"Key2\":\"value2\"}}", new TypeReference<UpdateAssignmentrequest>(){});

        // Set callback and perform API call
        Assignment result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.updateAssignment(numberId, accept, body);
        } catch(APIException e) {};

       // Test whether the response is null
        assertNotNull("Response is null", 
                httpResponse.getResponse());
        // Test response code
        assertEquals("Status is not 204", 
                204, httpResponse.getResponse().getStatusCode());

        // Test headers
        Map<String, String> headers = new LinkedHashMap<String, String>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        
        assertTrue("Headers do not match", TestHelper.areHeadersProperSubsetOf(
                headers, httpResponse.getResponse().getHeaders(), true));

        // Test whether the captured response is as we expected
        assertNotNull("Result does not exist", 
                result);
        assertTrue("Response body does not match in keys", TestHelper.isJsonObjectProperSubsetOf(
                "{\"id\":\"b06387c0-f4d9-4333-8657-c819bede79c3\",\"number_id\":\"073fb6bd-f054-4644-aada-8fb204145d77\"}", 
                TestHelper.convertStreamToString(httpResponse.getResponse().getRawBody()), 
                false, true, false));
    }

}
