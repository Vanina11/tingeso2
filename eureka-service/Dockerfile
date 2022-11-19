FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} EurekaServiceApplication.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/EurekaServiceApplication.jar"]