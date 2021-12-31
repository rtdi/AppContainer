package io.rtdi.appcontainer.activation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class for the .requires file
 *
 */
public class DirectoryDependency {
	private List<String> dependents;
	
	public DirectoryDependency() {
	}
	
	/**
	 * Read the directory and check if there is a .requires file. If yes, return it else return null
	 * 
	 * @param dir directory with a potential .requires file
	 * @return
	 * @throws IOException
	 */
	public static DirectoryDependency read(File dir) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		File f = new File(dir, ".requires");
		if (f.isFile()) {
			DirectoryDependency dep = mapper.readValue(f, DirectoryDependency.class);
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
	
	/**
	 * Serialize the object into a .requires file
	 * 
	 * @param dir
	 * @throws IOException
	 */
	public void write(Path dir) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Path mappingfile = dir.resolve(".requires");
		mapper.writeValue(mappingfile.toFile(), this);
	}

	public void addDependent(String path) {
		if (dependents == null) {
			dependents = new ArrayList<>();
		}
		dependents.add(path);
	}

}
