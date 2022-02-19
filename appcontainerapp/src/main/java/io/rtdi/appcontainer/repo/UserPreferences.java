package io.rtdi.appcontainer.repo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class UserPreferences {

	private Path upath;
	private SecureStore securestore;

	public UserPreferences(Path upath) throws JsonProcessingException, IOException {
		this.upath = upath;
		reload();
	}

	public SecureStore getSecureStore() {
		return securestore;
	}
	
	public void reload() throws JsonProcessingException, IOException {
		File f = new File(upath.toFile(), ".securestore");
		if (f.exists()) {
			ObjectMapper mapper = new ObjectMapper();
			securestore = mapper.readValue(f, SecureStore.class);
		} else {
			securestore = new SecureStore();
		}
	}
	
	public void save() throws JsonProcessingException, IOException {
		File f = new File(upath.toFile(), ".securestore");
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(f, securestore);
	}
	
	public static class SecureStore {
		private Map<String, Map<String, String>> sections;

		public Map<String, String> section(String sectionname) {
			if (sections != null) {
				return sections.get(sectionname);
			} else {
				return null;
			}
		}
		
		public void setSections(Map<String, Map<String, String>> sections) {
			this.sections = sections;
		}
		
		public Map<String, Map<String, String>> getSections() {
			return sections;
		}

		public String value(String sectionname, String key) {
			Map<String, String> s = section(sectionname);
			if (s != null) {
				return s.get(key);
			}
			return null;
		}

		public void storeValue(String sectionname, String key, String value) {
			if (sections == null) {
				sections = new HashMap<>();
			}
			Map<String, String> s = sections.get(sectionname);
			if (s == null) {
				s = new HashMap<>();
				sections.put(sectionname, s);
			}
			s.put(key, value);
		}
	}


	public static UserPreferences getFromSession(HttpServletRequest request) throws ServletException, IOException {
		HttpSession s = request.getSession(false);
		if (s == null) {
			throw new IOException("No session defined, user not logged in");
		} else {
			UserPreferences up = (UserPreferences) s.getAttribute("userpreferences");
			if (up == null) {
				java.nio.file.Path upath = RepoDirectory.getRepoUserDir(request);
				up = new UserPreferences(upath);
				s.setAttribute("userpreferences", up);
			}
			return up;
		}
	}

	public Path getUserDirectoryPath() {
		return upath;
	}
}
