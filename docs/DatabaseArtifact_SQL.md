## Activating SQL scripts

The requirements of a SQL script are

1. If the object does not exist, create the most recent version.
1. If the object does exist already, alter it to get to the most recent version.
1. If possible alter objects in a none-destructive way, e.g. just because a table with millions of records should get an additional column, dropping and recreating the table is mighty expensive.
1. If the script fails with an error, the execution stops. Hence it shall never fail. It must be embedded inside proper boiler-plate code.


### Option 1: create-or-replace

A script using the `create or replace table (...` syntax is safe. If the table does not exist, it will be created. And if it does exist, it will get replaced with the new version. Downside of this approach is that all data is gone and objects depending on this table might get invalidated.

### Option 2: create-latest-if-not-exists and add-column-if-not-exists

If the table is created only in case it does not exist, else the table is altered to get the current structure from any previous version, the script confirms to all four rules.
There is just one tiny problem: Such SQL commands do not exist. A stored procedure is written that accomplishes that and called in the script.

### Option 3: create-v1-if-not-exists and add-column-if-not-exists

The downside of above script is that all table modifications must be done at two places, the create table command and the upgrade part of the script.
The alternative is to keep the create table command unchanged and just alter the table.
If a fresh install is common, Option 2 makes more sense, especially if the upgrade sequence has breaking/incompatible changes. If the number of versions is small, Option 3 sounds like the better one.

