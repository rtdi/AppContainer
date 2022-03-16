# Solution Design

## Motivation

All large software vendors provide Web based development environments and programs can interact with databases. In that sense all requirements from above can be fulfilled. But all the work is left to the end user. The AppContainer aims to simplify the entire process for databse backed business applications.

## Architecture

A Tomcat webserver with some apps is wrapped into a container and all operations are done via web technologies. It is as simple as that. The components implemented are:

- Tomcat Realms to delegate the authorization and authentication to the connected database - one realm per database type
- Swagger UI to document all Restful end points
- oData and Restful to expose database data
- Repository operation endpoints
- UIs for repository operations
- Activation logic for different types of resources (database specific)

([Implementation](docs/001 - Architecture basics.md))

## Project plan

(details [here](docs/002 - Projectplan.md))

## Develop Web based UIs

### Webserver

**Industry standard**

The bare minimum for developing a web based UI is to have a web server. In the Eclipse IDE a full blown web server is started for debugging, which is quite heavy weight.
That is one of the reasons Node.js got popular, as it includes a web server.
Deploying the code for testing a large application can still take a while.

**AppContainer**

In contrast, the AppContainer is a webserver with file change interceptors. The moment a file is changed it is available via the webserver.
There is no need to start/stop a webserver, to package and deploy code, to deal with caching issues in the browser or server.

([Implementation](docs/006 - WebApp basics.md))

### Webserver Security and Session handling

**Industry standard**

