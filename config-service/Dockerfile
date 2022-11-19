FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ConfigServiceApplication.jar
ENTRYPOINT ["java","-jar","/ConfigServiceApplication.jar"]