# Design Time Objects

Users create database objects via either of the following methods:

- [x] Option 1: SQL Scripts. Running a list of SQL commands from a single file sequentially which creates all objects.
- [ ] Option 2: SQL Tools. These tools have screens to define the tables one by one using a graphical editor.
- [ ] Option 3: Data Modeling Tools. These tools allow to create logical and physical data model and derive the SQL commands in the database vendor dialect.
- [x] Option 4: Activation logic. The database is considered the backend for actual object classes, hence given the class definition the required data model to store all data can be derived.

Each of those approaches have their pros and cons, primarily around ease of use, database portability and database vendor specific SQL options.

Example: A table should have 10 columns, a primary key, multiple foreign keys, partitioning information and extra indexes with their individual settings. This is certainly no problem for purpose built SQL scripts, however if the script fails the database is in no determined state. Running the script again will likely fail. the other options have some capability to add database specific information but usually tend to stick to the basic SQL syntax to help portability of the code.

The enable CI/CD no manual work is possible during the activation and it must be complete. Complete in the sense of "exactly as it will be used in production". Therefor adding database specific syntax is a must.
