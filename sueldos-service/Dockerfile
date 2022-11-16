FROM openjdk:17
ARG JAR_FILE=target/SueldosServiceApp.jar
COPY ${JAR_FILE} SueldosServiceApp.jar
ENTRYPOINT ["java","-jar","/SueldosServiceApp.jar"]