# Testing

The testing suite should be modeled after JUnit5, so have methods to execute database commands with input and compare the result.
While scalar comparisons do make sense, a more common comparison will be on data set level.

Examples:

- create 10 orders --> is the overall order value of these orders 100USD
- create 10 orders --> does the order table and line item table have the following records?

An added complexity stems from the fact that database operations cannot be undone always and in all cases. This impacts triggers, sequences, auto-increment columns and potentially every stored procedure. 
Instead of making any assumptions in that area, the better option is to design the testing framework with this requirement from the start.

Example:

 - The procedure CREATE_ORDER does insert records in the ORDER_HEADER and ORDER_DETAIL table but also in five more tables for billing, manufacturing, stock reservation.
 - The inverse operation is the CANCEL_ORDER which updates the ORDER_HEADER column STATUS to cancelled. Stock reservations are undone, a subsequent stock replenish action is kept.
 - The provided customer order number must be unique, so it cannot be reused in the next order.
 - The internal ORDERID is automatically incremented and will be different always, hence.
 

Therefore an assertEquals method must allow to read the start value, execute the database operation with provided input, compare the output with a desired result but the comparison is order-insensitive and not all columns must be compared.

## Implementation options

To achieve all a balance between simplicity and flexibility must be attained.

 - [ ] Option 1: Tests as SQL scripts: The user writes SQL scripts and therefore has the full power to select data from the database, store the current values, compare result with expected data via set operations (MINUS or INTERSECT). But he must do all by himself and probably store all testing data in the database. Maybe even implement the tests as stored procedure in their own right.
 - [ ] Option 2: Provide typical asserts with CSV files as input and expected result. This allows to execute the SQL code without the need to create any new object inside the database.
   - [ ] Option 2a: As single commands: The test can execute a single SQL statement, e.g. execute a procedure with input and compare its output. Data is prepared using the SQL script parser of the activation.
   - [x] Option 2b: As script: Invent a syntax with variables to pass into SQL commands, assign variables to the output of SQL commands and asserts statements.
 - [ ] Option 3: Use any easy to use programming language to write the tests, e.g. Python. Would have the most options and is easy to implement but has another dependency and requires coding experience from the end user. Integration will be harder and the question will be why using the appcontainer for such.
 
Option 3 would be an easy way out as it delegates all work to the end user. Only a rest API to run the program would be needed. It has security concerns however as the appcontainer runs within the data center and the test program can do everything including network scans.

Option 1 should be supported but is not enough by itself. Scripts that throw an error can be built but what is the method to compare the result and throw an exception in case of a difference? What if the test must validate an error is thrown (assertThrows)?

Option 2a is too limited. For a test case a set of actions must be taken to setup the test case and then a sequence of tests is performed followed by a tear down.

That leaves only option 2b.

## Test script syntax

A test script should consist of JUnit5 like annotations and methods with code blocks. The methods have a very basic syntax of variable assignments, SQL calls and assertions. The parser should be easy enough to implement without the need to use ANTLR.

Example 1:

```
@Test
void test1() {
    assertNotNull('select sum(amount) from orders where sales_region = ? and customer = ?', 'US', 894332);
}
```

Example 2:

```
@ParameterizedTest
@CsvFileSource(files = '/two-column.csv', numLinesToSkip = 1)
void testWithCsvFileSourceFromClasspath(country, customer) {
    assertNotNull("select sum(amount) from orders where sales_region = ? and customer = ?", country, customer);
}
```

### Annotations

Methods are annotated with useful combinations of the following keywords

 - @BeforeEach
 - @AfterEach
 - @BeforeAll
 - @AfterAll
 - @Test
 - @ParameterizedTest
 - @CsvSource({..})
 - @CsvFileSource(files = .., numLinesToSkip = ..)
 - @VariableSource(..)
 - @Tag
 - @Disabled(..)
 - @Timeout(..)

### Variable declaration

Variables can be defined in the script body (global variables), as method parameters or within methods, all with their scope.
Global variables can be used everywhere but modified only in @BeforeAll and @BeforeEach.

Example: Create multiple orders using a stored procedure, CREATED_ORDERS contains an array of the create_order() procedure output

```
var CREATED_ORDERS;

@BeforeAll
@CsvSource(files = .., numLinesToSkip = 1)
void setup(num, cust, mat, qty) {
    CREATED_ORDERS += execute('call create_order(?,?,?,?)', num, cust, mat, qty);
}
```

### Commands

 - SQLQuery(..)
 - readCSV(..)
 - assertEquals(..)
 - assertNotEquals(..)
 - assertNull(..)
 - assertNotNull(..)
 - assertTrue(..)
 - assertFalse(..)
 - assertThrows(..)
 - assertDoesNotThrow(..)

### Operators

 - Math operators: +, -, *, /
 - Comparison: ==, !=, >, <, >=, <=
 - Unary: !
 - table row/column access: [..]


