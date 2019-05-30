# Places API
Search Places and Details of places

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `Spring boot application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn clean install
mvn spring-boot:run
```

or

```shell
mvn clean install
java -jar XXX_jar_nameXXX.jar
```

### Places API rest end point
`http://localhost:8888/api/place/details/{place_id}` 

Example - http://localhost:8888/api/place/details/ChIJpaz2fx_BwjsR8OBdBo34Mtg


`http://localhost:8888/api/place/search/{input}`

Example - http://localhost:8888/api/place/search/Tibco%20pune
