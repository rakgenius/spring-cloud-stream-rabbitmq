Spring boot Cloud Stream RabbitMQ


Using the shared model between services

The model is in user-view-dto component.

Compile it using
```
mvn package -DskipTests
```

Copy the jar file to the local maven repository using
```
mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file -Dfile=target/user-view-dto-0.0.1.jar -DgroupId=com.rakeshv -Dartifactid=user-view-dto -Dversion=0.0.1 -Dpackaging=jar -DlocalRepositoryPath=/root/.m2
```

Add the below dependency in the pom.xml of the component which uses this model


```
<dependency>
	<groupId>com.rakeshv</groupId>
	<artifactId>user-view-dto</artifactId>
	<version>0.0.1</version>
</dependency>
```


Add the local repository

```
<repositories>
    <repository>
	<id>local</id>
	<name>Local repo</name>
	<url>file:/root/.m2</url>
    </repository>
</repositories>
```
