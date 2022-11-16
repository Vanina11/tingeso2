FROM openjdk:17
ARG JAR_FILE=target/ConfigServiceApp.jar
COPY ${JAR_FILE} ConfigServiceApp.jar
ENTRYPOINT ["java","-jar","/ConfigServiceApp.jar"]