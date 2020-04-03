# HanaAppContainer

_Developing SAP Hana Applications quickly_

## Design Thinking goal
* As a developer I would like to build UI5 applications as quickly as possible. Everything the backend can do automatically, it should.
* Cloud, onPrem are just different deployment options.


## Core thoughts

For building a Hana application the following components are needed

- Graphical User Interface: Today that would be a web application utilizing SAPUI5, OpenUI5, Angular, React or pure HTML5.
- Backend: The web application makes calls to a backend service which translates the actions into database commands. Example: A List-control for the order types should be populated with the list of all allowed order types. Hence a service is needed reading the respective table and returning that data in Json format allowing the control can render the data.
- Database structures: Applications either use existing tables and views or new ones need to be created during the installation of the application.
- Security: A user needs to be authenticated (via username/password usually), a user has permissions for certain actions but not others, a user has access to some data but not all

## Installation and testing

This project is exposed as a web archive (war file) and a docker container exists for easy deployment.
see [here](https://github.com/rtdi/HanaAppContainerDockerBuild)


## Capabilities

### RestFul API

#### Stored Procedures
Every stored procedure can be invoked via a restful API.
Examples:

    GET http://..../protected/rest/procedures
    POST http://..../protected/rest/procedures/SYS/GET_OBJECT_DEFINITION with Json payload {"SCHEMA": "PUBLIC", "OBJECT": "VIEWS" }

All the different input and output parameters are supported, from scalar parameters to table types.
  
#### Lookup a record
A simple Restful API to retrieve single records. If the query would produce more than one record, only the first is returned.
For cases where more than one record should be returned, the oData API is better suited as it supports ordering, paging and more.
 
Example:

    GET http://..../protected/rest/lookup/SYS/OBJECTS?$select=SCHEMA_NAME, OBJECT_NAME, OBJECT_TYPE, OBJECT_OID&SCHEMA_NAME=SYS&OBJECT_NAME=TABLES

#### Swagger
All Restful APIs are annotated to create a openapi.json Swagger documentation. 

### oData API
Most UI components will favor reading data via the oData protocol. Every table, view or calculation view can be read via this API and
each database object is treated as a separate oData service with its own $metadata document.

Example:

    GET http://..../protected/odata/SYS/OBJECTS/$metadata

