FROM openjdk:17
ARG JAR_FILE=target/MarcasRelojServiceApp.jar
COPY ${JAR_FILE} MarcasRelojServiceApp.jar
ENTRYPOINT ["java","-jar","/MarcasRelojServiceApp.jar"]