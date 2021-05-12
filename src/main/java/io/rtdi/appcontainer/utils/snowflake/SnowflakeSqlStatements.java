package io.rtdi.appcontainer.utils.snowflake;

public class SnowflakeSqlStatements {

	public static final String SNOWFLAKE_SQL_ALL_OBJECTS = "select table_schema as schema_name, table_name as object_name, "
			+ "case when table_type = 'BASE TABLE' then 'TABLE' else table_type end  as object_type "
			+ "from information_schema.tables "
			+ "where table_schema = 'DATA' order by table_schema, table_name";
}
