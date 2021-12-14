# Repository

As explained in the [Architecture](001 - Architecture basics.md) chapter, the repository is file based on the server for better git integration.
This has multiple consequences.

1. How are two users separated so they cannot see each others files?
1. How to integrate the file permissions when the server runs under a single OS user?
1. Where do production files get deployed to, e.g. Javascript files for the UI?
1. How to deal with links when the URL must contain the user name in the URL?
1. How to integrate the database groups into the file system so one user can access files, another cannot?

## Example

Two developers create three applications, two are developed by each invidually and app3 is worked on together.
The endusers have permissions on none of the apps or on some.

On the server, each developer has its own workspace, a directory e.g. `/repo/dev1`. Within this directory the next level are the git projects, e.g. `/repo/dev1/app1`. This is linked to a git repository on the server. Therefore each developer can have multiple git projects and all developers work on different files just as git mandates. The `dev1` name is the username of the realm, the user has no way to access somebody else's file system. 

The developers checkin and checkout code on the various apps `/repo/dev1/app1`, `/repo/dev1/app3`, `/repo/dev2/app2`, `/repo/dev2/app3` via git. As git does not provide security on file level, only on repository level, each developer has full permissions in his folders.

URLs should be relative, either within the app `<a href="./page2.html">` or crossing apps `<a href="../app3/index.html">`.
This enables that the developer can see the version from within his repository `/repo/dev1`. The final production code will be in another schema, e.g. `/repo/public/app1`.

## Database scripts and schemas

For database objects this is not sufficient because one app might consists of multiple database schemas. An obvious example is a large ERP application which consists of 100s of apps. The ERP data should be central, not individual to the app. 
Similar to above this is handled via directories, e.g. `/repo/dev1/app1/db/erpschema`

A create table script located in `/repo/dev1/app1/db/erpschema` will be created in the database schema `erpschema`. The create script should not decide on the schema the table is created, this is derived from the directory name.
Which creates another problem when deploying the same application multiple times in the same database. For example when two developers want to work totally independent including the database tables or in the database is a test and QA schema.

The repository must support more - schema aliasing. 
In the root folder an optional `/repo/dev1/app1/dbalias.json` file controls the actual schema name to be used. This shall not be part of the git repository as it is developer specific (`.gitignore`!). 
It contains key-value pairs where key is the schema directory `erpschema` and the value is the actual schema to use `dev1`.
When a script in the erpschema directory is executed, the database connection changes the default schema to dev1 and runs the script.
Hence the table is created in this schema, assuming the developer has the required permissions on that schema - in this example his very own dev1 schema.

But aliases work within the scripts as well. A script with `create view sales select * from erpschema.orders;` would get changed at execution time, replacing the `erpschema` to `dev1`. 
This enables each developer to have full control about the degree of individuality (use the common schema, use a personal schema) for each schema. Also at the deployment of the application the schema assoziations can be changed if needed.

The general guideline however shall be to use schema names as they will be at deployment time and the developers alias it to their schemas if needed.

