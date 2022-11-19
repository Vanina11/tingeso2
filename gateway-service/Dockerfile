FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} GatewayServiceApplication.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/GatewayServiceApplication.jar"]