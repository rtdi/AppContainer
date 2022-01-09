package io.rtdi.appcontainer.repo;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public class FileUtil {
	public static final FileUtil.DirectoryFilter DIRECTORYFILTER = new FileUtil.DirectoryFilter();
	public static final FileUtil.PlainFilesFilter PLAINFILEFILTER = new FileUtil.PlainFilesFilter();

	public static void rmDirRecursive(Path rootPath) throws IOException {
		try (Stream<Path> walk = Files.walk(rootPath)) {
		    walk.sorted(Comparator.reverseOrder())
		        .map(Path::toFile)
		        .forEach(File::delete);
		}
	}

	public static String validateFilename(String filename) throws IOException {
		// TODO: validate that the input path does not contain chars the file system cannot handle or should not handle
		return filename;
	}
	
	/**
	 * Return all directories but hide the .git dir.
	 *
	 */
	private static class DirectoryFilter implements FileFilter {
	
		@Override
		public boolean accept(File file) {
			return file.isDirectory() & !file.getName().equals(".git");
		}
		
	}
	
	/**
	 * Filter to return only regular files, not directories
	 *
	 */
	private static class PlainFilesFilter implements FileFilter {
	
		@Override
		public boolean accept(File file) {
			return file.isFile();
		}
		
	}

	public static String makeRelativePath(String path) {
		if (path == null || path.length() == 0) {
			return ".";
		} else if (path.charAt(0) == '/') {
			return path.substring(1);
		} else {
			return path;
		}
	}

}
