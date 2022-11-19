FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ConfigServiceApplication.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/ConfigServiceApplication.jar"]