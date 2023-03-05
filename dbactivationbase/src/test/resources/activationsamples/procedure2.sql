// A procedure
CREATE or replace PROCEDURE PROD.proc2()
  RETURNS VARCHAR
  // return table contents
  LANGUAGE javascript
  AS
  $$
  var rs = snowflake.execute( { sqlText:
      `INSERT INTO ${alias1}.table1 ("column 1") 
           SELECT 'value 1' AS "column 1" ;`
       } );
  return 'Done.';
  $$;