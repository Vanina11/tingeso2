FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} SueldosServiceApplication.jar
EXPOSE 8094
ENTRYPOINT ["java","-jar","/SueldosServiceApplication.jar"]