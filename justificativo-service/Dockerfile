FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} JustificativoServiceApplication.jar
EXPOSE 8092
ENTRYPOINT ["java","-jar","/JustificativoServiceApplication.jar"]