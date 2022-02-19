package io.rtdi.appcontainer.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.rtdi.appcontainer.repo.rest.entity.GitCommit;
import io.rtdi.appcontainer.repo.rest.entity.GitConfig;

public class RepoRestCalls {
	private HttpClientContext context;
	private CloseableHttpClient httpClient;
	private static String WEBAPPURL = "http://localhost:8080/appcontainerapp";
	private static String FSAPI = WEBAPPURL + "/protected/rest/repo";
	private static String ACTIVATIONAPI = WEBAPPURL + "/protected/rest/activation";
	private static String GITAPI = WEBAPPURL + "/protected/rest/git";
	private static ObjectMapper mapper = new ObjectMapper();
	
	public RepoRestCalls() throws URISyntaxException, ClientProtocolException, IOException {
		BasicCookieStore cookieStore = new BasicCookieStore();
		HttpGet request = new HttpGet();
	    context = HttpClientContext.create();
	    context.setCookieStore(cookieStore);

	    List<NameValuePair> params = new ArrayList<>();
	    params.add(new BasicNameValuePair("username", "wdaehn"));
	    params.add(new BasicNameValuePair("password", "W4JCv3tz4crxNZn"));
	    URI uri = new URIBuilder(WEBAPPURL + "/restlogin")
	    	      .addParameters(params)
	    	      .build();
	    request.setURI(uri);
	    RequestConfig requestConfig = RequestConfig.custom().setCircularRedirectsAllowed(true).build();
	    httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .setRedirectStrategy(new LaxRedirectStrategy())
                .build();
    	try (CloseableHttpResponse response = httpClient.execute(request, context);) {
    		String ret = EntityUtils.toString(response.getEntity());
    		if (!ret.equals("{\"message\":\"OK\"}")) {
    			throw new IOException("Login failed");
    		}
    	}
	}

	public JsonNode rmdir(String path) throws ClientProtocolException, IOException {
    	try (CloseableHttpResponse response = httpClient.execute(new HttpGet(FSAPI + "/rmdir" + path), context);) {
    		String ret = EntityUtils.toString(response.getEntity());
    		if (response.getStatusLine().getStatusCode() != 200) {
    			throw new IOException("rmdir " + path + " failed with: " + ret);
    		} else {
    			return parseJson(ret);
    		}
    	}
	}

	public JsonNode mkdir(String path) throws ClientProtocolException, IOException {
    	try (CloseableHttpResponse response = httpClient.execute(new HttpGet(FSAPI + "/mkdir" + path), context);) {
    		String ret = EntityUtils.toString(response.getEntity());
    		if (response.getStatusLine().getStatusCode() != 200) {
    			throw new IOException("mkdir " + path + " failed with: " + ret);
    		} else {
    			return parseJson(ret);
    		}
    	}
	}

	public JsonNode touch(String path) throws ClientProtocolException, IOException {
    	try (CloseableHttpResponse response = httpClient.execute(new HttpGet(FSAPI + "/touch" + path), context);) {
    		String ret = EntityUtils.toString(response.getEntity());
    		if (response.getStatusLine().getStatusCode() != 200) {
    			throw new IOException("touch " + path + " failed with: " + ret);
    		} else {
    			return parseJson(ret);
    		}
    	}
	}

	public JsonNode listFiles(String path) throws ClientProtocolException, IOException {
    	try (CloseableHttpResponse response = httpClient.execute(new HttpGet(FSAPI + "/files" + path), context);) {
    		String ret = EntityUtils.toString(response.getEntity());
    		if (response.getStatusLine().getStatusCode() != 200) {
    			throw new IOException("list files " + path + " failed with: " + ret);
    		} else {
    			return parseJson(ret);
    		}
    	}
	}

	public JsonNode dir(String path) throws ClientProtocolException, IOException {
    	try (CloseableHttpResponse response = httpClient.execute(new HttpGet(FSAPI + "/dir" + path), context);) {
    		String ret = EntityUtils.toString(response.getEntity());
    		if (response.getStatusLine().getStatusCode() != 200) {
    			throw new IOException("dir " + path + " failed with: " + ret);
    		} else {
    			return parseJson(ret);
    		}
    	}
	}

	public JsonNode mv(String frompath, String topath) throws ClientProtocolException, IOException {
		HttpPost p = new HttpPost(FSAPI + "/mv" + frompath);
		p.setEntity(new StringEntity("{ \"path\": \"" + topath + "\" }", ContentType.APPLICATION_JSON));
    	try (CloseableHttpResponse response = httpClient.execute(p, context);) {
    		String ret = EntityUtils.toString(response.getEntity());
    		if (response.getStatusLine().getStatusCode() != 200) {
    			throw new IOException("mv " + frompath + " to " + topath + " failed with: " + ret);
    		} else {
    			return parseJson(ret);
    		}
    	}
	}

	public boolean exists(String path) throws ClientProtocolException, IOException {
    	try (CloseableHttpResponse response = httpClient.execute(new HttpGet(FSAPI + "/exists" + path), context);) {
    		String ret = EntityUtils.toString(response.getEntity());
    		if (response.getStatusLine().getStatusCode() == 404) {
    			return false;
    		} else if (response.getStatusLine().getStatusCode() == 200) {
    			return true;
    		} else {
    			throw new IOException("exists " + path + " failed with: " + ret);
    		}
    	}
	}
	
