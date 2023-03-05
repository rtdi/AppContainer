// if object exists CURRENTSCHEMA.TABLE_EXISTS
  // if column not exists CURRENTSCHEMA.TABLE_EXISTS.NO_SUCH_COLUMN
      alter table TABLE_EXISTS add column (NO_SUCH_COLUMN decimal(5,4));
  // end if
// end if
create or replace view V_TABLE_EXISTS
  select * from TABLE_EXISTS;
