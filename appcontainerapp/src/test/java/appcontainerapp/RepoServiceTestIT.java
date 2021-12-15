package appcontainerapp;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RepoServiceTestIT {

	private static HttpClientContext context;
	private static CloseableHttpClient httpClient;
	private static String WEBAPPURL = "http://localhost:8080/appcontainerapp";
	private static String FSAPI = WEBAPPURL + "/protected/rest/repo";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
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
    	try (CloseableHttpResponse response = httpClient.execute(new HttpGet(FSAPI + "/rmdir/testreposervice"), context);) {
    		String ret = EntityUtils.toString(response.getEntity());
    		if (ret.equals("{\"message\":\"OK\"}")) {
    			System.out.println("Existing /testreposervice directory got deleted");
    		} else {
    			System.out.println(ret);
    		}
    	}
    	mkdir("/testreposervice");
    	mkdir("/testreposervice/dir1");
    	mkdir("/testreposervice/dir1/dirA");
    	mkdir("/testreposervice/dir2");
    	touch("/testreposervice/rootfile.txt");
    	touch("/testreposervice/dir1/dirA/file1.txt");
    	touch("/testreposervice/dir1/dirA/file2.txt");
    	touch("/testreposervice/dir1/file.txt");
    	touch("/testreposervice/dir2/file.txt");
	}
	
	private static void mkdir(String path) throws ClientProtocolException, IOException {
    	try (CloseableHttpResponse response = httpClient.execute(new HttpGet(FSAPI + "/mkdir" + path), context);) {
    		if (response.getStatusLine().getStatusCode() != 200) {
        		String ret = EntityUtils.toString(response.getEntity());
    			throw new IOException("mkdir " + path + " failed with: " + ret);
    		}
    	}
	}

	private static void touch(String path) throws ClientProtocolException, IOException {
    	try (CloseableHttpResponse response = httpClient.execute(new HttpGet(FSAPI + "/touch" + path), context);) {
    		if (response.getStatusLine().getStatusCode() != 200) {
        		String ret = EntityUtils.toString(response.getEntity());
    			throw new IOException("touch " + path + " failed with: " + ret);
    		}
    	}
	}

	private static String dir(String path) throws ClientProtocolException, IOException {
    	try (CloseableHttpResponse response = httpClient.execute(new HttpGet(FSAPI + "/dir" + path), context);) {
    		String ret = EntityUtils.toString(response.getEntity());
    		if (response.getStatusLine().getStatusCode() != 200) {
    			throw new IOException("dir " + path + " failed with: " + ret);
    		} else {
    			return ret;
    		}
    	}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		httpClient.close();
	}

	@Test
	void testDir() {
		try {
			String s1 = dir("");
			String s2 = dir("/testreposervice");
			String s3 = dir("/testreposervice/dir1/dirA");
		} catch (Exception e) {
			e.printStackTrace();
		    fail(e.getMessage());
		}
	}

}
