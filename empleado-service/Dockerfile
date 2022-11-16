FROM openjdk:17
ARG JAR_FILE=target/EmpleadoServiceApp.jar
COPY ${JAR_FILE} EmpleadoServiceApp.jar
ENTRYPOINT ["java","-jar","/EmpleadoServiceApp.jar"]
