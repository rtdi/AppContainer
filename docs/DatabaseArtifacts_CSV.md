## Loading static data

Some tables are not loaded from a source system but contain static data. The table with the list of supported languages has no source and should contain the values for 'EN' and 'FR' and 'DE'.

While this can be done using SQL DML statements, it is possible to define CSV files for that as well. The CSV import can either truncate the table and load all data of the CSV file or modify individual subsets of data.