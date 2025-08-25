FROM openjdk:17
EXPOSE 9090
ADD target/jenkins-demo.jar jenkins-demo.jar
ENTRYPOINT ["java","-jar","/jenkins-demo.jar"]