The common approach is to have an [IdentityProvider](https://www.cloudflare.com/learning/access-management/what-is-an-identity-provider/) (IdP) [(_[1] cloudflare_)](#1) and all services contact it directly for authentication and authorization.
The webserver, every single Restful service,...

Following the Microservice paradime of stateless services, these queries must be done constantly. Either direct or every few minutes when a [JWT](https://jwt.io/) token expires [(_[2] IETF, 2015_)](#2).
For single database applications this creates a massive overhead.

**AppContainer**

The webserver has a database realm using the database users itself as authentication and authorization system. So the webserver asks for the database login/password, creates a database connection for this user and reads the database roles the user has assigned.
This does not prevent using the IdP but it is not used directly. The database is configured to use the IdP and the webserver utilizes the database functionality.

The database connection pool is therefore made available via the user (Principal) the session belongs to.

This has a whole set of advantages:
 - Better performance
 - Using the database authentication and authorization for the web applications as well
 - Using the database security - the logged in user has access to the database objects and rows the database user has permissions on. There is no technical user to connect to the database, it is the actual database user itself interacting with the database.
 - Due to the stable webserver session, intermediate states can be preserved between Restful calls. This speeds up pagination requests, where the first call returns 1000 rows from a query and the next call the next set of data. Thanks to the session the query can stay open so that the next call just fetches more records until all data has been read or the query runs into a timeout.

 The only dowside is that this model does not scale into millions of parallel users, just a couple of 10'000 - which is more than enough for business applications.

([Implementation](docs/003 - Security.md))

### UI Component Library

**Industry standard**

Installing and using the library is part of the initial code setup.

**AppContainer**

By providing a HTML5 component framework out of the box, building web applications is much easier. It must not get installed, its files are cached by the browser and additional custom controls can be provided to help with database centric applications.
And if the provided library is not the desired one, nothing prevents to install another in addition.

## Multi-developer environment using git

All modern IDEs have git integration. For some it is an additional external storage in the sense of the objects get exported and imported from git. But the majority works directly on the local git repository. So no difference here.

([Implementation](docs/008 - Git integration.md))

([Repository](docs/007 - Repository.md))

## Deploy database artifacts

**Industry standard**

A huge problem for database applications are their database artifacts. How to create tables, views and all other database objects. 
There are multiple approaches, one is to generate the database artifacts out of their corresponding Class definitions using an Object-Relational-Mapping. In the Java world the [Java Persistence API](https://docs.oracle.com/javaee/6/tutorial/doc/bnbpz.html) (JPA) is the standard for such [(_[3] Oracle, 2013_)](#3).

Another approach is to embed SQL scripts or run them seperately or even manually.

**AppContainer**

The AppContainer uses directory structures to create the objects in the desired order via SQL scripts. This allows to break apart the huge script creating all objects into more digestable parts and still honor the dependencies.

While these scripts suppport the full syntax of the database - there are no limitations in regards to the allowed SQL statements and options - a few additional features are provided in the script parser.

 - Conditional execution: Execute a statement only if a condition applies, e.g. execute the create-table statement if the table does not exist, else check if the table has column xyz and execute the alter table add column statement if needed.
 - Schema aliases: Allows to parameter the schema name where the table is created for cases where one database should get the same application installed but in different schemas.

 In case the developer has database artifacts already, the AppContainer provides a reverse-engineering option as well. To create the scripts for individual objects or entire schemas.

([Implementation](docs/004 - DesignTimeObjects.md))

([SQL Script usage options](docs/004a - SQL Scripts.md))

([SQL Parser Implementation](docs/004b - SQL Script Parser.md))

## Backend for accessing database data via a Restful API

**Industry standard**

Clound vendors do have simple Restful APIs to interact with a database service. For onPremise databases and for classic software development tools these APIs must be either explicitly configured or coded from scratch. That should not come as a surprise as this API must handle security.

The root cause for all these problems is again the fact, that a technical user used to connect to the database, not the actual user.

**AppContainer**

In the AppContainer life is much easier. It exposes an API whith which any SQL query can be executed. Is that a security problem? Of course not, the database protects itself from returning data to a user who does not have permissions. If the user does not have permissions on an object, the query fails. If the user has permissions on specific rows in the object, the query does return only those.

Therefore the AppContainer provides APIs for:
 - Executing any SQL query
 - Reading tables/views
 - Invoking stored procedures with input/output parameters including result sets.

([Implementation](docs/005 - Restful API.md))

## Unit testing

**Industry standard**

For a library the Unit testing is pretty straight forward. For example the library has a method with the signature _int multiply(int a, int b)_. Whenever that library is changed, a series of tests validate that the result is the expected one.

- _assertEquals(0, multiply(0,100))_
- _assertEquals(100, multiply(1,100))_
- _assertThrows(OverflowException, multiply(10,Integer.MAX_VALUE))_
- ...

If the tests are covering all normal and edge cases, a side effect of a code change will be uncovered early.

When the application has states, things get more difficult. For example the user clicks on the _order_ button and one time the result is a new order being posted and another time an error message "product out of stock" is presented. Obviously the more states, the more cases must be tested.
A tpyical database application with hundreds of tables is per definition a stateful application and it has lots of combinations to test.

Because of that there are almost no tools that provide help to the developer. All must be built manually.

The naive approach would use normal CI/CD pipeline. A test run simulates the complete cycle from instantiating the database, loading data into the tables and then run the tests. That is doable for tiny projects but generally speaking has the following issues:

1. Deploying a large database application can take a long time, too long to be done at every code push.
2. The sequence of the tests matter. Example: One test orders a product and the other modifies the inventory level. Within one test that would be fine, e.g. create an order then modify this order, but such dependencies occur even between different subject areas like in the provided example.
3. Therefor tests cannot be executed in parallel unless extra care is taken. Complexity of dependencies grow exponentially.
4. If one database is used for all developers the tests must run one at a time, otherwise they interfere.
5. If each developer has its own database, the amount of resources will be immense.
6. The test would cover a fresh installation only. But customers will upgrade the application also, and not start with an empty database.
7. Hence upgrade scripts must be implemented and tested as well.
8. The customer might not upgrade to every new version but skip some. So upgrade scripts must handle different starting points.

All these problems require more functionality for these types of applications.

**AppContainer**

Similar to activation of SQL scripts, the AppContainer can also activate *.test.js files. These contain normal JavaScript code which has a `db` object to interact with the database. It allows to execute queries and use the resulting dataset in the JS code. This can then be compared with a reference dataset, e.g. one that has been preserved as CSV file.

As stated above, due to the stateful nature of database objects, the comparison must be more flexible. Data can be returned in different order, columns that change, like ORDERID coming from a static database sequence, should not be compared. The AppContainer provides all these options.

([Implementation](docs/009 - Testing.md))

## CI/CD pipeline for development automation

**Industry standard**

To deploy software all tools package the application into a file, transport it and deploy it in the target.
For software libraries this approach does make sense as the library itself is a single file. A Java library is a JAR file for example.
For applications that consists of many different types of artifacts, there are no good solutions. For such database centric applications static html pages, javascript code, database scripts, and much more must be installed and executed.

**AppContainer**

The AppContainer is using the git repository itself as deployment vehicle. On the production system a git-pull copies the latest code version into the local repository and the activation call copies the web server files and executes the database scripts.

The git-pull and the activation call can be triggered either via the UI manually or via rest calls to automate the deployment process completely.


## References

<a id="1">[1]</a> Cloudflare. "What is an identity provider (IdP)?", [link](https://www.cloudflare.com/learning/access-management/what-is-an-identity-provider/)

<a id="2">[2]</a> IETF. "RFC 7519 - JSON Web Token", [link](https://datatracker.ietf.org/doc/html/rfc7519)

<a id="3">[3]</a> Oracle. "Introduction to the Java Persistence API", [link](https://docs.oracle.com/javaee/6/tutorial/doc/bnbpz.html)
