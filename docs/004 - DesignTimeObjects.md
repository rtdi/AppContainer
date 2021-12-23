# Design Time Objects

## Current state

The only option database vendors provide for creating database objects are command line interfaces to run scripts. Because there is no dependency handling between scripts, all must be one script and the user must take care of everything in the script: execution order, error handling, recovery, ...
Another unsolved problem are the schema names of database objects. For enterprise grade software the application will be deployed multiple times, in a test, QA and prod database. Possibly every developer has his own instance of the data. The only options in database scripts is to either have fixed schema names and one database per instance, or to use no schema names anywhere and deploy all in the connected user's schema.
Both options are of limited use.
This solution should combine the flexibility of scripts with dependency handling, schema aliasing, error handling and recovery.

## Options

Users create database objects via either of the following methods:

- [x] Option 1: SQL Scripts. Running a list of SQL commands from a single file sequentially which creates all objects.
- [ ] Option 2: SQL Tools. These tools have screens to define the tables one by one using a graphical editor.
- [ ] Option 3: Data Modeling Tools. These tools allow to create logical and physical data model and derive the SQL commands in the database vendor dialect.
- [x] Option 4: Activation logic. The database is considered the backend for actual object classes, hence given the class definition the required data model to store all data can be derived.

Each of those approaches have their pros and cons, primarily around ease of use, database portability and database vendor specific SQL options.

Example: A table should have 10 columns, a primary key, multiple foreign keys, partitioning information and extra indexes with their individual settings. This is certainly no problem for purpose built SQL scripts, however if the script fails the database is in no determined state. Running the script again will likely fail. the other options have some capability to add database specific information but usually tend to stick to the basic SQL syntax to help portability of the code.

The enable CI/CD no manual work is possible during the activation and it must be complete. Complete in the sense of "exactly as it will be used in production". Therefor adding database specific syntax is a must.

The first supported creation method is Option 1, SQL Scripts. But not as one script that does it all but a directory tree which is executed in order. Parent nodes first, child nodes second, within a directory all objects are executed sorted by name. As there might be dependencies with other schema objects, an additional link to directories which must be executed before must be possible as well.

For table contents insert statements would be okay but a first step towards Option 4 is possible as well. Activating CSV files means loading the data into the table with the same name.


## Implementation

Goal: Use a git repo and activate the database objects. All separation of concerns must be possible, individually per object.

Summary:

1. A repository should have a directory level with the schema names as used in production, e.g. STAGING, DWH, DATA, ...
1. Within each of this schema directories create a tree of directories to manage the dependencies, e.g. 01-tables, 02-views. When activating objects the scripts/directories are executed sorted by name.
1. All schema references to this schema use `${CURRENTOWNER}`.
1. All references to other schemas, e.g. a script in DATA must access STAGING is using `${STAGING}`.
1. Optionally a `.globalmapping` file in the root directory translates these into the pyhsical names, e.g. STAGING -> DEV_STAGING. This file must be added to .gitignore.


### Separation of concerns

In a large project multiple developers work together in parallel and the code is deployed in the development system, test and production.
Dev, test, prod are usually different databases or different servers so there is no immediate problem at deployment, except that maybe the schema names are different.
The developers themselves have two contradicting requirements. On the one hand they want to use what other team members created, but they do not want to be impacted by work-in-progress database objects of others. All objects in the shared development database must be usable by others and pure local testing should happen in the developers own schema.

As a more technical statement, in scripts the schema must be parameterized. Which schema to use is decided at deploy-time.

Separation of concerns are:

- Every developer is 100% independent, all objects are activated in his personal schema
- One database supports deploying the same artifacts but in different schemas
- Objects are in the same schema no matter who is using them

As a further complication, multiple schemas are used to group database objects and for security reasons. This allows for multiple approaches.

1. No schema: The create table simply does not specify any schema `create table orders (...`. At deploy time the table is created in whatever schema is configured as the current session schema of that user.
1. Explicitly use a schema: Then the create table would look like `create table data.orders (...`. If executed, the schema is hard coded and cannot be changed at deployment. Bad idea.
1. Parameterize the schema: When this appcontainer sees the text `${any_schema_name}` it assumes this schema name is an alias and replaces the parameter with the actually configured schema for each alias. `create table ${staging}.orders (...` and `${staging}` being mapped to `DEV_STAGING_AREA` would create a table DEV_STAGING_AREA.ORDERS.
1. Parameterize the schema with ${CURRENTOWNER}: This alias maps the schema to where the script is located. So it specifies a schema (unlike in 1.), hence does not rely on the session schema settings but creates the object in a schema with the same name as the connected database user name.

