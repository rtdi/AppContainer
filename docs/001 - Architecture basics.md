# Architecture basics

The vision of this solution is to provide a backend and frontend for database development. This should be deployable on premise and cloud and work with different databases. The easiest way to achieve all of that is by providing a software container based on the [Tomcat webserver image](https://hub.docker.com/_/tomcat) with custom web applications.

![Architecture Diagram](_media/CICD_Architecture.drawio.png)

The browser has multiple endpoints to connect to, be it the OpenAPI documentation of all endpoints, oData or RestFul endpoints to read database data or other (static) pages.

If the page is protected, a new session is established with the tomcat server and it is authenticated using a database-login-realm. This realm takes the username/password from a form based login page and uses that to login to the database. If that succeeds, all user groups the login is part of are read from the database as well to be used by the webserver. This obviously requires a connection pool management per session instead of the classic database connection pool in Tomcat.

The integration between database and Tomcat can be done via two basic options:

- [x] Option 1: One Tomcat for one database: In this variant the database is the tomcat securtiy realm, hence no separate IDP handling is required. Instead the user logs in with the database credentials entered in the browser. Database user groups are used to control the permissions of the application also. Connection information for the database is entered in the tomcat configuration files. By usnig the database auth, the database connections can run under the database user and his database permissions.
- [ ] Option 2: One Tomcat can handle multiple databases: Only one container is needed but the application requires the option to switch between databases, probably via different root URLs.
  - [ ] Option 2a: If the databases are centrally managed and all users share the same database credentials, the database specific settings cannot be used and an entire permission system must be added to the application, duplicating the database work.
  - [ ] Option 2b: If every user connects their own databases, the database permissions can be reused but the users must maintain the login information for the databases as well, e.g. storing the username/passwords in the application. Other database login methods like Kerberos, OAuth, ... must individually be implemented in the application to work.

Decision was to go with **Option 1**. The difference between a root URL or a port number is little and the overhead of having multiple images deployed is minute. This way a lot of Tomcat functionaltiy can be reused including other security realms on top.

## Repository

Any application consists of lots of files. Be it web pages but also files with database scripts. One question is where to store those files. As a database is involved the typical answer in the past was using the database itself as a file store. The alternative would be to store the files in a regular file system.

The requirements for a repository are today:

- Fine grained security control who can read/write/execute a file
- Git integration with push/pull/commit
- Compatible with containers

Implementation options:

- [ ] Option 1: Store all files in the database. This makes security much easier because the complete database security can be utilized. Such virtual filesystem is also fully compatibility with containers, because database access has no relationship with containers. The big problem is the git integration however. Every single git operation must be enabled and work perfectly.
- [x] Option 2: Store the files in the container filesystem. This allows to use all git libraries including [Jgit](https://wiki.eclipse.org/JGit/User_Guide). Another advantage is that not every git special function must be implemented as other git clients can be used as well. The container compatibility is a two edged swoard. If the file system is container internal, the files get deleted when the container is removed. Therefore it is strongly encouraged to overlay the host filesystem into the container and then the user has all advantages. The data is persistent via the host file system which can actually be a network file system. New versions of the container can be spun up at any time without losing any data. And git commands/tools can be used on the host computer. Security is more problematic as a container runs with a single OS user only. But if every developer has his own area to clone the git repository, this is no problem eiter.

Overall option 2 seems to be the better solution. It is secure enough, less difficult to implement and more compatible.
