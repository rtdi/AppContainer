# Web application basics

Note: This web application is based on tomcat 10 and hence is using the jakarta packages, not the javax packages.

## Maven pom

As it is a dynamic web project based on servlet specification 5.0, the pom entry

```
<dependency>
	<groupId>jakarta.servlet</groupId>
	<artifactId>jakarta.servlet-api</artifactId>
	<version>5.0.0</version>
	<scope>provided</scope>
</dependency>
```

is needed.
All servlets, listeners, etc use the classes as defined in this servlet-api library. If a servlet would be built based on the javax package, they are ignored, or more precise, not recognized as servlets.

All restful classes are built using the jersey JAX-RS library with the jackson JSON library. Hence the dependencies:

```
<dependency>
	<groupId>org.glassfish.jersey.containers</groupId>
	<artifactId>jersey-container-servlet</artifactId>
	<version>3.0.3</version>
</dependency>
<dependency>
	<groupId>org.glassfish.jersey.core</groupId>
	<artifactId>jersey-client</artifactId>
	<version>3.0.3</version>
</dependency>
<dependency>
	<groupId>org.glassfish.jersey.inject</groupId>
	<artifactId>jersey-hk2</artifactId>
	<version>3.0.3</version>
</dependency>
<dependency>
	<groupId>org.glassfish.jersey.media</groupId>
	<artifactId>jersey-media-json-jackson</artifactId>
	<version>3.0.3</version>
</dependency>
```

For the Open API documentation Swagger is used, which consists of two parts.
One is the swagger UI, a web page to render the OpenAPI json descriptor, and the swagger library which introspects the classes for annotations.

```
<dependency>
	<groupId>io.swagger.core.v3</groupId>
	<artifactId>swagger-jaxrs2-jakarta</artifactId>
	<version>2.1.11</version>
</dependency>
<dependency>
	<groupId>io.swagger.core.v3</groupId>
	<artifactId>swagger-jaxrs2-servlet-initializer-jakarta</artifactId>
	<version>2.1.11</version>
</dependency>
<dependency>
	<groupId>io.swagger.core.v3</groupId>
	<artifactId>swagger-annotations</artifactId>
	<version>2.1.11</version>
</dependency>
```

## Configuration

All configurations, as so far as possible, is done via annotations and not the [web.xml](../appcontainerapp/src/main/webapp/WEB-INF/web.xml) file.

The web.xml contains the security settings, telling that all resources under the /protected/* URL require the user to be logged in.

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

As this application is used for development, all resources have a rather short cache time-out for javascript files. This is set globally using a filter.

```
	<filter>
		<filter-name>ExpiresFilter</filter-name>
		<filter-class>org.apache.catalina.filters.ExpiresFilter</filter-class>
		<init-param>
			<param-name>ExpiresDefault</param-name>
			<param-value>access plus 24 hours</param-value>
		</init-param>
		<init-param>
			<param-name>ExpiresByType application/javascript</param-name>
			<param-value>access plus 10 minutes</param-value>
		</init-param>
	</filter>
	<filter-mapping>
		<filter-name>ExpiresFilter</filter-name>
		<url-pattern>/*</url-pattern>
		<dispatcher>REQUEST</dispatcher>
	</filter-mapping>
```

When the tomcat starts it scans all jar files for webserver related annotations (see also [context.xml](../appcontainerapp/src/main/webapp/META-INF/context.xml)).
The most important is the [WebApplication ResourceConfig](../appcontainerapp/src/main/java/io/rtdi/appcontainer/WebApplication.java), which does setup the restful path at `/protected/rest` as root URL and swagger.



