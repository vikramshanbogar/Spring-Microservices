FROM eclipse-temurin:17-jdk-focal
LABEL authors="Vikram"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} orders_service.jar
ENTRYPOINT ["java","-jar","/orders_service.jar"]
