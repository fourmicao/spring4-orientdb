Spring4 mvc ( no SpringBoot)
+ OrientDB
+ Spring Scheduling
+ web.xml (
+ ViewResolver with JavaConfig
+ PropertySourcesPlaceholderConfigurer
+ c3.js/d3.js for ui


If intellij source folder is corrupted, then use the following.
      <sourceFolder url="file://$MODULE_DIR$/src/main/java" isTestSource="false" />
      <sourceFolder url="file://$MODULE_DIR$/src/main/resources" type="java-resource" />
      <sourceFolder url="file://$MODULE_DIR$/src/test/java" isTestSource="true" />
      <excludeFolder url="file://$MODULE_DIR$/target" />

Set Jetty for Intellij
https://federicoponte.wordpress.com/2014/03/06/setting-up-jetty-with-intellij-idea/

10000 ft for OrientDb : 
+ http://rrevo.github.io/2015/04/05/getting-started/
+ http://pettergraff.blogspot.ie/2014/01/getting-started-with-orientdb.html
+ https://floatcode.wordpress.com/2015/07/08/graph-database-using-java-orientdb-and-gremlin/
+ Spring data gremlin makes it easier to implement Graph based repositories.
+ https://github.com/maggiolo00?tab=repositories

https://github.com/gjrwebber/spring-data-gremlin

<p> check maven for a specific top level </p>
+ mvn dependency:tree -Dverbose -Dincludes=commons-collections
+ mvn dependency:tree -Dverbose -Dincludes=com.orientechnologies
+ 
