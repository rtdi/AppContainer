package io.rtdi.appcontainer.repo.rest.entity;

import java.io.File;
import java.io.IOException;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description="Metadata of a single file")
public class FileData implements Comparable<FileData> {
	private String name;
	private String extension;
	private String path;
	
	public FileData() {
		super();
	}
	
	public FileData(@NotNull File file, String path) throws IOException {
		if (!file.exists()) {
			throw new IOException("The requested file \"" + file.getAbsolutePath() + "\" does not exist");
		} else if (file.isDirectory()) {
			throw new IOException("The requested path \"" + file.getAbsolutePath() + "\" exists but is a directory");
		}
		name = file.getName();
		int pos = name.lastIndexOf('.');
		if (pos != -1) {
			extension = name.substring(pos+1);
		}
		if (path == null) {
			this.path = name;
		} else {
			this.path = path + "/" + name;
		}
	}

	public String getName() {
		return name;
	}

	public String getExtension() {
		return extension;
	}

	public String getPath() {
		return path;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public int compareTo(FileData o) {
		return name.compareTo(o.name);
	}

}