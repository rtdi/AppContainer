package io.rtdi.hanaappcontainer.browseapp;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.rtdi.hanaappserver.hanarealm.HanaPrincipal;
import io.rtdi.hanaappserver.utils.ErrorMessage;
import io.rtdi.hanaappserver.utils.Util;

@Path("/browseapp")
public class BrowseService {
	protected final Logger log = LogManager.getLogger(this.getClass().getName());
	private static final PlainFilesFilter plainfilefilter = new PlainFilesFilter();

	@Context
    private Configuration configuration;

	@Context 
	private ServletContext servletContext;
	
	@Context 
	private HttpServletRequest request;

	@GET
	@Path("browse")
    @Produces(MediaType.APPLICATION_JSON)
    public Response browse() {
		HanaPrincipal user = (HanaPrincipal) request.getUserPrincipal();
		String username = user.getHanaUser();
		String rootpath = request.getServletContext().getRealPath("/protected/hanarepo");
		try {
			username = Util.validateFilename(username);
			File rootdir = new File(rootpath + File.separatorChar + username);
			if (!rootdir.isDirectory()) {
				log.debug("Root directory is not accessible on the server \"{}\"", rootdir.getAbsolutePath());
				return Response.ok(new Directory()).build();
			}
			Directory directorytree = new Directory(username, rootdir); 
			return Response.ok(directorytree).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ErrorMessage(e)).build();
		}
	}

	@GET
	@Path("files/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listFiles(@PathParam("path") String path) {
		HanaPrincipal user = (HanaPrincipal) request.getUserPrincipal();
		String username = user.getHanaUser();
		String rootpath = request.getServletContext().getRealPath("/protected/hanarepo");
		try {
			username = Util.validateFilename(username);
			File rootdir = new File(rootpath + File.separatorChar + username);
			File filedir = new File(rootpath + File.separatorChar + username + File.separatorChar + path);
			if (!filedir.isDirectory()) {
				throw new IOException("The directory is not accessible on the server \"" + filedir.getAbsolutePath() + "\"");
			}
			File[] files = filedir.listFiles(plainfilefilter);
			List<FileData> directorylist = new ArrayList<>();
			for(File f : files) {
				directorylist.add(new FileData(f, rootdir));
			}
			return Response.ok(directorylist).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ErrorMessage(e)).build();
		}
	}

	
	public static class Directory extends Folder {
		private String username;

		public Directory() {
			super();
		}

		private Directory(String username, File rootdir) {
			super(rootdir, null);
			this.username = username;
		}

		public String getUsername() {
			return username;
		}
	}
	
	public static class Folder {
		protected List<Folder> folders;
		protected String name;
		protected String path;
		private int filecount;
		private static FileFilter filter = new DirectoryFilter();
		
		public Folder() {
			super();
		}
		
		public Folder(File rootdir, Folder parent) {
			this();
			name = rootdir.getName();
			if (parent == null) {
				path = "";
			} else if (parent.path == "") {
				path = name;
			} else {
				path = parent.path + "/" + name;
			}
			File[] plainfiles = rootdir.listFiles(plainfilefilter);
			if (plainfiles!= null) {
				filecount = plainfiles.length;
			} else {
				filecount = 0;
			}
			
			File[] files = rootdir.listFiles(filter);
			if (files != null && files.length > 0) {
				folders = new ArrayList<>();
				for (File f : files) {
					folders.add(new Folder(f, this));
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
	
	private static class DirectoryFilter implements FileFilter {

		@Override
		public boolean accept(File file) {
			return file.isDirectory();
		}
		
	}

	private static class PlainFilesFilter implements FileFilter {

		@Override
		public boolean accept(File file) {
			return file.isFile();
		}
		
	}

	public static class FileData {
		private String name;
		private String extension;
		private String path;
		
		public FileData() {
			super();
		}

		public FileData(File file, File rootdir) {
			super();
			this.name = file.getName();
			int pos = name.lastIndexOf('.');
			if (pos != -1) {
				extension = name.substring(pos+1);
			}
			// Cannot work with Path methods as these create \ chars on Windows systems.
			StringBuilder b = new StringBuilder();
			b.append(file.getName());
			while (file.getParentFile() != null && !file.getParentFile().equals(rootdir)) {
				file = file.getParentFile();
				b.insert(0, '/');
				b.insert(0, file.getName());
			}
			path = b.toString();
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
	}
}
