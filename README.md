# SMS Messaging Microservice

## Project Description

The goal of this project is to build a microservice around APIs to receive HTTP requests and respond by sending SMS messages to customer's phone numbers and achieve this asynchronously.

## Setup Instructions

The project uses the Java prohramming language. frameworks, libraries and servers. The decision to use Java is purely based on the fact that I as the developer is most familiar with the language, frameworks and libraries. An alternative would have been C# or NodeJS and their concurrent libraries and frameworks.

To implement and run the project locally the following are the step to step setup instructions:

- Use the Eclipse IDE to create a Maven Project. In this case the artefact ID is given as "smsmessenger"
- Select the Jersey Archetypes - For this project I selected to start with: - jersey-quickstart-webapp 2.16. (The version is very import as it has to correspond to the Tomcat version and the Java EE version used).
- After the initial project files are built, the next step is to add a server. This project applies Tomcat v8.5 (ensure that the version is v9 and below).
- The project should now contain a simple resource that contains a MyResource class that returns a dummy webpage with one simple resource.
- The project is now ready for development.

## BDD

### Services

Using the services in the application, the idea is to have a client use the resource to distribute messages as SMSs to customers each with a unique phone number and in the case where a request encounters an error, receive an error message with a status code which determines whether the client should resend the message.

### APIs

The development of APIs applies the Richardson Maturity Model to measure level RESTfulness which includes

- Level 3 - Applies the Haetous model using the rel and href attributes.
- Level 2 - Applies status codes.
- Level 1 - Individual URI for each resource.
- Level 0 - Not RESTful.

The decisons made about the API aims to accomplish easy deployment of APIs, Scaling, Flexibility and Technology agnosticity. Some of the features are as follows:

#### GET

In JAX-RS the GET method could either return an XML or JSON data formats. The annotation for this output is the @XMLRootElement.

#### POST

- To consume data from the API the annotation @Consumes specifies the expected request body format which in this case is included in the header requirements as the ContentType which is indicated as application/json.

#### FILTERING

The APIs managing the services use the @QueryParam annotation that maps over the data and returns method arguments. For example, the QueryParam accepts the year in the format {API}?year=2021 and could also pagenate the responses like {API}?start=1&size=2. The purpose of filtering is to allow for scaling of the application should the client have many messages to send to customers.

### Data

Ordinarily the messages should come into the queue from a JBBC database however in the interest of accomplishing the logic of the services in this project, in memory set of objects are used.

### Event Responses

#### Status Codes & Location Headers

The design of the responses send back after different methods are implemented are vital because this metadata information helps in establishment of the event responses where the client can either receive a success response or a failed response that prompts another retry. The way this project achieves this is by using some of the most popular Status Codes along with their request types included in parenthesis. They include the following: - 200 - Okay (GET, DELETE, POST). - 201 - Message created (POST). - 204 - Message deleted (DELETE). - 302 - Resource found. - 304 - Resource not modified. - 307 - Temporary redirected. - 400 - Bad request (PUT, POST). - 401 - Unauthorised request. - 403 - Forbidden request. - 404 - Resource not found (GET, DELETE, PUT). - 415 - Unsupported media type (PUT, POST). - 500 - Internal server error (GET, DELETE, PUT, POST).

For example in this Post method to add a new message below, the Response returns a status code 201 - Created which could be used to evaluate the SMSsent Event.

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response addMessage(Message message) {
    	    Message newMessage = messageService.addMessage(message);
    	    return Response.status(Status.CREATED)
    			.entity(newMessage)
    			.build();
        }

### Handling Exceptions

Exceptions form the basis of the response the application will return to the client so that they can know whether all SMSs were sent to customers or not and whether to retry to resend them.

For example in this example below an exception is thrown when the client attempts to get a message and sets a foundation for the next steps the client may attempt to implement.

    	public Message getMessage(long id) {
    	Message message = messages.get(id);
    	if (message == null) {
    		throw new MessageSendRequestException("Message with id " + id + " not found")
    	}
    	return message;
    }

### Logs

Logs was not implemented.

### Shortcomings

- The application services are not threat safe and does not implement a concurrency of protection.

### Future Modifications

- Implement API metadata headers that allows for authentication using objects such as API Keys, also incude Cookies in the metadata to increase API fetch efficiency.
- Use status code responses to automate retrying of messages.

## Technologies, Libraries and Frameworks Used

        - Java
        - Tomcat v8.5 server
        - Jakarta RESTful Web Services (JAX-RS) a Jakarta EE API specification
        = Jersey Framework

## Profile Information

    Name: Dennis Njenga
    Email: dennis95peters@gmail.com
    Phone Number: +254715144831
