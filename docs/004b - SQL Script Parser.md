# SQL Script Parser

SQL Scripts are very similar, e.g. `create table test1 (col1 varchar(10));` is a statement every database understands.

Differences are in

- Command termination char: ;, [go]
- Begin-End blocks supported
- Procedure body
- Supported SQL commands and command variations
- Variables and parameters
- Data types

So the question is how to parse the SQL scripts without falling behind new syntax options always.

 - [ ] Option 1: The ANTLR parser is the defacto standard for parsing. It allows defining syntax rule files and generates the parsing code from that. For a full parser which understands every single option, this is the best alternative.
 - [x] Option 2: Implement a parser manually which looks at the rough structure only. It must not understand the SQL commands in detail, only where a SQL command starts and ends and this SQL text is then sent to the database for execution.
 - [ ] Option 3: Do not parse the SQL script but use textual replacement for schema aliases and variables.
 
Option 1 is certainly the best and most flexible option but will require to stay on par with each of the supported databases. In some cases the parser will even need to consider the database version to tell which syntax variant to use.
The worst thing that can happen is when a customer has a script which he knows works with the database tools but cannot be used by the appcontainer because of the parser.

Option 3 as the other extreme is too dangerous. Schema aliases and variables are not unique enough to guarantee they do not collide with normal text within a script. 

Hence Option 2 seems to be the best option from a cost/benefit point of view.

## Parsing classes

As the sql script has lots of commonalities, the [dbactivationbase](../dbactivationbase/src/main/java/io/rtdi/appcontainer/plugins/activation/SQLParser.java) module contains the common code.
The corresponding database specific module (e.g. [Snowflake](../dbactivationsnowflake/src/main/java/io/rtdi/appcontainer/plugins/databasesnowflake/SnowflakeActivationSyntax.java)) configures this base class and handles additional custom syntax.

