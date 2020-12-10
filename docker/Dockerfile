FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD demo-1.0-SNAPSHOT.jar demo.jar
ENTRYPOINT ["java","-Djava.security.mvn clean package -Dmaven.test.skip=true=file:/dev/./urandom","-jar","demo.jar"]
