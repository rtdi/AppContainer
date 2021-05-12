package io.rtdi.appcontainer.designtimeobjects.sql;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.rtdi.appcontainer.designtimeobjects.ActivationException;

public class SQLVariables {
	private Map<String, String> mappings;


	public static SQLVariables read(Path path) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Path mappingfile = path.resolve(".variables");
		File f = mappingfile.toFile();
		if (f.isFile()) {
			return mapper.readValue(mappingfile.toFile(), SQLVariables.class);
		} else {
			return new SQLVariables();
		}
	}

	public static SQLVariables read(Path path, SQLVariables parent) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Path mappingfile = path.resolve(".variables");
		File f = mappingfile.toFile();
		if (f.isFile()) {
			SQLVariables vars = mapper.readValue(mappingfile.toFile(), SQLVariables.class);
			vars.addAll(parent);
			return vars;
		} else if (parent == null) {
			return new SQLVariables();
		} else {
			return parent;
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
		} else if (mappings == null) {
			mappings = new HashMap<>();
		}
		for (String key : parent.getVariables().keySet()) {
			if (!mappings.containsKey(key)) { // only add variables from the parent which the child does not define
				mappings.put(key, parent.getVariables().get(key));
			}
		}
	}

	public Map<String, String> getVariables() {
		return mappings;
	}
	
	public void addVarable(String variablename, String value) {
		if (mappings == null) {
			mappings = new HashMap<>();
		}
		mappings.put(variablename, value);
	}

	public String getValue(String variable) throws ActivationException {
		if (mappings == null) {
			throw new ActivationException("No variables are defined but the variable \"" + variable + "\" is requested");
		} else {
			String value = mappings.get(variable);
			if (value == null) {
				throw new ActivationException("The variable \"" + variable + "\" is requested but nowhere defined");
			} else {
				return value;
			}
		}
	}


}
