package io.rtdi.appcontainer.repo.rest.entity;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.RemoteConfig;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.rtdi.appcontainer.repo.UserPreferences;

public class GitConfig {
	private String remoteurl;
	private String username;
	private String password;
	private String email;
	private String token;
	
	public GitConfig() {
	}
	
	public void saveUserData(Git git, UserPreferences up) throws JsonProcessingException, IOException {
		String sectionname = getUserPreferencesSectionName(git, up);
		up.getSecureStore().storeValue(sectionname, "password", password);
		up.getSecureStore().storeValue(sectionname, "token", token);
		up.save();
	}

	public static GitConfig createFromFile(Git git, UserPreferences up) {
		StoredConfig config = git.getRepository().getConfig();
		GitConfig gitconfig = new GitConfig();
		gitconfig.setUsername(config.getString("user", null, "name"));
		gitconfig.setEmail(config.getString("user", null, "email"));
		String url = git.getRepository().getConfig().getString("remote", "origin", "url");
		gitconfig.setRemoteurl(url);
		String sectionname = getUserPreferencesSectionName(git, up);
		gitconfig.setPassword(up.getSecureStore().value(sectionname, "password"));
		gitconfig.setToken(up.getSecureStore().value(sectionname, "token"));
		return gitconfig;
	}
	
	private static String getUserPreferencesSectionName(Git git, UserPreferences up) {
		java.nio.file.Path upath = up.getUserDirectoryPath();
		java.nio.file.Path relative = upath.relativize(git.getRepository().getWorkTree().toPath());
		return "git_" + relative.toString();
	}

	public String getRemoteurl() {
		return remoteurl;
	}
	
	public void setGitRemote(Git git) throws GitAPIException, URISyntaxException {
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
			git.remoteSetUrl().setRemoteName("origin").setRemoteUri(new URIish(getRemoteurl())).call();
		} else {
			git.remoteAdd().setName("origin").setUri(new URIish(getRemoteurl())).call();
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
	public void updateConfig(Git git) throws IOException {
		StoredConfig config = git.getRepository().getConfig();
        config.setString("user", null, "name", getUsername());
        config.setString("user", null, "email", getEmail());
        config.save();
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