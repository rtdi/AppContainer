FROM rtdi/connectorrootapp:tomcat9

LABEL maintainer="info@rtdi.io"

ADD https://github.com/rtdi/hanaappserverrealm/releases/latest/download/hanarealm.jar ./lib
ADD https://repo1.maven.org/maven2/com/sap/cloud/db/jdbc/ngdbc/2.4.70/ngdbc-2.4.70.jar ./lib
ADD https://raw.githubusercontent.com/rtdi/AppContainer/master/docker/server.xml conf/server.xml
ADD https://github.com/rtdi/AppContainer/releases/latest/download/AppContainer.war ./webapps/

EXPOSE 8080
EXPOSE 8443


CMD ["catalina.sh", "run"]
