package io.rtdi.appcontainer.repo.rest.entity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="Json structure with the file content information")
public class FileContent {
	private String content;
	private String filename;
	private String path;
	
	public FileContent() {
		super();
	}

	public FileContent(File file, String path) throws IOException {
		this.path = path;
		this.filename = file.getName();
		content = new String(Files.readAllBytes(file.toPath()));
	}

	public String getContent() {
		return content;
	}

	public String getFilename() {
		return filename;
	}

	public String getPath() {
		return path;
	}
}