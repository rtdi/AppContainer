package io.rtdi.appcontainer.plugins.activation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SQLVariables {
	private Map<String, String> variables;


	public static SQLVariables read(Path path) throws IOException {
		return read(path, null);
	}

	public static SQLVariables read(Path dir, SQLVariables parent) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Path mappingfile = dir.resolve(".variables");
		File f = mappingfile.toFile();
		if (f.isFile()) {
			SQLVariables vars = mapper.readValue(mappingfile.toFile(), SQLVariables.class);
			vars.addAll(parent);
			return vars;
		} else if (parent == null) {
			// Neither is there a parent with variables nor does the current directory have a .variables file
			return new SQLVariables();
		} else {
			// The current path has no new variables
			return parent;
		}
	}
	
	public static SQLVariables readAllVariablesForPath(Path dir, Path upath) throws IOException {
		if (dir == null) {
			throw new IOException("path cannot be null");
		} else if (dir.getParent() == null) {
			throw new IOException("The path's parent is null");
		} else if (dir.getParent().equals(upath)) {
			return read(dir);
		} else if (dir.getParent().startsWith(upath)) {
			SQLVariables parent = readAllVariablesForPath(dir.getParent(), upath);
			return read(dir, parent);
		} else {
			throw new IOException("Path is outside the user's root path");
		}
	}

	/**
	 * The parent has some variables defined which are added to the variables list on this level.
	 * If however the current level overwrites some of the parent variables, the current level wins.
	 * 
	 * @param parent contains all variables defined in the parent
	 */
	private void addAll(SQLVariables parent) {
		if (parent == null || parent.getVariables() == null) {
			return; // do nothing
		} else if (variables == null) {
			variables = new HashMap<>();
		}
		for (String key : parent.getVariables().keySet()) {
			if (!variables.containsKey(key)) { // only add variables from the parent which the child does not define
				variables.put(key, parent.getVariables().get(key));
			}
		}
	}

	public Map<String, String> getVariables() {
		return variables;
	}
	
	public void setVariables(Map<String, String> variables) {
		this.variables = variables;
	}
	
	public void addVariable(String variablename, String value) {
		if (variables == null) {
			variables = new HashMap<>();
		}
		variables.put(variablename, value);
	}

	public String getValue(String variable) throws SQLException {
		if (variables == null) {
			throw new SQLException("No variables are defined but the variable \"" + variable + "\" is requested");
		} else {
			String value = variables.get(variable);
			if (value == null) {
				throw new SQLException("The variable \"" + variable + "\" is requested but nowhere defined");
			} else {
				return value;
			}
		}
	}


}
