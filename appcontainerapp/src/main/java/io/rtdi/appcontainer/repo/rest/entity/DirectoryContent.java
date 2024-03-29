package io.rtdi.appcontainer.repo.rest.entity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jgit.lib.Constants;

import io.rtdi.appcontainer.repo.FileUtil;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="All files within a given directory")
public class DirectoryContent {
	private List<FileData> directorylist = new ArrayList<>();
	private String path;
	private boolean git = false;
	private boolean gitRoot = false;
	
	public DirectoryContent(File dir, String path) throws IOException {
		if (!dir.exists()) {
			throw new IOException("The requested directory \"" + dir.getAbsolutePath() + "\" does not exist");
		} else if (!dir.isDirectory()) {
			throw new IOException("The requested path \"" + dir.getAbsolutePath() + "\" exists but is not a directory");
		}
		File[] files = dir.listFiles(FileUtil.PLAINFILEFILTER);
		if (files != null) {
			for (File f : files) {
				directorylist.add(new FileData(f, path));
			}
			Collections.sort(directorylist);
		}
		
		File gitdir = new File(dir, Constants.DOT_GIT);
		gitRoot = gitdir.exists();
		git = gitRoot;
		if (path != null) {
			this.path = path;
			String[] parts = path.split("/");
			int depth = parts.length;
			File c = dir;
			while (!git && depth > 0) {
				c = c.getParentFile();
				gitdir = new File(c, Constants.DOT_GIT);
				if (gitdir.exists()) {
					git = true;
				}
				depth--;
			}
		} else {
			this.path = ".";
		}
	}
	
	public static DirectoryContent getCompleteDirectoryContent(File dir, String path) throws IOException {
		return new DirectoryContent(dir, path, true);
	}

	public DirectoryContent(File dir, String path, boolean complete) throws IOException {
		if (!dir.exists()) {
			throw new IOException("The requested directory \"" + dir.getAbsolutePath() + "\" does not exist");
		} else if (!dir.isDirectory()) {
			throw new IOException("The requested path \"" + dir.getAbsolutePath() + "\" exists but is not a directory");
		}
		this.path = path;
		File[] files = dir.listFiles();
		if (path != null && path.length() != 0) {
			directorylist.add(DirData.getParentEntry(path));
		}
		if (files != null) {
			/*
			 * Data must be sorted with directories first, files second and each list sorted by name.
			 */
			List<DirData> subdirs = new ArrayList<>();
			List<FileData> filelist = new ArrayList<>();
			for (File f : files) {
				if (f.isDirectory()) {
					subdirs.add(new DirData(f, path));
				} else if (!f.getName().equals(".securestore")) {
					filelist.add(new FileData(f, path));
				}
			}
			Collections.sort(subdirs);
			Collections.sort(filelist);
			directorylist.addAll(subdirs);
			directorylist.addAll(filelist);
		}
		
		File gitdir = new File(dir, Constants.DOT_GIT);
		gitRoot = gitdir.exists();
		git = gitRoot;
		if (path != null) {
			String[] parts = path.split("/");
			int depth = parts.length;
			File c = dir;
			while (!git && depth > 0) {
				c = c.getParentFile();
				gitdir = new File(c, Constants.DOT_GIT);
				if (gitdir.exists()) {
					git = true;
				}
				depth--;
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

	public boolean isGitRoot() {
		return gitRoot;
	}

	public boolean isGit() {
		return git;
	}
}