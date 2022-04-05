package io.rtdi.appcontainer.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class HttpUtil {

	public static final String COOKIES_HEADER = "Set-Cookie";

	public static SSLContext sslcontext;
	public static HostnameVerifier verifier;
	private HttpURLConnection conn = null;
	static {
		try {
			verifier = new SSLHostnameVerifierNoop();
			// HttpsURLConnection.setDefaultHostnameVerifier(verifier);
	    	sslcontext = SSLContext.getInstance("TLS");
			sslcontext.init(null, new TrustManager[]{new SSLTrustManagerNoop()}, new java.security.SecureRandom());
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	

	public HttpUtil() {
	}

	public void getHttpConnection(URL url, String requestmethod) throws IOException {
		conn  = (HttpURLConnection) url.openConnection();
		if (conn instanceof HttpsURLConnection) {
			((HttpsURLConnection) conn).setSSLSocketFactory(sslcontext.getSocketFactory());
			((HttpsURLConnection) conn).setHostnameVerifier(verifier);
		}
		conn.setRequestMethod(requestmethod);
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setReadTimeout(60000);
	}
	
	public HttpURLConnection getConnection() {
		return conn;
	}
	
	public SSLContext getSSLContext() {
		return sslcontext;
	}
	
	public HostnameVerifier getHostnameVerifier() {
		return verifier;
	}
	
}
