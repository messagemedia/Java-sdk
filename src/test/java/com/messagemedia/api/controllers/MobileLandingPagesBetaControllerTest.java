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
import com.messagemedia.api.controllers.MobileLandingPagesBetaController;

import com.fasterxml.jackson.core.type.TypeReference;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class MobileLandingPagesBetaControllerTest extends ControllerTestBase {
    
    /**
     * Controller instance (for all tests)
     */
    private static MobileLandingPagesBetaController controller;
    
    /**
     * Setup test class
     */
    @BeforeClass
    public static void setUpClass() {
        controller = getClient().getMobileLandingPagesBeta();
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
     * The Landing Page datastore makes it easier to create Campiangs based on the saved data.Create a Landing Page.
     * @throws Throwable
     */
    @Test
    public void testTestCreateaLandingPage() throws Throwable {
        // Parameters for the API call
        CreateLandingPage body = APIHelper.deserialize("{\"name\":\" My Landing Page\",\"template_id\":\"ac895f01-3149-4bf8-a8fe-01d3b8a9ba97\",\"parameters\":{\"pageTitle\":\"The page title\",\"pageText\":\"The body text\",\"imageUrl\":\"https://example.com/image.jpg\"},\"fields\":{\"title\":{\"type\":\"TEXT\"},\"bodyText\":{\"type\":\"TEXT\"},\"ctaUrl\":{\"type\":\"URL\"}}}", new TypeReference<CreateLandingPage>(){});

        // Set callback and perform API call
        CreateaLandingPageresponse result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.createaLandingPage(body);
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
                "{\"id\":\"a94041bb-704b-48fa-ba0b-6f1538fc502f\",\"name\":\" My Landing Page\",\"template_id\":\"ac895f01-3149-4bf8-a8fe-01d3b8a9ba97\",\"parameters\":{\"title\":\"This is a ${title}\",\"bodyText\":\"This is some ${bodyText}\",\"callToAction\":\"${ctaUrl}\"},\"fields\":{\"title\":{\"type\":\"TEXT\"},\"bodyText\":{\"type\":\"TEXT\"},\"ctaUrl\":{\"type\":\"URL\"}},\"created_timestamp\":\"2019-11-03T11:49:02.807Z\",\"modified_timestamp\":\"2019-11-03T11:49:02.807Z\"}", 
                TestHelper.convertStreamToString(httpResponse.getResponse().getRawBody()), 
                false, true, false));
    }

    /**
     * The Landing Page datastore makes it easier to create Campiangs based on the saved data.Returns a paginated list of Landing Pages for your account. ```sort_by``` and ```sort_direction``` must both be specified or neither at all (the default sort options are ```DESCENDING``` ```MODIFIED_TIMESTAMP```).
     * @throws Throwable
     */
    @Test
    public void testTestGetLandingPages() throws Throwable {
        // Parameters for the API call
        String pageSize = null;
        String pageToken = null;
        String sortBy = null;
        String sortDirection = null;

        // Set callback and perform API call
        Object result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.getLandingPages(pageSize, pageToken, sortBy, sortDirection);
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

}
