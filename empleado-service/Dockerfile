FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} EmpleadoServiceApplication.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/EmpleadoServiceApplication.jar"]
