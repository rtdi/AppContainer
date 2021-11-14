# Architecture basics

The vision of this solution is to provide a backend and frontend for database development. This should be deployable on premise and cloud and work with different databases. The easiest way to achieve all of that is by providing a software container based on the Tomcat webserver image with custom web applications.

The integration between database and tomcat can be done via two options:

[x] Option 1: One Tomcat for one database: In this variant the database is the tomcat securtiy realm, hence no separate IDP handling is required. Instead the user logs in with the database credentials entered in the browser. Database user groups are used to control the permissions of the application also. Connection information for the database is entered in the tomcat configuration files. By usnig the database auth, the database connections can run under the database user and his database permissions.
[] Option 2: One Tomcat can handle multiple databases: Only one container is needed but the application requires the option to switch between databases, probably via different root URLs.
[] Option 2a: If the databases are centrally managed and all users share the same database credentials, the database specific settings cannot be used and an entire permission system must be added to the application, duplicating the database work.
[] Option 2b: If every user connects their own databases, the database permissions can be reused but the users must maintain the login information for the databases as well, e.g. storing the username/passwords in the application. Other database login methods like Kerberos, OAuth, ... must individually be implemented in the application to work.

Decision was to go with Option 1. The difference between a root URL or a port number is little and the overhead of having multiple images deployed is minute. This way a lot of Tomcat functionaltiy can be reused including other security realms on top. 
