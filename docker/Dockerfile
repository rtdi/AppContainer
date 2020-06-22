FROM rtdi/connectorrootapp

LABEL maintainer="info@rtdi.io"

ADD https://github.com/rtdi/hanaappserverrealm/releases/latest/download/hanarealm.jar ./lib
ADD https://repo1.maven.org/maven2/com/sap/cloud/db/jdbc/ngdbc/2.4.70/ngdbc-2.4.70.jar ./lib
ADD https://raw.githubusercontent.com/rtdi/hanaappserverrealm/master/docker/server.xml conf/server.xml
ADD https://github.com/SAP/openui5/releases/download/1.74.0/openui5-runtime-1.74.0.zip ./webapps/openui5.war
ADD https://github.com/rtdi/HanaAppContainer/releases/latest/download/HanaAppContainer.war ./webapps/

EXPOSE 8080
EXPOSE 8443


CMD ["catalina.sh", "run"]
