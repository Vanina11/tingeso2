FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} MarcasRelojServiceApplication.jar
EXPOSE 8091
ENTRYPOINT ["java","-jar","/MarcasRelojServiceApplication.jar"]