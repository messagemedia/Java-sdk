# Getting started

# Introduction
The MessageMedia APIs provide powerful business messaging capabilities across sending, receiving, and processing SMS, MMS, and rich messaging. 

All requests to the MessageMedia REST API must be authenticated, this can either be done using Basic Authentication or by signing with a HMAC signature.
  
# Credentials
  
To access the API, an API key and secret are required.
  
[Sign up for a developer account here to get access](https://developers.messagemedia.com/register/): https://developers.messagemedia.com/register/.

# Features
###  De-Duplication 
De-Duplication helps you avoid having to undertake data cleansing before commencing send outs.  
It automatically detects and withholds messages deemed to be duplicates through the use of a 24-hour window – if a message is sent to the same number with the same content within a 24hr period, the subsequent message(s) will be withheld and rejected. To enable this, you don't need to make any changes to your application, just an account configuration change by MessageMedia's support team.

###  Social Sending 
Social Sending permits messages to be sent only during sociable hours - i.e. 8am to 6pm (based on your accounts local time zone - not local time). 
Messages sent outside of these hours are scheduled to be released during the next social time period. This feature helps businesses avoid send-outs during a time that would be deemed unsuitable by the customer. To enable this, you don't need to make any changes to your application, just an account configuration change by MessageMedia's support team.

###  Familiar Sender
Familiar Sender ensures all communication sent to a customer are from the same phone number. 
This allows businesses to build trust and familiarity with their customers and not confuse them by changing outgoing numbers. To enable this, you don't need to make any changes to your application, just an account configuration change by MessageMedia's support team.

### Character Converter
Characters in a message may not always fall within the GSM-7 supported characterset, and when this occurs all 
outbound messages will be encoded using UCS-2 leading to the customer being double-charged for the SMS. Character Converter 
can help you avoid being double-charged for your SMS by converting all characters into the GSM-7 format ensuring you always 
get the maximum characters into an SMS. Bear in my mind, this will downgrade all your unicode characters so for instance, 
your emojis will be translated into a string of unknown characters (eg: �).  To enable this, you don't need to make any 
changes to your application, just an account configuration change by MessageMedia's support team.


## How to Build

The generated code uses a few Maven dependencies e.g., Jackson, UniRest,
and Apache HttpClient. The reference to these dependencies is already
added in the pom.xml file will be installed automatically. Therefore,
you will need internet access for a successful build.

* In order to open the client library in Eclipse click on ``` File -> Import ```.

![Importing SDK into Eclipse - Step 1](https://apidocs.io/illustration/java?step=import0&workspaceFolder=MessageMedia-Java&workspaceName=MessageMedia&projectName=MessageMediaLib&rootNamespace=com.messagemedia.api)

* In the import dialog, select ``` Existing Java Project ``` and click ``` Next ```.

![Importing SDK into Eclipse - Step 2](https://apidocs.io/illustration/java?step=import1&workspaceFolder=MessageMedia-Java&workspaceName=MessageMedia&projectName=MessageMediaLib&rootNamespace=com.messagemedia.api)

* Browse to locate the folder containing the source code. Select the detected location of the project and click ``` Finish ```.

![Importing SDK into Eclipse - Step 3](https://apidocs.io/illustration/java?step=import2&workspaceFolder=MessageMedia-Java&workspaceName=MessageMedia&projectName=MessageMediaLib&rootNamespace=com.messagemedia.api)

* Upon successful import, the project will be automatically built by Eclipse after automatically resolving the dependencies.

![Importing SDK into Eclipse - Step 4](https://apidocs.io/illustration/java?step=import3&workspaceFolder=MessageMedia-Java&workspaceName=MessageMedia&projectName=MessageMediaLib&rootNamespace=com.messagemedia.api)

## How to Use

The following section explains how to use the MessageMedia library in a new console project.

### 1. Starting a new project

For starting a new project, click the menu command ``` File > New > Project ```.

![Add a new project in Eclipse](https://apidocs.io/illustration/java?step=createNewProject0&workspaceFolder=MessageMedia-Java&workspaceName=MessageMedia&projectName=MessageMediaLib&rootNamespace=com.messagemedia.api)

Next, choose ``` Maven > Maven Project ```and click ``` Next ```.

![Create a new Maven Project - Step 1](https://apidocs.io/illustration/java?step=createNewProject1&workspaceFolder=MessageMedia-Java&workspaceName=MessageMedia&projectName=MessageMediaLib&rootNamespace=com.messagemedia.api)

Here, make sure to use the current workspace by choosing ``` Use default Workspace location ```, as shown in the picture below and click ``` Next ```.

![Create a new Maven Project - Step 2](https://apidocs.io/illustration/java?step=createNewProject2&workspaceFolder=MessageMedia-Java&workspaceName=MessageMedia&projectName=MessageMediaLib&rootNamespace=com.messagemedia.api)

Following this, select the *quick start* project type to create a simple project with an existing class and a ``` main ``` method. To do this, choose ``` maven-archetype-quickstart ``` item from the list and click ``` Next ```.

![Create a new Maven Project - Step 3](https://apidocs.io/illustration/java?step=createNewProject3&workspaceFolder=MessageMedia-Java&workspaceName=MessageMedia&projectName=MessageMediaLib&rootNamespace=com.messagemedia.api)

In the last step, provide a ``` Group Id ``` and ``` Artifact Id ``` as shown in the picture below and click ``` Finish ```.

![Create a new Maven Project - Step 4](https://apidocs.io/illustration/java?step=createNewProject4&workspaceFolder=MessageMedia-Java&workspaceName=MessageMedia&projectName=MessageMediaLib&rootNamespace=com.messagemedia.api)

### 2. Add reference of the library project

The created Maven project manages its dependencies using its ``` pom.xml ``` file. In order to add a dependency on the *MessageMediaLib* client library, double click on the ``` pom.xml ``` file in the ``` Package Explorer ```. Opening the ``` pom.xml ``` file will render a graphical view on the cavas. Here, switch to the ``` Dependencies ``` tab and click the ``` Add ``` button as shown in the picture below.

![Adding dependency to the client library - Step 1](https://apidocs.io/illustration/java?step=testProject0&workspaceFolder=MessageMedia-Java&workspaceName=MessageMedia&projectName=MessageMediaLib&rootNamespace=com.messagemedia.api)

Clicking the ``` Add ``` button will open a dialog where you need to specify MessageMedia in ``` Group Id ``` and MessageMediaLib in the ``` Artifact Id ``` fields. Once added click ``` OK ```. Save the ``` pom.xml ``` file.

![Adding dependency to the client library - Step 2](https://apidocs.io/illustration/java?step=testProject1&workspaceFolder=MessageMedia-Java&workspaceName=MessageMedia&projectName=MessageMediaLib&rootNamespace=com.messagemedia.api)

### 3. Write sample code

Once the ``` SimpleConsoleApp ``` is created, a file named ``` App.java ``` will be visible in the *Package Explorer* with a ``` main ``` method. This is the entry point for the execution of the created project.
Here, you can add code to initialize the client library and instantiate a *Controller* class. Sample code to initialize the client library and using controller methods is given in the subsequent sections.

![Adding dependency to the client library - Step 2](https://apidocs.io/illustration/java?step=testProject2&workspaceFolder=MessageMedia-Java&workspaceName=MessageMedia&projectName=MessageMediaLib&rootNamespace=com.messagemedia.api)

## How to Test

The generated code and the server can be tested using automatically generated test cases. 
JUnit is used as the testing framework and test runner.

In Eclipse, for running the tests do the following:

1. Select the project *MessageMediaLib* from the package explorer.
2. Select "Run -> Run as -> JUnit Test" or use "Alt + Shift + X" followed by "T" to run the Tests.

## Initialization

### Authentication
In order to setup authentication and initialization of the API client, you need the following information.

| Parameter | Description |
|-----------|-------------|
| basicAuthUserName | The username to use with basic authentication |
| basicAuthPassword | The password to use with basic authentication |



API client can be initialized as following.

```java
// Configuration parameters and credentials
String basicAuthUserName = "basicAuthUserName"; // The username to use with basic authentication
String basicAuthPassword = "basicAuthPassword"; // The password to use with basic authentication

MessageMediaClient client = new MessageMediaClient(basicAuthUserName, basicAuthPassword);
```


# Class Reference

## <a name="list_of_controllers"></a>List of Controllers

* [MessagesController](#messages_controller)
* [DeliveryReportsController](#delivery_reports_controller)
* [RepliesController](#replies_controller)
* [LookupsController](#lookups_controller)
* [NumberAuthorisationController](#number_authorisation_controller)
* [DedicatedNumbersController](#dedicated_numbers_controller)
* [MessagingReportsController](#messaging_reports_controller)
* [ShortTrackableLinksReportsController](#short_trackable_links_reports_controller)
* [WebhooksManagementController](#webhooks_management_controller)
* [SignatureKeyManagementController](#signature_key_management_controller)
* [MobileLandingPagesBetaController](#mobile_landing_pages_beta_controller)

## <a name="messages_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.messagemedia.api.controllers.MessagesController") MessagesController

### Get singleton instance

The singleton instance of the ``` MessagesController ``` class can be accessed from the API Client.

```java
MessagesController messages = client.getMessages();
```

### <a name="get_message_status_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MessagesController.getMessageStatusAsync") getMessageStatusAsync

> Retrieve the current status of a message using the message ID returned
> in the send messages end point.
> 
> A successful request to the get message status endpoint will return a
> response body as follows:
> 
> ```json
> 
> {
>     "format": "SMS",
>     "content": "My first message!",
>     "metadata": {
>         "key1": "value1",
>         "key2": "value2"
>     },
>     "message_id": "877c19ef-fa2e-4cec-827a-e1df9b5509f7",
>     "callback_url": "https://my.callback.url.com",
>     "delivery_report": true,
>     "destination_number": "+61401760575",
>     "scheduled": "2016-11-03T11:49:02.807Z",
>     "source_number": "+61491570157",
>     "source_number_type": "INTERNATIONAL",
>     "message_expiry_timestamp": "2016-11-03T11:49:02.807Z",
>     "status": "enroute"
> }
> 
> ```
> 
> The status property of the response indicates the current status of the
> message. See the Delivery Reports section of this documentation for more information on message
> statues.
> 
> *Note: If an invalid or non existent message ID parameter is specified
> in the request, then a HTTP 404 Not Found response will be returned*
> 


```java
void getMessageStatusAsync(
        final String messageId,
        final APICallBack<Getmessagestatusresponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| messageId |  ``` Required ```  | 36 character UUID. |


#### Example Usage

```java
String messageId = "messageId";
// Invoking the API call with sample inputs
messages.getMessageStatusAsync(messageId, new APICallBack<Getmessagestatusresponse>() {
    public void onSuccess(HttpContext context, Getmessagestatusresponse response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 403 | Unauthorised |
| 404 | Resource not found |



### <a name="update_cancel_scheduled_message_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MessagesController.updateCancelScheduledMessageAsync") updateCancelScheduledMessageAsync

> Cancel a scheduled message that has not yet been delivered.
> 
> A scheduled message can be cancelled by updating the status of a message
> from ```scheduled``` to ```cancelled```. This is done by submitting a PUT request to the
> messages endpoint using the message ID as a parameter (the same endpoint used above to retrieve
> the status of a message).
> 
> The body of the request simply needs to contain a ```status``` property with the value set to ```cancelled```.
> 
> ```json
> 
> {
>     "status": "cancelled"
> }
> 
> ```
> 
> *Note: Only messages with a status of scheduled can be cancelled. If an invalid or non existent message ID parameter is specified in the request, then a HTTP 404 Not Found response will be returned*
> 


```java
void updateCancelScheduledMessageAsync(
        final String messageId,
        final Cancelscheduledmessagerequest body,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| messageId |  ``` Required ```  | 36 character UUID. |
| body |  ``` Required ```  | Parameters of a message to change. |


#### Example Usage

```java
try {
    String messageId = "messageId";
    Cancelscheduledmessagerequest body = new Cancelscheduledmessagerequest();
    // Invoking the API call with sample inputs
    messages.updateCancelScheduledMessageAsync(messageId, body, new APICallBack<void>() {
        public void onSuccess(HttpContext context, void response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad request |
| 403 | Unauthorised |
| 404 | Resource not found |



### <a name="create_send_messages_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MessagesController.createSendMessagesAsync") createSendMessagesAsync

> Submit one or more (up to 100 per request) SMS, MMS or text to voice
> messages for delivery.
> 
> The most basic message has the following structure:
> 
> ```json
> 
> {
>     "messages": [
>         {
>             "content": "My first message!",
>             "destination_number": "+61491570156"
>         }
>     ]
> }
> 
> ```
> 
> More advanced delivery features can be specified by setting the
> following properties in a message:
> 
> - ```callback_url``` A URL can be included with each message to which
> Webhooks will be pushed to via a HTTP POST request. Webhooks will be sent if and when the status of the message changes as it is processed (if the delivery report property of the request is set to ```true```) and when replies are received. Specifying a callback URL is optional.
> 
> - ```content``` The content of the message. This can be a Unicode string, up to 5,000 characters long.
>   Message content is required.
> 
> - ```delivery_report``` Delivery reports can be requested with each
> message. If delivery reports are requested, a webhook will be submitted to the ```callback_url``` property specified for the message (or to the webhooks)
>   specified for the account every time the status of the message changes as it is processed. The
>   current status of the message can also be retrieved via the Delivery Reports endpoint of the
>   Messages API. Delivery reports are optional and by default will not be requested.
> 
> - ```destination_number``` The destination number the message should be
> delivered to. This should be specified in E.164
>   international format. For information on E.164, please refer to http://en.wikipedia.org/wiki/E.164.
>   A destination number is required.
> 
> - ```format``` The format specifies which format the message will be
> sent as, ```SMS``` (text message), ```MMS``` (multimedia message)
>   or ```TTS``` (text to speech). With ```TTS``` format, we will call the destination number and read out the
>   message using a computer generated voice. Specifying a format is optional, by default ```SMS``` will be used.
> 
> - ```source_number``` A source number may be specified for the message,
> this will be the number that
>   the message appears from on the handset. By default this feature is _not_ available and will be ignored
>   in the request. Please contact <support@messagemedia.com> for more information. Specifying a source
>   number is optional and a by default a source number will be assigned to the message.
> 
> - ```media``` The media is used to specify the url of the media file
> that you are trying to send. Supported file formats include png, jpeg
> and gif. ```format``` parameter must be set to ```MMS``` for this to
> work.
> 
> - ```subject``` The subject field is used to denote subject of the MMS
> message and has a maximum size of 64 characters long. Specifying a
> subject is optional.
> 
> - ```source_number_type``` If a source number is specified, the type of
> source number may also be
>   specified. This is recommended when using a source address type that is not an internationally
>   formatted number, available options are ```INTERNATIONAL```, ```ALPHANUMERIC``` or ```SHORTCODE```. Specifying a
>   source number type is only valid when the ```source_number``` parameter is specified and is optional.
>   If a source number is specified and no source number type is specified, the source number type will be
>   inferred from the source number, however this may be inaccurate.
> 
> - ```scheduled``` A message can be scheduled for delivery in the future
> by setting the scheduled property.
>   The scheduled property expects a date time specified in ISO 8601 format. The scheduled time must be
>   provided in UTC and is optional. If no scheduled property is set, the message will be delivered immediately.
> 
> - ```message_expiry_timestamp``` A message expiry timestamp can be
> provided to specify the latest time
>   at which the message should be delivered. If the message cannot be delivered before the specified
>   message expiry timestamp elapses, the message will be discarded. Specifying a message expiry 
>   timestamp is optional.
> 
> - ```metadata``` Metadata can be included with the message which will
> then be included with any delivery
>   reports or replies matched to the message. This can be used to create powerful two-way messaging
>   applications without having to store persistent data in the application. Up to 10 key / value metadata data
>   pairs can be specified in a message. Each key can be up to 100 characters long, and each value up to 
>   256 characters long. Specifying metadata for a message is optional.
> 
> The response body of a successful POST request to the messages endpoint
> will include a ```messages``` property which contains a list of all messages submitted. The list of
> messages submitted will reflect the list of messages included in the request, but each message
> will also contain two new properties, ```message_id``` and ```status```. The returned message ID
> will be a 36 character UUID which can be used to check the status of the message via the Get Message
> Status endpoint. The status of the message which reflect the status of the message at submission
> time which will always be ```queued```. See the Delivery Reports section of this documentation for
> more information on message statues.
> 
> *Note: when sending multiple messages in a request, all messages must be valid for the request 
> to be successful. If any messages in the request are invalid, no messages will be sent.*
> 


```java
void createSendMessagesAsync(
        final Sendmessagesrequest body,
        final APICallBack<Sendmessagesresponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
try {
    String bodyValue = "{\"messages\":[{\"callback_url\":\"https://my.callback.url.com\",\"content\":\"My first message\",\"destination_number\":\"+61491570156\",\"delivery_report\":true,\"format\":\"SMS\",\"message_expiry_timestamp\":\"2016-11-03T11:49:02.807Z\",\"metadata\":{\"key1\":\"value1\",\"key2\":\"value2\"},\"scheduled\":\"2016-11-03T11:49:02.807Z\",\"source_number\":\"+61491570157\",\"source_number_type\":\"INTERNATIONAL\"},{\"callback_url\":\"https://my.callback.url.com\",\"content\":\"My second message\",\"destination_number\":\"+61491570158\",\"delivery_report\":true,\"format\":\"MMS\",\"subject\":\"This is an MMS message\",\"media\":[\"https://images.pexels.com/photos/1018350/pexels-photo-1018350.jpeg?cs=srgb&dl=architecture-buildings-city-1018350.jpg\"],\"message_expiry_timestamp\":\"2016-11-03T11:49:02.807Z\",\"metadata\":{\"key1\":\"value1\",\"key2\":\"value2\"},\"scheduled\":\"2016-11-03T11:49:02.807Z\",\"source_number\":\"+61491570159\",\"source_number_type\":\"INTERNATIONAL\"}]}";
    Sendmessagesrequest body = mapper.readValue(bodyValue,new TypeReference<Sendmessagesrequest> (){});
    // Invoking the API call with sample inputs
    messages.createSendMessagesAsync(body, new APICallBack<Sendmessagesresponse>() {
        public void onSuccess(HttpContext context, Sendmessagesresponse response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Unexpected error in API call. See HTTP response body for details. |
| 403 | Unauthorised |



[Back to List of Controllers](#list_of_controllers)

## <a name="delivery_reports_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.messagemedia.api.controllers.DeliveryReportsController") DeliveryReportsController

### Get singleton instance

The singleton instance of the ``` DeliveryReportsController ``` class can be accessed from the API Client.

```java
DeliveryReportsController deliveryReports = client.getDeliveryReports();
```

### <a name="get_check_delivery_reports_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.DeliveryReportsController.getCheckDeliveryReportsAsync") getCheckDeliveryReportsAsync

> Check for any delivery reports that have been received.
> Delivery reports are a notification of the change in status of a message as it is being processed.
> Each request to the check delivery reports endpoint will return any delivery reports received that
> have not yet been confirmed using the confirm delivery reports endpoint. A response from the check
> delivery reports endpoint will have the following structure:
> ```json
> {
>     "delivery_reports": [
>         {
>             "callback_url": "https://my.callback.url.com",
>             "delivery_report_id": "01e1fa0a-6e27-4945-9cdb-18644b4de043",
>             "source_number": "+61491570157",
>             "date_received": "2017-05-20T06:30:37.642Z",
>             "status": "enroute",
>             "delay": 0,
>             "submitted_date": "2017-05-20T06:30:37.639Z",
>             "original_text": "My first message!",
>             "message_id": "d781dcab-d9d8-4fb2-9e03-872f07ae94ba",
>             "vendor_account_id": {
>                 "vendor_id": "MessageMedia",
>                 "account_id": "MyAccount"
>             },
>             "metadata": {
>                 "key1": "value1",
>                 "key2": "value2"
>             }
>         },
>         {
>             "callback_url": "https://my.callback.url.com",
>             "delivery_report_id": "0edf9022-7ccc-43e6-acab-480e93e98c1b",
>             "source_number": "+61491570158",
>             "date_received": "2017-05-21T01:46:42.579Z",
>             "status": "enroute",
>             "delay": 0,
>             "submitted_date": "2017-05-21T01:46:42.574Z",
>             "original_text": "My second message!",
>             "message_id": "fbb3b3f5-b702-4d8b-ab44-65b2ee39a281",
>             "vendor_account_id": {
>                 "vendor_id": "MessageMedia",
>                 "account_id": "MyAccount"
>             },
>             "metadata": {
>                 "key1": "value1",
>                 "key2": "value2"
>             }
>         }
>     ]
> }
> ```
> Each delivery report will contain details about the message, including any metadata specified
> and the new status of the message (as each delivery report indicates a change in status of a
> message) and the timestamp at which the status changed. Every delivery report will have a 
> unique delivery report ID for use with the confirm delivery reports endpoint.
> *Note: The source number and destination number properties in a delivery report are the inverse of
> those specified in the message that the delivery report relates to. The source number of the
> delivery report is the destination number of the original message.*
> Subsequent requests to the check delivery reports endpoint will return the same delivery reports
> and a maximum of 100 delivery reports will be returned in each request. Applications should use the
> confirm delivery reports endpoint in the following pattern so that delivery reports that have been
> processed are no longer returned in subsequent check delivery reports requests.
> 1. Call check delivery reports endpoint
> 2. Process each delivery report
> 3. Confirm all processed delivery reports using the confirm delivery reports endpoint
> *Note: It is recommended to use the Webhooks feature to receive reply messages rather than
> polling the check delivery reports endpoint.*


```java
void getCheckDeliveryReportsAsync(final APICallBack<Checkdeliveryreportsresponse> callBack)
```

#### Example Usage

```java
// Invoking the API call with sample inputs
deliveryReports.getCheckDeliveryReportsAsync(new APICallBack<Checkdeliveryreportsresponse>() {
    public void onSuccess(HttpContext context, Checkdeliveryreportsresponse response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 403 | Unauthorised |
| 404 | Resource not found |



### <a name="create_confirm_delivery_reports_as_received_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.DeliveryReportsController.createConfirmDeliveryReportsAsReceivedAsync") createConfirmDeliveryReportsAsReceivedAsync

> Mark a delivery report as confirmed so it is no longer return in check delivery reports requests.
> The confirm delivery reports endpoint is intended to be used in conjunction with the check delivery
> reports endpoint to allow for robust processing of delivery reports. Once one or more delivery
> reports have been processed, they can then be confirmed using the confirm delivery reports endpoint so they
> are no longer returned in subsequent check delivery reports requests.
> The confirm delivery reports endpoint takes a list of delivery report IDs as follows:
> ```json
> {
>     "delivery_report_ids": [
>         "011dcead-6988-4ad6-a1c7-6b6c68ea628d",
>         "3487b3fa-6586-4979-a233-2d1b095c7718",
>         "ba28e94b-c83d-4759-98e7-ff9c7edb87a1"
>     ]
> }
> ```
> Up to 100 delivery reports can be confirmed in a single confirm delivery reports request.


```java
void createConfirmDeliveryReportsAsReceivedAsync(
        final Confirmeliveryreportsasreceivedrequest body,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | Delivery reports to confirm as received. |


#### Example Usage

```java
try {
    String bodyValue = "{\"delivery_report_ids\":[\"011dcead-6988-4ad6-a1c7-6b6c68ea628d\",\"3487b3fa-6586-4979-a233-2d1b095c7718\",\"ba28e94b-c83d-4759-98e7-ff9c7edb87a1\"]}";
    Confirmeliveryreportsasreceivedrequest body = mapper.readValue(bodyValue,new TypeReference<Confirmeliveryreportsasreceivedrequest> (){});
    // Invoking the API call with sample inputs
    deliveryReports.createConfirmDeliveryReportsAsReceivedAsync(body, new APICallBack<Object>() {
        public void onSuccess(HttpContext context, Object response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad request |
| 403 | Unauthorised |
| 404 | Resource not found |



[Back to List of Controllers](#list_of_controllers)

## <a name="replies_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.messagemedia.api.controllers.RepliesController") RepliesController

### Get singleton instance

The singleton instance of the ``` RepliesController ``` class can be accessed from the API Client.

```java
RepliesController replies = client.getReplies();
```

### <a name="get_check_replies_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.RepliesController.getCheckRepliesAsync") getCheckRepliesAsync

> Check for any replies that have been received.
> Replies are messages that have been sent from a handset in response to a message sent by an
> application or messages that have been sent from a handset to a inbound number associated with
> an account, known as a dedicated inbound number (contact <support@messagemedia.com> for more
> information on dedicated inbound numbers).
> Each request to the check replies endpoint will return any replies received that have not yet
> been confirmed using the confirm replies endpoint. A response from the check replies endpoint
> will have the following structure:
> ```json
> {
>     "replies": [
>         {
>             "metadata": {
>                 "key1": "value1",
>                 "key2": "value2"
>             },
>             "message_id": "877c19ef-fa2e-4cec-827a-e1df9b5509f7",
>             "reply_id": "a175e797-2b54-468b-9850-41a3eab32f74",
>             "date_received": "2016-12-07T08:43:00.850Z",
>             "callback_url": "https://my.callback.url.com",
>             "destination_number": "+61491570156",
>             "source_number": "+61491570157",
>             "vendor_account_id": {
>                 "vendor_id": "MessageMedia",
>                 "account_id": "MyAccount"
>             },
>             "content": "My first reply!"
>         },
>         {
>             "metadata": {
>                 "key1": "value1",
>                 "key2": "value2"
>             },
>             "message_id": "8f2f5927-2e16-4f1c-bd43-47dbe2a77ae4",
>             "reply_id": "3d8d53d8-01d3-45dd-8cfa-4dfc81600f7f",
>             "date_received": "2016-12-07T08:43:00.850Z",
>             "callback_url": "https://my.callback.url.com",
>             "destination_number": "+61491570157",
>             "source_number": "+61491570158",
>             "vendor_account_id": {
>                 "vendor_id": "MessageMedia",
>                 "account_id": "MyAccount"
>             },
>             "content": "My second reply!"
>         }
>     ]
> }
> ```
> Each reply will contain details about the reply message, as well as details of the message the reply was sent
> in response to, including any metadata specified. Every reply will have a reply ID to be used with the
> confirm replies endpoint.
> *Note: The source number and destination number properties in a reply are the inverse of those
> specified in the message the reply is in response to. The source number of the reply message is the
> same as the destination number of the original message, and the destination number of the reply
> message is the same as the source number of the original message. If a source number
> wasn't specified in the original message, then the destination number property will not be present
> in the reply message.*
> Subsequent requests to the check replies endpoint will return the same reply messages and a maximum
> of 100 replies will be returned in each request. Applications should use the confirm replies endpoint
> in the following pattern so that replies that have been processed are no longer returned in
> subsequent check replies requests.
> 1. Call check replies endpoint
> 2. Process each reply message
> 3. Confirm all processed reply messages using the confirm replies endpoint
> *Note: It is recommended to use the Webhooks feature to receive reply messages rather than polling
> the check replies endpoint.*


```java
void getCheckRepliesAsync(final APICallBack<Checkrepliesresponse> callBack)
```

#### Example Usage

```java
// Invoking the API call with sample inputs
replies.getCheckRepliesAsync(new APICallBack<Checkrepliesresponse>() {
    public void onSuccess(HttpContext context, Checkrepliesresponse response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 403 | Unauthorised |
| 404 | Resource not found |



### <a name="create_confirm_replies_as_received_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.RepliesController.createConfirmRepliesAsReceivedAsync") createConfirmRepliesAsReceivedAsync

> Mark a reply message as confirmed so it is no longer returned in check replies requests.
> The confirm replies endpoint is intended to be used in conjunction with the check replies endpoint
> to allow for robust processing of reply messages. Once one or more reply messages have been processed
> they can then be confirmed using the confirm replies endpoint so they are no longer returned in
> subsequent check replies requests.
> The confirm replies endpoint takes a list of reply IDs as follows:
> ```json
> {
>     "reply_ids": [
>         "011dcead-6988-4ad6-a1c7-6b6c68ea628d",
>         "3487b3fa-6586-4979-a233-2d1b095c7718",
>         "ba28e94b-c83d-4759-98e7-ff9c7edb87a1"
>     ]
> }
> ```
> Up to 100 replies can be confirmed in a single confirm replies request.


```java
void createConfirmRepliesAsReceivedAsync(
        final Confirmrepliesasreceivedrequest body,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
try {
    String bodyValue = "{\"reply_ids\":[\"011dcead-6988-4ad6-a1c7-6b6c68ea628d\",\"3487b3fa-6586-4979-a233-2d1b095c7718\",\"ba28e94b-c83d-4759-98e7-ff9c7edb87a1\"]}";
    Confirmrepliesasreceivedrequest body = mapper.readValue(bodyValue,new TypeReference<Confirmrepliesasreceivedrequest> (){});
    // Invoking the API call with sample inputs
    replies.createConfirmRepliesAsReceivedAsync(body, new APICallBack<Object>() {
        public void onSuccess(HttpContext context, Object response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad request |
| 403 | Unauthorised |
| 404 | Resource not found |



[Back to List of Controllers](#list_of_controllers)

## <a name="lookups_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.messagemedia.api.controllers.LookupsController") LookupsController

### Get singleton instance

The singleton instance of the ``` LookupsController ``` class can be accessed from the API Client.

```java
LookupsController lookups = client.getLookups();
```

### <a name="get_lookup_a_phone_number_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.LookupsController.getLookupAPhoneNumberAsync") getLookupAPhoneNumberAsync

> Use the Lookups API to find information about a phone number.
> 
> A request to the lookups API has the following format:
> 
> ```/v1/lookups/phone/{phone_number}?options={x}```
> 
> where `{x}` is an individual value or a combination of values. 
> 
> The `{phone_number}` parameter is a required field and should be set to the phone number to be looked up.
> 
> The options query parameter can also be used to request additional information about the phone number.
> 
> By default, a request will only return the `country_code` and `phone_number` properties in the response.
> 
> ```json
> {  "country_code": "AU", "phone_number": "+61491570156"}
> ```
> 
> To request details about the the carrier, include `carrier` as a value of the options parameter and to 
> request details about the type, include `type` as a value of the options parameter. The `carrier` and
> the `type` values can be used together using a comma separated list, i.e. `carrier,type`.
> 
> To request details about the location, include `hlr` as a value of the options parameter. 
> 
> NOTE: The `hlr` value CANNOT be used in conjuction with the other values.
> 
> A successful request to the lookups endpoint with `carrier` and `type` as values will 
> 
> return a response body as follows:
> 
> ```json
> {  
>   "country_code": "AU",
>   "phone_number": "+61491570156",
>   "type": "mobile",  "carrier": {"name": "Telstra"  }
> }
> ```
> 
> A successful request to the lookups endpoint with `hlr` as the value will return a response body as follows:
> 
> ```json
> {"result": "OK",    "imsi": 24008,    "location": 46}
> ```
> Each property in the response body is defined as follows:- ```country_code``` ISO ALPHA 2 country code of the phone number
> - ```phone_number``` E.164 formatted phone number
> - ```type``` The type of number. This can be ```"mobile"``` or ```"landline"```
> - ```carrier``` Holds information about the specific carrier (if available)  
> - ```name``` The carrier's name as reported by the network
> - `imsi` A unique number identifying a GSM subscriber
> - `location` The location of the mobile number"
> 


```java
void getLookupAPhoneNumberAsync(
        final String phoneNumber,
        final String options,
        final APICallBack<Lookupaphonenumberresponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| phoneNumber |  ``` Required ```  | The phone number to be looked up |
| options |  ``` Optional ```  | The options query parameter can also be used to request additional information about the phone number. |


#### Example Usage

```java
String phoneNumber = "phone_number";
String options = "options";
// Invoking the API call with sample inputs
lookups.getLookupAPhoneNumberAsync(phoneNumber, options, new APICallBack<Lookupaphonenumberresponse>() {
    public void onSuccess(HttpContext context, Lookupaphonenumberresponse response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad request |
| 403 | Unauthorised |
| 404 | Resource not found |



[Back to List of Controllers](#list_of_controllers)

## <a name="number_authorisation_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.messagemedia.api.controllers.NumberAuthorisationController") NumberAuthorisationController

### Get singleton instance

The singleton instance of the ``` NumberAuthorisationController ``` class can be accessed from the API Client.

```java
NumberAuthorisationController numberAuthorisation = client.getNumberAuthorisation();
```

### <a name="list_all_blocked_numbers_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.NumberAuthorisationController.listAllBlockedNumbersAsync") listAllBlockedNumbersAsync

> This endpoint returns a list of 100 numbers that are on the blacklist.  There is a pagination token to retrieve the next 100 numbers
> 
> In the example response the numbers `+61491570156` and `+61491570157` are on the blacklist and therefore will never receive any messages from you.


```java
void listAllBlockedNumbersAsync(final APICallBack<Getnumberauthorisationblacklistresponse> callBack)
```

#### Example Usage

```java
// Invoking the API call with sample inputs
numberAuthorisation.listAllBlockedNumbersAsync(new APICallBack<Getnumberauthorisationblacklistresponse>() {
    public void onSuccess(HttpContext context, Getnumberauthorisationblacklistresponse response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 403 | Unauthorised |



### <a name="add_one_or_more_numbers_to_your_backlist_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.NumberAuthorisationController.addOneOrMoreNumbersToYourBacklistAsync") addOneOrMoreNumbersToYourBacklistAsync

> This endpoint allows you to add one or more numbers to your blacklist. You can add up to 10 numbers in one request.
> NOTE: numbers need to be in international format and therefore start with a +


```java
void addOneOrMoreNumbersToYourBacklistAsync(
        final Addoneormorenumberstoyourbacklistrequest body,
        final APICallBack<Addoneormorenumberstoyourbacklistresponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
try {
    String bodyValue = "{\"numbers\":[\"+61491570156\",\"+61491570157\"]}";
    Addoneormorenumberstoyourbacklistrequest body = mapper.readValue(bodyValue,new TypeReference<Addoneormorenumberstoyourbacklistrequest> (){});
    // Invoking the API call with sample inputs
    numberAuthorisation.addOneOrMoreNumbersToYourBacklistAsync(body, new APICallBack<Addoneormorenumberstoyourbacklistresponse>() {
        public void onSuccess(HttpContext context, Addoneormorenumberstoyourbacklistresponse response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="remove_a_number_from_the_blacklist_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.NumberAuthorisationController.removeANumberFromTheBlacklistAsync") removeANumberFromTheBlacklistAsync

> This endpoint allows you to remove a number from the blacklist.  Only one number can be deleted per request.
> In the example +61491570157 will be removed from the blacklist.
> NOTE:  numbers need to be in international format and therefore start with a +


```java
void removeANumberFromTheBlacklistAsync(
        final String number,
        final APICallBack<InputStream> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| number |  ``` Required ```  | a number in international format e.g. ```+61491570156``` |


#### Example Usage

```java
String number = "number";
// Invoking the API call with sample inputs
numberAuthorisation.removeANumberFromTheBlacklistAsync(number, new APICallBack<InputStream>() {
    public void onSuccess(HttpContext context, InputStream response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 404 | TODO: Add an error description |



### <a name="get_check_if_one_or_several_numbers_are_currently_blacklisted_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.NumberAuthorisationController.getCheckIfOneOrSeveralNumbersAreCurrentlyBlacklistedAsync") getCheckIfOneOrSeveralNumbersAreCurrentlyBlacklistedAsync

> This endpoints lists for each requested number if you are authorised (which means the number is not blacklisted) to send to this number.
> In the example given +61491570157 is on the blacklist.
> NOTE: We do this call for you internally no matter what. Use this endpoint only if you want to have some indication upfront. If you send a message which is on the blacklist, we issue a delivery receipt with the appropriate status code.


```java
void getCheckIfOneOrSeveralNumbersAreCurrentlyBlacklistedAsync(
        final List<String> numbers,
        final APICallBack<Checkifoneorseveralnumbersarecurrentlyblacklistedresponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| numbers |  ``` Required ```  ``` Collection ```  | one or more numbers in international format seperate by a comma, e.g. ```+61491570156,+61491570157``` |


#### Example Usage

```java
List<String> numbers = new LinkedList<String>(Arrays.asList("numbers"));
// Invoking the API call with sample inputs
numberAuthorisation.getCheckIfOneOrSeveralNumbersAreCurrentlyBlacklistedAsync(numbers, new APICallBack<Checkifoneorseveralnumbersarecurrentlyblacklistedresponse>() {
    public void onSuccess(HttpContext context, Checkifoneorseveralnumbersarecurrentlyblacklistedresponse response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


[Back to List of Controllers](#list_of_controllers)

## <a name="dedicated_numbers_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.messagemedia.api.controllers.DedicatedNumbersController") DedicatedNumbersController

### Get singleton instance

The singleton instance of the ``` DedicatedNumbersController ``` class can be accessed from the API Client.

```java
DedicatedNumbersController dedicatedNumbers = client.getDedicatedNumbers();
```

### <a name="get_numbers_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.DedicatedNumbersController.getNumbersAsync") getNumbersAsync

> Get a list of available dedicated numbers, filtered by requirements.


```java
void getNumbersAsync(
        final String country,
        final String matching,
        final Integer pageSize,
        final ServiceTypesEnum serviceTypes,
        final String token,
        final APICallBack<NumbersListResponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| country |  ``` Optional ```  | ISO_3166 country code, 2 character code to filter available numbers by country |
| matching |  ``` Optional ```  | filters results by a pattern of digits contained within the number |
| pageSize |  ``` Optional ```  | number of results returned per page, default 50 |
| serviceTypes |  ``` Optional ```  | filter results to include numbers with certain capabilities |
| token |  ``` Optional ```  | In paginated data the original request will return with a "next_token" attribute. This token must be entered into subsequent call in the "token" query parameter to obtain the next set of records. |


#### Example Usage

```java
String country = "AU";
String matching = "223344";
String pageSizeValue = "3";
Integer pageSize = mapper.readValue(pageSizeValue,new TypeReference<Integer> (){});
ServiceTypesEnum serviceTypes = ServiceTypesEnum.fromString("SMS");
String token = "example";
// Invoking the API call with sample inputs
dedicatedNumbers.getNumbersAsync(country, matching, pageSize, serviceTypes, token, new APICallBack<NumbersListResponse>() {
    public void onSuccess(HttpContext context, NumbersListResponse response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 403 | Unexpected error in API call. See HTTP response body for details. |



### <a name="get_number_by_id_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.DedicatedNumbersController.getNumberByIdAsync") getNumberByIdAsync

> Get details about a specific dedicated number.


```java
void getNumberByIdAsync(
        final String id,
        final String accept,
        final APICallBack<Number> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| id |  ``` Required ```  | unique identifier |
| accept |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
String id = "id";
String accept = "Accept";
// Invoking the API call with sample inputs
dedicatedNumbers.getNumberByIdAsync(id, accept, new APICallBack<Number>() {
    public void onSuccess(HttpContext context, Number response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 403 | Unexpected error in API call. See HTTP response body for details. |
| 404 | Unexpected error in API call. See HTTP response body for details. |



### <a name="get_assignment_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.DedicatedNumbersController.getAssignmentAsync") getAssignmentAsync

> Use this endpoint to view details of the assignment including the label and metadata.


```java
void getAssignmentAsync(
        final String numberId,
        final String accept,
        final APICallBack<Assignment> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| numberId |  ``` Required ```  | unique identifier |
| accept |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
String numberId = "e2014bc7-5fed-4e27-bd8c-XXXXXXXXXXX";
String accept = "application/json;charset=UTF-8";
// Invoking the API call with sample inputs
dedicatedNumbers.getAssignmentAsync(numberId, accept, new APICallBack<Assignment>() {
    public void onSuccess(HttpContext context, Assignment response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 403 | Unexpected error in API call. See HTTP response body for details. |
| 404 | Unexpected error in API call. See HTTP response body for details. |



### <a name="create_assignment_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.DedicatedNumbersController.createAssignmentAsync") createAssignmentAsync

> Assign the specified number to the authenticated account. 
> Use the body of the request to specify a label or metadata 
> for this number assignment.
> 
> If you receive a *conflict* error then the number that you have selected is unavailable for assignment. 
> This means that the number is either already assigned to another account, 
> or has an available_after date in the future. Should this occur, perform 
> another search and select a different number.


```java
void createAssignmentAsync(
        final String numberId,
        final String accept,
        final CreateAssignmentrequest body,
        final APICallBack<Assignment> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| numberId |  ``` Required ```  | unique identifier |
| accept |  ``` Required ```  | TODO: Add a parameter description |
| body |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
try {
    String numberId = "e2014bc7-5fed-4e27-bd8c-XXXXXXXXXXX";
    String accept = "application/json;charset=UTF-8";
    String bodyValue = "{\"label\":\"ExampleLabel\",\"metadata\":{\"Key1\":\"value1\",\"Key2\":\"value2\"}}";
    CreateAssignmentrequest body = mapper.readValue(bodyValue,new TypeReference<CreateAssignmentrequest> (){});
    // Invoking the API call with sample inputs
    dedicatedNumbers.createAssignmentAsync(numberId, accept, body, new APICallBack<Assignment>() {
        public void onSuccess(HttpContext context, Assignment response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 403 | Unexpected error in API call. See HTTP response body for details. |
| 404 | Unexpected error in API call. See HTTP response body for details. |



### <a name="delete_assignment_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.DedicatedNumbersController.deleteAssignmentAsync") deleteAssignmentAsync

> Release the dedicated number from your account.


```java
void deleteAssignmentAsync(
        final String numberId,
        final String accept,
        final APICallBack<InputStream> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| numberId |  ``` Required ```  | unique identifier |
| accept |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
String numberId = "e2014bc7-5fed-4e27-bd8c-XXXXXXXXXXX";
String accept = "application/json;charset=UTF-8";
// Invoking the API call with sample inputs
dedicatedNumbers.deleteAssignmentAsync(numberId, accept, new APICallBack<InputStream>() {
    public void onSuccess(HttpContext context, InputStream response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 403 | Unexpected error in API call. See HTTP response body for details. |



### <a name="update_assignment_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.DedicatedNumbersController.updateAssignmentAsync") updateAssignmentAsync

> Retain the dedicated number assignment, and edit or add additional metadata or title information. You can exclude any data from the body of this request that you do not want updated.


```java
void updateAssignmentAsync(
        final String numberId,
        final String accept,
        final UpdateAssignmentrequest body,
        final APICallBack<Assignment> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| numberId |  ``` Required ```  | unique identifier |
| accept |  ``` Required ```  | TODO: Add a parameter description |
| body |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
try {
    String numberId = "e2014bc7-5fed-4e27-bd8c-XXXXXXXXXXX";
    String accept = "application/json;charset=UTF-8";
    String bodyValue = "{\"label\":\"ExampleLabel\",\"metadata\":{\"Key1\":\"value1\",\"Key2\":\"value2\"}}";
    UpdateAssignmentrequest body = mapper.readValue(bodyValue,new TypeReference<UpdateAssignmentrequest> (){});
    // Invoking the API call with sample inputs
    dedicatedNumbers.updateAssignmentAsync(numberId, accept, body, new APICallBack<Assignment>() {
        public void onSuccess(HttpContext context, Assignment response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 403 | Unexpected error in API call. See HTTP response body for details. |



### <a name="get_assigned_numbers_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.DedicatedNumbersController.getAssignedNumbersAsync") getAssignedNumbersAsync

> Get assigned numbers


```java
void getAssignedNumbersAsync(
        final String accept,
        final Integer pageSize,
        final String token,
        final String numberId,
        final String matching,
        final String country,
        final Type1Enum type,
        final ClassificationEnum classification,
        final ServiceTypesEnum serviceTypes,
        final String label,
        final SortByEnum sortBy,
        final SortDirectionEnum sortDirection,
        final APICallBack<AssignedNumberListResponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| accept |  ``` Required ```  | TODO: Add a parameter description |
| pageSize |  ``` Optional ```  | Number of results returned per page, default 50 |
| token |  ``` Optional ```  | In paginated data the original request will return with a "next_token" attribute. This token must be entered into subsequent call in the "token" query parameter to obtain the next set of records. |
| numberId |  ``` Optional ```  | Unique identifier of a specific number |
| matching |  ``` Optional ```  | Filters results by a pattern of digits contained within the number |
| country |  ``` Optional ```  | Filter results by ISO_3166 country code, 2 character code to filter available numbers by country |
| type |  ``` Optional ```  | Filter results by Number type |
| classification |  ``` Optional ```  | Filter results by Number Classification |
| serviceTypes |  ``` Optional ```  | Filter results by capabilities |
| label |  ``` Optional ```  | Filter results by a matching label |
| sortBy |  ``` Optional ```  | Sort results by property |
| sortDirection |  ``` Optional ```  | Sort direction |


#### Example Usage

```java
String accept = "Accept";
Integer pageSize = new Integer();
String token = "token";
String numberId = "number_id";
String matching = "matching";
String country = "country";
Type1Enum type = Type1Enum.fromString("MOBILE");
ClassificationEnum classification = ClassificationEnum.fromString("BRONZE");
ServiceTypesEnum serviceTypes = ServiceTypesEnum.fromString("SMS");
String label = "label";
SortByEnum sortBy = SortByEnum.fromString("ACCOUNT");
SortDirectionEnum sortDirection = SortDirectionEnum.fromString("ASCENDING");
// Invoking the API call with sample inputs
dedicatedNumbers.getAssignedNumbersAsync(accept, pageSize, token, numberId, matching, country, type, classification, serviceTypes, label, sortBy, sortDirection, new APICallBack<AssignedNumberListResponse>() {
    public void onSuccess(HttpContext context, AssignedNumberListResponse response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 403 | Unauthorised |



[Back to List of Controllers](#list_of_controllers)

## <a name="messaging_reports_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.messagemedia.api.controllers.MessagingReportsController") MessagingReportsController

### Get singleton instance

The singleton instance of the ``` MessagingReportsController ``` class can be accessed from the API Client.

```java
MessagingReportsController messagingReports = client.getMessagingReports();
```

### <a name="get_metadata_keys_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MessagingReportsController.getMetadataKeysAsync") getMetadataKeysAsync

> Returns a list of metadata keys


```java
void getMetadataKeysAsync(
        final MessageTypeEnum messageType,
        final String startDate,
        final String endDate,
        final List<String> accounts,
        final String timezone,
        final APICallBack<MetadataKeysResponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| messageType |  ``` Required ```  | Message type. Possible values are sent messages and received messages. |
| startDate |  ``` Required ```  | Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format |
| endDate |  ``` Required ```  | End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format |
| accounts |  ``` Optional ```  ``` Collection ```  | Filter results by a specific account. By default results

will be returned for the account associated with the authentication

credentials and all sub accounts. |
| timezone |  ``` Optional ```  | The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'. |


#### Example Usage

```java
MessageTypeEnum messageType = MessageTypeEnum.fromString("SENT_MESSAGES");
String startDate = "2017-02-10T13:30:00";
String endDate = "2017-02-12T13:30:00";
List<String> accounts = new LinkedList<String>(Arrays.asList("accounts"));
String timezone = "timezone";
// Invoking the API call with sample inputs
messagingReports.getMetadataKeysAsync(messageType, startDate, endDate, accounts, timezone, new APICallBack<MetadataKeysResponse>() {
    public void onSuccess(HttpContext context, MetadataKeysResponse response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request. Check the json response for more details on what went wrong. |



### <a name="get_async_reports_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MessagingReportsController.getAsyncReportsAsync") getAsyncReportsAsync

> Lists asynchronous reports.


```java
void getAsyncReportsAsync(
        final Double page,
        final Double pageSize,
        final APICallBack<GetAsyncReportsResponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| page |  ``` Optional ```  | Page number for paging through paginated result sets. |
| pageSize |  ``` Optional ```  | Number of results to return in a page for paginated result sets. |


#### Example Usage

```java
Double page = 227.055453505393;
Double pageSize = 227.055453505393;
// Invoking the API call with sample inputs
messagingReports.getAsyncReportsAsync(page, pageSize, new APICallBack<GetAsyncReportsResponse>() {
    public void onSuccess(HttpContext context, GetAsyncReportsResponse response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="get_async_report_by_id_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MessagingReportsController.getAsyncReportByIdAsync") getAsyncReportByIdAsync

> Gets a single asynchronous report.


```java
void getAsyncReportByIdAsync(
        final String reportId,
        final APICallBack<AsyncReport> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| reportId |  ``` Required ```  | Unique ID of the async report |


#### Example Usage

```java
String reportId = "report_id";
// Invoking the API call with sample inputs
messagingReports.getAsyncReportByIdAsync(reportId, new APICallBack<AsyncReport>() {
    public void onSuccess(HttpContext context, AsyncReport response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request. Check the json response for more details on what went wrong. |
| 404 | The requested report was not found. |



### <a name="get_async_report_data_by_id_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MessagingReportsController.getAsyncReportDataByIdAsync") getAsyncReportDataByIdAsync

> Gets the data of an asynchronous report.


```java
void getAsyncReportDataByIdAsync(
        final String reportId,
        final APICallBack<InputStream> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| reportId |  ``` Required ```  | Unique ID of the async report |


#### Example Usage

```java
String reportId = "report_id";
// Invoking the API call with sample inputs
messagingReports.getAsyncReportDataByIdAsync(reportId, new APICallBack<InputStream>() {
    public void onSuccess(HttpContext context, InputStream response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request. Check the json response for more details on what went wrong. |
| 404 | Report not found or not finished. |



### <a name="create_submit_received_messages_detail_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MessagingReportsController.createSubmitReceivedMessagesDetailAsync") createSubmitReceivedMessagesDetailAsync

> Submits a request to generate an async detail report


```java
void createSubmitReceivedMessagesDetailAsync(
        final Asyncreceivedmessagesdetailrequest body,
        final APICallBack<AsyncReportResponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
try {
    String bodyValue = "{\"end_date\":\"2017-02-10T13:30:00\",\"start_date\":\"2017-02-12T13:30:00\",\"period\":\"TODAY\",\"sort_by\":\"ACCOUNT\",\"sort_direction\":\"ASCENDING\",\"timezone\":\"Australia/Melbourne\",\"accounts\":[],\"delivery_options\":[{\"delivery_type\":\"EMAIL\",\"delivery_addresses\":[],\"delivery_format\":\"CSV\"}]}";
    Asyncreceivedmessagesdetailrequest body = mapper.readValue(bodyValue,new TypeReference<Asyncreceivedmessagesdetailrequest> (){});
    // Invoking the API call with sample inputs
    messagingReports.createSubmitReceivedMessagesDetailAsync(body, new APICallBack<AsyncReportResponse>() {
        public void onSuccess(HttpContext context, AsyncReportResponse response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request. Check the json response for more details on what went wrong. |



### <a name="get_received_messages_detail_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MessagingReportsController.getReceivedMessagesDetailAsync") getReceivedMessagesDetailAsync

> Returns a list message received


```java
void getReceivedMessagesDetailAsync(
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
        final APICallBack<ReceivedMessages> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| endDate |  ``` Required ```  | End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format. |
| startDate |  ``` Required ```  | Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format. |
| accounts |  ``` Optional ```  ``` Collection ```  | Filter results by a specific account. By default results

will be returned for the account associated with the authentication

credentials and all sub accounts. |
| action |  ``` Optional ```  | Filter results by the action that was invoked for this message. |
| destinationAddressCountry |  ``` Optional ```  | Filter results by destination address country. |
| destinationAddress |  ``` Optional ```  | Filter results by destination address. |
| messageFormat |  ``` Optional ```  | Filter results by message format. |
| metadataKey |  ``` Optional ```  | Filter results for messages that include a metadata key. |
| metadataValue |  ``` Optional ```  | Filter results for messages that include a metadata key containing this value. If this parameter is provided, the metadata_key parameter must also be provided. |
| page |  ``` Optional ```  | Page number for paging through paginated result sets. |
| pageSize |  ``` Optional ```  | Number of results to return in a page for paginated result sets. |
| sortBy |  ``` Optional ```  | Field to sort results set by |
| sortDirection |  ``` Optional ```  | Order to sort results by. |
| sourceAddressCountry |  ``` Optional ```  | Filter results by source address country. |
| sourceAddress |  ``` Optional ```  | Filter results by source address. |
| timezone |  ``` Optional ```  | The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'. |


#### Example Usage

```java
String endDate = "end_date";
String startDate = "start_date";
List<String> accounts = new LinkedList<String>(Arrays.asList("accounts"));
ActionEnum action = ActionEnum.fromString("MyAccount001");
String destinationAddressCountry = "destination_address_country";
String destinationAddress = "destination_address";
Format1Enum messageFormat = Format1Enum.fromString("MMS");
String metadataKey = "metadata_key";
String metadataValue = "metadata_value";
Double page = 227.055453505393;
Double pageSize = 227.055453505393;
SortByEnum sortBy = SortByEnum.fromString("ACCOUNT");
SortDirectionEnum sortDirection = SortDirectionEnum.fromString("ASCENDING");
String sourceAddressCountry = "source_address_country";
String sourceAddress = "source_address";
String timezone = "timezone";
// Invoking the API call with sample inputs
messagingReports.getReceivedMessagesDetailAsync(endDate, startDate, accounts, action, destinationAddressCountry, destinationAddress, messageFormat, metadataKey, metadataValue, page, pageSize, sortBy, sortDirection, sourceAddressCountry, sourceAddress, timezone, new APICallBack<ReceivedMessages>() {
    public void onSuccess(HttpContext context, ReceivedMessages response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request. Check the json response for more details on what went wrong. |



### <a name="create_submit_sent_messages_detail_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MessagingReportsController.createSubmitSentMessagesDetailAsync") createSubmitSentMessagesDetailAsync

> Submits a request to generate an async detail report


```java
void createSubmitSentMessagesDetailAsync(
        final Asyncsentmessagesdetailrequest body,
        final APICallBack<AsyncReportResponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
try {
    Asyncsentmessagesdetailrequest body = new Asyncsentmessagesdetailrequest();
    // Invoking the API call with sample inputs
    messagingReports.createSubmitSentMessagesDetailAsync(body, new APICallBack<AsyncReportResponse>() {
        public void onSuccess(HttpContext context, AsyncReportResponse response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request. Check the json response for more details on what went wrong. |



### <a name="get_sent_messages_detail_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MessagingReportsController.getSentMessagesDetailAsync") getSentMessagesDetailAsync

> Returns a list of message sent


```java
void getSentMessagesDetailAsync(
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
        final APICallBack<SentMessages> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| endDate |  ``` Required ```  | End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format. |
| startDate |  ``` Required ```  | Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format. |
| accounts |  ``` Optional ```  ``` Collection ```  | Filter results by a specific account. By default results

will be returned for the account associated with the authentication

credentials and all sub accounts. |
| deliveryReport |  ``` Optional ```  | Filter results by delivery report. |
| destinationAddressCountry |  ``` Optional ```  | Filter results by destination address country. |
| destinationAddress |  ``` Optional ```  | Filter results by destination address. |
| messageFormat |  ``` Optional ```  | Filter results by message format. |
| metadataKey |  ``` Optional ```  | Filter results for messages that include a metadata key. |
| metadataValue |  ``` Optional ```  | Filter results for messages that include a metadata key containing this value. If this parameter is provided, the metadata_key parameter must also be provided. |
| statusCode |  ``` Optional ```  | Filter results by message status code. |
| status |  ``` Optional ```  | Filter results by message status. Can't be combined with statuses. |
| statuses |  ``` Optional ```  | Filter results by message status. Can't be combined with status.{array} |
| page |  ``` Optional ```  | Page number for paging through paginated result sets. |
| pageSize |  ``` Optional ```  | Number of results to return in a page for paginated result sets. |
| sortBy |  ``` Optional ```  | Field to sort results set by |
| sortDirection |  ``` Optional ```  | Order to sort results by. |
| sourceAddressCountry |  ``` Optional ```  | Filter results by source address country. |
| sourceAddress |  ``` Optional ```  | Filter results by source address. |
| timezone |  ``` Optional ```  | The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'. |


#### Example Usage

```java
String endDate = "end_date";
String startDate = "start_date";
List<String> accounts = new LinkedList<String>(Arrays.asList("accounts"));
Boolean deliveryReport = true;
String destinationAddressCountry = "destination_address_country";
String destinationAddress = "destination_address";
Format1Enum messageFormat = Format1Enum.fromString("MMS");
String metadataKey = "metadata_key";
String metadataValue = "metadata_value";
String statusCode = "status_code";
Status1Enum status = Status1Enum.fromString("CANCELLED");
StatusesEnum statuses = StatusesEnum.fromString("CANCELLED");
Double page = 227.055453505393;
Double pageSize = 227.055453505393;
SortByEnum sortBy = SortByEnum.fromString("ACCOUNT");
SortDirectionEnum sortDirection = SortDirectionEnum.fromString("ASCENDING");
String sourceAddressCountry = "source_address_country";
String sourceAddress = "source_address";
String timezone = "timezone";
// Invoking the API call with sample inputs
messagingReports.getSentMessagesDetailAsync(endDate, startDate, accounts, deliveryReport, destinationAddressCountry, destinationAddress, messageFormat, metadataKey, metadataValue, statusCode, status, statuses, page, pageSize, sortBy, sortDirection, sourceAddressCountry, sourceAddress, timezone, new APICallBack<SentMessages>() {
    public void onSuccess(HttpContext context, SentMessages response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request. Check the json response for more details on what went wrong. |



### <a name="create_submit_received_messages_summary_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MessagingReportsController.createSubmitReceivedMessagesSummaryAsync") createSubmitReceivedMessagesSummaryAsync

> Submits a summarised report of received messages


```java
void createSubmitReceivedMessagesSummaryAsync(
        final Asyncreceivedmessagessummaryrequest body,
        final APICallBack<AsyncReportResponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
try {
    String bodyValue = "{\"end_date\":\"2017-02-10T13:30:00\",\"start_date\":\"2017-02-12T13:30:00\",\"summary_by\":\"COUNT\",\"summary_field\":\"MESSAGE_ID\",\"group_by\":[\"DAY\"],\"period\":\"THIS_WEEK\",\"timezone\":\"Australia/Melbourne\",\"accounts\":[],\"delivery_options\":[{\"delivery_type\":\"EMAIL\",\"delivery_addresses\":[],\"delivery_format\":\"CSV\"}]}";
    Asyncreceivedmessagessummaryrequest body = mapper.readValue(bodyValue,new TypeReference<Asyncreceivedmessagessummaryrequest> (){});
    // Invoking the API call with sample inputs
    messagingReports.createSubmitReceivedMessagesSummaryAsync(body, new APICallBack<AsyncReportResponse>() {
        public void onSuccess(HttpContext context, AsyncReportResponse response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request. Check the json response for more details on what went wrong. |
| 501 | The group_by combination is not currently implemented |



### <a name="get_received_messages_summary_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MessagingReportsController.getReceivedMessagesSummaryAsync") getReceivedMessagesSummaryAsync

> Returns a summarised report of messages received


```java
void getReceivedMessagesSummaryAsync(
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
        final APICallBack<SummaryReport> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| endDate |  ``` Required ```  | End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format. |
| startDate |  ``` Required ```  | Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format. |
| groupBy |  ``` Required ```  | List of fields to group results set by{array} |
| accounts |  ``` Optional ```  ``` Collection ```  | Filter results by a specific account. By default results

will be returned for the account associated with the authentication

credentials and all sub accounts. |
| destinationAddressCountry |  ``` Optional ```  | Filter results by destination address country. |
| destinationAddress |  ``` Optional ```  | Filter results by destination address. |
| messageFormat |  ``` Optional ```  | Filter results by message format. |
| metadataKey |  ``` Optional ```  | Filter results for messages that include a metadata key. |
| metadataValue |  ``` Optional ```  | Filter results for messages that include a metadata key containing this value. If this parameter is provided, the metadata_key parameter must also be provided. |
| summaryBy |  ``` Optional ```  | Function to apply when summarising results |
| summaryField |  ``` Optional ```  | Field to summarise results by |
| sourceAddressCountry |  ``` Optional ```  | Filter results by source address country. |
| sourceAddress |  ``` Optional ```  | Filter results by source address. |
| timezone |  ``` Optional ```  | The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'. |


#### Example Usage

```java
String endDate = "2017-02-10T13:30:00";
String startDate = "2017-02-12T13:30:00";
GroupByEnum groupBy = GroupByEnum.fromString("DAY");
List<String> accounts = new LinkedList<String>(Arrays.asList("accounts"));
String destinationAddressCountry = "destination_address_country";
String destinationAddress = "destination_address";
Format1Enum messageFormat = Format1Enum.fromString("MMS");
String metadataKey = "metadata_key";
String metadataValue = "metadata_value";
SummaryByEnum summaryBy = SummaryByEnum.fromString("COUNT");
SummaryFieldEnum summaryField = SummaryFieldEnum.fromString("UNITS");
String sourceAddressCountry = "source_address_country";
String sourceAddress = "source_address";
String timezone = "timezone";
// Invoking the API call with sample inputs
messagingReports.getReceivedMessagesSummaryAsync(endDate, startDate, groupBy, accounts, destinationAddressCountry, destinationAddress, messageFormat, metadataKey, metadataValue, summaryBy, summaryField, sourceAddressCountry, sourceAddress, timezone, new APICallBack<SummaryReport>() {
    public void onSuccess(HttpContext context, SummaryReport response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request. Check the json response for more details on what went wrong. |
| 501 | The group_by combination is not currently implemented |



### <a name="create_submit_sent_messages_summary_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MessagingReportsController.createSubmitSentMessagesSummaryAsync") createSubmitSentMessagesSummaryAsync

> Submits a summarised report of sent messages


```java
void createSubmitSentMessagesSummaryAsync(
        final Asyncsentmessagesrequest body,
        final APICallBack<AsyncReportResponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
try {
    String bodyValue = "{\"end_date\":\"2017-02-10T13:30:00\",\"start_date\":\"2017-02-12T13:30:00\",\"group_by\":[\"DAY\"],\"period\":\"YESTERDAY\",\"timezone\":\"Australia/Melbourne\",\"accounts\":[],\"delivery_options\":[{\"delivery_type\":\"EMAIL\",\"delivery_addresses\":[],\"delivery_format\":\"CSV\"}]}";
    Asyncsentmessagesrequest body = mapper.readValue(bodyValue,new TypeReference<Asyncsentmessagesrequest> (){});
    // Invoking the API call with sample inputs
    messagingReports.createSubmitSentMessagesSummaryAsync(body, new APICallBack<AsyncReportResponse>() {
        public void onSuccess(HttpContext context, AsyncReportResponse response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request. Check the json response for more details on what went wrong. |
| 501 | The group_by combination is not currently implemented |



### <a name="get_sent_messages_summary_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MessagingReportsController.getSentMessagesSummaryAsync") getSentMessagesSummaryAsync

> Returns a summarised report of messages sent


```java
void getSentMessagesSummaryAsync(
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
        final APICallBack<SummaryReport> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| endDate |  ``` Required ```  | End date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format. |
| startDate |  ``` Required ```  | Start date time for report window. By default, the timezone for this parameter will be taken from the account settings for the account associated with the credentials used to make the request, or the account included in the Account parameter. This can be overridden using the timezone parameter per request. The date must be in ISO8601 format. |
| groupBy |  ``` Required ```  | List of fields to group results set by{array} |
| accounts |  ``` Optional ```  ``` Collection ```  | Filter results by a specific account. By default results

will be returned for the account associated with the authentication

credentials and all sub accounts. |
| deliveryReport |  ``` Optional ```  | Filter results by delivery report. |
| destinationAddressCountry |  ``` Optional ```  | Filter results by destination address country. |
| destinationAddress |  ``` Optional ```  | Filter results by destination address. |
| summaryBy |  ``` Optional ```  | Function to apply when summarising results |
| summaryField |  ``` Optional ```  | Field to summarise results by |
| messageFormat |  ``` Optional ```  | Filter results by message format. |
| metadataKey |  ``` Optional ```  | Filter results for messages that include a metadata key. |
| metadataValue |  ``` Optional ```  | Filter results for messages that include a metadata key containing this value. If this parameter is provided, the metadata_key parameter must also be provided. |
| statusCode |  ``` Optional ```  | Filter results by message status code. |
| sourceAddressCountry |  ``` Optional ```  | Filter results by source address country. |
| sourceAddress |  ``` Optional ```  | Filter results by source address. |
| timezone |  ``` Optional ```  | The timezone to use for the context of the request. If provided this will be used as the timezone for the start date and end date parameters, and all datetime fields returns in the response. The timezone should be provided as a IANA (Internet Assigned Numbers Authority) time zone database zone name, i.e., 'Australia/Melbourne'. |


#### Example Usage

```java
String endDate = "2017-02-10T13:30:00";
String startDate = "2017-02-12T13:30:00";
GroupByEnum groupBy = GroupByEnum.fromString("DAY");
List<String> accounts = new LinkedList<String>(Arrays.asList("accounts"));
Boolean deliveryReport = true;
String destinationAddressCountry = "destination_address_country";
String destinationAddress = "destination_address";
SummaryByEnum summaryBy = SummaryByEnum.fromString("COUNT");
SummaryFieldEnum summaryField = SummaryFieldEnum.fromString("UNITS");
Format1Enum messageFormat = Format1Enum.fromString("MMS");
String metadataKey = "metadata_key";
String metadataValue = "metadata_value";
String statusCode = "status_code";
String sourceAddressCountry = "source_address_country";
String sourceAddress = "source_address";
String timezone = "timezone";
// Invoking the API call with sample inputs
messagingReports.getSentMessagesSummaryAsync(endDate, startDate, groupBy, accounts, deliveryReport, destinationAddressCountry, destinationAddress, summaryBy, summaryField, messageFormat, metadataKey, metadataValue, statusCode, sourceAddressCountry, sourceAddress, timezone, new APICallBack<SummaryReport>() {
    public void onSuccess(HttpContext context, SummaryReport response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request. Check the json response for more details on what went wrong. |
| 501 | The group_by combination is not currently implemented |



[Back to List of Controllers](#list_of_controllers)

## <a name="short_trackable_links_reports_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.messagemedia.api.controllers.ShortTrackableLinksReportsController") ShortTrackableLinksReportsController

### Get singleton instance

The singleton instance of the ``` ShortTrackableLinksReportsController ``` class can be accessed from the API Client.

```java
ShortTrackableLinksReportsController shortTrackableLinksReports = client.getShortTrackableLinksReports();
```

### <a name="get_log_summary_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.ShortTrackableLinksReportsController.getLogSummaryAsync") getLogSummaryAsync

> Clicks summary report for metadata key value pair, long url and short url.


```java
void getLogSummaryAsync(
        final String key,
        final String value,
        final String url,
        final String recipient,
        final Double page,
        final Double pageSize,
        final APICallBack<LogSummaryResult> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| key |  ``` Optional ```  | TODO: Add a parameter description |
| value |  ``` Optional ```  | TODO: Add a parameter description |
| url |  ``` Optional ```  | TODO: Add a parameter description |
| recipient |  ``` Optional ```  | TODO: Add a parameter description |
| page |  ``` Optional ```  | TODO: Add a parameter description |
| pageSize |  ``` Optional ```  | TODO: Add a parameter description |


#### Example Usage

```java
String key = "key";
String value = "value";
String url = "url";
String recipient = "recipient";
Double page = 227.055453505393;
Double pageSize = 227.055453505393;
// Invoking the API call with sample inputs
shortTrackableLinksReports.getLogSummaryAsync(key, value, url, recipient, page, pageSize, new APICallBack<LogSummaryResult>() {
    public void onSuccess(HttpContext context, LogSummaryResult response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request. Invalid data provided |
| 404 | Data cannot be found |
| 500 | System Error |



### <a name="get_log_detail_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.ShortTrackableLinksReportsController.getLogDetailAsync") getLogDetailAsync

> Detailed clicks report for a hashcode.


```java
void getLogDetailAsync(
        final String hash,
        final Double page,
        final Double pageSize,
        final APICallBack<LogsDetailResult> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| hash |  ``` Required ```  | TODO: Add a parameter description |
| page |  ``` Optional ```  | TODO: Add a parameter description |
| pageSize |  ``` Optional ```  | TODO: Add a parameter description |


#### Example Usage

```java
String hash = "hash";
Double page = 227.055453505393;
Double pageSize = 227.055453505393;
// Invoking the API call with sample inputs
shortTrackableLinksReports.getLogDetailAsync(hash, page, pageSize, new APICallBack<LogsDetailResult>() {
    public void onSuccess(HttpContext context, LogsDetailResult response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Bad Request. Invalid data provided |
| 404 | Data cannot be found |
| 500 | System Error |



[Back to List of Controllers](#list_of_controllers)

## <a name="webhooks_management_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.messagemedia.api.controllers.WebhooksManagementController") WebhooksManagementController

### Get singleton instance

The singleton instance of the ``` WebhooksManagementController ``` class can be accessed from the API Client.

```java
WebhooksManagementController webhooksManagement = client.getWebhooksManagement();
```

### <a name="retrieve_webhook_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.WebhooksManagementController.retrieveWebhookAsync") retrieveWebhookAsync

> Retrieve all the webhooks created for the connected account.
> A successful request to the retrieve webhook endpoint will return a response body as follows:
> 
> ```
> {
>     "page": 0,
>     "pageSize": 100,
>     "pageData": [
>         {
>             "url": "https://webhook.com",
>             "method": "POST",
>             "id": "8805c9d8-bef7-41c7-906a-69ede93aa024",
>             "encoding": "JSON",
>             "events": [
>                 "RECEIVED_SMS"
>             ],
>             "headers": {},
>             "template": "{\"id\":\"$mtId\", \"status\":\"$statusCode\"}"
>         }
>     ]
> }
> ```
> 
> *Note: Response 400 is returned when the `page` query parameter is not valid or the `pageSize` query parameter is not valid.*


```java
void retrieveWebhookAsync(
        final Integer page,
        final Integer pageSize,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| page |  ``` Optional ```  | TODO: Add a parameter description |
| pageSize |  ``` Optional ```  | TODO: Add a parameter description |


#### Example Usage

```java
Integer page = new Integer();
Integer pageSize = new Integer();
// Invoking the API call with sample inputs
webhooksManagement.retrieveWebhookAsync(page, pageSize, new APICallBack<Object>() {
    public void onSuccess(HttpContext context, Object response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Unexpected error in API call. See HTTP response body for details. |



### <a name="create_webhook_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.WebhooksManagementController.createWebhookAsync") createWebhookAsync

> Create a webhook for one or more of the specified events.
> 
> A webhook would typically have the following structure:
> 
> ```
> { 
>   "url": "http://webhook.com",
>   "method": "POST",
>   "encoding": "JSON",  
>   "headers": {"Account": "DeveloperPortal7000"  },  
>   "events": ["RECEIVED_SMS"  ],
>   "template": {
>     "id":"$mtId",
>     "status":"$statusCode"}
>   }
> 
> ```
> 
> A valid webhook must consist of the following properties:
> 
> - ```url``` The configured URL which will trigger the webhook when a selected event occurs.
> 
> - ```method``` The methods to map CRUD (create, retrieve, update, delete) operations to HTTP requests.
> 
> - ```encoding``` Webhooks can be delivered using different content types. You can choose from ```JSON```, ```FORM_ENCODED``` or ```XML```. This will automatically add the Content-Type header for you so you don't have to add it again in the `headers` property.
> 
> - ```headers``` HTTP header fields which provide required information about the request or response, or about the object sent in the message body. This should NOT include the `Content-Type` header.
> 
> - ```events``` Event or events that will trigger the webhook. Atleast one event should be present.
> 
> - ```template``` The structure of the payload that will be returned. You can format this in JSON or XML.
> 
> #### Types of Events
> 
> You can select all of the events (listed below) or combine them in whatever way you like but atleast one event must be used. Otherwise, the webhook won't be created.
> 
> A webhook will be triggered when any one or more of the events occur:
> 
> + **SMS** 
>   + `RECEIVED_SMS` Receive an SMS
>   + `OPT_OUT_SMS` Opt-out occured
> + **MMS**
>   + `RECEIVED_MMS` Receive an MMS
> + **DR (Delivery Reports)**
>   + `ENROUTE_DR` Message is enroute
>   + `EXPIRED_DR` Message has expired
>   + `REJECTED_DR` Message is rejected
>   + `FAILED_DR` Message has failed
>   + `DELIVERED_DR` Message is delivered
>   + `SUBMITTED_DR` Message is submitted
> 
> #### Template Parameters
> 
> You can choose what to include in the data that will be sent as the payload via the Webhook. It's upto you to choose what format you would like the payload to be returned. You can choose between JSON or XML.
> 
> Keep in my mind, if you've chosen JSON as the format, you must escape the JSON in the template value (see example above).
> 
> The table illustrates a list of all the parameters that can be included in the template and which event types it can be applied to.
> 
> | Data  | Parameter Name | Example | Event Type |
> |:--|--|--|--:|
> | **Service Type**  | $type| `SMS` | `DR` `MO` `MO MMS` |
> | **Message ID**  | $mtId, $messageId| `877c19ef-fa2e-4cec-827a-e1df9b5509f7` | `DR` `MO` `MO MMS`|
> | **Delivery Report ID** |$drId, $reportId| `01e1fa0a-6e27-4945-9cdb-18644b4de043` | `DR` |
> | **Reply ID**| $moId, $replyId| `a175e797-2b54-468b-9850-41a3eab32f74` | `MO` `MO MMS` |
> | **Account ID**  | $accountId| `DeveloperPortal7000` | `DR` `MO` `MO MMS` |
> | **Message Timestamp**  | $submittedTimestamp| `2016-12-07T08:43:00.850Z` | `DR` `MO` `MO MMS` |
> | **Provider Timestamp**  | $receivedTimestamp| `2016-12-07T08:44:00.850Z` | `DR` `MO` `MO MMS` |
> | **Message Status** | $status| `enroute` | `DR` |\n| **Status Code**  | $statusCode| `200` | `DR` |
> | **External Metadata** | $metadata.get('key')| `name` | `DR` `MO` `MO MMS` |
> | **Source Address**| $sourceAddress| `+61491570156` | `DR` `MO` `MO MMS` |
> | **Destination Address**| $destinationAddress| `+61491593156` | `MO` `MO MMS` |
> | **Message Content**| $mtContent, $messageContent| `Hi Derp` | `DR` `MO` `MO MMS` |
> | **Reply Content**| $moContent, $replyContent| `Hello Derpina` | `MO` `MO MMS` |
> | **Retry Count**| $retryCount| `1` | `DR` `MO` `MO MMS` |
> 
> *Note: A 400 response will be returned if the `url` is invalid, the `events`, `encoding` or `method` is null or the `headers` has a Content-Type  attribute.*
> 


```java
void createWebhookAsync(
        final CreateWebhookrequest body,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
try {
    String bodyValue = "{\"url\":\"http://webhook.com\",\"method\":\"POST\",\"encoding\":\"JSON\",\"headers\":{\"Account\":\"DeveloperPortal7000\"},\"events\":[\"ENROUTE_DR\",\"DELIVERED_DR\"],\"template\":\"{\\\"id\\\":\\\"$mtId\\\",\\\"status\\\":\\\"$statusCode\\\"}\"}";
    CreateWebhookrequest body = mapper.readValue(bodyValue,new TypeReference<CreateWebhookrequest> (){});
    // Invoking the API call with sample inputs
    webhooksManagement.createWebhookAsync(body, new APICallBack<Object>() {
        public void onSuccess(HttpContext context, Object response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Unexpected error in API call. See HTTP response body for details. |
| 409 | Unexpected error in API call. See HTTP response body for details. |



### <a name="delete_webhook_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.WebhooksManagementController.deleteWebhookAsync") deleteWebhookAsync

> Delete a webhook that was previously created for the connected account.
> A webhook can be cancelled by appending the UUID of the webhook to the endpoint and submitting a DELETE request to the /webhooks/messages endpoint.
> 
> A successful request to the retrieve webhook endpoint will return a null response.
> 
> *Note: Only pre-created webhooks can be deleted. If an invalid or non existent webhook ID parameter is specified in the request, then a HTTP 404 Not Found response will be returned.*


```java
void deleteWebhookAsync(
        final UUID webhookId,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| webhookId |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
UUID webhookId = a7f11bb0-f299-4861-a5ca-9b29d04bc5ad;
// Invoking the API call with sample inputs
webhooksManagement.deleteWebhookAsync(webhookId, new APICallBack<void>() {
    public void onSuccess(HttpContext context, void response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 404 | TODO: Add an error description |



### <a name="update_webhook_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.WebhooksManagementController.updateWebhookAsync") updateWebhookAsync

> Update a webhook. You can update individual attributes or all of them by submitting a PATCH request to the /webhooks/messages endpoint (the same endpoint used above to delete a webhook)
> 
> A successful request to the retrieve webhook endpoint will return a response body as follows:
> 
> ```
> {
>     "url": "https://webhook.com",
>     "method": "POST",
>     "id": "04442623-0961-464e-9cbc-ec50804e0413",
>     "encoding": "JSON",
>     "events": [
>         "RECEIVED_SMS"
>     ],
>     "headers": {},
>     "template": "{\"id\":\"$mtId\", \"status\":\"$statusCode\"}"
> }
> ```
> 
> *Note: Only pre-created webhooks can be deleted. If an invalid or non existent webhook ID parameter is specified in the request, then a HTTP 404 Not Found response will be returned.*


```java
void updateWebhookAsync(
        final UUID webhookId,
        final UpdateWebhookrequest body,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| webhookId |  ``` Required ```  | TODO: Add a parameter description |
| body |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
try {
    UUID webhookId = a7f11bb0-f299-4861-a5ca-9b29d04bc5ad;
    String bodyValue = "{\"url\":\"https://myurl.com\",\"method\":\"POST\",\"encoding\":\"FORM_ENCODED\",\"events\":[\"ENROUTE_DR\"],\"template\":\"{\\\"id\\\":\\\"$mtId\\\", \\\"status\\\":\\\"$statusCode\\\"}\"}";
    UpdateWebhookrequest body = mapper.readValue(bodyValue,new TypeReference<UpdateWebhookrequest> (){});
    // Invoking the API call with sample inputs
    webhooksManagement.updateWebhookAsync(webhookId, body, new APICallBack<Object>() {
        public void onSuccess(HttpContext context, Object response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Unexpected error in API call. See HTTP response body for details. |
| 404 | TODO: Add an error description |



[Back to List of Controllers](#list_of_controllers)

## <a name="signature_key_management_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.messagemedia.api.controllers.SignatureKeyManagementController") SignatureKeyManagementController

### Get singleton instance

The singleton instance of the ``` SignatureKeyManagementController ``` class can be accessed from the API Client.

```java
SignatureKeyManagementController signatureKeyManagement = client.getSignatureKeyManagement();
```

### <a name="get_signature_key_list_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.SignatureKeyManagementController.getSignatureKeyListAsync") getSignatureKeyListAsync

> Retrieve the paginated list of signature keys.
> 
> A successful request for the ```get signature key list``` endpoint will return a response body as follows:
> 
> ```json
> [
>   {
>     "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31",
>     "cipher": "RSA",
>     "digest": "SHA224",
>     "created": "2018-01-18T10:16:12.364Z",
>     "enabled": false
>   }
> ]
> ```


```java
void getSignatureKeyListAsync(
        final String page,
        final String pageSize,
        final APICallBack<List<Getsignaturekeylistresponse>> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| page |  ``` Required ```  | TODO: Add a parameter description |
| pageSize |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
String page = "page";
String pageSize = "page_size";
// Invoking the API call with sample inputs
signatureKeyManagement.getSignatureKeyListAsync(page, pageSize, new APICallBack<List<Getsignaturekeylistresponse>>() {
    public void onSuccess(HttpContext context, List<Getsignaturekeylistresponse> response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Unexpected error in API call. See HTTP response body for details. |
| 403 | Unexpected error in API call. See HTTP response body for details. |



### <a name="create_signature_key_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.SignatureKeyManagementController.createSignatureKeyAsync") createSignatureKeyAsync

> This will create a key pair:
> 
> - The ```private key``` stored in MessageMedia is used to create the signature.
> 
> - The ```public key``` is returned and stored at your side to verify the signature in callbacks.
> 
> You need to enable your signature key after creating.
> 
> The most basic body has the following structure:
> 
> ```json
> {
>     "digest": "SHA224",
>     "cipher": "RSA"
> }
> ```
> 
> - ```digest``` is used to hash the message. The valid values for digest type are: SHA224, SHA256, SHA512
> 
> - ```cipher``` is used to encrypt the hashed message. The valid value for cipher type is: RSA
> 
> A successful request for the ```create signature key``` endpoint will return a response body as follows:
> 
> ```json
> {
>     "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31",
>     "public_key": "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCTIxtRyT5CuOD74r7UCT+AKzWNxvaAP9myjAqR7+vBnJKEvoPnmbKTnm6uLlxutnMbjKrnCCWnQ9vtBVnnd+ElhwLDPADfMcJoOqwi7mTcxucckeEbBsfsgYRfdacxgSZL8hVD1hLViQr3xwjEIkJcx1w3x8npvwMuTY0uW8+PjwIDAQAB",
>     "cipher": "RSA",
>     "digest": "SHA224",
>     "created": "2018-01-18T10:16:12.364Z",
>     "enabled": false
> }
> ```
> 
> The response body of a successful POST request to the ```create signature key``` endpoint will contain six properties:
> 
> - ```key_id``` will be a 36 character UUID which can be used to enable, delete or get the details.
> 
> - ```public_key``` is used to decrypt the signature.
> 
> - ```cipher``` same as cipher in request body.
> 
> - ```digest``` same as digest in request body.
> 
> - ```created``` is the created date.
> 
> - ```enabled``` is false for the new signature key. You can use the ```enable signature key``` endpoint to set this field to true.


```java
void createSignatureKeyAsync(
        final String accept,
        final Createsignaturekeyrequest body,
        final APICallBack<Createsignaturekeyresponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| accept |  ``` Required ```  | TODO: Add a parameter description |
| body |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
try {
    String accept = "application/json";
    String bodyValue = "{\"digest\":\"SHA224\",\"cipher\":\"RSA\"}";
    Createsignaturekeyrequest body = mapper.readValue(bodyValue,new TypeReference<Createsignaturekeyrequest> (){});
    // Invoking the API call with sample inputs
    signatureKeyManagement.createSignatureKeyAsync(accept, body, new APICallBack<Createsignaturekeyresponse>() {
        public void onSuccess(HttpContext context, Createsignaturekeyresponse response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Unexpected error in API call. See HTTP response body for details. |
| 403 | Unexpected error in API call. See HTTP response body for details. |



### <a name="get_signature_key_detail_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.SignatureKeyManagementController.getSignatureKeyDetailAsync") getSignatureKeyDetailAsync

> Retrieve the current detail of a signature key using the key_id returned in the ```create signature key``` endpoint.
> 
> A successful request for the ```get signature key detail``` endpoint will return a response body as follows:
> 
> ```json
> {
>     "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31",
>     "cipher": "RSA",
>     "digest": "SHA224",
>     "created": "2018-01-18T10:16:12.364Z",
>     "enabled": false
> }
> ```
> 
> *Note: If an invalid or non-existent key_id parameter is specified in the request, then an HTTP 404 Not Found response will be returned*


```java
void getSignatureKeyDetailAsync(
        final String keyId,
        final APICallBack<Getsignaturekeydetailresponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| keyId |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
String keyId = "key_id";
// Invoking the API call with sample inputs
signatureKeyManagement.getSignatureKeyDetailAsync(keyId, new APICallBack<Getsignaturekeydetailresponse>() {
    public void onSuccess(HttpContext context, Getsignaturekeydetailresponse response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Unexpected error in API call. See HTTP response body for details. |
| 403 | Unexpected error in API call. See HTTP response body for details. |
| 404 | Unexpected error in API call. See HTTP response body for details. |



### <a name="delete_signature_key_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.SignatureKeyManagementController.deleteSignatureKeyAsync") deleteSignatureKeyAsync

> Delete a signature key using the key_id returned in the ```create signature key``` endpoint.
> 
> A successful request for the ```delete signature key``` endpoint will return an empty response body.
> 
> *Note: If an invalid or non-existent key_id parameter is specified in the request, then an HTTP 404 Not Found response will be returned*


```java
void deleteSignatureKeyAsync(
        final String keyId,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| keyId |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
String keyId = "key_id";
// Invoking the API call with sample inputs
signatureKeyManagement.deleteSignatureKeyAsync(keyId, new APICallBack<void>() {
    public void onSuccess(HttpContext context, void response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 403 | Unexpected error in API call. See HTTP response body for details. |
| 404 | Unexpected error in API call. See HTTP response body for details. |



### <a name="update_enable_signature_key_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.SignatureKeyManagementController.updateEnableSignatureKeyAsync") updateEnableSignatureKeyAsync

> Enable a signature key using the key_id returned in the ```create signature key``` endpoint.
> There is only one signature key is enabled at the one moment in time. So if you enable the new signature key, the old one will be disabled.
> 
> The most basic body has the following structure:
> 
> ```json
> {
>     "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31"
> }
> ```
> 
> The response body of a successful PATCH request to ```enable signature key``` endpoint will contain the ```enabled``` properties with the value is true as follows:
> 
> ```json
> {
>     "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31",
>     "cipher": "RSA",
>     "digest": "SHA224",
>     "created": "2018-01-18T10:16:12.364Z",
>     "enabled": true
> }
> ```
> 
> *Note: If an invalid or non-existent key_id parameter is specified in the request, then an HTTP 404 Not Found response will be returned*


```java
void updateEnableSignatureKeyAsync(
        final String accept,
        final Enablesignaturekeyrequest body,
        final APICallBack<Enablesignaturekeyresponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| accept |  ``` Required ```  | TODO: Add a parameter description |
| body |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
try {
    String accept = "application/json";
    String bodyValue = "{\"key_id\":\"7ca628a8-08b0-4e42-aeb8-960b37049c31\"}";
    Enablesignaturekeyrequest body = mapper.readValue(bodyValue,new TypeReference<Enablesignaturekeyrequest> (){});
    // Invoking the API call with sample inputs
    signatureKeyManagement.updateEnableSignatureKeyAsync(accept, body, new APICallBack<Enablesignaturekeyresponse>() {
        public void onSuccess(HttpContext context, Enablesignaturekeyresponse response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | Unexpected error in API call. See HTTP response body for details. |
| 403 | Unexpected error in API call. See HTTP response body for details. |
| 404 | Unexpected error in API call. See HTTP response body for details. |



### <a name="get_enabled_signature_key_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.SignatureKeyManagementController.getEnabledSignatureKeyAsync") getEnabledSignatureKeyAsync

> Retrieve the currently enabled signature key.
> 
> A successful request for the ```get enabled signature key``` endpoint will return a response body as follows:
> 
> ```json
> {
>     "key_id": "7ca628a8-08b0-4e42-aeb8-960b37049c31",
>     "cipher": "RSA",
>     "digest": "SHA224",
>     "created": "2018-01-18T10:16:12.364Z",
>     "enabled": true
> }
> ```
> 
> *Note: If there is no enabled signature key, then an HTTP 404 Not Found response will be returned*


```java
void getEnabledSignatureKeyAsync(final APICallBack<Getenabledsignaturekeyresponse> callBack)
```

#### Example Usage

```java
// Invoking the API call with sample inputs
signatureKeyManagement.getEnabledSignatureKeyAsync(new APICallBack<Getenabledsignaturekeyresponse>() {
    public void onSuccess(HttpContext context, Getenabledsignaturekeyresponse response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 403 | Unexpected error in API call. See HTTP response body for details. |
| 404 | Unexpected error in API call. See HTTP response body for details. |



### <a name="delete_disable_the_current_enabled_signature_key_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.SignatureKeyManagementController.deleteDisableTheCurrentEnabledSignatureKeyAsync") deleteDisableTheCurrentEnabledSignatureKeyAsync

> Disable the current enabled signature key.
> 
> A successful request for the ```disable the current enabled signature key.``` endpoint will return no content when successful.
> If there is an enabled key, it will be disabled; and the 204 status code is returned.
> If there is no key or no enabled key, the 204 status code is also returned.


```java
void deleteDisableTheCurrentEnabledSignatureKeyAsync(final APICallBack<Object> callBack)
```

#### Example Usage

```java
// Invoking the API call with sample inputs
signatureKeyManagement.deleteDisableTheCurrentEnabledSignatureKeyAsync(new APICallBack<void>() {
    public void onSuccess(HttpContext context, void response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 403 | Unexpected error in API call. See HTTP response body for details. |



[Back to List of Controllers](#list_of_controllers)

## <a name="mobile_landing_pages_beta_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.messagemedia.api.controllers.MobileLandingPagesBetaController") MobileLandingPagesBetaController

### Get singleton instance

The singleton instance of the ``` MobileLandingPagesBetaController ``` class can be accessed from the API Client.

```java
MobileLandingPagesBetaController mobileLandingPagesBeta = client.getMobileLandingPagesBeta();
```

### <a name="create_new_campaign_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MobileLandingPagesBetaController.createNewCampaignAsync") createNewCampaignAsync

> Mobile Landing Pages Campaigns belonging to the user.Create a new campaign.


```java
void createNewCampaignAsync(
        final Campaign body,
        final APICallBack<CreateNewCampaignresponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
try {
    Campaign body = new Campaign();
    // Invoking the API call with sample inputs
    mobileLandingPagesBeta.createNewCampaignAsync(body, new APICallBack<CreateNewCampaignresponse>() {
        public void onSuccess(HttpContext context, CreateNewCampaignresponse response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | TODO: Add an error description |
| 402 | TODO: Add an error description |



### <a name="get_campaign_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MobileLandingPagesBetaController.getCampaignAsync") getCampaignAsync

> A single campaign, identified by a unique identifier.Returns the details of a single campaign.


```java
void getCampaignAsync(
        final String id,
        final APICallBack<GetCampaignresponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| id |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
String id = "id";
// Invoking the API call with sample inputs
mobileLandingPagesBeta.getCampaignAsync(id, new APICallBack<GetCampaignresponse>() {
    public void onSuccess(HttpContext context, GetCampaignresponse response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="create_send_campaign_to_recipients_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MobileLandingPagesBetaController.createSendCampaignToRecipientsAsync") createSendCampaignToRecipientsAsync

> Sends a campaign message to a group of recipients.


```java
void createSendCampaignToRecipientsAsync(
        final String id,
        final SendCampaignToRecipientsrequest body,
        final APICallBack<SendCampaignToRecipientsresponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| id |  ``` Required ```  | TODO: Add a parameter description |
| body |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
try {
    String id = "id";
    SendCampaignToRecipientsrequest body = new SendCampaignToRecipientsrequest();
    // Invoking the API call with sample inputs
    mobileLandingPagesBeta.createSendCampaignToRecipientsAsync(id, body, new APICallBack<SendCampaignToRecipientsresponse>() {
        public void onSuccess(HttpContext context, SendCampaignToRecipientsresponse response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="createa_landing_page_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MobileLandingPagesBetaController.createaLandingPageAsync") createaLandingPageAsync

> The Landing Page datastore makes it easier to create Campiangs based on the saved data.Create a Landing Page.


```java
void createaLandingPageAsync(
        final CreateLandingPage body,
        final APICallBack<CreateaLandingPageresponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| body |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
try {
    String bodyValue = "{\"name\":\" My Landing Page\",\"template_id\":\"ac895f01-3149-4bf8-a8fe-01d3b8a9ba97\",\"parameters\":{\"pageTitle\":\"The page title\",\"pageText\":\"The body text\",\"imageUrl\":\"https://example.com/image.jpg\"},\"fields\":{\"title\":{\"type\":\"TEXT\"},\"bodyText\":{\"type\":\"TEXT\"},\"ctaUrl\":{\"type\":\"URL\"}}}";
    CreateLandingPage body = mapper.readValue(bodyValue,new TypeReference<CreateLandingPage> (){});
    // Invoking the API call with sample inputs
    mobileLandingPagesBeta.createaLandingPageAsync(body, new APICallBack<CreateaLandingPageresponse>() {
        public void onSuccess(HttpContext context, CreateaLandingPageresponse response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | TODO: Add an error description |
| 402 | TODO: Add an error description |



### <a name="get_landing_pages_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MobileLandingPagesBetaController.getLandingPagesAsync") getLandingPagesAsync

> The Landing Page datastore makes it easier to create Campiangs based on the saved data.Returns a paginated list of Landing Pages for your account. ```sort_by``` and ```sort_direction``` must both be specified or neither at all (the default sort options are ```DESCENDING``` ```MODIFIED_TIMESTAMP```).


```java
void getLandingPagesAsync(
        final String pageSize,
        final String pageToken,
        final String sortBy,
        final String sortDirection,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| pageSize |  ``` Optional ```  | Page size between 5 and 100 (default 20) |
| pageToken |  ``` Optional ```  | Token to fetch the next page |
| sortBy |  ``` Optional ```  | Can be `CREATED_TIMESTAMP` or `UPDATED_TIMESTAMP` |
| sortDirection |  ``` Optional ```  | Can be `ASCENDING` or `DESCENDING` |


#### Example Usage

```java
String pageSize = "page_size";
String pageToken = "page_token";
String sortBy = "sort_by";
String sortDirection = "sort_direction";
// Invoking the API call with sample inputs
mobileLandingPagesBeta.getLandingPagesAsync(pageSize, pageToken, sortBy, sortDirection, new APICallBack<Object>() {
    public void onSuccess(HttpContext context, Object response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 402 | TODO: Add an error description |



### <a name="updatea_landing_page_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MobileLandingPagesBetaController.updateaLandingPageAsync") updateaLandingPageAsync

> The Landing Page datastore makes it easier to create Campiangs based on the saved data.Update a Landing Page.


```java
void updateaLandingPageAsync(
        final String id,
        final UpdateLandingPage body,
        final APICallBack<UpdateaLandingPageresponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| id |  ``` Required ```  | TODO: Add a parameter description |
| body |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
try {
    String id = "id";
    UpdateLandingPage body = new UpdateLandingPage();
    // Invoking the API call with sample inputs
    mobileLandingPagesBeta.updateaLandingPageAsync(id, body, new APICallBack<UpdateaLandingPageresponse>() {
        public void onSuccess(HttpContext context, UpdateaLandingPageresponse response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 400 | TODO: Add an error description |
| 402 | TODO: Add an error description |



### <a name="deletea_landing_page_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MobileLandingPagesBetaController.deleteaLandingPageAsync") deleteaLandingPageAsync

> The Landing Page datastore makes it easier to create Campiangs based on the saved data.Delete a Landing Page.


```java
void deleteaLandingPageAsync(
        final String id,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| id |  ``` Required ```  | TODO: Add a parameter description |


#### Example Usage

```java
String id = "id";
// Invoking the API call with sample inputs
mobileLandingPagesBeta.deleteaLandingPageAsync(id, new APICallBack<void>() {
    public void onSuccess(HttpContext context, void response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 402 | TODO: Add an error description |



### <a name="get_campaign_summary_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MobileLandingPagesBetaController.getCampaignSummaryAsync") getCampaignSummaryAsync

> The reporting endpoint provides access to the reporting analytics.
> 
> ### Events Types
> 
> The campaign report consists of a series of events, that were generated by recipients when
> interacting with the generated mobile landing page.  The set of events that are currently supported
> are as follows:
> 
> | Event Type        | Event Source | Description                                    |
> |:------------------|:-------------|:-----------------------------------------------|
> | `PAGE_OPEN`       | n/a          | The page was opened in a browser.              |
> | `BUTTON_CLICKED`  | Button label | One of the Call to Action buttons was clicked. |
> | `FORM_SUBMITTED`  | n/a          | A form has been submitted with the captured data stored in the 'data' field. |Returns the breakdown of events and recipients of a particular campaign.
> 
> This will contain the following bits of information:
> 
> - The total number of events recorded for the particular campaign.
> 
> - The number of unique engagements.  This is the number of recipients for which there exists at least one recorded event.
> 
> - A breakdown of the number of the total number of events grouped by the event type and event source
> 
> The event breakdown will return the following information for each event and source type:
> 
> - The total number of recorded events of that type and source
> 
> - The number of unique recipients for which that event and source was recorded for at least once
> 
> For example, if a recipient opened the landing page three times, the number of recorded events will be 3 but the number of unique recipients will be 1.


```java
void getCampaignSummaryAsync(
        final String campaignId,
        final APICallBack<CampaignSummary> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| campaignId |  ``` Required ```  | The campaign ID |


#### Example Usage

```java
String campaignId = "campaign_id";
// Invoking the API call with sample inputs
mobileLandingPagesBeta.getCampaignSummaryAsync(campaignId, new APICallBack<CampaignSummary>() {
    public void onSuccess(HttpContext context, CampaignSummary response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="get_campaign_events_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MobileLandingPagesBetaController.getCampaignEventsAsync") getCampaignEventsAsync

> The reporting endpoint provides access to the reporting analytics.
> 
> ### Events Types
> 
> The campaign report consists of a series of events, that were generated by recipients when
> interacting with the generated mobile landing page.  The set of events that are currently supported
> are as follows:
> 
> | Event Type        | Event Source | Description                                    |
> |:------------------|:-------------|:-----------------------------------------------|
> | `PAGE_OPEN`       | n/a          | The page was opened in a browser.              |
> | `BUTTON_CLICKED`  | Button label | One of the Call to Action buttons was clicked. |
> | `FORM_SUBMITTED`  | n/a          | A form has been submitted with the captured data stored in the 'data' field. |Returns a list of events that have occurred for a particular campaign.
> 
> At this stage, the events are returned in reverse chronological order.


```java
void getCampaignEventsAsync(
        final String campaignId,
        final Double page,
        final Double pageSize,
        final APICallBack<ListCampaignEventPage> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| campaignId |  ``` Required ```  | The campaign ID |
| page |  ``` Optional ```  | The page of results to retrieve.  If unspecified, defaults to 0. |
| pageSize |  ``` Optional ```  | The size of each page.  Must be between 5 and 100.  Defaults to 25. |


#### Example Usage

```java
String campaignId = "campaign_id";
Double page = 227.055453505393;
Double pageSize = 227.055453505393;
// Invoking the API call with sample inputs
mobileLandingPagesBeta.getCampaignEventsAsync(campaignId, page, pageSize, new APICallBack<ListCampaignEventPage>() {
    public void onSuccess(HttpContext context, ListCampaignEventPage response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 402 | TODO: Add an error description |
| 404 | TODO: Add an error description |



### <a name="get_export_campaign_events_async_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MobileLandingPagesBetaController.getExportCampaignEventsAsyncAsync") getExportCampaignEventsAsyncAsync

> The reporting endpoint provides access to the reporting analytics.
> 
> ### Events Types
> 
> The campaign report consists of a series of events, that were generated by recipients when
> interacting with the generated mobile landing page.  The set of events that are currently supported
> are as follows:
> 
> | Event Type        | Event Source | Description                                    |
> |:------------------|:-------------|:-----------------------------------------------|
> | `PAGE_OPEN`       | n/a          | The page was opened in a browser.              |
> | `BUTTON_CLICKED`  | Button label | One of the Call to Action buttons was clicked. |
> | `FORM_SUBMITTED`  | n/a          | A form has been submitted with the captured data stored in the 'data' field. |Produces an unpaginated CSV file of events that have occurred for a particular campaign and emails them to the specified address(es).
> 
> At this stage, the events are returned in reverse chronological order.


```java
void getExportCampaignEventsAsyncAsync(
        final String campaignId,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| campaignId |  ``` Required ```  | The campaign ID |


#### Example Usage

```java
String campaignId = "campaign_id";
// Invoking the API call with sample inputs
mobileLandingPagesBeta.getExportCampaignEventsAsyncAsync(campaignId, new APICallBack<void>() {
    public void onSuccess(HttpContext context, void response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 402 | TODO: Add an error description |
| 404 | TODO: Add an error description |



### <a name="get_templates_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MobileLandingPagesBetaController.getTemplatesAsync") getTemplatesAsync

> Returns a paginated list of Template.


```java
void getTemplatesAsync(
        final String pageSize,
        final String pageToken,
        final APICallBack<GetTemplatesresponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| pageSize |  ``` Optional ```  | Page size between 5 and 100 (default 20) |
| pageToken |  ``` Optional ```  | Token to fetch the next page |


#### Example Usage

```java
String pageSize = "page_size";
String pageToken = "page_token";
// Invoking the API call with sample inputs
mobileLandingPagesBeta.getTemplatesAsync(pageSize, pageToken, new APICallBack<GetTemplatesresponse>() {
    public void onSuccess(HttpContext context, GetTemplatesresponse response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 402 | TODO: Add an error description |



### <a name="get_templates_fields_defination_async"></a>![Method: ](https://apidocs.io/img/method.png "com.messagemedia.api.controllers.MobileLandingPagesBetaController.getTemplatesFieldsDefinationAsync") getTemplatesFieldsDefinationAsync

> Returns a list of Template Field Defination.


```java
void getTemplatesFieldsDefinationAsync(
        final String id,
        final APICallBack<GetTemplatesFieldsDefinationresponse> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| id |  ``` Required ```  | Template Id |


#### Example Usage

```java
String id = "id";
// Invoking the API call with sample inputs
mobileLandingPagesBeta.getTemplatesFieldsDefinationAsync(id, new APICallBack<GetTemplatesFieldsDefinationresponse>() {
    public void onSuccess(HttpContext context, GetTemplatesFieldsDefinationresponse response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```

#### Errors

| Error Code | Error Description |
|------------|-------------------|
| 402 | TODO: Add an error description |



[Back to List of Controllers](#list_of_controllers)



