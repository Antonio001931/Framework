 jar cvf framework.jar -C Framework/build/web/WEB-INF/classes/ etu1931
 mkdir Temporary
 mkdir Temporary/META-INF
 mkdir Temporary/WEB-INF
 mkdir Temporary/WEB-INF/classes
 cp -R Test-framework/build/web/WEB-INF/classes/model/ Temporary/WEB-INF/classes
 mkdir Temporary/WEB-INF/lib
  cp framework.jar Temporary/WEB-INF/lib/
  cp Test-framework/build/web/WEB-INF/web.xml Temporary/WEB-INF
 cp Test-framework/build/web/*.jsp Temporary
 jar cvf project.war -C Temporary .
 cp project.war /opt/apache-tomcat-9.0.71/webapps/
 rm -R Temporary/
