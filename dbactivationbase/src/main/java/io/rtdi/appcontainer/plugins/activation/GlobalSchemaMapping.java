package io.rtdi.appcontainer.plugins.activation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Read/Write the .globalmapping file
 *
 */
public class GlobalSchemaMapping {
	private Map<String, String> mappings;
	
	public GlobalSchemaMapping() {
	}
	
	/**
	 * @param upath
	 * @return
	 * @throws IOException
	 */
	public static GlobalSchemaMapping read(Path upath) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Path mappingfile = upath.resolve(".globalmapping");
		File f = mappingfile.toFile();
		if (f.isFile()) {
			GlobalSchemaMapping gm = mapper.readValue(mappingfile.toFile(), GlobalSchemaMapping.class);
			return gm;
		} else {
			return new GlobalSchemaMapping();
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

	public String getActualSchema(String alias, String currentschema) {
		if (alias == null) {
			return currentschema;
		}
		if (alias.equals("CURRENTOWNER")) {
			// Not using recursion here for the odd case where the schema alias is CURRENTOWNER
			if (mappings != null) {
				return mappings.get(currentschema);
			} else {
				return currentschema; // it is just fine to use a well defined schema
			}
		} else if (mappings != null) {
			String m = mappings.get(alias);
			if (m != null) {
				return m;
			} else {
				return alias;
			}
		} else {
			return alias; // it is just fine to use a well defined schema
		}
	}
	
	public void addMapping(String alias, String actualschema) {
		if (mappings == null) {
			mappings = new HashMap<>();
		}
		mappings.put(alias, actualschema);
	}
}
