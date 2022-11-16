FROM openjdk:17
ARG JAR_FILE=target/JustificativoServiceApp.jar
COPY ${JAR_FILE} JustificativoServiceApp.jar
ENTRYPOINT ["java","-jar","/JustificativoServiceApp.jar"]