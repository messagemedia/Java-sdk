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
import com.messagemedia.api.controllers.ShortTrackableLinksReportsController;

import com.fasterxml.jackson.core.type.TypeReference;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class ShortTrackableLinksReportsControllerTest extends ControllerTestBase {
    
    /**
     * Controller instance (for all tests)
     */
    private static ShortTrackableLinksReportsController controller;
    
    /**
     * Setup test class
     */
    @BeforeClass
    public static void setUpClass() {
        controller = getClient().getShortTrackableLinksReports();
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
     * Clicks summary report for metadata key value pair, long url and short url.
     * @throws Throwable
     */
    @Test
    public void testTestLogSummary() throws Throwable {
        // Parameters for the API call
        String key = null;
        String value = null;
        String url = null;
        String recipient = null;
        Double page = null;
        Double pageSize = null;

        // Set callback and perform API call
        LogSummaryResult result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.getLogSummary(key, value, url, recipient, page, pageSize);
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
                "{\"total_clicks\":3,\"unique_clicks\":1,\"total_views\":2,\"unique_views\":1,\"short_urls_generated\":1,\"short_urls\":[{\"click_count\":3,\"view_count\":2,\"message_id\":\"00000000-0000-0000-0000-000000000000\",\"long_url\":\"https://developers.messagemedia.com\",\"short_url\":\"https://nxt.to/abc1234\",\"destination_number\":\"+61491570157\"}],\"pagination\":{\"page\":1,\"page_size\":100,\"page_count\":3}}", 
                TestHelper.convertStreamToString(httpResponse.getResponse().getRawBody()), 
                false, true, false));
    }

}
