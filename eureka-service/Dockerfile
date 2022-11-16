FROM openjdk:17
ARG JAR_FILE=target/EurekaServiceApp.jar
COPY ${JAR_FILE} EurekaServiceApp.jar
ENTRYPOINT ["java","-jar","/EurekaServiceApp.jar"]