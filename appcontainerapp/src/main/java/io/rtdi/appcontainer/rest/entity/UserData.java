package io.rtdi.appcontainer.rest.entity;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;

import io.rtdi.appcontainer.databaseloginrealm.IDatabaseLoginPrincipal;

public class UserData {

	private String dbuser;
	private String dbversion;
	private Optional<String> loginwarnings;
	private String[] roles;
	private String schema;
	private UserPrefrences preferences;

	public UserData(IDatabaseLoginPrincipal dbprincipal) {
		dbuser = dbprincipal.getDBUser();
		dbversion = dbprincipal.getDBVersion();
		loginwarnings = dbprincipal.getLoginWarnings();
		roles = dbprincipal.getRoles();
		schema = dbprincipal.getSchema();
		preferences = new UserPrefrences();
	}

	public String getDbuser() {
		return dbuser;
	}

	public String getDbversion() {
		return dbversion;
	}

	public Optional<String> getLoginwarnings() {
		return loginwarnings;
	}

	public String[] getRoles() {
		return roles;
	}

	public String getSchema() {
		return schema;
	}

	public UserPrefrences getPreferences() {
		return preferences;
	}

	public static class UserPrefrences {
		private String dateformat = "yyy-mm-dd";
		private String timeformat = "HH:mi:ss";
		private String datetimeformat = "yyy-mm-dd HH:mi:ss";
		private Locale locale = Locale.US;
		private TimeZone tz = TimeZone.getTimeZone("GMT");
		private Map<String, String> usersettings;
		
		public String getLanguageCode() {
			return locale.getISO3Language();
		}
		
		public String getCountryCode() {
			return locale.getISO3Country();
		}

		public String getDateformat() {
			return dateformat;
		}

		public String getTimeformat() {
			return timeformat;
		}

		public String getDatetimeformat() {
			return datetimeformat;
		}
		
		public String getTimeZoneID() {
			return tz.getID();
		}
		
		public void addUserSetting(String key, String value) {
			if (usersettings == null) {
				usersettings = new HashMap<>();
			}
			usersettings.put(key, value);
		}

		public Map<String, String> getUsersettings() {
			return usersettings;
		}
		
	}
}
