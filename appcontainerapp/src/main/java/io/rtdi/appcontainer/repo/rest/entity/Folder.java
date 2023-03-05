package io.rtdi.appcontainer.repo.rest.entity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jgit.lib.Constants;

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
	protected boolean gitRoot = false;
	protected int filecount = 0;

	public Folder(@NotNull File rootdir) throws IOException {
		this(rootdir, null);
	}
	
	/**
	 * Calls the {@link #Folder(File, String)} but adds the directory itself has the root node of the structure.
	 * 
	 * @param dir is supposed to be the developer's directory
	 * @param relativepath if null it lists all directories within the developer directory
	 * @return a single folder for the requested directory and a child structure with all the child folders 
	 * @throws IOException
	 */
	public static Folder getFolder(@NotNull File dir, String relativepath) throws IOException {
		return new Folder(dir, relativepath);
	}
	
	public Folder(@NotNull File dir, String relativepath) throws IOException {
		if (!dir.exists()) {
			throw new IOException("The requested directory \"" + dir.getAbsolutePath() + "\" does not exist");
		} else if (!dir.isDirectory()) {
			throw new IOException("The requested path \"" + dir.getAbsolutePath() + "\" exists but is not a directory");
		}
		name = dir.getName();
		if (relativepath == null) {
			path = "";
		} else {
			path = relativepath;
		}
		File[] files = dir.listFiles(FileUtil.PLAINFILEFILTER);
		filecount = files.length;
		File gitdir = new File(dir, Constants.DOT_GIT);
		gitRoot = gitdir.exists();
		File[] dirs = dir.listFiles(FileUtil.DIRECTORYFILTER);
		if (dirs != null && dirs.length > 0) {
			folders = new ArrayList<>();
			for (File f : dirs) {
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

	public int getFilecount() {
		return filecount;
	}

}