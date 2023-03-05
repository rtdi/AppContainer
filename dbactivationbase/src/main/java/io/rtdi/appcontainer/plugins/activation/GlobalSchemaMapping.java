package io.rtdi.appcontainer.plugins.activation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Read/Write the .globalmapping file
 *
 */
public class GlobalSchemaMapping {
	private Map<String, String> mappings;
	private String currentschema;
	private String currentuser;
	
	public GlobalSchemaMapping() {
	}
	
	public GlobalSchemaMapping(String currentschema, String currentuser) {
		this.currentschema = currentschema;
		this.currentuser = currentuser;
	}

	/**
	 * @param upath
	 * @return
	 * @throws IOException
	 */
	public static GlobalSchemaMapping read(Path upath, String currentschema, String currentuser) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Path mappingfile = upath.resolve(".globalmapping");
		File f = mappingfile.toFile();
		if (f.isFile()) {
			GlobalSchemaMapping gm = mapper.readValue(mappingfile.toFile(), GlobalSchemaMapping.class);
			gm.currentuser = currentuser;
			gm.currentschema = currentschema;
			return gm;
		} else {
			return new GlobalSchemaMapping(currentschema, currentuser);
		}
	}

	public Map<String, String> getMappings() {
		return mappings;
	}

	public void setMappings(Map<String, String> mappings) {
		this.mappings = mappings;
	}
	
	public void write(Path upath) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Path mappingfile = upath.resolve(".globalmapping");
		mapper.writeValue(mappingfile.toFile(), this);
	}

	/**
	 * @param name
	 * @return either the text the provided alias points to or the input name itself
	 */
	public String getActualSchema(String name) {
		if (name == null) {
			return currentschema;
		}
		if (name.equalsIgnoreCase("CURRENTSCHEMA")) {
			return currentschema;
		} else if (name.equalsIgnoreCase("CURRENTUSER")) {
			return currentuser;
		} else if (mappings != null) {
			String m = mappings.get(name);
			if (m != null) {
				return m;
			} else {
				return name;
			}
		} else {
			return name; // if the schema is a plain schema, return it
		}
	}

	/**
	 * @param alias
	 * @return the translated alias
	 * @throws ActivationException when the alias is null or cannot be found
	 */
	public String getActualSchemaFromMapping(String alias) throws ActivationException {
		if (alias == null) {
			throw new ActivationException("alias is null");
		}
		if (alias.equalsIgnoreCase("CURRENTSCHEMA")) {
			return currentschema;
		} else if (alias.equalsIgnoreCase("CURRENTUSER")) {
			return currentuser;
		} else if (mappings != null) {
			String m = mappings.get(alias);
			if (m != null) {
				return m;
			} else {
				throw new ActivationException("alias \"" + alias + "\" is not defined in the globalmappings");
			}
		} else {
			throw new ActivationException("There are no aliases in the globalmappings defined");
		}
	}

	public void addMapping(String alias, String actualschema) {
		if (mappings == null) {
			mappings = new HashMap<>();
		}
		mappings.put(alias, actualschema);
	}

	@JsonIgnore
	public String getCurrentSchema() {
		return currentschema;
	}
	
}
