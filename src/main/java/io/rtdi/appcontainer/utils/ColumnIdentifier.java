package io.rtdi.appcontainer.utils;

import java.sql.Connection;
import java.sql.SQLException;

import io.rtdi.appcontainer.designtimeobjects.GlobalSchemaMapping;

public class ColumnIdentifier {
	private String schemaname;
	private String objectname;
	private String columnname;

	public ColumnIdentifier(Connection conn, String columnidentifier, GlobalSchemaMapping gm) throws AppContainerSQLException {
		
		if (columnidentifier != null && columnidentifier.length() > 0) {
			String defaultschema;
			try {
				defaultschema = conn.getSchema();
			} catch (SQLException e) {
				throw new AppContainerSQLException("Cannot read the schema from the database driver", null);
			}
			String[] parts = columnidentifier.split("\\.");
			if (parts.length > 2) {
				schemaname = gm.getActualSchema(parts[0], defaultschema);
				objectname = parts[1];
				columnname = parts[2];
			} else if (parts.length > 1) {
				schemaname = defaultschema;
				objectname = parts[0];
				columnname = parts[1];
			} else {
				throw new AppContainerSQLException("Provided column identifier has no object name", null);
			}
		} else {
			throw new AppContainerSQLException("Provided column identifier is empty", null);
		}
	}

	public String getObjectname() {
		return objectname;
	}

	public String getSchemaname() {
		return schemaname;
	}

	public String getColumnname() {
		return columnname;
	}
	
}
