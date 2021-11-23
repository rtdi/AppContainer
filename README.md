# Bachelor

_Continuous Integration/Continuous Delivery (CI/CD) in the context of database applications_

## Design Thinking Goal

The user is able to deploy database applications similar to CI/CD pipelines in classic software development. Must support the initial creation of a database application, non-destructive upgrade from each version at the customer, automated testing and git integration.

## Motivation

Professional software development is using CI/CD pipelines. The aim is to compile the software immediately after each code change (commit/push) and having automated tests, to validate the result is still correct. 
For a library this is pretty straight forward. For example it has a method with the signature _int multiply(int a, int b)_. Whenever that library is changed, a series of tests validate the result is the expected one.

- _assertEquals(0, multiply(0,100))_
- _assertEquals(100, multiply(1,100))_
- _assertThrows(OverflowException, multiply(10,Integer.MAX_VALUE))_
- ...

If the tests are covering all normal and edge cases, a side effect of a code change will be uncovered early.

If graphical user interfaces are involved, things get more complex. The automated tests must simulate the user input, either indirectly by calling the various widget methods or by recording user input and using that in tests. Software for that exists, too.

A different kind of problem is when the application has states. For example the user clicks on the _order_ button and one time the result is a new order being posted and another time an error message "product out of stock" is presented. Obviously the more states, the more cases must be tested.
A tpyical database application with hundreds of tables is per definition a stateful application and it has lots of combinations to test.

The naive approach would use normal CI/CD pipeline. A test run simulates the complete cycle from instantiating the database, loading data into the tables and then run the tests. That is doable for tiny projects but generally speaking has the following issues.

1. Deploying a large database application can take a long time, too long to be done at every code push.
2. The sequence of the tests matter. Example: One test orders a product and the other modifies the inventory level. Within one test that would be fine, e.g. create an order then modify this order, but such dependencies occur even between different subject areas like in the provided example.
3. Therefor tests cannot be executed in parallel unless extra care is taken. Complexity of dependencies grow exponentially.
4. If one database is used for all developers the tests must run one at a time, otherwise they interfere.
5. If each developer has its own database, the amount of resources will be immense.
6. The test would cover a fresh installation only. But customers will upgrade the application also, and not start with an empty database.
7. Hence upgrade scripts must be implemented and tested as well.
8. The customer might not upgrade to every new version but skip some. So upgrade scripts must handle different starting points.

All these issues show database application development requires more features in the CI/CD pipeline.

### Deployment of database objects

The entire problem starts with the question of how to actually deploy the database objects. The only option database vendors provide are command line interfaces to run scripts. Because there is no dependency handling, it must be one script in fact. The user must take care of everything in the script: execution order, error handling, recovery, ...
Another unsolved problem are the schema names of database objects. For enterpise grade software the application will be deployed multiple times, in a test, QA and prod database. Possibly every deveoper has his own instance of the data. The only options in database scripts is to either have fixed schema names and one database per instance, or to use no schema names anywhere and deploy all in the connected user's schema.
Both options are of limited use.
This solution should combine the flexibility of scripts with dependency handling, schema aliasing, error handling and recovery.

### Testing of database objects

A database testing suite for CI/CD does not exist either. It would need to execute SQL statements and compare the results with expected data. In many cases these results are either datasets or database specific exceptions.

### Incremental upgrade of database objects (Migration)

Scripts should also have the means of checking the current state of the database object.
This does come handy in the recovery case as well.

Example: If the table does not have a column named ORDER_STATE, then run the following script segement, else skip it.

### Documentation of database objects

While table and column comments are supported by most databases, providing entity relation ship diagrams and dependency trees does help also.

### APIs to access the data

The standard way of consuming database data in web UIs is to write individual Restful methods that read the database objects and provide the result as structure as required by the UI. In other words, the Restful service does all the transformation.
In oData the idea is to have one API which can use any kind of database object but the oData endpoint must be configured.
Both cases perform the transformations in the web application server.

In this application the transformation shall be done in the database, e.g. in procedures or views, and a single API provides access to all data. 
No configuration needed, any database object can be used.

### Documentation of the UI-Backend dependencies

Provide screens to view the ERDiagrams, dependency trees, comments and everything else that might help the users.

### Reverse engineer existing objects

Especially when using this application for the first time, existing database objects must be converted into script files. To help this process a feture to import the database structure shall exist.


## Architecture

The detailed architecture is discussed [here](docs/001 - Architecture basics.md) but essentially a Tomcat webserver with some apps is wrapped into a container and all operations are done via web technologies. The components implemented are:

- Tomcat Realms to delegate the authorization and authentication to the connected database - one realm per database type
- Swagger UI to document all Restful end points
- oData and Restful to expose database data
- Repository operation endpoints
- UIs for repository operations
- Activation logic for different types of resources (database specific)
