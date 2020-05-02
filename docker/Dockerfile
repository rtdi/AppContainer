FROM tomcat:9-jdk13-openjdk-oracle

LABEL maintainer="info@rtdi.io"

ADD https://oss.sonatype.org/service/local/repositories/releases/content/io/rtdi/hanaappserver/hanarealm/0.8.5/hanarealm-0.8.5.jar ./lib
ADD https://repo1.maven.org/maven2/com/sap/cloud/db/jdbc/ngdbc/2.4.70/ngdbc-2.4.70.jar ./lib
ADD server.xml conf/server.xml
ADD https://github.com/SAP/openui5/releases/download/1.74.0/openui5-runtime-1.74.0.zip ./webapps/openui5.war
ADD https://github.com/rtdi/HanaAppContainer/releases/download/v0.8.8/HanaAppContainer.war ./webapps/

EXPOSE 8080


CMD ["catalina.sh", "run"]
