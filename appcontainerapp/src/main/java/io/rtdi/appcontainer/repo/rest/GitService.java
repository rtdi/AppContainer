package io.rtdi.appcontainer.repo.rest;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.LsRemoteCommand;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.merge.ContentMergeStrategy;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.PushResult;

import io.rtdi.appcontainer.repo.RepoDirectory;
import io.rtdi.appcontainer.repo.UserPreferences;
import io.rtdi.appcontainer.repo.rest.entity.GitCommit;
import io.rtdi.appcontainer.repo.rest.entity.GitConfig;
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
import jakarta.servlet.ServletException;
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
			UserPreferences up = UserPreferences.getFromSession(request);
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
							.setCredentialsProvider(getGitConfig(git, up).createUserPasswordProvider())
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
			UserPreferences up = UserPreferences.getFromSession(request);
			java.nio.file.Path gitpath = RepoService.getEffectivePath(request, path);
			try (Git git = Git.open(gitpath.toFile());) {
				if (git != null) {
					GitResult result = new GitResult();
					CredentialsProvider credentials = getGitConfig(git, up).createUserPasswordProvider();
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
	
	/**
	 * As this API is called to read GitConfig data and it might not be fully defined yet, it should return an
	 * empty GitConfig object in case.
	 * 
	 * @param path
	 * @return an existing or a new GitConfig object
	 */
	@GET
	@Path("gitconfig/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Get configured remote git",
			description = "Returns the current settings for the remote git repo",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "Returns the config data",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = GitConfig.class)
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
    public Response getGitconfig(
    		@PathParam("path")
		 	@Parameter(
		 	    		description = "Path to the git directory",
		 	    		example = "dir1/subdirA"
		 	    		)
			String path) {
		try {
			UserPreferences up = UserPreferences.getFromSession(request);
			java.nio.file.Path gitpath = RepoService.getEffectivePath(request, path);
			GitConfig gitconfig = null;
			File gitdir = new File(gitpath.toFile(), Constants.DOT_GIT);
			if (gitdir.exists()) {
				try (Git git = Git.open(gitpath.toFile());) {
					if (git != null) {
						gitconfig = getGitConfig(git, up);
					}
				}
			}
			if (gitconfig == null) {
				gitconfig = new GitConfig();
			}
			return Response.ok(gitconfig).build();
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
			UserPreferences up = UserPreferences.getFromSession(request);
			java.nio.file.Path gitpath = RepoService.getEffectivePath(request, path);
			validateGitWithinGit(gitpath, RepoDirectory.getRepoUserDir(request));
			CredentialsProvider credentials = gitconfig.createUserPasswordProvider();
			Collection<Ref> remoterepofiles = new LsRemoteCommand(null)
					.setRemote(gitconfig.getRemoteurl())
					.setCredentialsProvider(credentials).call();
			// remote repo exists and can be connected
			saveGitConfigInSession(path, gitconfig);
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
						gitconfig.setGitRemote(git);
						gitconfig.updateConfig(git);
						gitconfig.saveUserData(git, up);
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
						gitconfig.setGitRemote(git);
						gitconfig.updateConfig(git);
						gitconfig.saveUserData(git, up);
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
					gitconfig.updateConfig(git);
					gitconfig.saveUserData(git, up);
					message = "git clone";
				}
			} else {
				if (!gitdir.exists()) {
					// Case #4: The local filesystem has data but no git and the remote has data
					try (Git git = Git.init().setDirectory(gitpath.toFile()).call();) {
						gitconfig.setGitRemote(git);
						gitconfig.updateConfig(git);
						gitconfig.saveUserData(git, up);
						message = "git init with remote set, no pull yet as both have data";
					}
				} else {
					// Case #5: The local filesystem has data in its git and the remote has data
					try (Git git = Git.open(gitpath.toFile());) {
						gitconfig.setGitRemote(git);
						gitconfig.updateConfig(git);
						gitconfig.saveUserData(git, up);
						message = "Updated the local configuration, both, local and remote have data";
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

	/**
	 * Either read the credentials from the session. If the session does not have any yet because the have not been read,
	 * the credentials are read from the file and stored with the session for faster access.   
	 * @param git
	 * @return
	 * @throws IOException
	 * @throws ServletException 
	 */
	private GitConfig getGitConfig(Git git, UserPreferences up) throws IOException, ServletException {
		java.nio.file.Path upath = RepoDirectory.getRepoUserDir(request);
		java.nio.file.Path wpath = java.nio.file.Path.of(git.getRepository().getWorkTree().getPath());
		String a = getGitConfigSessionVariable(upath.relativize(wpath).toString());
		HttpSession s = request.getSession(false);
		GitConfig gitconfig = (GitConfig) s.getAttribute(a);
		if (gitconfig == null) {
			gitconfig = GitConfig.createFromFile(git, up);
			s.setAttribute(a, gitconfig);
		}
		return gitconfig;
	}
	
	private void saveGitConfigInSession(String path, GitConfig gitconfig) {
		String a = getGitConfigSessionVariable(path);
		HttpSession s = request.getSession(false);
		s.setAttribute(a, gitconfig);
	}
	
	private String getGitConfigSessionVariable(String path) {
		return "git." + path;
	}

}
