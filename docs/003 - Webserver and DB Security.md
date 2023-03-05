# Authentication and authorization

## Realm to use

Typically a web server comes with its own authentication and authorization realm, chosen be the administrator deploying the web application.
In this case however a database application is built and hence a deep integration with the database permissions is desired.

For example the user has the database permission to create tables in a specifc database schema and this information should be used when creating the design time artifacts as well.
Same argument with the groups a user belongs to. If a user is part of the database role A, he should also have the application permissions that go with that.

Tomcat provides different [standard security realms](https://tomcat.apache.org/tomcat-10.0-doc/realm-howto.html#Standard_Realm_Implementations):

- DataSourceRealm & JDBCRealm: Login data is read from database tables with user/password and roles a user is part of
- JNDIRealm: LDAP
- UserDatabaseRealm & MemoryRealm: An XML file contains all user/password and roles
- JAASRealm: Utilize the Java Authentication & Authorization Service (JAAS) framework

None of these realms use a connected database to for authentication and authorization. The desired program flow would be to present the user with a login form, the entered credentials are then used to login to the database with this particular user, the group memberships read and this information is used in the web application.
As such a realm does not exist, it must be created. And obviously it is database specific.

Another issue is that the database login procedure can have different results:

1. Login was successful and the application can be used.
2. Login was not successful due to invalid credentials.
3. Login was successful but user must change the password before continuing.
4. Database cannot be reached either due to misconfiguration (JDBC URL) or the database is temporary not available.
5. Database is in maintenance mode.

The normal Tomcat realm implementation does only respond with true/false. It does not provide any means of differentiated user feedback, not even the option to present the user with a specific error message.
This has been discussed in the support forum of Tomcat and we agreed to file a bug [(see here)](https://bz.apache.org/bugzilla/show_bug.cgi?id=65635).

For the time being the DatabaseLoginPrincipal got an additional property to show warnings at least.


## Tomcat permissions configuration

With the realm being configured, it is now a matter of deciding which URLs are login protected as such. This is done in the [web.xml](../appcontainerapp/src/main/webapp/WEB-INF/web.xml) of the web application.

It defines a role PUBLIC and a security constraint on all URLs `/protected/*`. All pages outside this URL can be accessed without being logged in, e.g. the home page /index.html, and everything with the URL /protected/* can only be access by a logged in user which has the role PUBLIC.

If such a protected resource is opened for the first time, Tomcat automatically triggers the login workflow. Here the procedure is to use a form based login and the login page it shows is called `/login`. This is actually a servlet, the [io.rtdi.appcontainer.servlets.Login](../appcontainerapp/src/main/java/io/rtdi/appcontainer/servlets/Login.java). 

```
	<security-constraint>
		<web-resource-collection>
			<web-resource-name>Protected</web-resource-name>
			<url-pattern>/protected/*</url-pattern>
		</web-resource-collection>
		<auth-constraint>
			<role-name>PUBLIC</role-name>
		</auth-constraint>
	</security-constraint>
	<login-config>
		<auth-method>FORM</auth-method>
		<form-login-config>
			<form-login-page>/login</form-login-page>
			<form-error-page>/error</form-error-page>
		</form-login-config>
	</login-config>
	<security-role>
		<role-name>PUBLIC</role-name>
	</security-role>
```

The form based login method is considered a very safe method, especially compared to BASIC AUTH, but it has the downside that it cannot be used programmatically, e.g. if a client consumes a web service. 
To enable that a [autologin](../appcontainerapp/src/main/java/io/rtdi/appcontainer/servlets/LoginAutomatic.java) servlet exists in parallel to the login servlet. This servlet creates a session, does attach the login data to the session and redirects to the target URL. As this target URL is protected, Tomcat will call the login servlet and that checks if the login data is available in the session. If yes, it is using that.

The logout servlet invalidates the Tomcat session and redirects to the home page.

For rest and OData services there is another endpoint `/restlogin` available. It is a `GET` and expects two query parameters: `username` and `password`. If the login was successful a tomcat session is created.

