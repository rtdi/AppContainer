package io.rtdi.appcontainer.utils;

import java.sql.Connection;
import java.sql.SQLException;

import io.rtdi.appcontainer.designtimeobjects.GlobalSchemaMapping;

public class ObjectIdentifier {
	private String schemaname;
	private String objectname;

	public ObjectIdentifier(Connection conn, String objectidentifier, GlobalSchemaMapping gm) throws AppContainerSQLException {
		
		if (objectidentifier != null && objectidentifier.length() > 0) {
			String defaultschema;
			try {
				defaultschema = conn.getSchema();
			} catch (SQLException e) {
				throw new AppContainerSQLException("Cannot read the schema from the database driver", null);
			}
			String[] parts = objectidentifier.split("\\.");
			if (parts.length > 1) {
				schemaname = gm.getActualSchema(parts[0], defaultschema);
				objectname = parts[1];
			} else {
				schemaname = defaultschema;
				objectname = parts[0];
			}
		} else {
			throw new AppContainerSQLException("Provided object identifier is empty", "");
		}
	}

	public String getObjectname() {
		return objectname;
	}

	public String getSchemaname() {
		return schemaname;
	}
	
}
