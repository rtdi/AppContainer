package io.rtdi.appcontainer.repo.rest.entity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.rtdi.appcontainer.repo.FileUtil;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="All files within a given directory")
public class DirectoryContent {
	private List<FileData> directorylist = new ArrayList<>();
	private String path;
	
	public DirectoryContent(File dir, String path) throws IOException {
		if (!dir.exists()) {
			throw new IOException("The requested directory \"" + dir.getAbsolutePath() + "\" does not exist");
		} else if (!dir.isDirectory()) {
			throw new IOException("The requested path \"" + dir.getAbsolutePath() + "\" exists but is not a directory");
		}
		this.path = path;
		File[] files = dir.listFiles(FileUtil.PLAINFILEFILTER);
		if (files != null) {
			for (File f : files) {
				directorylist.add(new FileData(f, path));
			}
		}
	}

	public List<FileData> getFiles() {
		return directorylist;
	}
	public void setFiles(List<FileData> directorylist) {
		this.directorylist = directorylist;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}