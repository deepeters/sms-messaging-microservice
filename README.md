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

### Preparation

### Installations

## BDD

### Services

### APIs

#### GET

#### POST

#### PUT

#### DELETE

#### FILTER

    The APIs managing the services use the @QueryParam annotation that maps over the data and returns method arguments. For example, the QueryParam accepts the year in the format {API}?year=2021 and could also pagenate the responses like {API}?start=1&size=2. The purpose of filtering is to allow for scaling of the application should the client have many messages to send to customers.

### Sending Messages

### Event Responses

#### Status Codes & Location Headers

    The design of the responses send back after different methods are implemented are vital because this metadata information helps in establishment of the event responses where the client can either receive a success response or a failed response that prompts another retry. The way this project achieves this is by using some of the most popular Status Codes along with their request types included in parenthesis. They include the following:
    - 200 - Okay (GET, DELETE, POST).
    - 201 - Message created (POST).
    - 204 - Message deleted (DELETE).
    - 302 - Resource found.
    - 304 - Resource not modified.
    - 307 - Temporary redirected.
    - 400 - Bad request (PUT, POST).
    - 401 - Unauthorised request.
    - 403 - Forbidden request.
    - 404 - Resource not found (GET, DELETE, PUT).
    - 415 - Unsupported media type (PUT, POST).
    - 500 - Internal server error (GET, DELETE, PUT, POST).

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

### Shortcomings

    -   The application services are not threat safe and does not implement a concurrency of protection.

### Future Modifications

    - Implement API metadata headers that allows for authentication using objects such as API Keys, also incude Cookies in the metadata to increase API fetch efficiency.

## Technologies, Libraries and Frameworks Used

        - Java
        - Tomcat v8.5 server
        - Jakarta RESTful Web Services (JAX-RS) a Jakarta EE API specification
        = Jersey Framework

## Profile Information

    Name: Dennis Njenga
    Email: dennis95peters@gmail.com
    Phone Number: +254715144831