This approach allows to work with multiple schemas, e.g. `create view ${monitor_schema}.status as select * from ${staging_area}.load_status`.


#### Configure the schema mappings

Each git repository can have a file at root level named `.globalmapping`. It is a Json file in the format:

```
{
	"mappings" : {
		"alias1" : "dbschema1",
		"alias2" : "dbschema2",
		...
		...
	}
}
```

and contains the alias and actual schema pairs. This file will be different for each cloned repository, thus must be in `.gitignore`. 

When the deployment process is executed, the scripts are parsed and all textual occurrences of an alias gets replaced with the actual name according to above file. In case an alias is missing, the deployment process stops with an error.

Important: The SQL script processor does not understand the SQL statements, otherwise it would be too version dependent. It understands the basic script syntax, what is a line comment, a block comment, a string constant, a line comment within a SQL statement but not the actual SQL syntax as such. As result a `create table "${schema1}"."TABLE1" (...` replaces the `${schema1}` part of the string thus preserving the double quotes. A comment like `// Use ${schema1}` is left untouched.


#### CURRENTOWNER and files without schema

For SQL scripts specifying a schema is no problem - it is part of the file content. But there are other files that do not have that option, e.g. a CSV file to load static data into a table. Where to specify the schema/alias for that? The answer is simple, it is using the CURRENTOWNER semantic the SQL scripts allow for as well. Leaves the question of what the value for this variable is.

The directory structure of database artifacts should have the target schema as first level. This is used as CURRENTOWNER and modified by the globalmapping.

Example:

[ ] developer1: The root directory of the currently logged in user. This is where the git repo is cloned into.
    [ ] STAGING: All objects meant for the production schema STAGING go in this directory. So STAGING is the value of the CURRENTOWNER.
        [ ] ORDER_STATUS.csv: The table STAGING.ORDER_STATUS should contain the data of this file.
        [ ] views.sql: A script that creates multiple views. It can use ${CURRENTOWNER} but does not have to.
    [ ] DWH: All objects meant for the production schema DWH go in this directory. So DWH is the value of the CURRENTOWNER.
        [ ] objects.sql: A script that creates all/some database objects. It can use ${CURRENTOWNER} but does not have to and the value would be DWH.

As with all other schema names, the actual schema is derived using the `.globalmapping` file. So if there is an alias for `DWH` to use the actual schema `DEV_DWH` this will be the actual value of CURRENTOWNER.


### Activation Order

In a large project there will always dependencies.

- One script creates the main ERP tables
- Another script adds module specific tables
- View require the tables to exist already
- Same with procedures, synonyms and other objects

Another issue arises if the dependencies would be activated automatically. One the one hand it makes it more secure to activate the dependent objects always, yet that would also mean every activation of a leaf objects triggers the activation of pretty much the entire database. Even if the user does not have the permissions in the database to do so.
Hence the only useful approach is to decide at activation time the scope: single script, single directory, root directory, ... and all within gets activated but not the dependencies outside that scope.

And how can dependencies be defined?

- [ ] Option 1: Anaylse the script contents and build a dependency tree
- [x] option 2: The directory structure represents the dependency tree.
- [ ] Option 3: Every file lists the dependencies in the header on object level
- [ ] Option 4: Every file lists the dependencies in the header by linking to other directories
- [x] Option 5: The developer can add an optional file with the dependent directories in a directory

While Option 1 would certainly be the most convenient method, it would require a parser which understands 100% of the database syntax. Also, it does not encourage users to watchout for activation loops, where one object does depend directly or indirectly on another object which in turn depends on the first.

Deriving all only from the directory structure does not work either as a module does depend on the script with the base tables and both are logically at the same level. A module is an addon, not necessarily a sub component. While the directory structure will suffice often, it is not always enough. Option 5 is needed also.

If one directory does have a file `.requires` all directories listed in there will be activated first. If the requires file points to a directory that is outside the activation scope, it is ignored.
Then all files of the current directory are retrieved and sorted by name. Within each directory the files are sorted and activated.
Therefore the dependencies can be managed by directory naming, naming of the files the `.requires` file or any combination of that.

The structure of the `.requires` file:

```
{
	"requires" : [
		"../tables",
		"/staging",
		...
		...
	]
}
```

