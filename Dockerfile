FROM tomcat:9.0
WORKDIR /usr/local/tomcat/webapps/
COPY target/OwnShop.war /usr/local/tomcat/webapps/
EXPOSE 1016
CMD ["catalina.sh", "run"]