	public JsonNode save(String path, String text) throws ClientProtocolException, IOException {
		HttpPost p = new HttpPost(FSAPI + "/file" + path);
		p.setEntity(new StringEntity(text));
    	try (CloseableHttpResponse response = httpClient.execute(p, context);) {
    		String ret = EntityUtils.toString(response.getEntity());
    		if (response.getStatusLine().getStatusCode() != 200) {
    			throw new IOException("save to file " + path + " failed with: " + ret);
    		} else {
    			return parseJson(ret);
    		}
    	}
	}

	public JsonNode read(String path) throws ClientProtocolException, IOException {
		HttpGet p = new HttpGet(FSAPI + "/file" + path);
    	try (CloseableHttpResponse response = httpClient.execute(p, context);) {
    		String ret = EntityUtils.toString(response.getEntity());
    		if (response.getStatusLine().getStatusCode() != 200) {
    			throw new IOException("save to file " + path + " failed with: " + ret);
    		} else {
    			return parseJson(ret);
    		}
    	}
	}

	public JsonNode gitconfig(String path, GitConfig gitconfig) throws ClientProtocolException, IOException {
		HttpPost p = new HttpPost(GITAPI + "/gitconfig" + path);
		p.setEntity(new StringEntity(objectToJson(gitconfig), ContentType.APPLICATION_JSON));
    	try (CloseableHttpResponse response = httpClient.execute(p, context);) {
    		String ret = EntityUtils.toString(response.getEntity());
    		if (response.getStatusLine().getStatusCode() != 200) {
    			throw new IOException("git config " + path + " failed with: " + ret);
    		} else {
    			return parseJson(ret);
    		}
    	}
	}

	public JsonNode gitpush(String path, GitCommit commit) throws ClientProtocolException, IOException {
		HttpPost p = new HttpPost(GITAPI + "/gitpush" + path);
		p.setEntity(new StringEntity(objectToJson(commit), ContentType.APPLICATION_JSON));
    	try (CloseableHttpResponse response = httpClient.execute(p, context);) {
    		String ret = EntityUtils.toString(response.getEntity());
    		if (response.getStatusLine().getStatusCode() != 200) {
    			throw new IOException("git push " + path + " failed with: " + ret);
    		} else {
    			return parseJson(ret);
    		}
    	}
	}

	public JsonNode gitpull(String path) throws ClientProtocolException, IOException {
		HttpGet p = new HttpGet(GITAPI + "/gitpull" + path);
    	try (CloseableHttpResponse response = httpClient.execute(p, context);) {
    		String ret = EntityUtils.toString(response.getEntity());
    		if (response.getStatusLine().getStatusCode() != 200) {
    			throw new IOException("git pull of " + path + " failed with: " + ret);
    		} else {
    			return parseJson(ret);
    		}
    	}
	}

	
	public JsonNode parseJson(String payload) throws IOException {
		try {
			return mapper.readTree(payload);
		} catch (JsonProcessingException e) {
			throw new IOException("Failed to parse the result as a JSON payload", e);
		}
	}
	
	public String objectToJson(Object o) throws IOException {
		try {
			return mapper.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			throw new IOException("Failed to convert the object to a JSON string", e);
		}
	}
	
	public Map<String, JsonNode> getJsonKV(JsonNode node) {
		Map<String, JsonNode> m = new HashMap<>();
		fillJsonKV(node, m, null);
		return m;
	}

	public void fillJsonKV(JsonNode node, Map<String, JsonNode> m, String path) {
		Iterator<Entry<String, JsonNode>> iter = node.fields();
		while (iter.hasNext()) {
			Entry<String, JsonNode> e = iter.next();
			JsonNode n = e.getValue();
			String p = (path==null?e.getKey():path + "->" + e.getKey());
			if (n.isTextual()) {
				m.put(p + ":" + n.textValue(), n);
			} else if (n.isNumber()) {
				m.put(p + ":" + n.numberValue(), n);
			} else if (n instanceof ArrayNode) {
				ArrayNode a = (ArrayNode) n;
				if (a.size() == 0) {
					m.put(p + ":", null);
				} else {
					for (int i=0; i<a.size();i++) {
						fillJsonKV(a.get(i), m, p);
					}
				}
			} else if (n instanceof ObjectNode) {
				fillJsonKV(n, m, p);
			}
		}
	}
	
	public boolean isSuccess(JsonNode node) {
		JsonNode n = node.get("message");
		if (n != null) {
			return "OK".equals(n.textValue());
		} else {
			return false;
		}
	}

	public void close() throws IOException {
		httpClient.close();
	}

	public JsonNode activate(String path) throws ClientProtocolException, IOException {
    	try (CloseableHttpResponse response = httpClient.execute(new HttpGet(ACTIVATIONAPI + "/activate" + path), context);) {
    		String ret = EntityUtils.toString(response.getEntity());
    		if (response.getStatusLine().getStatusCode() != 200) {
    			throw new IOException("activate " + path + " failed with: " + ret);
    		} else {
    			return parseJson(ret);
    		}
    	}
	}

}
