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
