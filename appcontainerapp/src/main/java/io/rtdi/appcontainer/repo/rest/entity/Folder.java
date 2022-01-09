package io.rtdi.appcontainer.repo.rest.entity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.rtdi.appcontainer.repo.FileUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

/**
 * A folder is a tree of folder objects with some metadata
 *
 */
@Schema(description="A directory tree")
public class Folder {
	protected List<Folder> folders;
	protected String name = null;
	protected String path = null;

	private Folder() {
		super();
	}

	public Folder(@NotNull File rootdir) throws IOException {
		this(rootdir, null);
	}
	
	/**
	 * Calls the {@link #Folder(File, String)} but adds the directory itself has the root node of the structure.
	 * 
	 * @param dir
	 * @param relativepath
	 * @return
	 * @throws IOException
	 */
	public static Folder getFolder(@NotNull File dir, String relativepath) throws IOException {
		Folder f = new Folder();
		f.addFolder(new Folder(dir, relativepath));
		return f;
	}
	
	private void addFolder(Folder folder) {
		if (folders == null) {
			folders = new ArrayList<>();
		}
		folders.add(folder);
	}

	public Folder(@NotNull File dir, String relativepath) throws IOException {
		if (!dir.exists()) {
			throw new IOException("The requested directory \"" + dir.getAbsolutePath() + "\" does not exist");
		} else if (!dir.isDirectory()) {
			throw new IOException("The requested path \"" + dir.getAbsolutePath() + "\" exists but is not a directory");
		}
		if (relativepath == null) {
			name = dir.getName();
			path = "";
		} else {
			name = dir.getName();
			path = relativepath;
		}
		
		File[] files = dir.listFiles(FileUtil.DIRECTORYFILTER);
		if (files != null && files.length > 0) {
			folders = new ArrayList<>();
			for (File f : files) {
				String p;
				if (path == null || path.length() == 0) {
					p = f.getName();
				} else {
					p = path + "/" + f.getName();
				}
				folders.add(new Folder(f, p));
			}
		}
	}

	public List<Folder> getFolders() {
		return folders;
	}
	public String getName() {
		return name;
	}
	public String getPath() {
		return path;
	}

}