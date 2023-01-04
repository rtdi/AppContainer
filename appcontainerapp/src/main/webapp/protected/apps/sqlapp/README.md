# SQL App

## Goal

Build SQL select statements in a guided way with as complete support of the entire syntax as possible. Especially autocomplete must be context aware.
It should also _repair_ SQL commands, e.g. when a group by is missing for an aggregation query.
The other goal is to keep the text at condensed as possible, e.g. when a single table is selected from, the columns must not be qualified with the table name.