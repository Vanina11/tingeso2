FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} AutorizacionServiceApplication.jar
EXPOSE 8093
ENTRYPOINT ["java","-jar","/AutorizacionServiceApplication.jar"]