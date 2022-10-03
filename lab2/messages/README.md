# Second Lab of IADI 2022

In this lab you may find an API for a resource "message". The file `MessageAPI` 
contains an interface that declares the endpoints for the resource messages using 
the standard REST approach. The file `MessageController` includes a non-implementation 
of the API just to define a working API in Spring. There is also the definition of the
DTO for the resource with special and separate definitions for the detail of a message, 
the summary of a message to be used in a list, and a smaller detail of a message to be used 
to create a new message. 

## The use of OpenAPI to specify an API

OpenAPI is used in this project to automatically produce human-readable documentation and 
specification and also machine-readable specification that can be used to automate the use 
of that same API. 

Notice that the project includes a new dependency in file `pom.xml`, to the 
module `springdoc-openapi-ui`. Once the application is running new endpoints are available to
dynamically produce data regarding the structure of the API. 

Please use the browser to check the URL `http://localhost:8080/swagger-ui.html` to find the user
interface that allows one to inspect the API, its endpoints, their parameters, and with 
the possibility of testing the API itself. The machine-readable information is available in the
end-point `http://localhost:8080/v3/api-docs`. It consists of a `JSON` object that describes all 
the endpoints in a structured way. This information can be used in swagger's website 
(`http://editor.swagger.io`) -- just paste the JSON object onto the editor -- to test the API 
and generate all sorts of code stubs, for server and client applications. 

Along with the endpoint declarations, the interface contains annotations that add human-readable
information to the API specification. Explore the annotations that are in the interface 
in file `MessageAPI` and data classes in file `MessageDTO`. 

## Goal

Extend the API to implement a resource `mailbox` that contains messages (as a subresource). 
Recall the lecture (and slides) to understand how to structure the endpoints of a resource 
(`mailbox`) and its subresource (`message`). 
