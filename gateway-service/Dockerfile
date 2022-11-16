FROM openjdk:17
ARG JAR_FILE=target/GatewayServiceApp.jar
COPY ${JAR_FILE} GatewayServiceApp.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/GatewayServiceApp.jar"]