package io.rtdi.hanaappcontainer.browseapp;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

import io.rtdi.hanaappcontainer.WebAppConstants;
import io.rtdi.hanaappserver.hanarealm.HanaPrincipal;
import io.rtdi.hanaappserver.utils.ErrorMessage;
import io.rtdi.hanaappserver.utils.SuccessMessage;
import io.rtdi.hanaappserver.utils.Util;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

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
	@Operation(
			summary = "All directories of the user",
			description = "Returns a tree of all schemas and their directories of the currently logged in user",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "The directory tree",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = Directory.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "400", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Filesystem")
    public Response browse() {
		HanaPrincipal user = (HanaPrincipal) request.getUserPrincipal();
		String username = user.getHanaUser();
		String rootpath = request.getServletContext().getRealPath(WebAppConstants.HANAREPO);
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
			return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(e)).build();
		}
	}

	@GET
	@Path("files/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "All files in a user directory",
			description = "Returns a list of all files of the user in a given schema and directory",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "The directory content",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = DirectoryContent.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "400", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Filesystem")
    public Response listFiles(
    		 @PathParam("path") 
    		 @Parameter(
    	    		description = "Path in the format SCHEMA/dir1/dir2",
    	    		example = "SCHEMAXYZ/dir1/subdirA"
    	    		)
    		 String path) {
		HanaPrincipal user = (HanaPrincipal) request.getUserPrincipal();
		String username = user.getHanaUser();
		String rootpath = request.getServletContext().getRealPath(WebAppConstants.HANAREPO);
		try {
			username = Util.validateFilename(username);
			File rootdir = new File(rootpath + File.separatorChar + username);
			File filedir = new File(rootpath + File.separatorChar + username + File.separatorChar + path);
			if (!filedir.isDirectory()) {
				throw new IOException("The directory is not accessible on the server \"" + filedir.getAbsolutePath() + "\"");
			}
			File[] files = filedir.listFiles(plainfilefilter);
			DirectoryContent directorylist = new DirectoryContent(getPath(filedir, rootdir));
			for(File f : files) {
				directorylist.add(new FileData(f, rootdir));
			}
			Collections.sort(directorylist.getFiles());
			return Response.ok(directorylist).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(e)).build();
		}
	}

	@GET
	@Path("touchfile/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Create file",
			description = "Creates a file in the current users workspace at the given schema and directory location",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "Returns the file metadata",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = FileData.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "400", 
							description = "Any exception thrown, e.g. file exists already",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Filesystem")
    public Response touchFile(
    		@PathParam("path")
   		 	@Parameter(
 	    		description = "Path in the format SCHEMA/dir1/dir2/fileX",
 	    		example = "SCHEMAXYZ/dir1/subdirA/fileX"
 	    		)
    		String path) {
		HanaPrincipal user = (HanaPrincipal) request.getUserPrincipal();
		String username = user.getHanaUser();
		String rootpath = request.getServletContext().getRealPath(WebAppConstants.HANAREPO);
		try {
			username = Util.validateFilename(username);
			File rootdir = new File(rootpath + File.separatorChar + username);
			File file = new File(rootpath + File.separatorChar + username + File.separatorChar + path);
			if (file.exists()) {
				throw new IOException("The file exists on the server already \"" + file.getAbsolutePath() + "\"");
			}
			
			java.nio.file.Path newfile = Files.createFile(file.toPath());
			FileData data = new FileData(newfile.toFile(), rootdir);
			return Response.ok(data).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(e)).build();
		}
	}

	@GET
	@Path("mkdir/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Create directory",
			description = "Creates a directory in the current users workspace at the given path",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "Returns the simple success message",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = SuccessMessage.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "400", 
							description = "Any exception thrown, e.g. path exists already",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Filesystem")
    public Response mkDir(
    		@PathParam("path") 
   		 	@Parameter(
   	 	    		description = "Path in the format SCHEMA/dir1/dir2",
   	 	    		example = "SCHEMAXYZ/dir1/subdirA"
   	 	    		)
    		String path) {
		HanaPrincipal user = (HanaPrincipal) request.getUserPrincipal();
		String username = user.getHanaUser();
		String rootpath = request.getServletContext().getRealPath(WebAppConstants.HANAREPO);
		try {
			username = Util.validateFilename(username);
			File filedir = new File(rootpath + File.separatorChar + username + File.separatorChar + path);
			File rootdir = filedir.getParentFile();
			if (!rootdir.exists()) {
				rootdir.mkdirs(); // The user logged in the first time
			} else if (!rootdir.isDirectory()) {
				throw new IOException("The directory is not accessible on the server \"" 
						+ rootdir.getAbsolutePath() + "\", cannot create a directory under it");
			}
			if (filedir.exists()) {
				throw new IOException("A file of that name exists already on the server \"" 
						+ filedir.getAbsolutePath() + "\"");
			}
			filedir.mkdir();
			return Response.ok(new SuccessMessage(path)).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(e)).build();
		}
	}

	@GET
	@Path("rmdir/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Remove directory",
			description = "Removes a directory in the current users workspace at the given path",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "Returns the simple success message",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = SuccessMessage.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "400", 
							description = "Any exception thrown, e.g. path does not exist",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Filesystem")
    public Response rmDir(
    		@PathParam("path")
   		 	@Parameter(
   	 	    		description = "Path in the format SCHEMA/dir1/dir2",
   	 	    		example = "SCHEMAXYZ/dir1/subdirA"
   	 	    		)
    		String path) {
		HanaPrincipal user = (HanaPrincipal) request.getUserPrincipal();
		String username = user.getHanaUser();
		String rootpath = request.getServletContext().getRealPath(WebAppConstants.HANAREPO);
		try {
			username = Util.validateFilename(username);
			File filedir = new File(rootpath + File.separatorChar + username + File.separatorChar + path);
			if (!filedir.isDirectory()) {
				throw new IOException("The directory is not accessible on the server \"" + filedir.getAbsolutePath() + "\"");
			}
			Files.delete(filedir.toPath());
			return Response.ok(new SuccessMessage(path)).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(e)).build();
		}
	}

	@GET
	@Path("rmfile/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Delete file",
			description = "Removes a file in the current users workspace specified by the path",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "Returns the simple success message",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = SuccessMessage.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "400", 
							description = "Any exception thrown, e.g. path exists already",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Filesystem")
    public Response rmFile(
    		@PathParam("path")
   		 	@Parameter(
   	 	    		description = "Path in the format SCHEMA/dir1/dir2/fileA",
   	 	    		example = "SCHEMAXYZ/dir1/subdirA/fileX"
   	 	    		)
    		String path) {
		HanaPrincipal user = (HanaPrincipal) request.getUserPrincipal();
		String username = user.getHanaUser();
		String rootpath = request.getServletContext().getRealPath(WebAppConstants.HANAREPO);
		try {
			username = Util.validateFilename(username);
			File filedir = new File(rootpath + File.separatorChar + username + File.separatorChar + path);
			if (!filedir.isFile()) {
				throw new IOException("The file does not exist or is a directory \"" + filedir.getAbsolutePath() + "\"");
			}
			Files.delete(filedir.toPath());
			return Response.ok(new SuccessMessage(path)).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(e)).build();
		}
	}

	@POST
	@Path("mvfile/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Move file",
			description = "Moves a file from path to target location",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "Returns the simple success message",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = SuccessMessage.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "400", 
							description = "Any exception thrown, e.g. file at path does not exist",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Filesystem")
    public Response mvFile(
    		@PathParam("path")
   		 	@Parameter(
   	 	    		description = "Path in the format SCHEMA/dir1/dir2/fileA",
   	 	    		example = "SCHEMAXYZ/dir1/subdirA/fileX"
   	 	    		)
    		String path,
   		 	@Parameter(
   	 	    		description = "Json with the target location",
   	 	    		example = "{ path: \"SCHEMAXYZ/dir1/subdirA/fileY\" }"
   	 	    		)
    		FileData target) {
		HanaPrincipal user = (HanaPrincipal) request.getUserPrincipal();
		String username = user.getHanaUser();
		String rootpath = request.getServletContext().getRealPath(WebAppConstants.HANAREPO);
		try {
			username = Util.validateFilename(username);
			File rootdir = new File(rootpath + File.separatorChar + username);
			File sourcefile = new File(rootpath + File.separatorChar + username + File.separatorChar + path);
			File targetfile = new File(rootpath + File.separatorChar + username + File.separatorChar + target.path);
			Util.validatePathWithin(targetfile, rootdir);
			if (!sourcefile.exists()) {
				throw new IOException("The file does not exist \"" + sourcefile.getAbsolutePath() + "\"");
			}
			if (targetfile.exists()) {
				throw new IOException("The target file exist already \"" + targetfile.getAbsolutePath() + "\"");
			}
			Files.move(sourcefile.toPath(), targetfile.toPath());
			return Response.ok(new SuccessMessage(path)).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(e)).build();
		}
	}

	@Schema(description="All files within a given directory")
	public static class DirectoryContent {
		List<FileData> directorylist = new ArrayList<>();
		String path;
		
		public DirectoryContent() {
			super();
		}

		public void add(FileData filedata) {
			directorylist.add(filedata);
		}

		public DirectoryContent(String path) {
			super();
			this.path = path;
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
	
	@Schema(description="Tree of directories and sub directories")
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

	@Schema(description="Metadata of a single file")
	public static class FileData implements Comparable<FileData> {
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
			path = BrowseService.getPath(file, rootdir);
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

		@Override
		public int compareTo(FileData o) {
			return name.compareTo(o.name);
		}

		public void setPath(String path) {
			this.path = path;
		}
	}
	
	public static String getPath(File file, File rootdir) {
		// Cannot work with Path methods as these create \ chars on Windows systems.
		StringBuilder b = new StringBuilder();
		b.append(file.getName());
		while (file.getParentFile() != null && !file.getParentFile().equals(rootdir)) {
			file = file.getParentFile();
			b.insert(0, '/');
			b.insert(0, file.getName());
		}
		return b.toString();
	}
}
