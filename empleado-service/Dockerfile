FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} EmpleadoServiceApplication.jar
ENTRYPOINT ["java","-jar","/EmpleadoServiceApplication.jar"]
