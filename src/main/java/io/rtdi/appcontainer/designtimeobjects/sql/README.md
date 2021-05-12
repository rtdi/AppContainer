## SQL Script capabilities

A SQL script is something that is pre-parsed and executed. It is parsed for the basic SQL syntax but not for the commands as such to make as little assumptions as possible about the commands.

The basic building blocks are

- Line Comments: `// This is a comment\n`
- Block Comments: `/* This is a block comment */`
- SQL Text: `create ....;`
- Aliases: `create table "${schema1}".ORDERS .... ;`
- Variables: `...col1 varchar(5) default '&unknown',...`

This allows to create sql scripts that have comments, use any database supported commands (as they are not parsed but sent as is to the database) plus allows to deploy the same script into different database schemas due to the aliasing.
Variables can be defined to standardize values, e.g. instead of specifying a default_to_date everywhere, a variable with the value `&max_date_value` is defined once and used everywhere.

Note: Escape character is `\`, e.g. `\$` would ensure the dollar char is not considered as alias start character.

### Aliasing

As a database developer the CI/CD scripts are used in various scenarios. 

- The developer creates all objects in his private database schema to avoid any interferences with other users or the official build.
- One CI/CD pipeline tests the creation of all objects in an empty schema.
- Another pipeline tests the upgrade logic using yet another schema.
- Test and Prod might be different database schemas again.

One option to support that is to never specify a schema in any sql scripts. Instead of `create table PROD.ORDERS (...);` no schema is specified `create table ORDERS (...);`.
This works well in scenarios where every user, and test & prod are just different users again, is 100% separated.

For large development projects the result of that would be that each of the 100s of the developers has the full database populated with all the 1000s of tables and GB data. Just in case if somebody does a braking change.

More often it will be a mixture. Very few development objects are locally but there are shared schemas containing the DEV/TEST/PROD objects. When the developer creates a view, he must specify the schema hence but which? He would specify the schema `${maindb}` and define his mapping from aliases to the actual schema to use. When the code is deployed in TEST or PROD, each of those have individual alias mappings.

Such strings `${alias}` are replaced in SQL text, when inside double quotes or single quotes. Comments are left untouched.