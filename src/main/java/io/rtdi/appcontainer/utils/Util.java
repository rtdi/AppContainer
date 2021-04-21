package io.rtdi.appcontainer.utils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Principal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import io.rtdi.appcontainer.realm.IAppContainerPrincipal;

public class Util {

	public static String getDataTypeString(String datatypename, Integer length, Integer scale) throws HanaSQLException {
		return getDataTypeString(datatypename, length, length, scale);
	}
	
	public static String getDataTypeString(String datatypename, Integer length, Integer precision, Integer scale) throws HanaSQLException {
		HanaDataType d = HanaDataType.valueOf(datatypename);
		return getDataTypeString(d, length, precision, scale);
	}
	
	public static String getDataTypeString(HanaDataType datatype, Integer length, Integer precision, Integer scale) throws HanaSQLException {
		switch (datatype.getGroup()) {
		case NOPARAM:
			return datatype.name();
		case LENGTHPARAM:
			if (length == null || length.intValue() == 0) {
				throw new HanaSQLException("The datatype needs a length information", datatype.name());
			}
			return datatype.name() + " (" + String.valueOf(length) + ")";
		case DECIMALPARAM:
			if (precision == null || precision.intValue() == 0) {
				if (length == null || length.intValue() == 0) {
					throw new HanaSQLException("The datatype needs a length/precision information", datatype.name());
				}
				precision = length;
			}
			if (scale == null) {
				scale = 0;
			}
			return datatype.name() + " (" + String.valueOf(precision) + "," + String.valueOf(scale) + ")";
		default:
			throw new HanaSQLException("The datatype is not known", datatype.name());
		}
	}

	/**
	 * Tomcat prevents encoded / chars (as %2f) for security reasons. Therefore this character sequence is encoded a second time.
	 * 
	 * @param input an encoded String for the path segment of an URI, see webide/ui5/controls/helperfunctions.js/encodeURIfull()
	 * @return the actual object name
	 */
	public static String decodeURIfull(String input) {
		if (input != null) {
			return input.replace("%2f", "/");
		} else {
			return input;
		}
	}

	public static String encodeURIfull(String input) {
		if (input != null) {
			return input.replace("/", "%2f");
		} else {
			return input;
		}
	}

	public static String validateFilename(String filename) throws IOException {
		if (filename == null) {
			throw new IOException("The filename cannot be null");
		} else if (filename.contains("/")) {
			throw new IOException("The filename \"" + filename + "\" contains an invalid character");
		}
		return filename;
	}

	public static String trimQuotes(String text) {
		if (text == null) {
			return null;
		} else if (text.length() < 2 || text.charAt(0) != '"') {
			return text;
		} else {
			return text.substring(1, text.length()-1);
		}
	}
	
	public static String packageToPath(String objectname) {
		if (objectname == null) {
			return null;
		}
		int pos = objectname.indexOf("::");
		if (pos == -1) {
			return ".";
		} else {
			String[] pathelements = objectname.substring(0, pos).split("\\.");
			StringBuffer b = new StringBuffer();
			for (String e : pathelements) {
				if (b.length() != 0) {
					b.append(File.separatorChar);
				}
				b.append(e);
			}
			return b.toString();
		}
	}
	
	public static String packageToFilename(String objectname) {
		if (objectname == null) {
			return null;
		}
		int pos = objectname.indexOf("::");
		if (pos == -1) {
			return objectname;
		} else {
			return objectname.substring(pos+1);
		}
	}

	public static String fileToTablename(File file, File rootdir) {
		StringBuffer b = new StringBuffer();
		int pos = file.getName().lastIndexOf('.');
		String name = file.getName();
		if (pos != -1) {
			name = name.substring(0, pos);
		}
		b.append(name);
		while (file != null && file.getParentFile() != rootdir) {
			file = file.getParentFile();
			if (file.getParentFile().equals(rootdir)) {
				// The last element is the schema name to be activated in
				break;
			}
			if (b.length() == name.length()) {
				b.insert(0, "::");
			} else {
				b.insert(0, '.');
			}
			b.insert(0, file.getName());
		}
		return b.toString();
	}
	
	public static String fileToSchemaname(File file, File rootdir) {
		String schemaname = null;
		if (file.equals(rootdir)) {
			return file.getName();
		} else {
			while (file != null && file.getParentFile() != null && !file.equals(rootdir)) {
				file = file.getParentFile();
				schemaname = file.getName();
			}
			return schemaname;
		}
	}

	public static String getFileExtension(File file) {
		int pos = file.getName().lastIndexOf('.');
		if (pos == -1) {
			return null;
		}
		return file.getName().substring(pos+1);
	}
	
	public static boolean sameOrNull(Object o1, Object o2) {
		if (o1 == null || o2 == null) {
			return true;
		} else {
			return o1.equals(o2);
		}
	}
	
	public static String writeStringList(List<String> list) {
		StringBuffer b = new StringBuffer();
		b.append("[");
		boolean first = true;
		for (String s : list) {
			if (first) {
				first = false;
			} else {
				b.append(", ");
			}
			b.append("\"").append(s).append("\"");
		}
		b.append("]");
		return b.toString();
	}
	
	/**
	 * @param list
	 * @return A string with all quoted columns separated by commas
	 */
	public static String getColumnList(List<String> list) {
		StringBuffer b = new StringBuffer();
		for (String s : list) {
			if (b.length() != 0) {
				b.append(", ");
			}
			b.append("\"").append(s).append("\"");
		}
		return b.toString();
	}

	/**
	 * Throws an exception if the target file is outside the root directory
	 * @param targetfile to be tested
	 * @param rootdir where the targetfile needs to be contained in
	 * @throws IOException if the condition is not met
	 */
	public static void validatePathWithin(File targetfile, File rootdir) throws IOException {
		while (targetfile != null && !targetfile.equals(rootdir)) {
			targetfile = targetfile.getParentFile();
		}
		if (targetfile == null) {
			throw new IOException("The target file is outside the allowed root folder");
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
	
	public static void rmDirRecursive(Path rootPath) throws IOException {
		try (Stream<Path> walk = Files.walk(rootPath)) {
		    walk.sorted(Comparator.reverseOrder())
		        .map(Path::toFile)
		        .forEach(File::delete);
		}
	}
	
	public static String getAppSchemaFromReferrer(HttpServletRequest req) throws URISyntaxException {
		String referrer = req.getHeader("referer");
		if (referrer != null) {
			URI uri = new URI(referrer);
			String referrerpath = uri.getPath();
			String[] parts = referrerpath.split("/");
			// parts = [, AppContainer, protected, repo, currentuser, WEBPROJEKT, index.html]
			if (parts.length > 5 && parts[3].equals("repo")) {
				return parts[5];
			}
		}
		return null;
	}
	
	public static String getSchema(String schemaname, HttpServletRequest req) throws URISyntaxException {
		if (schemaname.equals(".") || schemaname.equals("currentuser")) {
			Principal p = req.getUserPrincipal();
			if (p instanceof IAppContainerPrincipal) {
				IAppContainerPrincipal apppricipal = (IAppContainerPrincipal) p;
				schemaname = apppricipal.getDBUser();
			}
		} else if (schemaname.equals("appschema")) {
			String referrerschema = getAppSchemaFromReferrer(req);
			if (referrerschema != null) {
				schemaname = referrerschema;
			}
		}
		return schemaname;
	}
}
