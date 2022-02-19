package io.rtdi.appcontainer.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;

import io.rtdi.appcontainer.databaseloginrealm.IDatabaseLoginPrincipal;
import jakarta.servlet.http.HttpServletRequest;

public class Util {

	/**
	 * Tomcat prevents encoded / chars (as %2f) for security reasons. Therefore this character sequence is encoded a second time.
	 * 
	 * @param input an encoded String for the path segment of an URI, see webide/ui5/controls/helperfunctions.js/encodeURIfull()
	 * @return the actual object name
	 */
	public static String decodeURIfull(String input) {
		if (input != null) {
			return input.replace("%2f", "/");
		} else {
			return input;
		}
	}

	public static String encodeURIfull(String input) {
		if (input != null) {
			return input.replace("/", "%2f");
		} else {
			return input;
		}
	}
	
	public static String getAppSchemaFromReferrer(HttpServletRequest req) throws URISyntaxException {
		String referrer = req.getHeader("referer");
		if (referrer != null) {
			URI uri = new URI(referrer);
			String referrerpath = uri.getPath();
			String[] parts = referrerpath.split("/");
			// parts = [, AppContainer, protected, repo, currentuser, WEBPROJEKT, index.html]
			if (parts.length > 5 && parts[3].equals("repo")) {
				return parts[5];
			}
		}
		return null;
	}
	
	public static String getSchema(String schemaname, HttpServletRequest req) throws URISyntaxException {
		if (schemaname.equals(".") || schemaname.equals("currentuser")) {
			Principal p = req.getUserPrincipal();
			if (p instanceof IDatabaseLoginPrincipal) {
				IDatabaseLoginPrincipal apppricipal = (IDatabaseLoginPrincipal) p;
				schemaname = apppricipal.getDBUser();
			}
		} else if (schemaname.equals("appschema")) {
			String referrerschema = getAppSchemaFromReferrer(req);
			if (referrerschema != null) {
				schemaname = referrerschema;
			}
		}
		return schemaname;
	}

}
