package io.rtdi.appcontainer.repo.rest;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.LsRemoteCommand;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.errors.CheckoutConflictException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.merge.ContentMergeStrategy;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.RemoteConfig;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.rtdi.appcontainer.repo.RepoDirectory;
import io.rtdi.appcontainer.repo.rest.entity.GitResult;
import io.rtdi.appcontainer.rest.entity.ErrorMessage;
import io.rtdi.appcontainer.rest.entity.SuccessMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Configuration;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/git")
public class GitService {
	protected final Logger log = LogManager.getLogger(this.getClass().getName());

	@Context
    private Configuration configuration;

	@Context 
	private ServletContext servletContext;
	
	@Context 
	private HttpServletRequest request;
	
	@GET
	@Path("gitpull/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Pull git repository with the merge strategy OURS, meaning the remote branch will be copied and conflicts resolved so that the local file is kept",
			description = "Does a git pull",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "Returns the simple success message",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = GitResult.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "202", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Repository")
    public Response gitPull(
    		@PathParam("path")
		 	@Parameter(
		 	    		description = "Path to the git directory",
		 	    		example = "dir1/subdirA"
		 	    		)
			String path) {
		try {
			java.nio.file.Path gitpath = RepoService.getEffectivePath(request, path);
			try (Git git = Git.open(gitpath.toFile());) {
				if (git != null) {
					String url = git.getRepository().getConfig().getString("remote", "origin", "url");
					if (url == null) {
						throw new IOException("No git remote url specified yet");
					} else {
						GitResult result = new GitResult();
						PullResult pullresult = git.pull()
							.setRemote("origin")
							.setContentMergeStrategy(ContentMergeStrategy.OURS)
							.setCredentialsProvider(getGitCredentials(git))
							.call();
						result.add(pullresult.getFetchResult());
						result.add(pullresult.getMergeResult());
						result.add(pullresult.getRebaseResult());
						return Response.ok(result).build();
					}
				} else {
					return ErrorMessage.createResponse("Git not configured");
				}
			}
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@POST
	@Path("gitpush/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Push contents to git repository",
			description = "Does a git add, commit and push",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "Returns information about the success of the operation",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = GitResult.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "202", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Repository")
    public Response gitPush(
    		@PathParam("path")
		 	@Parameter(
		 	    		description = "Path to the git directory",
		 	    		example = "dir1/subdirA"
		 	    		)
			String path,
   		 	@Parameter(
   	 	    		description = "Commit message",
   	 	    		example = "Initial commit"
   	 	    		)
    		GitCommit gitcommit) {
		String message = gitcommit.getMessage();
		try {
			java.nio.file.Path gitpath = RepoService.getEffectivePath(request, path);
			try (Git git = Git.open(gitpath.toFile());) {
				if (git != null) {
					GitResult result = new GitResult();
					CredentialsProvider credentials = getGitCredentials(git);
					if (message == null || message.length() == 0) {
						message = "commit at " + DateFormat.getInstance().format(new Date()); 
					}
					org.eclipse.jgit.api.Status status = git.status().call();
					
					int diffcount = 0;
					/*
					 * The git.addFilePattern(".") seems to read all files and takes a while hence 
					 */
					for(String file : status.getModified()) {
						git.add().setUpdate(true).addFilepattern(file).call(); // add all modified files
						diffcount++;
					}
					for(String file : status.getMissing()) {
						git.rm().addFilepattern(file).call(); // remove deleted files
						diffcount++;
					}
					for(String file : status.getUntracked()) {
						git.add().addFilepattern(file).call(); // add all untracked files
						diffcount++;
					}
					if (diffcount != 0) {
						/*
						 * local filesystem and local git index were different, hence git commit
						 */
						git.commit().setMessage(message).call();
						result.setCommitCalled(true);
					}
					String url = git.getRepository().getConfig().getString("remote", "origin", "url");
					if (url == null) {
						throw new IOException("No git remote url specified yet");
					} else {
						Iterator<PushResult> iter = git.push()
							.setRemote("origin")
							// .add("main")
							.setCredentialsProvider(credentials)
							.call().iterator();
						while (iter.hasNext()) {
							PushResult pushResult = iter.next();
							result.add(pushResult);
						}
					}
					return Response.ok(result).build();
				} else {
					throw new IOException("No git repository configured at that path");
				}
			}
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}
	
	@POST
	@Path("gitconfig/{path:.*}")
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
							responseCode = "202", 
							description = "Any exception thrown, e.g. file at path does not exist",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Repository")
    public Response gitconfig(
    		@PathParam("path")
		 	@Parameter(
		 	    		description = "Path to the git directory",
		 	    		example = "dir1/subdirA"
		 	    		)
			String path,
   		 	@Parameter(
   	 	    		description = "Config data",
   	 	    		example = "{ url: 'https://github.com/my/repo', username: 'hello', passwd: 'world' }"
   	 	    		)
    		GitConfig gitconfig) {
		try {
			java.nio.file.Path gitpath = RepoService.getEffectivePath(request, path);
			validateGitWithinGit(gitpath, RepoDirectory.getRepoUserDir(request));
			CredentialsProvider credentials = gitconfig.createUserPasswordProvider();
			Collection<Ref> remoterepofiles = new LsRemoteCommand(null)
					.setRemote(gitconfig.getRemoteurl())
					.setCredentialsProvider(credentials).call();
			// remote repo exists and can be connected
			gitconfig.save(gitpath);
			File gitdir = new File(gitpath.toFile(), Constants.DOT_GIT);
			String[] localfiles = gitpath.toFile().list();
			String message;
			if (remoterepofiles == null || remoterepofiles.size() == 0) {
				if (!gitdir.exists()) {
					// Case 1: The remote is empty and no local git repo, hence git init.
					/*
					 * echo "# temp" >> README.md
					 * git init
					 * git add README.md
					 * git commit -m "first commit"
					 * git branch -M main
					 * git remote add origin https://github.com/rtdi/temp.git
					 * git push -u origin main
					 */
					try (Git git = Git.init().setDirectory(gitpath.toFile()).call();) {
						setGitRemote(git, gitconfig);
						updateConfig(git, gitconfig);
						// git.branchCreate().setName("main").call();
						message = "git init with remote set";
					}
				} else {
					// Case 2: The remote is empty and a local git repo exists, hence git open and update to the new remote.
					/*
					 * git remote add origin https://github.com/rtdi/temp.git
					 * git branch -M main
					 * git push -u origin main
					 */
					try (Git git = Git.open(gitpath.toFile());) {
						setGitRemote(git, gitconfig);
						updateConfig(git, gitconfig);
						// git.branchCreate().setName("main").call();
						message = "git remote set";
					}
				}
			} else if (localfiles == null || localfiles.length == 0) {
				// Case #3: The local repo does not exist and the local folder is empty
				try (Git git = Git.cloneRepository()
						  .setURI(gitconfig.getRemoteurl())
						  .setDirectory(gitpath.toFile())
						  .setCredentialsProvider(credentials)
						  .call();) {
					updateConfig(git, gitconfig);
					message = "git clone";
				}
			} else {
				if (!gitdir.exists()) {
					// Case #4: The local filesystem has data but no git and the remote has data
					try (Git git = Git.init().setDirectory(gitpath.toFile()).call();) {
						setGitRemote(git, gitconfig);
						updateConfig(git, gitconfig);
						try {
							git.pull()
								// .setRemote("origin")
								.setCredentialsProvider(getGitCredentials(git))
								.call();
							message = "git init with remote set and pulled remote";
						} catch (CheckoutConflictException e) {
							message = e.getMessage();
						}
					}
				} else {
					// Case #5: The local filesystem has data in its git and the remote has data
					try (Git git = Git.open(gitpath.toFile());) {
						setGitRemote(git, gitconfig);
						updateConfig(git,gitconfig);
						try {
							git.pull()
								// .setRemote("origin")
								.setCredentialsProvider(getGitCredentials(git))
								.call();
							message = "Created local git repo and pulled remote";
						} catch (CheckoutConflictException e) {
							message = e.getMessage();
						}
						/* FetchResult fetchresult = git.fetch().setCredentialsProvider(credentials).call();
						git.branchCreate().setName(branchName).setStartPoint("origin/" + branchName)
						    .setUpstreamMode(CreateBranchCommand.SetupUpstreamMode.TRACK).call();
						Ref ref = git.checkout().setName(branchName).call();
						FetchResult fetchresult = git.fetch().setCredentialsProvider(credentials).call();
						git.reset().setRef("origin/" + branchName).call(); */
					}
				}
			}
			return Response.ok(new SuccessMessage(message)).build();
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	private void validateGitWithinGit(java.nio.file.Path gitpath, java.nio.file.Path upath) throws IOException {
		java.nio.file.Path  current = gitpath.getParent();
		while (current != null && !current.equals(upath)) {
			File f = new File(gitpath.toFile(), Constants.DOT_GIT);
			if (f.exists()) {
				throw new IOException("The request git path is within a parent git directory");
			}
			current = current.getParent();
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

	/**
	 * The repo must have a username and email for git commands to work.
	 * 
	 * @param git
	 * @param username
	 * @param gitconfig
	 * @throws IOException
	 */
	private void updateConfig(Git git, GitConfig gitconfig) throws IOException {
		StoredConfig config = git.getRepository().getConfig();
        config.setString("user", null, "name", gitconfig.getUsername());
        config.setString("user", null, "email", gitconfig.getEmail());
        config.save();
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
	/**
	 * Either read the credentials from the session. If the session does not have any yet because the have not been read,
	 * the credentials are read from the file and stored with the session for faster access.   
	 * @param git
	 * @return
	 * @throws IOException
	 */
	private CredentialsProvider getGitCredentials(Git git) throws IOException {
		String a = "git." + git.getRepository().getWorkTree();
		HttpSession s = request.getSession(false);
		CredentialsProvider credentials = (CredentialsProvider) s.getAttribute(a);
		if (credentials == null) {
			GitConfig gitconfig = GitConfig.createFromFile(git);
			credentials = gitconfig.createUserPasswordProvider();
			s.setAttribute(a, credentials);
		}
		return credentials;
	}

	public static class GitConfig {
		private String remoteurl;
		private String username;
		private String password;
		private String email;
		private String token;
		
		public GitConfig() {
		}
		
		public static GitConfig createFromFile(Git git) throws JsonParseException, JsonMappingException, IOException {
			File d = git.getRepository().getWorkTree().getParentFile();
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(new File(d, ".remotesettings"), GitConfig.class);
		}		
		
		public String getRemoteurl() {
			return remoteurl;
		}
		
		public void save(java.nio.file.Path gitpath) throws JsonGenerationException, JsonMappingException, IOException {
			File d = gitpath.getParent().toFile();
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File(d, ".remotesettings"), this);
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}
		
		public CredentialsProvider createUserPasswordProvider() {
			if (token == null) {
				return new UsernamePasswordCredentialsProvider(username, password);
			} else {
				return new UsernamePasswordCredentialsProvider(token, "");
			}
		}

		
	}

}
