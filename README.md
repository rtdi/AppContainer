# AppContainer

_Developing SAP Hana Applications quickly_

Source code available here: [github](https://github.com/rtdi/AppContainer)

## Design Thinking goal
* As a developer I would like to build UI5 applications as quickly as possible. Everything the backend can do automatically, it should.
* Cloud, onPrem are just different deployment options.


## Core thoughts

For building a web application the following components are needed

- Graphical User Interface: Today that would be a web application utilizing SAPUI5, OpenUI5, Angular, React or pure HTML5.
- Backend: The web application makes calls to a backend service which translates the actions into database commands. Example: A List-control for the order types should be populated with the list of all allowed order types. Hence a service is needed reading the respective table and returning that data in Json format allowing the control can render the data.
- Database structures: Applications either use existing tables and views or new ones need to be created during the installation of the application.
- Security: A user needs to be authenticated (via username/password usually), a user has permissions for certain actions but not others, a user has access to some data but not all
- CI/CD: Support continuous integration and development and git version control 

## Installation and testing

On any computer install the Docker Daemon - if it is not already and download this docker image with

    docker pull rtdi/appcontainer:latest-hana
    docker pull rtdi/appcontainer:latest-snowflake

Then start the image via docker run. Only one parameter needs to be set, the environment variable JDBCURL. For Hana this consist of the hostname (in this example hana.rtdi.io) and the port number (39015 because the instance number is 90 - pattern is 3<instanceNo>15) and the MDC database name (here HXE). For Snowflake see the [Snowflake JDBC documentation](https://docs.snowflake.com/en/user-guide/jdbc-configure.html#jdbc-driver-connection-string).

    docker run -d -p 80:8080 -e JDBCURL=jdbc:sap://hana.rtdi.io:39015/HXE rtdi/appcontainer

From then on the application can be opened with at the URL http://&lt;dockerhostname&gt;/AppContainer/ with a list of applications

An even better docker run command is to add a few server directories, here all in the hosts /dockermountpoints directory, and point them into various predefined points.

    docker run -d --name appcontainer  -p 80:8080 -p 443:8443 \
       -v /dockermountpoints/rtdiconfig:/usr/local/tomcat/conf/rtdiconfig \
       -v /dockermountpoints/security:/usr/local/tomcat/conf/security \
       -v /dockermountpoints/repo:/usr/local/tomcat/repo \
       -v /dockermountpoints/ui5externallibs:/usr/local/tomcat/webapps/ui5externallibs \
       -e JDBCURL=jdbc:sap://hana.rtdi.io:39015/HXE rtdi/appcontainer

- /usr/local/tomcat/conf/rtdiconfig: The directory where tomcat related settings can go. Usually not needed.
- /usr/local/tomcat/conf/security: The directory with ssl settings. The tomcat-users.xml user database is not used.
- /usr/local/tomcat/repo: This is where all developed files are located, one directory per user and a global PUBLIC directory.
- /usr/local/tomcat/webapps/ui5externallibs: A place to put all additional ui5 libraries and files not part of the deployed web application.


## Capabilities

The complete solution consists of the following modules:

* Repository to create new files or change them
* Activation of Hana files like hdbtable
* Webserver to provide html files, xml views and other files needed for web development
* Graphical UI Editor for XMLViews
* Backend services to read data via oData or Restful calls
* Backend services to invoke stored procedures, which usually trigger business logic, e.g. create a booking
* Lots of extension points at all levels to use for custom projects

<img src="https://github.com/rtdi/AppContainer/raw/master/docs/media/Screenshot 01 - Home page.png" width="50%">



### Repository

A file system resp. git based repository where new development artifacts can be managed and edited. The goal is to support all file types to create tables from scratch, html files,... 

<img src="https://github.com/rtdi/AppContainer/raw/master/docs/media/Screenshot 02 - Designtime Browser.png" width="50%">



### Activation

The goal of a CI/CD pipeline is to allow deploying the same code in an automated way, thus it makes sure that moving code to production is as simple as a click of a button.
This begs the question who executes the code and manages all dependencies? The activation application does. 



### Webserver

All files within the repository can be opened via the web browser, assuming the user has the required permissions.

<img src="https://github.com/rtdi/AppContainer/raw/master/docs/media/SampleUI.png" width="50%">


### UI5 Application Development

When building UI5 apps, a lot of common preparation work must be performed. This AppContainer aims to simplify as much as possible without creating limitations.
The approach is generally speaking one of

- If a mandatory file is missing, it is generated automatically. Example: The MyApp.html file is missing but a manifest.json exists -> create a default html and component.js file when such file is requested by the browser.
- Controls and fragments to be reused
- Especially the [am4charts library](https://www.amcharts.com/demos/) is available via UI5 controls

For the details see [UI5Development](UI5Development.md)


### Graphical UI Editor

Allows to edit normal XMLView files by drag and drop of control and changing their properties via a double click.

ATTENTION: PoC only.

<img src="https://github.com/rtdi/AppContainer/raw/master/docs/media/XMLViewEditor.gif">



### oData/Restful service endpoint

Every single table or view is exposed as oData endpoint and as Restful service. See the swagger definitions and oData metadata.

<img src="https://github.com/rtdi/AppContainer/raw/master/docs/media/Screenshot 16 - odata.png" width="50%">


### Procedures as Restful endpoints

Every stored procedure the user has permissions on can be invoked via a Restful service.

<img src="https://github.com/rtdi/AppContainer/raw/master/docs/media/procedure-invocation.png" width="50%">

### Rest Lookup

To return at most a single record from a table, lookup endpoint exists. It supports custom where clauses using the $where query parameter and via $select a reduced list of column.

Example:
http://localhost:8080/AppContainer/protected/rest/lookup/SYS/USERS

### Rest Query

In case needed, data can also be queried via a rest interface. The endpoint is called query and it expects a parameter query= with the select statement to be executed.

Example:
http://localhost:8080/AppContainer/protected/rest/query?$select=select%20*%20from%20users

### Rest Group-Query

Similar to the Rest Query, except that it returns the data in a hierarchical manner. 

For this to work properly, the call must meet multiple conditions:
1. The columns with less distinct values come before the other
1. The parameter $levelcolumns specifies the number of levels the diagram has a the most
1. All columns after the $levelcolumns specified number go into the leaf node

Example:
http://localhost:8080/AppContainer/protected/rest/groupquery?$select=SELECT%20schema_name,%20data_type_name,%20count(*)%20AS%20count%20FROM%20VIEW_columns%20GROUP%20BY%20schema_name,%20data_type_name&$levelcolumns=2

The select statement returns in that column order:

| schema | datatype | count |
| ------ | -------- | ----- |
| SYS    | VARCHAR  |    10 |
| SYS    | INTEGER  |     5 |

The $levelcolumns tells two levels at most. Hence the output Json looks like

[ { "name": "SYS",
    "children": [
        {
            "name": "VARCHAR",
            "count": 10
        },
        {
            "name": INTEGER",
            "count": 5
        }
    ]
} ]

It is a tree with name/children and all columns at position >2 are added to the leaf node.

If one level has a value of NULL it is skipped.


### Extension points

To extend this application and use it beyond the editing capabilities, own code can be added via various ways.
* Deploy your web application
* Mount more files via docker
* Put custom files into the file repository
* USe the framework to add services more easily

## Licensing

This application is provided as dual license. For all users with less than 10'000 API calls per month the application can be used free of charge and the code falls under a Gnu Public License. Users with more than 10'000 API calls are asked to get a commercial license to support further development of this solution. The commercial license is on a pay-per-use basis.
One API call is one invocation of any of the backend services, oData or Restful, in any running container hosted within the company. In other words, when 10 containers are active and used equally, once all got more than 1'000 calls they exceed overall the 10'000 api call limit.

## Data protection and privacy

Every ten minutes the application does send the api call statistics via a http call to a central server where the data is stored for information along with the public IP address (usually the IP addess the router got assigned). It is just a count which service was invoked how often, no information about endpoints, users or URL parameters. This information is collected to get an idea about the adoption.
To disable that, set the environment variable HANAAPPCONTAINERSTATISTICS=FALSE.