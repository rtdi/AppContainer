# Assumptions

Users will have SQL scripts already, hence the requirement is to support the syntax of these without any modifications.
At the same time, 100% of the syntax must be supported.

The scripts will likely not contain migration logic and error handling, both important during migrations.

For example some databases support a syntax `create or replace view...` which prevents an error when the view already exists but it will also create the view again, invalidating all dependent objects in the database, even if the view did not change. This is no problem for databases as such script is executed only occasionally but in a CI/CD environment this happens multiple times a day.

For tables no database has a syntax like "If the column xyz does not exist yet, then add it".

The scripting capabilities must be enhanced by such conditionals without breaking the script syntax.

## Activating SQL scripts

The requirements of a SQL script are

1. If the object does not exist, create the most recent version.
1. If the object does exist already, alter it to get to the most recent version.
1. If possible alter objects in a none-destructive way, e.g. just because a table with millions of records should get an additional column, dropping and recreating the table is mighty expensive.
1. If the script fails with an error, the execution stops. Hence it shall never fail. It must be embedded inside proper boiler-plate code.

The developer has the choice what to use:

### create-or-replace

A script using the `create or replace table (...` syntax is safe. If the table does not exist, it will be created. And if it does exist, it will get replaced with the new version. Downside of this approach is that all data is gone and objects depending on this table might get invalidated.

### create-latest-if-not-exists and add-column-if-not-exists

If the table is created only in case it does not exist, else the table is altered to get the current structure from any previous version, the script adheres to all four rules.
There is just one tiny problem: Such SQL commands do not exist. A line comment in the form of `// if object not exists SCHEMA1.OBJECT1` tells to execute or skip the next SQL block.

### create-v1-if-not-exists and add-column-if-not-exists

The downside of above script is that all table modifications must be done at two places, the create table command and the upgrade part of the script.
The alternative is to keep the create table command unchanged and just alter the table.
If a fresh install is common, Option 2 makes more sense, especially if the upgrade sequence has breaking/incompatible changes. If the number of versions is small, Option 3 sounds like the better one. The line comments help for that as well.


### SQL Script capabilities

A SQL script is something that is pre-parsed and executed. It is parsed for the basic SQL syntax but not for the commands as such to make as little assumptions as possible about the commands.

The basic building blocks are

- Line Comments: `// This is a comment`
- Block Comments: `/* This is a block comment */`
- SQL Text: `create ....;`
- Aliases: `create table "${schema1}".ORDERS .... ;`
- Variables: `...col1 varchar(5) default '&unknown',...`

This allows to create sql scripts that have comments, use any database supported commands (as they are not parsed but sent as-is to the database) plus allows to deploy the same script into different database schemas due to the aliasing.
Variables can be defined to standardize values, e.g. instead of specifying a default to_date everywhere, a variable with the value `&max_date_value` is defined once and used everywhere.

Note: Escape character is `\`, e.g. `\$` would ensure the dollar char is not considered as alias start character.

Line comments in the form of `if {object | column} [not] exists {object_identifier | column_identifier}` cause all subsequent SQL statement to be either executed or skipped until the if is closed using a `// endif` or another if comment.
Nesting of if's is not supported.

Examples for such line comments are:

- `// if object exists MYSCHEMA.MYTABLE`
- `// if object not exists MYSCHEMA.MYTABLE`
- `// if column exists MYSCHEMA.MYTABLE.COLUMN1`
- `// if column not exists MYSCHEMA.MYTABLE.COLUMN1`
- `// if column not exists MYTABLE.COLUMN1`
- `// if column not exists CURRENTSCHEMA.MYTABLE.COLUMN1`
- `// if column not exists ${schema1}.MYTABLE.COLUMN1`
- `// endif`



#### Aliasing

As a database developer the CI/CD scripts are used in various scenarios. 

- The developer creates all objects in his private database schema to avoid any interferences with other users or the official build.
- One CI/CD pipeline tests the creation of all objects in an empty schema.
- Another pipeline tests the upgrade logic using yet another schema.
- Test and Prod might be different database schemas again.

One option to support that is to never specify a schema in any sql scripts. Instead of `create table PROD.ORDERS (...);` no schema is specified `create table ORDERS (...);`.
This works well in scenarios where every user, and test & prod are just different users again, is 100% separated.

For large development projects the result of that would be that each of the 100s of the developers has the full database populated with all the 1000s of tables and GB data. Just in case if somebody does a breaking change.

More often it will be a mixture. Very few development objects are locally but there are shared schemas containing the DEV/TEST/PROD objects. When the developer creates a view, he must specify the schema hence but which? He would specify the schema `${maindb}` and define his mapping from aliases to the actual schema to use. When the code is deployed in TEST or PROD, each of those have individual alias mappings.

Such strings `${alias}` are replaced in SQL text, when inside double quotes or single quotes. Comments are left untouched.
