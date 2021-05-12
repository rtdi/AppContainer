package io.rtdi.appcontainer.utils.hana;

public class HanaSqlStatements {

	public static final String HANA_SQL_ALL_OBJECTS = "select schema_name, object_name, object_type from objects\r\n" + 
			"where object_type in ('TABLE', 'VIEW') and schema_name = ? order by schema_name, object_name";
	
}
