package io.rtdi.appcontainer.designtimeobjects;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DirectoryDependency {
	private List<String> dependents;
	private Path upath;
	private File directory;
	
	public DirectoryDependency() {
	}
	
	public static DirectoryDependency read(File dir, Path upath) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		File f = new File(dir, ".depends");
		if (f.isFile()) {
			DirectoryDependency dep = mapper.readValue(f, DirectoryDependency.class);
			dep.upath = upath;
			dep.directory = dir;
			return dep;
		} else {
			return null;
		}
	}

	public List<String> getDependents() {
		return dependents;
	}

	public void setDependents(List<String> dependents) {
		this.dependents = dependents;
	}
	
	public void write(Path dir) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Path mappingfile = dir.resolve(".depends");
		mapper.writeValue(mappingfile.toFile(), this);
	}

	public void addDependent(String path) {
		if (dependents == null) {
			dependents = new ArrayList<>();
		}
		dependents.add(path);
	}

	public List<File> getDependentsInside(Path activationroot) {
		List<File> files = new ArrayList<>();
		for (String pathstring : dependents) {
			File f;
			if (pathstring.charAt(0) == '/') {
				f = new File(upath.toFile(), pathstring.substring(1));
			} else {
				f = new File(directory, pathstring);
			}
			if (f.toPath().startsWith(activationroot)) {
				if (f.isDirectory()) {
					files.add(f);
				}
			}
		}
		return files;
	}
}
