# The AppContainer

(Github Repo: https://github.com/rtdi/AppContainer)

_Provide a development environment for database application with the focus of Continuous Integration/Continuous Delivery (CI/CD)_

## Design Thinking Goal

Developers for database application need an easy to use and light weight development environment, which supports all methods of modern software development but with the specialities needed for database centric apps.

In particular these are:

- Develop Web based UIs
- Multi-developer environment using git
- Deploy database artifacts
- Backend for accessing database data via a Restful API
- Unit testing
- CI/CD pipeline for development automation

## Further reading

- [Solution Design](https://github.com/rtdi/AppContainer/blob/master/docs/000%20-%20Solution%20Design.md)
  - [Architecture](https://github.com/rtdi/AppContainer/blob/master/docs/001%20-%20Architecture%20basics.md)
  - [Authentication and Authorizations](https://github.com/rtdi/AppContainer/blob/master/docs/003%20-%20Webserver%20and%20DB%20Security.md)
  - [Design Time Objects](https://github.com/rtdi/AppContainer/blob/master/docs/004%20-%20DesignTimeObjects.md)
    - [SQL Scripts](https://github.com/rtdi/AppContainer/blob/master/docs/004a%20-%20SQL%20Scripts.md)
    - [SQL Script Parser](https://github.com/rtdi/AppContainer/blob/master/docs/004b%20-%20SQL%20Script%20Parser.md)
  - [Rest API Guidelines](https://github.com/rtdi/AppContainer/blob/master/docs/005%20-%20Restful%20API.md)
  - [WebServer configuration](https://github.com/rtdi/AppContainer/blob/master/docs/006%20-%20WebApp%20basics.md)
  - [Repository](https://github.com/rtdi/AppContainer/blob/master/docs/007%20-%20Repository.md)
  - [UI5 NoCode/LowCode editor (Prototype)](https://github.com/rtdi/AppContainer/blob/master/docs/010%20-%20UI%20Editor.md)
  - [Git Integration](https://github.com/rtdi/AppContainer/blob/master/docs/008%20-%20Git%20integration.md)
  - [Unit Testing for Database Objects](https://github.com/rtdi/AppContainer/blob/master/docs/009%20-%20Testing.md)
- [Background information about CI/CD](https://github.com/rtdi/AppContainer/blob/master/background/001%20-%20CICD.md)
- [Important Software Design Patterns used](https://github.com/rtdi/AppContainer/blob/master/background/002%20-%20Design%20Patterns.md)
- [Design Thinking - WebUI development](https://github.com/rtdi/AppContainer/blob/master/background/003%20%20Building%20Web%20UIs.md)

## Quickstart

Attention: A better docker run command is explained in the [Installation](https://github.com/rtdi/AppContainer/blob/master/docs/000%20-%20Installation%20details.md) document.

On any computer or cloud infrastructure capable of running software-containers (aka Docker Images) the image can be downloaded from docker hub

    docker pull rtdi/appcontainer:latest-hana
    docker pull rtdi/appcontainer:latest-snowflake
    docker pull rtdi/appcontainer:latest-sqlserver
    docker pull rtdi/appcontainer:latest-mysql
    docker pull rtdi/appcontainer:latest-postgresql

Then the image is started via docker run. Only one parameter must be set, the environment variable JDBCURL. For Hana this consists of the hostname (in this example hana.rtdi.io) and the port number (39015 because the instance number is 90 - pattern is 3<instanceNo>15) and the MDC database name (here HXE). For Snowflake see the [Snowflake JDBC documentation](https://docs.snowflake.com/en/user-guide/jdbc-configure.html#jdbc-driver-connection-string).

### Examples

(Connection strings are not pointing to any actual databases):

Hana:

    docker run -d -p 80:8080 \
      -e JDBCURL="jdbc:sap://hana.rtdi.io:39015/?databaseName=HXE" \
      rtdi/appcontainer:latest-hana

Snowflake:

    docker run -d -p 80:8080 \
      -e JDBCURL="jdbc:snowflake://tn0815.eu-central-1.snowflakecomputing.com/?db=MYDATABASE" \
      rtdi/appcontainer:latest-snowflake

SQLServer/Azure SQL DB:

    docker run -d -p 80:8080 \
      -e JDBCURL="jdbc:sqlserver://rtdi.database.windows.net:1433;database=rtdi;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;" \
      rtdi/appcontainer:latest-sqlserver

MySQL:

    docker run -d -p 80:8080 \
      -e JDBCURL="jdbc:mysql://database-1.abcd.eu-central-1.rds.amazonaws.com:3306/DATA" \
      rtdi/appcontainer:latest-mysql

PostgreSQL:

    docker run -d -p 80:8080 \
      -e JDBCURL="jdbc:postgresql://database-1.abcd.eu-central-1.rds.amazonaws.com:5432/" \
      rtdi/appcontainer:latest-postgresql

From then on the application can be opened with at the URL http://&lt;dockerhostname&gt;/AppContainer/ with a list of applications

## Features

### Home Page

The IT department did download and run the AppContainer via a docker-run command. Now the development environment is available as web application under that URL and presents itself to the user as a Home screen with multiple tiles.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image.png" width="750">

The important tile is the Repository Browser. The Swagger tile is to see the Restful APIs exposed by the AppContainer and the OpenUI5 tile links to the installed documentation of this UI framework.

### Login

Because the Repository is user specific and should not be accessible by everybody, the web server asks the user to login first.
Any user with a database login can use the same to connect to the database.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-1.png" title="" alt="image-1.png" width="300">

### Restful endpoints and OData V4

This AppContainer exposes every table, view and stored procedure the logged in user has permissions to read/execute via the Restful protocol.
There are APIs to view table contents, lookup a single record based on its primary key, execute any SQL query (select only, user permissions apply), get the list of all tables and views, invoke stored procedures and function with input and output parameters and table output.

These APIs are as simple to use as possible.

OData is a Restful protocol and provides more information like metadata about the objects, datatype handling, pagination.
Hence it is a perfect fit for business APIs.

#### Example:

On the AppContainer's home page one tile is the link to the Swagger UI, which lists all Restful APIs exposed by the AppContainer.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-22.png" width="750">

The Swagger UI also lets the user try out API calls. The `rest/query/{schemaname}/{tablename}` is exactly the one we need to read the data from the database.

So what does it need to read the data from a table/view of the database with the permissions of the current web user? Nothing. Absolutely nothing. The AppContainer does all of that.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-23.png" width="750">


### Online editing of files

The repository browser shows on the left hand side the directory structure for the logged in user and on the right half of the screen the files in the currently selected directory.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-2.png" width="750">

The user can do all the normal file operations, rename, delete, create, move files and directories.

To create any new file the add button is clicked

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-3.png" width="300">

and the the name of the file to be created can be specified. In this case the user wants to create a UI screen, hence the extension *.view.xml.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-5.png" width="750">


This xml file is a regular text file and can be edit as such by clicking on its name.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-4.png" width="300">

The text editor shows the empty file and allows to create the XML structure. The editor supports basic syntax highlighting.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-6.png" width="750">


### CI/CD of database objects, infrastructure as a service and DevOps

When creating tables, views, procedures and other database objects, it would be beneficial if these can be scripted and the script is executed at code checkin.
Scripting SQLs is possible with every database, but for running the scripts multiple times the developer most have more control. 
He cannot simple run the create table script as it will fail once the table exists. He cannot drop the table because then the data is lost. He cannot skip the table creation when the table exists because it might have gotten a new field. First create the table, then the view based on it. Some tables must be loaded with a set of records from a CSV file.

There are many problems like that and the AppContainer provides features to solve all.

#### Example:

A folder structure must be created. The names can be chosen freely but to make the dependencies very obvious it might be a good idea to name them accordingly, e.g. the folder with the tables is `01 - ...` to ensure the tables are created first and all other dependent objects later. Similar concept for the files within each folder.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-16.png" width="750">

Now the sql scripts can be created.
If that script does contain the create table statement only, it will succeed the first time and all subsequent activations would fail with the error "object exists already". 

Therefore the SQL script parser of the AppContainer supports annotations to control the code blocks. For the current situation a "execute only if the table does not exist yet" is sufficient but there can be all kinds of conditions, e.g. check if the column in the table exists and if not, add the column so that the table is of the most recent version.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-18.png" width="750">

To create only the table, the activation button on the top right corner of the editor is clicked (or the activation buttons in the browser).
The user gets detailed feedback about the activation process.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-17.png" width="750">

But this table must get data as well as part of the deployment process and if all is activated, it must happen after the tables have been created. 
Sounds like adding another directory and a file with the table name.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-19.png" width="750">

This file is a regular CSV file with header and data. When clicking on the activate button, it truncates the table and loads the entire file data into the table.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-20.png" width="750">

As it is shown by the database tool.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-21.png" width="750">


### Git integration

Today every code must be maintained via a Git repository. The AppContainer can clone and pull the scripts from a Git repository.
This allows complete automated deployments by first calling the Rest endpoint for the pull and then the endpoint to execute the scripts against the connected database.
This process is called the code activation.

#### Example:

Moving all into production is very simple.

1. A git pull is performed on the production system with the database user which has the permissions to execute the scripts in the target database.
2. Perform an activation on the root folder.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-28.png" width="750">

This goes through the entire directory structure and activates the logic. The activation logic for *.sql files is to execute them, for *.csv files to import the data, for *.test.js to execute the tests and all other files are static files, which get copied into the PUBLIC folder of the repository so they are no longer user specific.

Note: the git pull and the activation are also Restful APIs. The UI does nothing else than calling those, so can any other program that triggers the deployment.

### Unit tests

Tests are written in JavaScript as *.test.js files. As the order is important also, all test files are best placed into a separate directory.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-26.png" width="750">

The tests can be any JavaScript code, the interaction with the database happens through the `db` object.
In this example the test code is very simple and fails, because three records were loaded into the table but the tests - for demonstration purposes - expects 9999 rows.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-27.png" width="750">


### HTML5 app deployment

HTML and other files can be served by the AppContainer's webserver. Each directory has an annotation (a file) whic describes the user groups the connected user must belong to in order to open these files.
All logged in users are in the group PUBLIC and a directory annotated correspondingly contains all web files all logged in users should see.
Files that are visible only to users in the group FINANCE should be placed into another directory.
The group names are the database roles the user is assigned to.

### UI5 app development

The AppContainer can be used with any files but it does include the OpenUI5 (aka "UI5") development framework.
This supports many controls and data binding via OData V4 out of the box and is considered a good fit for this kind of business applications.

Further more the AppContainer provides additional support to make the UI5 development process more lean.


### AMCharts integration

Business applications benefit from rich charting options and the AppContainer has the AMCharts library included and integrated into the UI5 framework.




