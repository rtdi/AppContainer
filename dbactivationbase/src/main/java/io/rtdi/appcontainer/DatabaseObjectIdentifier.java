package io.rtdi.appcontainer;

import java.sql.SQLException;
import java.util.Locale;

import io.rtdi.appcontainer.plugins.activation.GlobalSchemaMapping;

public class DatabaseObjectIdentifier {
	String schema;
	String object;
	
	public DatabaseObjectIdentifier(String identifier, GlobalSchemaMapping gm) throws SQLException {
	    String[] parts = identifier.split("\\.(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
    	/*
    	 * An object identifier can be either the object itself or schema.object
    	 */
    	if (parts.length == 1) {
    		object = getObject(parts[0]);
    	} else if (parts.length == 2) {
    		schema = getSchema(parts[0], gm);
    		object = getObject(parts[1]);
    	} else {
			throw new SQLException("An object identifier can be either <name> or <schema>.<name> but the provided identifier is \"" + identifier + "\"");
    	}
	}

	public static String getObject(String part) {
    	if (part.charAt(0) == '\"' && part.charAt(part.length()-1) == '\"') {
    		return part.substring(1, part.length()-2);
    	} else {
    		return part.toUpperCase(Locale.ROOT);
    	}
	}

	/**
	 * Expects either a schema, a quoted schema or an alias and returns the schema name.
	 * 
	 * @param part the identifier part
	 * @return the schema, which is either retrieved from the alias or the part converted to uppercase or the part itself
	 * @throws SQLException if there is no .globalmapping file or the alias is unknown or the schema is not valid
	 */
	public static String getSchema(String part, GlobalSchemaMapping gm) throws SQLException {
    	if (part.startsWith("${") && part.endsWith("}")) {
			if (gm == null || gm.getMappings() == null) {
				throw new SQLException(
						String.format("A schema alias \"%s\" was found but no .globalmapping file exists", part));
			}
    		String alias = part.substring(2, part.length()-1);
			String schema = gm.getMappings().get(alias);
			if (schema == null) {
				throw new SQLException(
						String.format("A schema alias \"%s\" was found but does not exist in the .globalmapping file", part));
			} else {
				return schema;
			}
    	} else {
    		return getObject(part);
    	}
	}

	public String getSchemaName() {
		return schema;
	}

	public String getObjectName(String name) {
		return object;
	}

}
