# Athentication and authorization

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
