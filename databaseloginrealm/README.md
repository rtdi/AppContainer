# DatabaseLoginRealm

All this package consists of the base objects to build a database login Realm.

The program flow of such realm and principal is

1. Tomcat wants to authenticate a user
2. Tomcat is configured in the server.xml configuration file to use a specific realm, one that is of this type
3. The realm gets the JDBCURL from the realm configuration set
4. authenticate(String username, String credentials) of the realm is called and should return a new Principal
5. The realm creates a new Principal object passing username, password and JDBCURL
6. If this is successful more metadata is read to have that data at hand
7. Also a Tomcat DataSource, a connection pool for the database, is created
8. If the driver did raise a warning, e.g. password expiration, this is kept into the Principal as well
9. The servlets have the option to get the Principal and use the connection pool of it

As the Realm is configured once for the entire Tomcat, it is the task of the Tomcat to use the desired Realm implementation.