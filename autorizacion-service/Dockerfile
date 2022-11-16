FROM openjdk:17
ARG JAR_FILE=target/AutorizacionServiceApp.jar
COPY ${JAR_FILE} AutorizacionServiceApp.jar
ENTRYPOINT ["java","-jar","/AutorizacionServiceApp.jar"]