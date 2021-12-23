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

## Database schemas

A database application might consists of multiple database schemas. An obvious example is a large ERP application which consists of 100s of modules. The ERP data must be central, not copied per module. 
This schema specification is handled via directories in the repository, e.g. `/repo/dev1/app1/db/erpschema` where `erpschema` is one database schema.

A create table script located in `/repo/dev1/app1/db/erpschema` will be created in the database schema `erpschema`. The create script should not decide on the schema the table is created, this is derived from the directory name.
Which creates another problem when deploying the same application multiple times in the same database. For example when two developers want to work totally independent including the database tables or in the database is a test and QA schema.

The activation process must support more - schema aliasing. 
In the root folder an optional `/repo/dev1/app1/dbalias.json` file controls the actual schema name to be used. This shall not be part of the git repository as it is developer specific (`.gitignore`!). 
It contains key-value pairs where the key is the schema directory `erpschema` and the value is the actual schema to use `dev1`.
When a script in the erpschema directory is executed, the database connection changes the default schema to dev1 and runs the script.
Hence the table is created in this schema, assuming the developer has the required permissions on that database schema - in this example his very own dev1 schema.

But aliases work within the scripts as well. A script with `create view sales select * from erpschema.orders;` would get changed at execution time, replacing the `erpschema` to `dev1`. 
This enables each developer to have full control about the degree of individuality (use the common schema, use a personal schema) for each schema. Also at the deployment of the application the schema assoziations can be changed if needed.

The general guideline however shall be to use schema names as they will be at deployment time and the developers alias it to their schemas if needed.

## Dependencies

In a large project there will always dependencies.

- One script creates the main ERP tables
- Another script adds module specific tables
- View require the tables to exist already
- Same with procedures, synonyms and other objects

Another issue is if the dependencies should be activated automatically. One the one hand it would make it more secure to activate the dependent objects always, yet that would also mean every activation of a leaf objects triggers the activation of pretty much the entire database. Even if the user does not even have the permissions in the database to do so.
Hence the only useful approach is to decide at activation the scope, single script, single directory, root directory, ... and all within gets activated but not the dependencies outside that scope.

And how can dependencies be defined?

- [] Option 1: Anaylse the script contents and build a dependency tree
- [x] option 2: The directory structure represents the dependency tree.
- [] Option 3: Every file lists the dependencies in the header on object level
- [] Option 4: Every file lists the dependencies in the header by linking to other directories
- [x] Option 5: The developer can add an optional file with the dependent directories in a directory

While Option 1 would certainly be the most convenient method, it would require a parser which understands 100% of the database syntax. Also, it does not encourage users to watchout for activation loops, where one object does depend directly or indirectly on another object which in turn depends on the first.

Deriving all only from the directory structure does not work either as a module does depend on the script with the base tables and both are logically at the same level. A module is an addon, not necessarily a sub component. While the directory structure will suffice often, it is not always enough. Option 5 is needed also.

## Conclusions

The developer is completely free in defining a directory structure in the repository. There will be the natural tendency to structure the objects in a natural way, e.g. `001 - table scripts`, `002 - view scripts`, ... and the dependency will be built based on the sorted directory/file names.
If a dependency must be added to a directory in a parallel path, the developer creates a file `.requires.json` and lists all directories (their root directory only) that should be activated before.

Example:

- `ERP`
- `ERP/db/erpschema/001 - create tables/...` contains all scripts that create the ERP tables
- `ERP/db/erpschema/002 - create views/...` contains all scripts that create the ERP views and is executed after `001 - create tables`
- `app1/db/sales/001 - create views/...` adds views that are app dependent
- `app1/db/sales/.requires.json` contains the information that `ERP/db/erpschema` is used by app1

When the activation is started for all, then the ERP tables are created first, followed by the views and app1 views later. 
If the activation is started on the app1 directory, only the app1 scripts are executed and it is assumed the ERP scripts had been executed already and are current.

Using these two options the developer can define dependencies easily and in a natural manner without being limited. Either the dependency comes naturally from the directory tree or is specified explicitly.

Note: If directories are moved the `.requires.json` will likely not be altered or checked.

