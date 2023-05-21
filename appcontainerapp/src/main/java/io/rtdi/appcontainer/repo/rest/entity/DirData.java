package io.rtdi.appcontainer.repo.rest.entity;

import java.io.File;
import java.io.IOException;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description="Metadata of a single directory")
public class DirData extends FileData {
	
	public DirData() {
		super();
	}
	
	public DirData(@NotNull File file, String path) throws IOException {
		super();
		if (!file.exists()) {
			throw new IOException("The requested directory \"" + file.getAbsolutePath() + "\" does not exist");
		}
		String name = file.getName();
		setName(name);
		if (path == null) {
			setPath(name);
		} else {
			setPath(path + "/" + name);
		}
	}

	public static DirData getParentEntry(String path) throws IOException {
		DirData dir = new DirData();
		dir.setName("..");
		int p = path.lastIndexOf('/');
		if (p > 0) {
			dir.setPath(path.substring(0, p));
		} else {
			dir.setPath(null);
		}
		return dir;
	}
	
	public boolean isDirectory() {
		return true;
	}

}