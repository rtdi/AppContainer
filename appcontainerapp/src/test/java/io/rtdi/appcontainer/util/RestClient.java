package io.rtdi.appcontainer.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.apache.hc.client5.http.impl.DefaultRedirectStrategy;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.protocol.HttpClientContext;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class RestClient implements AutoCloseable {
	private HttpClientContext context;
	private CloseableHttpClient httpClient;
	private String webapprooturl;
	private static ObjectMapper mapper = new ObjectMapper();
	
	public RestClient(String username, String credential, String webapprooturl) throws URISyntaxException, ClientProtocolException, IOException, ParseException {
		this.webapprooturl = webapprooturl;
		BasicCookieStore cookieStore = new BasicCookieStore();
	    context = HttpClientContext.create();
	    context.setCookieStore(cookieStore);

	    List<NameValuePair> params = new ArrayList<>();
	    params.add(new BasicNameValuePair("username", username));
	    params.add(new BasicNameValuePair("password", credential));
	    URI uri = new URIBuilder(webapprooturl + "/restlogin")
	    	      .addParameters(params)
	    	      .build();
		HttpGet request = new HttpGet(uri);
	    RequestConfig requestConfig = RequestConfig.custom().setCircularRedirectsAllowed(true).build();
	    httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .setRedirectStrategy(new DefaultRedirectStrategy())
                .build();
    	ResponseData response = httpClient.execute(request, context, new CustomResponseHandler());
		if (!response.getPayload().equals("{\"message\":\"OK\"}")) {
			throw new IOException("Login failed");
		}
	}
	
	public String getWebappRootUrl() {
		return webapprooturl;
	}
	
	public ResponseData executeJsonGet(String apipath) throws IOException {
		String url = webapprooturl + apipath;
    	ResponseData response = httpClient.execute(new HttpGet(url), context, new CustomResponseHandler());
		if (response.getStatus() != 200) {
			throw new IOException("API call GET " + url + " failed with: " + response.getPayload());
		} else {
			return response;
		}
	}

	public ResponseData executeJsonGetRaw(String apipath) throws IOException {
		String url = webapprooturl + apipath;
    	ResponseData response = httpClient.execute(new HttpGet(url), context, new CustomResponseHandler());
		return response;
	}

	public ResponseData executeJsonPost(String apipath, String body, ContentType contenttype) throws IOException {
		String url = webapprooturl + apipath;
		HttpPost p = new HttpPost(url);
		p.setEntity(new StringEntity(body, contenttype));
		ResponseData response = httpClient.execute(p, context, new CustomResponseHandler());
		if (response.getStatus() == 200 || response.getStatus() == 404) {
			return response;
		} else {
			throw new IOException("API call POST " + url + " failed with: " + response.getPayload());
		}
	}

	public ResponseData executeJsonPost(String apipath, String body) throws IOException {
		return executeJsonPost(apipath, body, ContentType.APPLICATION_JSON);
	}

	public ResponseData executeJsonPost(String apipath, Object jsonobject) throws IOException {
		return executeJsonPost(apipath, objectToJson(jsonobject));
	}

	public ResponseData executeJsonPost(String apipath, Object jsonobject, ContentType contenttype) throws IOException {
		return executeJsonPost(apipath, objectToJson(jsonobject), contenttype);
	}

	public static JsonNode parseJson(String payload) throws IOException {
		try {
			return mapper.readTree(payload);
		} catch (JsonProcessingException e) {
			throw new IOException("Failed to parse the result as a JSON payload", e);
		}
	}
	
	public static String objectToJson(Object o) throws IOException {
		try {
			return mapper.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			throw new IOException("Failed to convert the object to a JSON string", e);
		}
	}
	
	public static Map<String, JsonNode> getJsonKV(JsonNode node) {
		Map<String, JsonNode> m = new HashMap<>();
		fillJsonKV(node, m, null);
		return m;
	}

	public static void fillJsonKV(JsonNode node, Map<String, JsonNode> m, String path) {
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
	
	public static boolean isSuccess(JsonNode node) {
		JsonNode n = node.get("message");
		if (n != null) {
			return "OK".equals(n.textValue());
		} else {
			return false;
		}
	}

	@Override
	public void close() throws IOException {
		httpClient.close();
	}
	
	public static String urlencode(String parameter) {
		return URLEncoder.encode(parameter, StandardCharsets.UTF_8);
	}

}
