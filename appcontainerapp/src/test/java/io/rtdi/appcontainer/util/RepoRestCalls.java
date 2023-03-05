package io.rtdi.appcontainer.util;

import java.io.IOException;

import org.apache.hc.core5.http.ContentType;

import com.fasterxml.jackson.databind.JsonNode;

import io.rtdi.appcontainer.repo.rest.entity.GitCommit;
import io.rtdi.appcontainer.repo.rest.entity.GitConfig;

public class RepoRestCalls {
	private RestClient client;
	private static final String FSAPI = "/protected/rest/repo";
	private static final String ACTIVATIONAPI = "/protected/rest/activation";
	private static final String GITAPI = "/protected/rest/git";
	
	public RepoRestCalls(RestClient client) throws IOException {
		this.client = client;
	}

	public JsonNode rmdir(String path) throws IOException {
		return client.executeJsonGet(FSAPI + "/rmdir" + path).getJson();
	}

	public JsonNode mkdir(String path) throws IOException {
		return client.executeJsonGet(FSAPI + "/mkdir" + path).getJson();
	}

	public JsonNode touch(String path) throws IOException {
		return client.executeJsonGet(FSAPI + "/touch" + path).getJson();
	}

	public JsonNode listFiles(String path) throws IOException {
		return client.executeJsonGet(FSAPI + "/files" + path).getJson();
	}

	public JsonNode dir(String path) throws IOException {
		return client.executeJsonGet(FSAPI + "/dir" + path).getJson();
	}

	public JsonNode mv(String frompath, String topath) throws IOException {
		return client.executeJsonPost(FSAPI + "/mv" + frompath,"{ \"path\": \"" + topath + "\" }").getJson();
	}

	public boolean exists(String path) throws IOException {
		ResponseData response = client.executeJsonGetRaw(FSAPI + "/exists" + path);
		if (response.getStatus() == 404) {
			return false;
		} else if (response.getStatus() == 200) {
			return true;
		} else {
			throw new IOException("exists " + path + " failed with: " + response.getPayload());
		}
	}
	
	public JsonNode save(String path, String text) throws IOException {
		return client.executeJsonPost(FSAPI + "/file" + path, text, ContentType.TEXT_PLAIN).getJson();
	}

	public JsonNode rmFile(String path) throws IOException {
		return client.executeJsonGet(FSAPI + "/rm" + path).getJson();
	}

	public JsonNode read(String path) throws IOException {
		return client.executeJsonGet(FSAPI + "/file" + path).getJson();
	}

	public JsonNode gitconfig(String path, GitConfig gitconfig) throws IOException {
		return client.executeJsonPost(GITAPI + "/gitconfig" + path, gitconfig).getJson();
	}

	public JsonNode gitpush(String path, GitCommit commit) throws IOException {
		return client.executeJsonPost(GITAPI + "/gitpush" + path, commit).getJson();
	}

	public JsonNode gitpull(String path) throws IOException {
		return client.executeJsonGet(GITAPI + "/gitpull" + path).getJson();
	}

	public JsonNode activate(String path) throws IOException {
		return client.executeJsonGet(ACTIVATIONAPI + "/activate" + path).getJson();
	}

}
