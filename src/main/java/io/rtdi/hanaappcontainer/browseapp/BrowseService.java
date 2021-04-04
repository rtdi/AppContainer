package io.rtdi.hanaappcontainer.browseapp;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import org.eclipse.jgit.api.CreateBranchCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.LsRemoteCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.dircache.DirCache;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.RemoteConfig;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

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
	private static Cache<String, CredentialsProvider> gitcredentialstore = Caffeine.newBuilder()
		    .maximumSize(100)
		    .expireAfterAccess(60, TimeUnit.MINUTES)
		    .build();

	@Context
    private Configuration configuration;

	@Context 
	private ServletContext servletContext;
	
	@Context 
	private HttpServletRequest request;
	
	private FileRepositoryBuilder getRepoBuilder(java.nio.file.Path upath) {
		File gitdir = new File(upath.toFile(), Constants.DOT_GIT);
		FileRepositoryBuilder repositoryBuilder = new FileRepositoryBuilder();
		repositoryBuilder
	        .readEnvironment() // scan environment GIT_* variables
	        .addCeilingDirectory(gitdir)
	        .findGitDir(gitdir);
		return repositoryBuilder;
	}

	private Git getGit(java.nio.file.Path upath, boolean forcecreate) throws IOException, IllegalStateException, GitAPIException {
		FileRepositoryBuilder repositoryBuilder = getRepoBuilder(upath);
		if( repositoryBuilder.getGitDir() == null ) {
			if (forcecreate) {
				File gitdir = new File(upath.toFile(), Constants.DOT_GIT);
				return Git.init().setDirectory(gitdir.getParentFile()).call();
			} else {
				return null;
			}
		} else {
			return new Git(repositoryBuilder.build());
		}
	}
	
	private CredentialsProvider getGitCredentials(Git git, String username) throws JsonParseException, JsonMappingException, IOException {
		CredentialsProvider credentials = gitcredentialstore.getIfPresent(username);
		if (credentials == null) {
			GitConfig gitconfig = GitConfig.createFromFile(git, username);
			credentials = new UsernamePasswordCredentialsProvider(gitconfig.getUsername(), gitconfig.getPassword());
			gitcredentialstore.put(username, credentials);
		}
		return credentials;
	}
	
	@POST
	@Path("gitpush")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Push contents to git repository",
			description = "Does a git add, commit and push",
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
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Filesystem")
    public Response gitPush(
   		 	@Parameter(
   	 	    		description = "Commit message",
   	 	    		example = "Initial commit"
   	 	    		)
    		GitCommit gitcommit) {
		HanaPrincipal user = (HanaPrincipal) request.getUserPrincipal();
		String username = user.getHanaUser();
		String message = gitcommit.getMessage();
		try {
			username = Util.validateFilename(username);
			if (message == null || message.length() == 0) {
				message = username + " at " + DateFormat.getInstance().format(new Date()); 
			}
			java.nio.file.Path upath = WebAppConstants.getHanaRepoUserDir(request.getServletContext(), username);
			try (Git git = getGit(upath, true);) {
				String result;
				org.eclipse.jgit.api.Status modified = git.status().call();
				Set<String> filesmodified = modified.getModified();
				if (filesmodified == null || filesmodified.size() == 0) {
					return Response.ok(new SuccessMessage("Local directory is up to date")).build();
				} else {			
					DirCache files = git.add().addFilepattern(".").call();
					RevCommit commit = git.commit().setMessage(message).call();
					String url = git.getRepository().getConfig().getString("remote", "origin", "url");
					if (url == null) {
						throw new IOException("No git remote url specified yet");
					} else {
						Iterable<PushResult> iter = git.push()
							.setRemote(url)
							.setCredentialsProvider(getGitCredentials(git, username))
							.call();
						PushResult pushResult = iter.iterator().next();
						org.eclipse.jgit.transport.RemoteRefUpdate.Status status = pushResult.getRemoteUpdate( "refs/heads/master" ).getStatus();
						result = status.name();
					}
					return Response.ok(new SuccessMessage("Changes pushed")).build();
				}
			}
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(e)).build();
		}
	}
	
	public static class GitCommit {
		private String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
	
	@GET
	@Path("gitpull")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Pull git repository",
			description = "Does a git pull",
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
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Filesystem")
    public Response gitPull() {
		HanaPrincipal user = (HanaPrincipal) request.getUserPrincipal();
		String username = user.getHanaUser();
		try {
			username = Util.validateFilename(username);
			java.nio.file.Path upath = WebAppConstants.getHanaRepoUserDir(request.getServletContext(), username);
			try (Git git = getGit(upath, false);) {
				String url = git.getRepository().getConfig().getString("remote", "origin", "url");
				if (url == null) {
					throw new IOException("No git remote url specified yet");
				} else {
					git.pull()
						.setRemote("origin")
						.setCredentialsProvider(getGitCredentials(git, username))
						.call();
				}
				return Response.ok(new SuccessMessage("pulled")).build();
			}
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(e)).build();
		}
	}


	@POST
	@Path("gitconfig")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Configure remote git",
			description = "Provide URL and tokens for the remote git repo",
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
    public Response gitconfig(
   		 	@Parameter(
   	 	    		description = "Config data",
   	 	    		example = "{ url: 'https://github.com/my/repo', username: 'hello', passwd: 'world' }"
   	 	    		)
    		GitConfig gitconfig) {
		HanaPrincipal user = (HanaPrincipal) request.getUserPrincipal();
		String username = user.getHanaUser();
		try {
			username = Util.validateFilename(username);
			java.nio.file.Path upath = WebAppConstants.getHanaRepoUserDir(request.getServletContext(), username);
			CredentialsProvider credentials = new UsernamePasswordCredentialsProvider(gitconfig.getUsername(), gitconfig.getPassword());
			Collection<Ref> remoterepos = new LsRemoteCommand(null)
					.setRemote(gitconfig.getRemoteurl())
					.setCredentialsProvider(credentials).call();
			// remote repo exists and can be connected
			gitconfig.save(upath, username);
			gitcredentialstore.put(username, credentials);
			// check if a git init or git clone is appropriate
			FileRepositoryBuilder builder = getRepoBuilder(upath);
			String[] localfiles = upath.toFile().list();
			if (builder.getGitDir() != null || remoterepos == null || remoterepos.size() == 0) {
				// Case #1: A local git exists already -> open git
				// Case #2: A local git does not exist and the remote is empty -> git init
				try (Git git = getGit(upath, true);) {
					setGitRemote(git, gitconfig);
					return Response.ok(new SuccessMessage("remote set")).build();
				}
			} else if (localfiles == null || localfiles.length == 0) {
				// Case #3: The local repo does not exist and the local folder is empty and the remote has data
				try (Git git = Git.cloneRepository()
						  .setURI(gitconfig.getRemoteurl())
						  .setDirectory(upath.toFile())
						  .setCredentialsProvider(credentials)
						  .call();) {
					return Response.ok(new SuccessMessage("Cloned remote repo")).build();
				}
			} else {
				// Case #4: The local filesystem has data and the remote has data
				try (Git git = getGit(upath, true);) {
					String branchName = "master";
					setGitRemote(git, gitconfig);
					git.fetch().call();
					git.branchCreate().setName(branchName).setStartPoint("origin/" + branchName)
					    .setUpstreamMode(CreateBranchCommand.SetupUpstreamMode.TRACK).call();
					git.checkout().setName(branchName).call();
					git.fetch().call();
					git.reset().setRef("origin/" + branchName).call();
					return Response.ok(new SuccessMessage("Created local repo and fetched remote")).build();
				}

				/*var git = Git.Init().SetDirectory(Location).Call();
				Repository = git.GetRepository();
				 
				// Original code in question works, is shorter,
				// but this is most likely the "proper" way to do it.
				var config = Repository.GetConfig();
				RemoteConfig remoteConfig = new RemoteConfig(config, "origin");
				remoteConfig.AddURI(new URIish(cloneUrl));
				// May use * instead of branch name to fetch all branches.
				// Same as config.SetString("remote", "origin", "fetch", ...);
				remoteConfig.AddFetchRefSpec(new RefSpec(
				    "+refs/heads/" + Settings.Branch +
				    ":refs/remotes/origin/" + Settings.Branch));
				remoteConfig.Update(config);
				config.Save();
				 
				git.Fetch().Call();
				git.BranchCreate().SetName(branchName).SetStartPoint("origin/" + branchName)
				    .SetUpstreamMode(CreateBranchCommand.SetupUpstreamMode.TRACK).Call();
				git.Checkout().SetName(branchName).Call();
				 
				// To update the branch:
				 
				git.Fetch().Call();
				git.Reset().SetRef("origin/" + branchName).Call(); */
			}
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(e)).build();
		}
	}

	private void setGitRemote(Git git, GitConfig gitconfig) throws GitAPIException, URISyntaxException {
		boolean remoteoriginexists = false;
		List<RemoteConfig> remotes = git.remoteList().call();
		if (remotes != null) {
			for( RemoteConfig r : remotes) {
				if (r.getName().equals("origin")) {
					remoteoriginexists = true;
					break;
				}
			}
		}
		if (remoteoriginexists) {
			/* StoredConfig config = git.getRepository().getConfig();
			config.setString("remote", "origin", "url", gitconfig.getRemoteurl());
			config.save(); */
			git.remoteSetUrl().setRemoteName("origin").setRemoteUri(new URIish(gitconfig.getRemoteurl())).call();
		} else {
			git.remoteAdd().setName("origin").setUri(new URIish(gitconfig.getRemoteurl())).call();
		}
	}
	
	public static class GitConfig {
		private String remoteurl;
		private String username;
		private String password;
		
		public GitConfig() {
		}
		
		public static GitConfig createFromFile(Git git, String username) throws JsonParseException, JsonMappingException, IOException {
			File d = git.getRepository().getWorkTree().getParentFile();
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(new File(d, username + ".remotesettings"), GitConfig.class);
		}		
		
		public String getRemoteurl() {
			return remoteurl;
		}
		
		public void save(java.nio.file.Path upath, String username) throws JsonGenerationException, JsonMappingException, IOException {
			File d = upath.getParent().toFile();
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File(d, username + ".remotesettings"), this);
		}

		public void setRemoteurl(String remoteurl) {
			this.remoteurl = remoteurl;
		}
		
		public String getUsername() {
			return username;
		}
		
		public void setUsername(String username) {
			this.username = username;
		}
		
		public String getPassword() {
			return password;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
		
	}
	
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
		try {
			username = Util.validateFilename(username);
			java.nio.file.Path upath = WebAppConstants.getHanaRepoUserDir(request.getServletContext(), username);
			File rootdir = upath.toFile();
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
		try {
			username = Util.validateFilename(username);
			java.nio.file.Path upath = WebAppConstants.getHanaRepoUserDir(request.getServletContext(), username);
			File filedir = upath.resolve(Util.makeRelativePath(path)).toFile();
			if (!filedir.isDirectory()) {
				throw new IOException("The directory is not accessible on the server \"" + filedir.getAbsolutePath() + "\"");
			}
			File[] files = filedir.listFiles(plainfilefilter);
			DirectoryContent directorylist = new DirectoryContent(getPath(filedir, upath.toFile()));
			for(File f : files) {
				directorylist.add(new FileData(f, upath.toFile()));
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
		try {
			username = Util.validateFilename(username);
			java.nio.file.Path upath = WebAppConstants.getHanaRepoUserDir(request.getServletContext(), username);
			java.nio.file.Path fpath = upath.resolve(Util.makeRelativePath(path));
			if (fpath.toFile().exists()) {
				throw new IOException("The file exists on the server already \"" + fpath.toAbsolutePath().toString() + "\"");
			}
			
			java.nio.file.Path newfile = Files.createFile(fpath);
			FileData data = new FileData(newfile.toFile(), upath.toFile());
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
		try {
			username = Util.validateFilename(username);
			java.nio.file.Path upath = WebAppConstants.getHanaRepoUserDir(request.getServletContext(), username);
			File filedir = upath.resolve(Util.makeRelativePath(path)).toFile();
			File rootdir = upath.toFile();
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
		try {
			username = Util.validateFilename(username);
			java.nio.file.Path upath = WebAppConstants.getHanaRepoUserDir(request.getServletContext(), username);
			java.nio.file.Path filedir = upath.resolve(Util.makeRelativePath(path));
			if (!filedir.toFile().isDirectory()) {
				throw new IOException("The directory is not accessible on the server \"" + filedir.toAbsolutePath().toString() + "\"");
			}
			Files.delete(filedir);
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
		try {
			username = Util.validateFilename(username);
			java.nio.file.Path upath = WebAppConstants.getHanaRepoUserDir(request.getServletContext(), username);
			java.nio.file.Path filedir = upath.resolve(Util.makeRelativePath(path));
			if (!filedir.toFile().isFile()) {
				throw new IOException("The file does not exist or is a directory \"" + filedir.toAbsolutePath().toString() + "\"");
			}
			Files.delete(filedir);
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
		try {
			username = Util.validateFilename(username);
			java.nio.file.Path upath = WebAppConstants.getHanaRepoUserDir(request.getServletContext(), username);
			java.nio.file.Path sourcefile = upath.resolve(Util.makeRelativePath(path));
			java.nio.file.Path targetfile = upath.resolve(Util.makeRelativePath(target.path));
			Util.validatePathWithin(targetfile.toFile(), upath.toFile());
			if (!sourcefile.toFile().exists()) {
				throw new IOException("The file does not exist \"" + sourcefile.toAbsolutePath().toString() + "\"");
			}
			if (targetfile.toFile().exists()) {
				throw new IOException("The target file exist already \"" + targetfile.toAbsolutePath().toString() + "\"");
			}
			Files.move(sourcefile, targetfile);
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
				folders = new ArrayList<>();
				folders.add(new Folder(rootdir, this));
			} else {
				if (parent.path == "") {
					path = ".";
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
						if (! f.getName().equals(".git")) {
							folders.add(new Folder(f, this));
						}
					}
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
