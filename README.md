Spring boot Cloud Stream RabbitMQ


Start the rabbitmq docker using
```
docker run -d --hostname my-test-rabbit --name test-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
```

default credentials are 
```
guest/guest
```

Access ui on http://localhost:15672


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


Implementing spring boot amqp using rabbitmq

This uses a user defined queue and exchange name.
Producer sends a message of type "Order" and consumer receives it
By default producer sends the data in the byte format.\
To convert it into json we need to override certain configurations.\
Also we need to override configuration on the listener side so that\
listener recives the message in json format
