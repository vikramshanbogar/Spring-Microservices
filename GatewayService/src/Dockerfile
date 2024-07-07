FROM eclipse-temurin:17-jdk-focal
LABEL authors="Vikram"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} gateway_service.jar
ENTRYPOINT ["java","-jar","/gateway_service.jar"]
