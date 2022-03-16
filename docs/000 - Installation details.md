# Installation Part 2

An even better docker run command is to overlay a few server directories, here all are in the host's /dockermountpoints directory, and point them into various predefined points.

Hana:

    docker run -d --name appcontainer  -p 80:8080 -p 443:8443 \
       -v /dockermountpoints/rtdiconfig:/usr/local/tomcat/conf/rtdiconfig \
       -v /dockermountpoints/security:/usr/local/tomcat/conf/security \
       -v /dockermountpoints/repo:/usr/local/tomcat/repo \
       -v /dockermountpoints/ui5externallibs:/usr/local/tomcat/webapps/ui5externallibs \
       -e JDBCURL="jdbc:sap://hana.rtdi.io:39015/?databaseName=HXE" \
       rtdi/appcontainer:latest-hana

Snowflake:

    docker run -d --name appcontainer  -p 80:8080 -p 443:8443 \
       -v /dockermountpoints/rtdiconfig:/usr/local/tomcat/conf/rtdiconfig \
       -v /dockermountpoints/security:/usr/local/tomcat/conf/security \
       -v /dockermountpoints/repo:/usr/local/tomcat/repo \
       -v /dockermountpoints/ui5externallibs:/usr/local/tomcat/webapps/ui5externallibs \
       -e JDBCURL="jdbc:snowflake://tn0815.eu-central-1.snowflakecomputing.com/?db=MYDATABASE" \
       rtdi/appcontainer:latest-hana:latest-snowflake

These directories are used for:

- /usr/local/tomcat/conf/rtdiconfig: The directory where tomcat related settings can go. Usually not needed.
- /usr/local/tomcat/conf/security: The directory with ssl settings. The tomcat-users.xml user database is not used.
- /usr/local/tomcat/repo: This is where all developed files are located, one directory per user and a global PUBLIC directory.
- /usr/local/tomcat/webapps/ui5externallibs: A place to put all additional ui5 libraries and files not part of the deployed web application.
