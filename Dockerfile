#FROM openjdk:17
FROM eclipse-temurin:21
EXPOSE 8080
ADD target/jenkins-demo.jar jenkins-demo.jar
ENTRYPOINT ["java","-jar","/jenkins-demo.jar"]
