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
import com.messagemedia.api.controllers.MessagingReportsController;

import com.fasterxml.jackson.core.type.TypeReference;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class MessagingReportsControllerTest extends ControllerTestBase {
    
    /**
     * Controller instance (for all tests)
     */
    private static MessagingReportsController controller;
    
    /**
     * Setup test class
     */
    @BeforeClass
    public static void setUpClass() {
        controller = getClient().getMessagingReports();
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
     * Returns a list of metadata keys
     * @throws Throwable
     */
    @Test
    public void testTestGetMetadataKeys() throws Throwable {
        // Parameters for the API call
        MessageTypeEnum messageType = MessageTypeEnum.fromString("SENT_MESSAGES");
        String startDate = "2017-02-10T13:30:00";
        String endDate = "2017-02-12T13:30:00";
        List<String> accounts = null;
        String timezone = null;

        // Set callback and perform API call
        MetadataKeysResponse result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.getMetadataKeys(messageType, startDate, endDate, accounts, timezone);
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
                "{\"data\":[],\"properties\":{\"end_date\":\"2017-02-10T13:30:00\",\"start_date\":\"2017-02-12T13:30:00\",\"accounts\":[]}}", 
                TestHelper.convertStreamToString(httpResponse.getResponse().getRawBody()), 
                false, true, false));
    }

    /**
     * Lists asynchronous reports.
     * @throws Throwable
     */
    @Test
    public void testTestGetAsyncReports() throws Throwable {
        // Parameters for the API call
        Double page = null;
        Double pageSize = null;

        // Set callback and perform API call
        GetAsyncReportsResponse result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.getAsyncReports(page, pageSize);
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
                "{\"data\":[{\"created_datetime\":\"2017-02-12T13:30:00\",\"last_modified_datetime\":\"2017-02-12T13:30:00\"}],\"pagination\":{}}", 
                TestHelper.convertStreamToString(httpResponse.getResponse().getRawBody()), 
                false, true, false));
    }

    /**
     * Submits a request to generate an async detail report
     * @throws Throwable
     */
    @Test
    public void testTestSubmitReceivedMessagesDetail() throws Throwable {
        // Parameters for the API call
        Asyncreceivedmessagesdetailrequest body = APIHelper.deserialize("{\"end_date\":\"2017-02-10T13:30:00\",\"start_date\":\"2017-02-12T13:30:00\",\"period\":\"TODAY\",\"sort_by\":\"ACCOUNT\",\"sort_direction\":\"ASCENDING\",\"timezone\":\"Australia/Melbourne\",\"accounts\":[],\"delivery_options\":[{\"delivery_type\":\"EMAIL\",\"delivery_addresses\":[],\"delivery_format\":\"CSV\"}]}", new TypeReference<Asyncreceivedmessagesdetailrequest>(){});

        // Set callback and perform API call
        AsyncReportResponse result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.createSubmitReceivedMessagesDetail(body);
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
                "{\"id\":\"b8ffd5b3-050a-46b9-9192-fbd7c20a22ec\"}", 
                TestHelper.convertStreamToString(httpResponse.getResponse().getRawBody()), 
                false, true, false));
    }

    /**
     * Submits a summarised report of received messages
     * @throws Throwable
     */
    @Test
    public void testTestSubmitReceivedMessagesSummary() throws Throwable {
        // Parameters for the API call
        Asyncreceivedmessagessummaryrequest body = APIHelper.deserialize("{\"end_date\":\"2017-02-10T13:30:00\",\"start_date\":\"2017-02-12T13:30:00\",\"summary_by\":\"COUNT\",\"summary_field\":\"MESSAGE_ID\",\"group_by\":[\"DAY\"],\"period\":\"THIS_WEEK\",\"timezone\":\"Australia/Melbourne\",\"accounts\":[],\"delivery_options\":[{\"delivery_type\":\"EMAIL\",\"delivery_addresses\":[],\"delivery_format\":\"CSV\"}]}", new TypeReference<Asyncreceivedmessagessummaryrequest>(){});

        // Set callback and perform API call
        AsyncReportResponse result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.createSubmitReceivedMessagesSummary(body);
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
                "{\"id\":\"b8ffd5b3-050a-46b9-9192-fbd7c20a22ec\"}", 
                TestHelper.convertStreamToString(httpResponse.getResponse().getRawBody()), 
                false, true, false));
    }

    /**
     * Returns a summarised report of messages received
     * @throws Throwable
     */
    @Test
    public void testTestGetReceivedMessagesSummary() throws Throwable {
        // Parameters for the API call
        String endDate = "2017-02-10T13:30:00";
        String startDate = "2017-02-12T13:30:00";
        GroupByEnum groupBy = GroupByEnum.fromString("DAY");
        List<String> accounts = null;
        String destinationAddressCountry = null;
        String destinationAddress = null;
        Format1Enum messageFormat = null;
        String metadataKey = null;
        String metadataValue = null;
        SummaryByEnum summaryBy = SummaryByEnum.fromString("COUNT");
        SummaryFieldEnum summaryField = SummaryFieldEnum.fromString("UNITS");
        String sourceAddressCountry = null;
        String sourceAddress = null;
        String timezone = null;

        // Set callback and perform API call
        SummaryReport result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.getReceivedMessagesSummary(endDate, startDate, groupBy, accounts, destinationAddressCountry, destinationAddress, messageFormat, metadataKey, metadataValue, summaryBy, summaryField, sourceAddressCountry, sourceAddress, timezone);
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
                "{\"properties\":{\"end_date\":\"2017-02-10T13:30:00\",\"start_date\":\"2017-02-12T13:30:00\",\"timezone\":\"The timezone that this report is presented in, this may be passed in as a parameter to the report, or taken from account settings\"},\"data\":[{}]}", 
                TestHelper.convertStreamToString(httpResponse.getResponse().getRawBody()), 
                false, true, false));
    }

    /**
     * Submits a summarised report of sent messages
     * @throws Throwable
     */
    @Test
    public void testTestSubmitSentMessagesSummary() throws Throwable {
        // Parameters for the API call
        Asyncsentmessagesrequest body = APIHelper.deserialize("{\"end_date\":\"2017-02-10T13:30:00\",\"start_date\":\"2017-02-12T13:30:00\",\"group_by\":[\"DAY\"],\"period\":\"YESTERDAY\",\"timezone\":\"Australia/Melbourne\",\"accounts\":[],\"delivery_options\":[{\"delivery_type\":\"EMAIL\",\"delivery_addresses\":[],\"delivery_format\":\"CSV\"}]}", new TypeReference<Asyncsentmessagesrequest>(){});

        // Set callback and perform API call
        AsyncReportResponse result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.createSubmitSentMessagesSummary(body);
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
                "{\"id\":\"b8ffd5b3-050a-46b9-9192-fbd7c20a22ec\"}", 
                TestHelper.convertStreamToString(httpResponse.getResponse().getRawBody()), 
                false, true, false));
    }

    /**
     * Returns a summarised report of messages sent
     * @throws Throwable
     */
    @Test
    public void testTestGetSentMessagesSummary() throws Throwable {
        // Parameters for the API call
        String endDate = "2017-02-10T13:30:00";
        String startDate = "2017-02-12T13:30:00";
        GroupByEnum groupBy = GroupByEnum.fromString("DAY");
        List<String> accounts = null;
        Boolean deliveryReport = null;
        String destinationAddressCountry = null;
        String destinationAddress = null;
        SummaryByEnum summaryBy = SummaryByEnum.fromString("COUNT");
        SummaryFieldEnum summaryField = SummaryFieldEnum.fromString("UNITS");
        Format1Enum messageFormat = null;
        String metadataKey = null;
        String metadataValue = null;
        String statusCode = null;
        String sourceAddressCountry = null;
        String sourceAddress = null;
        String timezone = null;

        // Set callback and perform API call
        SummaryReport result = null;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.getSentMessagesSummary(endDate, startDate, groupBy, accounts, deliveryReport, destinationAddressCountry, destinationAddress, summaryBy, summaryField, messageFormat, metadataKey, metadataValue, statusCode, sourceAddressCountry, sourceAddress, timezone);
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
                "{\"properties\":{\"end_date\":\"2017-02-10T13:30:00\",\"start_date\":\"2017-02-12T13:30:00\",\"timezone\":\"The timezone that this report is presented in, this may be passed in as a parameter to the report, or taken from account settings\"},\"data\":[{}]}", 
                TestHelper.convertStreamToString(httpResponse.getResponse().getRawBody()), 
                false, true, false));
    }

}
