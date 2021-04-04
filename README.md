# HanaAppContainer

_Developing SAP Hana Applications quickly_

Source code available here: [github](https://github.com/rtdi/HanaAppContainer)

## Design Thinking goal
* As a developer I would like to build UI5 applications as quickly as possible. Everything the backend can do automatically, it should.
* Cloud, onPrem are just different deployment options.


## Core thoughts

For building a Hana application the following components are needed

- Graphical User Interface: Today that would be a web application utilizing SAPUI5, OpenUI5, Angular, React or pure HTML5.
- Backend: The web application makes calls to a backend service which translates the actions into database commands. Example: A List-control for the order types should be populated with the list of all allowed order types. Hence a service is needed reading the respective table and returning that data in Json format allowing the control can render the data.
- Database structures: Applications either use existing tables and views or new ones need to be created during the installation of the application.
- Security: A user needs to be authenticated (via username/password usually), a user has permissions for certain actions but not others, a user has access to some data but not all
- CI/CD: Support continuous integration and development and git version control 

## Installation and testing

On any computer install the Docker Daemon - if it is not already and download this docker image with

    docker pull rtdi/hanaappcontainer:latest

Then start the image via docker run. Only one parameter needs to be set, the environment variable HANAJDBCURL. This consist of the hostname (in this example hana.rtdi.io) and the port number (39015 because the instance number is 90 - pattern is 3<instanceNo>15) and the MDC database name (here HXE).

    docker run -d -p 80:8080 -e HANAJDBCURL=jdbc:sap://hana.rtdi.io:39015/HXE rtdi/hanaappcontainer

From then on the application can be opened with at the URL http://&lt;dockerhostname&gt;/HanaAppContainer/ with a list of applications

An even better docker run command is to add a few server directories, here all in the hosts /dockermountpoints directory, and point them into various predefined points.

    docker run -d --name appcontainer  -p 80:8080 -p 443:8443 \
       -v /dockermountpoints/rtdiconfig:/usr/local/tomcat/conf/rtdiconfig \
       -v /dockermountpoints/security:/usr/local/tomcat/conf/security \
       -v /dockermountpoints/hanarepo:/usr/local/tomcat/hanarepo \
       -v /dockermountpoints/ui5externallibs:/usr/local/tomcat/webapps/ui5externallibs \
       -e HANAJDBCURL=jdbc:sap://hana.rtdi.io:39015/HXE rtdi/hanaappcontainer

- /usr/local/tomcat/conf/rtdiconfig: The directory where tomcat related settings can go. Usually not needed.
- /usr/local/tomcat/conf/security: The directory with ssl settings. The tomcat-users.xml user database is not used.
- /usr/local/tomcat/hanarepo: This is where all developed files are located, one directory per user and a global PUBLIC directory.
- /usr/local/tomcat/webapps/ui5externallibs: A place to put all additional ui5 libraries and files not part of the deployed web application.

## Help!

The source code of this project is available at [github](https://github.com/rtdi/HanaAppContainer).
As an OpenSource project it grows with the interactions. Hence I invite all to file [issues](https://github.com/rtdi/HanaAppContainer/issues) in github, no matter if it is a request for help or product suggestions and to spread the word. The more people are using it, the faster progress will be made to your benefit.


## Capabilities

The complete solution consists of the following modules:

* Repository to create new files or change them
* Activation of Hana files like hdbtable
* Webserver to provide html files, xml views and other files needed for web development
* Graphical UI Editor for XMLViews
* Backend services to read data via oData or Restful calls
* Backend services to invoke stored procedures, which usually trigger business logic, e.g. create a booking
* Lots of extension points at all levels to use for custom projects

<img src="https://github.com/rtdi/HanaAppContainer/raw/master/docs/media/Screenshot 01 - Home page.png" width="50%">



### Repository

A file system based repository where new development artifacts can be managed and edited. The goal is to support all file types, e.g. hdbtable files to create tables from scratch, html files,... It is file system based to allow easy integration with git source code control. 

<img src="https://github.com/rtdi/HanaAppContainer/raw/master/docs/media/Screenshot 02 - Designtime Browser.png" width="50%">



### Activation

Just like Hana XS Classic and Hana XS Advanced or the Cloud Application Programming Model artifacts of SAP, the same objects can be activated to create Hana objects easily.

<img src="https://github.com/rtdi/HanaAppContainer/raw/master/docs/media/Screenshot 03 - hdbtable.png" width="50%">



### Webserver

All files within the repository can be opened via the web browser, if permissions allow that.

<img src="https://github.com/rtdi/HanaAppContainer/raw/master/docs/media/SampleUI.png" width="50%">



### Graphical UI Editor

Allows to edit normal XMLView files by drag and drop of control and changing their properties via a double click.

<img src="https://github.com/rtdi/HanaAppContainer/raw/master/docs/media/XMLViewEditor.gif">



### oData/Restful service endpoint

Every single table or view is exposed as oData endpoint and as Restful service. See the swagger definitions.

<img src="https://github.com/rtdi/HanaAppContainer/raw/master/docs/media/Screenshot 16 - odata.png" width="50%">


### Procedures as Restful endpoints

Every stored procedure the user has permissions on can be invoked via a Restful service.

<img src="https://github.com/rtdi/HanaAppContainer/raw/master/docs/media/procedure-invocation.png" width="50%">


### Extension points

To extend this application and use it beyond the editing capabilities, own code can be added via various ways.
* Deploy your web application
* Mount more files via docker
* Put custom files into the file repository
* USe the framework to add services more easily

## Licensing

This application is provided as dual license. For all users with less than 10'000 API calls per month the application can be used free of charge and the code falls under a Gnu Public License. Users with more than 10'000 API calls are asked to get a commercial license to support further development of this solution. The commercial license is on a pay-per-use basis.
One API call is one invocation of any of the backend services, oData or Restful, in any running container hosted within the company. In other words, when then containers are active and used equally, once all got more than 1'000 calls they exceed overall the 10'000 api call limit.

## Data protection and privacy

Every ten minutes the application does send the api call statistics via a http call to a central server where the data is stored for information along with the public IP address (usually the IP addess the router got assigned). It is just a count which service was invoked how often, no information about endpoints, users or URL parameters. This information is collected to get an idea about the adoption.
To disable that, set the environment variable HANAAPPCONTAINERSTATISTICS=FALSE.