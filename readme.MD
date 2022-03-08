Containerize Spring Boot app with JIB - Demo.

Steps :

1. Add jib-maven-plugin to build part in "pom.xml" :

````xml
...
<plugins>
    <plugin>
        <groupId>com.google.cloud.tools</groupId>
        <artifactId>jib-maven-plugin</artifactId>
        <version>2.5.2</version>
    </plugin>
</plugins>
````

2. Configure profiles to push image (locally or to registry)

3. Run maven build

3.1. Maven command to push image locally

> mvnw clean install jib:dockerBuild -Djib.to.image=springboot-jib:v1

3.1. Maven command to push image to the registry

> mvnw clean install jib:build -Djib.to.image=miliariadnane/springboot-jib:v1 -Djib.to.auth.username=your_username -Djib.to.auth.password=your_password

4. Start the container

> docker run --name springboot-jib -p 8080:8080 springboot-jib:v1

5. APIs for testing :

> 1st: https://localhost:8080/api/v1/customers/all
> 2nd: https://localhost:8080/api/v1/customers/maleCustomers
