package io.rtdi.hanaappserver.utils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class SSLHostnameVerifierNoop implements HostnameVerifier {
	@Override
	public boolean verify(String hostname, SSLSession session) {
		return true;
	}
}