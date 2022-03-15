# Testing

The testing suite should be modeled after JUnit5, so have methods to execute database commands with input and compare the result.
While scalar comparisons do make sense, a more common comparison will be on data set level.

Examples:

- create 10 orders --> is the overall order value of these orders 100USD?
- create 10 orders --> does the order table and line item table have the following records?

An added complexity stems from the fact that database operations cannot be undone always and in all cases. This impacts triggers, sequences, auto-increment columns and potentially every stored procedure. 
Instead of making any assumptions in that area, the better option is to design the testing framework with this requirement from the start.

Examples of cases where an oepration cannot be completely reset:

 - The procedure CREATE_ORDER does insert records in the ORDER_HEADER and ORDER_DETAIL table but also in five more tables for billing, manufacturing, stock reservation.
 - The inverse operation is the CANCEL_ORDER which updates the ORDER_HEADER column STATUS to the value of 'I' for inactive. Stock reservations are undone, a subsequent stock replenish action is kept however.
 - The provided customer order number must be unique, so it cannot be reused in the next order.
 - The internal ORDERID sequence is automatically incremented and will be different always, hence.
 

Therefore an assertEquals method must allow to read the start value, execute the database operation with provided input and compare the output with a desired result. The comparison must be order-insensitive and not all columns must be compared.

## Implementation options

To achieve all, a balance between simplicity and flexibility must be attained.

 - [ ] Option 1: Tests as SQL scripts: The user writes SQL scripts and therefore has the full power to select data from the database, store the current values, compare result with expected data via set operations (MINUS or INTERSECT). But he must do all by himself and probably store all testing data in the database. Maybe even implement the tests as stored procedure in their own right.
 - [ ] Option 2: Provide typical asserts with CSV files as input and expected result. This allows to execute the SQL code without the need to create any new object inside the database.
   - [ ] Option 2a: As single commands: The tests can execute single SQL statements, e.g. execute a procedure with input and compare its output. Data is prepared using the SQL script parser of the activation.
   - [x] Option 2b: As script: Invent a syntax with variables to pass into SQL commands, assign variables to the output of SQL commands and asserts statements.
 - [x] Option 3: Use any easy to use programming language to write the tests, e.g. Python. Would have the most options and is easy to implement but has another dependency and requires coding experience from the end user. Integration will be harder and the question will be why using the appcontainer for such.
 
Option 3 would be an easy way out as it delegates all work to the end user. Only a rest API to run the program is needed. It has security concerns however as the appcontainer runs within the data center and the test program can do everything including network scans. And the usability is compromised unless there are comparison methods for tables.

Option 1 should be supported but is not enough by itself. Scripts that throw an error can be built but what is the method to compare the result and throw an exception in case of a difference? What if the test must validate an error is thrown (assertThrows)?

Option 2a is too limited. For a test case a set of actions must be taken to setup the test case and then a sequence of tests is performed followed by a tear down.

That leaves only option 2b and option 3, if the security concerns can be handled.

## Embed GraalVM JavaScript into Tomcat

The idea of the GraalVM project is to separate the programming language from the execution. No matter which programming language is being used, at compile time it gets translated into JVM instructions. 
Thus Java is just one language to be compiled. The interesting part is that GraalVM has a compiler for Javascript and this script engine can be hosted inside Java.

The result is that Java can execute scripts written in the Javascript language and the hosting Java can interact with the script in both ways. It can provide functionality to the script and it can read objects from the executed script.

This solves multiple problems:

1. The script syntax is not yet another invention specific to this appcontainer but a standardized language - ECMAScript. It is simple enough to learn for such simple test cases and also very popular.
2. Additional commands are made available to the script, in particular the `db` object. The command `db.query('select * from INFORMATION_SCHEMA.TABLES')` returns a [TableValue](https://git.sbg.ac.at/s1080660/bachelor/-/blob/main/dbactivationbase/src/main/java/io/rtdi/appcontainer/dbunittest/value/TableValue.java) object that represents a result set. This allows interaction with the database in a secure and easy to use way.
3. With the GraalVM ScriptEngine the security settings can be controller selectively. Which classes and methods of the host are accessible - almost none. What directories, if at all, are accessible. see [Security Guide](https://www.graalvm.org/22.0/security-guide/) of GraalVM.
4. Implementation of the basic functionality of any script like assigning variable values, calling functions, ... is all available out of the box.

In essence, using JavaScript embedded inside the Tomcat JVM, combines the advantages of Option 3 and Option 2b. The additional test functionality for databases is implemented in the Java host and the scripting benefits from the power of JavaScript. 
