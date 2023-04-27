FROM openjdk:17-jdk-slim
VOLUME /tmp
ADD /target/sample-json-serializer-demo-0.0.1-SNAPSHOT.jar sample-json-serializer-demo.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/sample-json-serializer-demo.jar"]
