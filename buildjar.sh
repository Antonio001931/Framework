 jar cvf framework.jar -C Framework/build/web/WEB-INF/classes/ etu1931
 cp framework.jar Test-framework/build/web/WEB-INF/lib/
 jar cvf projet.war -C Test-framework/build/web .
 cp projet.war /opt/apache-tomcat-9.0.71/webapps/
